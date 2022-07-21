package org.learning.jparelationrest.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.learning.jparelationrest.modal.entity.user.Address;
import org.learning.jparelationrest.modal.entity.user.Payment;
import org.learning.jparelationrest.modal.entity.user.User;
import org.learning.jparelationrest.repository.AddressRepository;
import org.learning.jparelationrest.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository    userRepository;
    private final AddressRepository addressRepository;

    public User createUser(User user) {

        Address address = user.getAddress();
        address.setUser(user);
        List<Payment> payments = user.getPayments();
        payments.forEach(payment -> payment.setUser(user));
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Failed to find the user"));
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public Address createAddress(Address address) {
        User user = address.getUser();
        user.getPayments().forEach(payment -> payment.setUser(user));
        user.setAddress(address);
        return addressRepository.save(address);
    }

    public Address getAddress(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Failed to find the address"));
    }

    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }
}
