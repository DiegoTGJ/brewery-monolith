package diego.spring.brewerymsvc.web.services;

import diego.spring.brewerymsvc.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getById(UUID id);
}
