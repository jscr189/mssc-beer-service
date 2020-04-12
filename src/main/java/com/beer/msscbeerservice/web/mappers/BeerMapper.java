package com.beer.msscbeerservice.web.mappers;

import com.beer.msscbeerservice.domain.Beer;
import com.beer.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses={DatesMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beer);
}
