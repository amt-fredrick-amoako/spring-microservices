package com.pdt.entities;

import org.springframework.data.redis.core.RedisHash;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RedisHash("Basket")
public record ShoppingCart(String username,
                           List<ShoppingCartItem> items
) {
    public ShoppingCart {
        items = new ArrayList<>();
    }

    public ShoppingCart(String username) {
        this(username, new ArrayList<>());
    }

    public BigDecimal getTotalPrice() {
        return BigDecimal.valueOf(items.stream()
                .map(item -> item.price().intValue() * item.quantity())
                .reduce(0, Integer::sum));
    }
}
