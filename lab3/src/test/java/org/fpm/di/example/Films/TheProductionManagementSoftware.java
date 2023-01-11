package org.fpm.di.example.Films;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TheProductionManagementSoftware extends Directors {
    private final TheFirstAvengerSeries fas;
    private final TheIronManSeries ims;
    private final TheAvengers ar;

    @Inject
    public TheProductionManagementSoftware(TheFirstAvengerSeries fas, TheIronManSeries ims, TheAvengers ar) {
        this.fas = fas;
        this.ims = ims;
        this.ar = ar;
    }

    public TheFirstAvengerSeries getTheFirstAvengerSeries() {
        return fas;
    }

    public TheIronManSeries getTheIronManSeries() {
        return ims;
    }

    public TheAvengers getTheAvengers() {
        return ar;
    }
}
