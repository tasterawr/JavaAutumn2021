package com.netcracker.framework;

import com.netcracker.annotations.Inject;
import com.netcracker.annotations.Primary;
import com.netcracker.factory.Factory;

import java.util.Arrays;
import java.util.Optional;

public class StudentServiceInjector implements AfterInitialization {

    @Override
    public void initialize(Object o) {
        Arrays.stream(
                o.getClass().getDeclaredFields()
        )
                .filter(field -> field.isAnnotationPresent(Inject.class))
                .forEach(field -> {
                    field.setAccessible(true);
                    try {
                        String className = field.getAnnotation(Inject.class).className();
                        Object objToInject;
                        if (!className.equals("")){
                            objToInject = Factory.getObjects().get(className);
                        }
                        else{
                            Class<?> fieldType = field.getType();
                            objToInject = Factory.getObjects().values()
                                    .stream()
                                    .filter(value -> value.getClass().isAnnotationPresent(Primary.class)
                                            && fieldType.isAssignableFrom(value.getClass()))
                                    .findFirst()
                                    .orElse(null);
                        }
                        field.set(o, objToInject);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }
}
