package diego.spring.brewerymsvc.services;


import diego.spring.brewerymsvc.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById(UUID beerId);

    BeerDTO save(BeerDTO beerDTO);

    void updateBeer(UUID beerId, BeerDTO beerDTO);

    void deleteById(UUID beerId);
}
