package com.customer.utility;


import com.customer.entity.Customer;
import com.customer.model.CustomerRequest;
import com.customer.model.CustomerResponse;
import org.springframework.stereotype.Component;

@Component
public class Convertor {

	public Customer requestToEntity(CustomerRequest customerRequest) {
		Customer customerEntity = new Customer();
		customerEntity.setFirst_name(customerRequest.getFirst_name());
		customerEntity.setLast_name(customerRequest.getLast_name());
		customerEntity.setStreet(customerRequest.getStreet());
		customerEntity.setAddress(customerRequest.getAddress());
		customerEntity.setCity(customerRequest.getCity());
		customerEntity.setState(customerRequest.getState());
		customerEntity.setEmail(customerRequest.getEmail());
		customerEntity.setPhone(customerRequest.getPhone());
		return customerEntity;

	}

	public CustomerResponse entityToResponse(Customer customerEntity) {
		CustomerResponse customerResponse = new CustomerResponse();
		customerResponse.setFirst_name(customerEntity.getFirst_name());
		customerResponse.setLast_name(customerEntity.getLast_name());
		customerResponse.setStreet(customerEntity.getStreet());
		customerResponse.setAddress(customerEntity.getAddress());
		customerResponse.setCity(customerEntity.getCity());
		customerResponse.setState(customerEntity.getState());
		customerResponse.setEmail(customerEntity.getEmail());
		customerResponse.setPhone(customerEntity.getPhone());
		return customerResponse;

	}

	public Customer updateEntity(CustomerRequest customerRequest, Customer customerEntity) {
		customerEntity.setFirst_name(customerRequest.getFirst_name());
		customerEntity.setLast_name(customerRequest.getLast_name());
		customerEntity.setStreet(customerRequest.getStreet());
		customerEntity.setAddress(customerRequest.getAddress());
		customerEntity.setCity(customerRequest.getCity());
		customerEntity.setState(customerRequest.getState());
		customerEntity.setEmail(customerRequest.getEmail());
		customerEntity.setPhone(customerRequest.getPhone());
		return customerEntity;

	}

}
