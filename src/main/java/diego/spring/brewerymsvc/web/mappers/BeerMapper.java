package diego.spring.brewerymsvc.web.mappers;

import diego.spring.brewerymsvc.domain.Beer;
import diego.spring.brewerymsvc.web.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDTO beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDTO dto);
}
