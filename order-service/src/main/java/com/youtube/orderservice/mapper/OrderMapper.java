package com.youtube.orderservice.mapper;

import com.youtube.orderservice.dto.OrderDTO;
import com.youtube.orderservice.dto.OrderDTOfromFE;
import com.youtube.orderservice.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order mapOrderDTOtoOrder(OrderDTO orderDTO);
    OrderDTO mapOrdertoOrderDTO(Order order);
}
