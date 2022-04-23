package com.example.demo.services.convertors;

// T - входящий тип, V - выходящий тип(наше Dto)
public interface Converter<T extends Convertable, V> {
    V convert(T input);

    InputType getType();
}
