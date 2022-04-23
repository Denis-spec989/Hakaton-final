package com.example.demo.services.convertors;

public interface ConverterService<T> {
    public <V> T convert(V input);
}
