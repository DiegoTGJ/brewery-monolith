package diego.spring.brewerymsvc.web.controller;

import diego.spring.brewerymsvc.web.model.BeerDTO;
import diego.spring.brewerymsvc.web.model.CustomerDTO;
import diego.spring.brewerymsvc.services.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("customerId") UUID customerId){

        return new ResponseEntity<>(customerService.getById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDTO> handlePost(@RequestBody CustomerDTO customerDTO){
        CustomerDTO saveDto = customerService.save(customerDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","http://localhost:8080/api/v1/customer/"+saveDto.getId());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handlePut(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDTO customerDto){
        customerService.updateCustomer(customerId, customerDto);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") UUID customerId){
        customerService.deleteById(customerId);
    }
}
