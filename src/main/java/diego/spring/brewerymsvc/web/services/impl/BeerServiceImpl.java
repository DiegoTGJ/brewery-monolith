package diego.spring.brewerymsvc.web.services.impl;

import diego.spring.brewerymsvc.web.model.BeerDTO;
import diego.spring.brewerymsvc.web.services.BeerService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getBeerById(UUID beerId) {
        return BeerDTO.builder().id(UUID.randomUUID())
                .beerName("Corona")
                .beerStyle("Negra")
                .build();
    }
}
