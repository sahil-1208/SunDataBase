package com.customer.service;


import com.customer.entity.Customer;
import com.customer.enums.Status;
import com.customer.globalException.CustomerResponseException;
import com.customer.model.CustomerRequest;
import com.customer.model.CustomerResponse;
import com.customer.repository.CustomerRepository;
import com.customer.utility.Convertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AuthService authenticationService;

    @Autowired
    private Convertor convertor;


    public Status create(String login_id, String password, CustomerRequest customerRequest) {
        if (authenticationService.authenticate(login_id, password) && Objects.nonNull(customerRequest)) {
            Customer customerEntity = convertor.requestToEntity(customerRequest);
            customerRepository.save(customerEntity);
            return Status.SUCCESS;
        }
        return Status.FALIURE;
    }

    public CustomerResponse findCustomerById(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            return convertor.entityToResponse(customer);
        } else {
            throw new CustomerResponseException("Customer not found for ID: " + id);
        }
    }

    public Status updateCustomerById(Long id, CustomerRequest customerRequest) {
        return customerRepository.findById(id).map(customerEntity -> {
            customerEntity = convertor.updateEntity(customerRequest, customerEntity);
            customerRepository.save(customerEntity);
            return Status.SUCCESS;
        }).orElseThrow(() -> new CustomerResponseException("Customer not found for ID: " + id));
    }

    public Status deleteById(Long id) {
        Optional<Customer> customerEntity = customerRepository.findById(id);
        if (Objects.nonNull(customerEntity)) {
            customerRepository.deleteById(id);
            return Status.SUCCESS;
        } else {
            return Status.FALIURE;
        }
    }

}

