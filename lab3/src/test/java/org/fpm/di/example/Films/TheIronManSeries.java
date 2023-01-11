package org.fpm.di.example.Films;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TheIronManSeries extends SeriesOfFilms{
    private final TheIronMan im;
    private final TheIronMan2 im2;
    private final TheIronMan3 im3;

    @Inject
    public TheIronManSeries(TheIronMan im, TheIronMan2 im2, TheIronMan3 im3) {
        this.im = im;
        this.im2 = im2;
        this.im3 = im3;
    }

    public TheIronMan getTheIronMan() {
        return im;
    }

    public TheIronMan2 getTheironMan2() {
        return im2;
    }

    public TheIronMan3 getTheIronMan3() {
        return im3;
    }
}
