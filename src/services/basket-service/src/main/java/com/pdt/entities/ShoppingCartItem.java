package com.pdt.entities;

import java.math.BigDecimal;

public record ShoppingCartItem(int quantity,
                               String color,
                               BigDecimal price,
                               String productId,
                               String productName) {
}
