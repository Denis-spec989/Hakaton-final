package com.example.demo.services.convertors;

public abstract class AbstractConverter<T, V> implements Converter<T, V> {
    public AbstractConverter(SuperConverter<V> superConverter) {
        superConverter.addConverter(this);
    }
}
