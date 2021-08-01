package diego.spring.brewerymsvc.services.v2;

import diego.spring.brewerymsvc.services.BeerService;
import diego.spring.brewerymsvc.web.model.BeerDTO;
import diego.spring.brewerymsvc.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {

    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 save(BeerDtoV2 beerDTO);

    void updateBeer(UUID beerId, BeerDtoV2 beerDTO);

    void deleteById(UUID beerId);
}
