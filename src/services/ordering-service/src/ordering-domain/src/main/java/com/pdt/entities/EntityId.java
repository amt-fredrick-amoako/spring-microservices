package com.pdt.entities;

import java.util.UUID;

public record EntityId(UUID id) {
    public EntityId(){
        this(UUID.randomUUID());
    }
}
