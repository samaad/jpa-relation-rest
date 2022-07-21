package org.learning.jparelationrest.controller;

import java.util.List;
import org.learning.jparelationrest.modal.entity.user.Address;
import org.learning.jparelationrest.modal.entity.user.User;
import org.learning.jparelationrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    @ResponseBody
    public User saveUser(@RequestBody User user) {
        User saveUser = userService.createUser(user);
        return saveUser;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User getuser(@PathVariable Long id) {
        User saveUser = userService.getUser(id);
        return saveUser;
    }

    @GetMapping()
    @ResponseBody
    public List<User> getAllUser() {
        List<User> saveUser = userService.getAllUser();
        return saveUser;
    }


    @PostMapping("/address")
    @ResponseBody
    public Address saveAddress(@RequestBody Address address) {
        Address saveAddress = userService.createAddress(address);
        return saveAddress;
    }

    @GetMapping("/address/{id}")
    @ResponseBody
    public Address getAddressByid(@PathVariable Long id) {
        Address saveAddress = userService.getAddress(id);
        return saveAddress;
    }

    @GetMapping("/address")
    @ResponseBody
    public List<Address> getAddress() {
        List<Address> saveAddress = userService.getAllAddress();
        return saveAddress;
    }
}
