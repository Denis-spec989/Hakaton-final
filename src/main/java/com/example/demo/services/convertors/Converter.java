package com.example.demo.services.convertors;

public interface Converter<T, V> {
    V convert(T input);

    String getInputType();

    String getOutputType();
}
