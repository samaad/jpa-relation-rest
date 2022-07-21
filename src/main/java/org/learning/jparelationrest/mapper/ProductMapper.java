package org.learning.jparelationrest.mapper;

import org.learning.jparelationrest.modal.dto.ProductDTO;
import org.learning.jparelationrest.modal.entity.Products;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Products toEntity(ProductDTO productDTO);
    ProductDTO toDto(Products products);
}
