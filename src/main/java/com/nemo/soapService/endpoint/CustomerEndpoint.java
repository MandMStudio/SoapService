package com.nemo.soapService.endpoint;

import com.nemo.soapService.model.DeleteCustomerRequest;
import com.nemo.soapService.model.DeleteCustomerResponse;
import com.nemo.soapService.model.GetCustomerRequest;
import com.nemo.soapService.model.GetCustomerResponse;
import com.nemo.soapService.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class CustomerEndpoint {
    private static final String NAMESPACE_URI = "http://tutorialspoint/schemas";

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerEndpoint(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "getCustomerRequest")
    @ResponsePayload
    public GetCustomerResponse getCustomer(@RequestPayload GetCustomerRequest request){
        GetCustomerResponse response = new GetCustomerResponse();
        response.setCustomer(customerRepository.findCustomer(request.getId()));
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "deleteCustomerRequest")
    @ResponsePayload
    public DeleteCustomerResponse deleteCustomer(@RequestPayload DeleteCustomerRequest request){
        DeleteCustomerResponse response = new DeleteCustomerResponse();
        response.setCustomer(customerRepository.deleteCustomer(request.getId()));
        return response;
    }

}
