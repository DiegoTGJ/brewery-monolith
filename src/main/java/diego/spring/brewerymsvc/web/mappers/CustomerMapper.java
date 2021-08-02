package diego.spring.brewerymsvc.web.mappers;

import diego.spring.brewerymsvc.domain.Customer;
import diego.spring.brewerymsvc.web.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerToCustomerDto(CustomerDTO customerDTO);
    CustomerDTO customerDtoToCustomer(Customer customer);
}
