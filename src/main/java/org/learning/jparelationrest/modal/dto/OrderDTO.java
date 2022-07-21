package org.learning.jparelationrest.modal.dto;

import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Long id;
    private String orderNumber;
    private Integer quantity;
    private Set<ProductDTO> products = new HashSet<>();
}
