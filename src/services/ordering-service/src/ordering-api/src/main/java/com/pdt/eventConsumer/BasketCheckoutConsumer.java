package com.pdt.eventConsumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdt.events.BasketCheckoutEvent;
import com.pdt.mapping.OrderingMapper;
import com.pdt.models.CheckoutOrder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class BasketCheckoutConsumer {
    private final ObjectMapper objectMapper;
    private final OrderingMapper orderingMapper;

    public BasketCheckoutConsumer(ObjectMapper objectMapper, OrderingMapper orderingMapper) {
        this.objectMapper = objectMapper;
        this.orderingMapper = orderingMapper;
    }

    @RabbitListener(queues = "#={basketCheckoutQueue.name}", containerFactory = "rabbitListenerContainerFactory")
    public void handleBasketCheckoutEvent(BasketCheckoutEvent event) {
        try {
            CheckoutOrder checkoutOrder = orderingMapper.toCheckoutOrder(event);
            //Todo:: call service to checkout here.
        } catch (Exception e) {

        }
    }

}
