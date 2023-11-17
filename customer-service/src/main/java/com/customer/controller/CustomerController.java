package com.customer.controller;


import com.customer.enums.Status;
import com.customer.model.CustomerRequest;
import com.customer.model.CustomerResponse;
import com.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sunbase/portal/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/assignment.jsp")
    public ResponseEntity<String> createCustomer(@RequestParam String login_id, @RequestParam String password , @RequestBody CustomerRequest customerRequest) {
        Status status = customerService.create(login_id, password, customerRequest);
        return ResponseEntity.ok(status.toString());
    }

    @GetMapping("/assignment.jsp/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long id) {
    CustomerResponse customerResponse = customerService.findCustomerById(id);
    return ResponseEntity.ok(customerResponse);
    }

    @PutMapping("/assignment.jsp/{id}")
    public ResponseEntity<String> updateCustomerById(@PathVariable Long id, @RequestBody CustomerRequest customerRequest) {
        Status status = customerService.updateCustomerById(id, customerRequest);
        return ResponseEntity.ok(status.toString());
    }

    @DeleteMapping("/assignment.jsp/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable Long id) {
        Status status = customerService.deleteById(id);
        return ResponseEntity.ok(status.toString());
    }

}
