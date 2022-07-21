package org.learning.jparelationrest.repository;

import java.util.List;
import java.util.Optional;
import org.learning.jparelationrest.modal.entity.user.Payment;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {


    @Override
    @EntityGraph("payment-user")
    Optional<Payment> findById(Long id);

    @Override
    @EntityGraph("payment-user")
    List<Payment> findAll();
}
