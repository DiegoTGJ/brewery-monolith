package diego.spring.brewerymsvc.web.services;


import diego.spring.brewerymsvc.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById(UUID beerId);
}
