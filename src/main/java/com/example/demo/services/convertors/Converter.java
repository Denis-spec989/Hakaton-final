package com.example.demo.services.convertors;

// T - входящий тип, V - выходящий тип(наше Dto)
public interface Converter<T, V> {
    V convert(T input);

    InputType getType();
}
