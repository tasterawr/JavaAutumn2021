package org.loktevik.netcracker;

import lombok.SneakyThrows;
import org.loktevik.netcracker.annotations.Bean;
import org.loktevik.netcracker.config.Configuration;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationContext {
    private List<Object> beans = new ArrayList<>();

    @SneakyThrows
    public void init(Configuration... configurations){
        for (Configuration config : configurations){
            Class<? extends Configuration> aClass = config.getClass();

            Method[] methods = aClass.getDeclaredMethods();

            for (Method method : methods){
                if (method.isAnnotationPresent(Bean.class)){
                    method.setAccessible(true);
                    beans.add(method.invoke(config, null));
                }
            }
        }
    }

    public <T> T getBean(Class<T> clazz){
        return (T)beans.stream().filter(bean -> clazz.isAssignableFrom(bean.getClass())).findFirst().get();
    }

    public <T> List<T> getBeans(Class<T> clazz){
        return (List<T>)beans.stream().filter(bean -> clazz.isAssignableFrom(bean.getClass())).collect(Collectors.toList());
    }
}
