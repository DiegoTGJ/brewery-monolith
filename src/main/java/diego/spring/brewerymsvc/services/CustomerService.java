package diego.spring.brewerymsvc.services;


import diego.spring.brewerymsvc.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getById(UUID id);

    CustomerDTO save(CustomerDTO customerDTO);

    void updateCustomer(UUID customerId, CustomerDTO customerDto);

    void deleteById(UUID id);
}
