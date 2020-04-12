package com.beer.msscbeerservice.bootstrap;

import com.beer.msscbeerservice.domain.Beer;
import com.beer.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count()==0)
        {
            beerRepository.save(Beer.builder().beerName("Mango Bobs").beerStyle("IPA").minOnHand(12).
                    quantityToBrew(200).upc(3334349L).price(new BigDecimal("12.95"))
                    .build());
            beerRepository.save(Beer.builder().beerName("Galaxy Cat").beerStyle("PALE_ALE").minOnHand(14).
                    quantityToBrew(250).upc(3384349L).price(new BigDecimal("14.95"))
                    .build());
        }
    }
}
