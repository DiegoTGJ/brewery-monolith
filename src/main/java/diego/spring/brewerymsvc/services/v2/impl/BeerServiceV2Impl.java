package diego.spring.brewerymsvc.services.v2.impl;

import diego.spring.brewerymsvc.services.v2.BeerServiceV2;
import diego.spring.brewerymsvc.web.model.BeerDTO;
import diego.spring.brewerymsvc.web.model.v2.BeerDtoV2;
import diego.spring.brewerymsvc.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder().id(UUID.randomUUID())
                .beerName("Corona")
                .beerStyle(BeerStyleEnum.STOUT)
                .build();
    }

    @Override
    public BeerDtoV2 save(BeerDtoV2 beerDTO) {
        return BeerDtoV2.builder().beerName("Coronita")
                .beerStyle(BeerStyleEnum.LAGER)
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beerDTO) {
        //todo add real update beer impl
        log.debug("Updating a beer");
    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("Deleting a beer");
    }
}
