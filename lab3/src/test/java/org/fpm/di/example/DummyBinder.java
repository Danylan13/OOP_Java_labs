package org.fpm.di.example;

import org.fpm.di.Binder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DummyBinder implements Binder {

    HashMap<Class<?>, Class<?>> realisations = new HashMap<>();

    HashMap<Class<?>, Object> copies = new HashMap<>();

    List<Class<?>> list = new ArrayList<>();

    @Override
    public <T> void bind(Class<T> clazz) {
        list.add(clazz);
    }

    @Override
    public <T> void bind(Class<T> clazz, Class<? extends T> implementation) {
        realisations.put(clazz, implementation);
    }

    @Override
    public <T> void bind(Class<T> clazz, T instance) {
        copies.put(clazz, instance);
    }
}
