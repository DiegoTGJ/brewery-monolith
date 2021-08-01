package diego.spring.brewerymsvc.services.impl;

import diego.spring.brewerymsvc.web.model.CustomerDTO;
import diego.spring.brewerymsvc.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getById(UUID id) {
        return CustomerDTO.builder().id(UUID.randomUUID())
                .name("Juanito")
                .build();
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        return CustomerDTO.builder().id(UUID.randomUUID()).name("Jose").build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDTO customerDto) {
        //todo add real update customer impl
        log.debug("Updating a customer...");
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("Deleting a customer...");
    }
}
