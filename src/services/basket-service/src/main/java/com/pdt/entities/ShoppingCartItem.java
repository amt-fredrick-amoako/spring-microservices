package com.pdt.entities;

public record ShoppingCartItem(int quantity,
                               String color,
                               double price,
                               String productId,
                               String productName) {
}
