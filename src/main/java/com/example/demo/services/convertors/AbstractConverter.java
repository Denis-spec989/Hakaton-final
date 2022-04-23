package com.example.demo.services.convertors;

public abstract class AbstractConverter<T extends Convertable, V> implements Converter<T, V> {
    public AbstractConverter(SuperConverter<V> superConverter) {
        superConverter.addConverter(this);
    }
}
