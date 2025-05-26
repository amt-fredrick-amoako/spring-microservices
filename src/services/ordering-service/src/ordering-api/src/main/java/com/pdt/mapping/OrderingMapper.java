package com.pdt.mapping;

import com.pdt.events.BasketCheckoutEvent;
import com.pdt.models.CheckoutOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderingMapper {
    CheckoutOrder toCheckoutOrder(BasketCheckoutEvent basketCheckoutEvent);
}
