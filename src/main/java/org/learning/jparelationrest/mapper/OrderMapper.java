package org.learning.jparelationrest.mapper;

import org.learning.jparelationrest.modal.dto.OrderDTO;
import org.learning.jparelationrest.modal.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDTO toDto(Order order);

    @Mapping(source = "products", target = "product")
    Order toEntity(OrderDTO orderDTO);
}
