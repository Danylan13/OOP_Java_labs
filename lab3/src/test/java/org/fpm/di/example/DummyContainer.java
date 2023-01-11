package org.fpm.di.example;

import org.fpm.di.Container;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

public class DummyContainer implements Container {
    DummyBinder binder;
    public DummyContainer(DummyBinder b){
        this.binder = b;
    }
    @Override
    public <T> T getComponent(Class<T> clazz) {
        if (binder.realisations.containsKey(clazz)) {
            return getComponent((Class<T>) binder.realisations.get(clazz));
        }
        if (binder.copies.containsKey(clazz)) {
            return (T) binder.copies.get(clazz);
        }
        try {
            for (Constructor<?> constructor : clazz.getConstructors()) {
                if (constructor.isAnnotationPresent(Inject.class)) {
                    Parameter[] p = constructor.getParameters();
                    int len = p.length;

                    Object[] init_p = new Object[len];
                    for (int i = 0; i < len; i++) {
                        init_p[i] = getComponent(p[i].getType());
                    }

                    T res = (T) constructor.newInstance(init_p);

                    if (clazz.isAnnotationPresent(Singleton.class)) {
                        binder.bind(clazz, res);
                    }
                    return res;
                }
            }
            T res = clazz.newInstance();
            if(clazz.isAnnotationPresent(Singleton.class)){
                binder.bind(clazz, res);
            }
            return res;

        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        /*
        if (clazz.equals(A.class)) {
            return (T) new A();
        }
        if (clazz.equals(B.class)) {
            return (T) new B();
        }
        return null;*/
    }
}
