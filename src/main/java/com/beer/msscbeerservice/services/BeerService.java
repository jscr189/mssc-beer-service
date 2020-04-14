package com.beer.msscbeerservice.services;

import com.beer.msscbeerservice.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto saveBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID id, BeerDto beerDto);

    BeerDto getBeerById(UUID id);
}
