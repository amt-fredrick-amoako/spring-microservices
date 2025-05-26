package com.pdt.mappings;

import com.pdt.entities.Order;
import com.pdt.models.CheckoutOrder;
import com.pdt.models.OrdersVm;
import com.pdt.models.UpdateOrder;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {
    Order toOrder(CheckoutOrder checkoutOrder);
    CheckoutOrder toCheckoutOrder(Order order);
    Order toOrder(OrdersVm ordersVm);
    OrdersVm toOrdersVm(Order order);
    Order toOrder(UpdateOrder updateOrder);
    UpdateOrder toUpdateOrder(Order order);
}
