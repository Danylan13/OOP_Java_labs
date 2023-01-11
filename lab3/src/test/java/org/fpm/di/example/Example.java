package org.fpm.di.example;

import org.fpm.di.Container;
import org.fpm.di.Environment;
import org.fpm.di.example.Films.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class Example {

    private Container container;

    @Before
    public void setUp() {
        Environment env = new DummyEnvironment();
        container = env.configure(new MyConfiguration());
    }

    @Test
    public void shouldInjectSingleton() {
        assertSame(container.getComponent(MySingleton.class), container.getComponent(MySingleton.class));
    }

    @Test
    public void shouldInjectPrototype() {
        assertNotSame(container.getComponent(MyPrototype.class), container.getComponent(MyPrototype.class));
    }

    @Test
    public void shouldBuildInjectionGraph() {
        /*
        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());
        */
        final B bAsSingleton = container.getComponent(B.class);
        assertSame(container.getComponent(A.class), bAsSingleton);
        assertSame(container.getComponent(B.class), bAsSingleton);
    }

    @Test
    public void shouldBuildInjectDependencies() {
        final UseA hasADependency = container.getComponent(UseA.class);
        assertSame(hasADependency.getDependency(), container.getComponent(B.class));
    }

    @Test
    public void Test1(){
        TheFirstAvenger fa = container.getComponent(TheFirstAvenger.class);
        TheFirstAvengerSeries series = container.getComponent(TheFirstAvengerSeries.class);
        assertSame(fa, series.getTheFirstavenger());
    }

    @Test
    public void Test2(){
        TheIronMan im = container.getComponent(TheIronMan.class);
        TheIronManSeries series = container.getComponent(TheIronManSeries.class);
        assertSame(im, series.getTheIronMan());
    }

    @Test
    public void Test3(){
        TheFirstAvenger fa = container.getComponent(TheFirstAvenger.class);
        TheProductionManagementSoftware pms = container.getComponent(TheProductionManagementSoftware.class);
        assertSame(fa, pms.getTheFirstAvengerSeries().getTheFirstavenger());
    }

    @Test
    public void Test4(){
        TheIronMan im = container.getComponent(TheIronMan.class);
        TheProductionManagementSoftware pms = container.getComponent(TheProductionManagementSoftware.class);
        assertSame(im, pms.getTheIronManSeries().getTheIronMan());
    }

    @Test
    public void Test5(){
        TheAvengers ar = container.getComponent(TheAvengers.class);
        assertSame(container.getComponent(TheAvengers.class), ar);
    }
}
