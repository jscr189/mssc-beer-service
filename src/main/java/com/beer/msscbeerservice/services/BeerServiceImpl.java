package com.beer.msscbeerservice.services;

import com.beer.msscbeerservice.controller.NotFoundException;
import com.beer.msscbeerservice.domain.Beer;
import com.beer.msscbeerservice.repositories.BeerRepository;
import com.beer.msscbeerservice.web.mappers.BeerMapper;
import com.beer.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service("beerService")
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {
    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;
    @Override
    public BeerDto saveBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID id, BeerDto beerDto)
    {
        Beer beer=beerRepository.findById(id).orElseThrow(() ->new NotFoundException());
        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());
        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }

    @Override
    public BeerDto getBeerById(UUID id)
    {
        return beerMapper.beerToBeerDto(beerRepository.findById(id).orElseThrow(() -> {
            return new NotFoundException();
        }));
    }
}
