package org.learning.jparelationrest.repository;

import java.util.List;
import java.util.Optional;
import org.learning.jparelationrest.modal.entity.Products;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

    @Override
    @EntityGraph("payment-order")
    Optional<Products> findById(Long id);

    @EntityGraph("payment-order")
    List<Products> findAll();
}
