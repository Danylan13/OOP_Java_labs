package org.fpm.di.example.Films;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TheFirstAvengerSeries extends SeriesOfFilms{
    private final TheFirstAvenger fa1;
    private final TheFirstAvengerSecondWar fa2;
    private final TheFirstAvengerConfrontation fa3;

    @Inject
    public TheFirstAvengerSeries(TheFirstAvenger fa1, TheFirstAvengerSecondWar fa2, TheFirstAvengerConfrontation fa3) {
        this.fa1 = fa1;
        this.fa2 = fa2;
        this.fa3 = fa3;
    }

    public TheFirstAvenger getTheFirstavenger() {
        return fa1;
    }

    public TheFirstAvengerSecondWar getTheFirstAvengerSecondWar() {
        return fa2;
    }

    public TheFirstAvengerConfrontation getTheFirstAvengerConfrontation() {
        return fa3;
    }
}
