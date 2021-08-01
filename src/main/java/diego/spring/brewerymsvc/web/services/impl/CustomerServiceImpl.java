package diego.spring.brewerymsvc.web.services.impl;

import diego.spring.brewerymsvc.web.model.CustomerDTO;
import diego.spring.brewerymsvc.web.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getById(UUID id) {
        return CustomerDTO.builder().id(UUID.randomUUID())
                .name("Juanito")
                .build();
    }
}
