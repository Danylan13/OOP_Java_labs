package org.fpm.di.example.Films;

public class Marvel extends Directors{
    private final TheIronMan im;

    public Marvel(TheIronMan im) {
        this.im = im;
    }

    public TheIronMan getTheIronMan() {
        return im;
    }
}
