package org.learning.jparelationrest.repository;

import java.util.List;
import java.util.Optional;
import org.learning.jparelationrest.modal.entity.user.Address;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Override
    @EntityGraph("address-user")
    Optional<Address> findById(Long id);

    @Override
    @EntityGraph("address-user")
    List<Address> findAll();
}
