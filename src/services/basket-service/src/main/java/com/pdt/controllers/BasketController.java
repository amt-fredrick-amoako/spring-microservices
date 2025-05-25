package com.pdt.controllers;

import com.pdt.entities.ShoppingCart;
import com.pdt.repositories.contracts.BasketRepository;
import com.pdt.services.DiscountGrpcService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

import static com.pdt.configurations.RabbitMQConfig.BASKET_EXCHANGE;
import static com.pdt.configurations.RabbitMQConfig.BASKET_UPDATED_ROUTING_KEY;

@RestController
@RequestMapping("api/v1/basket")
public class BasketController {
    private final BasketRepository basketRepository;
    private final DiscountGrpcService discountGrpcService;
    private final RabbitTemplate rabbitTemplate;

    public BasketController(BasketRepository basketRepository, DiscountGrpcService discountGrpcService, RabbitTemplate rabbitTemplate) {
        this.basketRepository = basketRepository;
        this.discountGrpcService = discountGrpcService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("{username}")
    @ResponseBody
    public ShoppingCart getBasket(@PathVariable String username){
        return basketRepository.getBasket(username).orElse(new ShoppingCart(username));
    }

    @PostMapping
    @ResponseBody
    public ShoppingCart updateBasket(@RequestBody ShoppingCart basket){
        //Todo:: add grpc logic here
        for(var product : basket.items()){
            var coupon = discountGrpcService.getDiscount(product.productName());
            product.price().subtract(BigDecimal.valueOf(coupon.getAmount())) ;
        }
        return basketRepository.updateShoppingCart(basket);
    }

    @PostMapping("/checkout")
    public ResponseEntity checkout(@RequestBody ShoppingCart basketCheckout){
        ShoppingCart basket = basketRepository.getBasket(basketCheckout.username()).orElse(null);
        if (basket == null) {
            return ResponseEntity.badRequest().build();
        }

        rabbitTemplate.convertAndSend(BASKET_EXCHANGE, BASKET_UPDATED_ROUTING_KEY, basket);

        return ResponseEntity.accepted().build();
    }
}
