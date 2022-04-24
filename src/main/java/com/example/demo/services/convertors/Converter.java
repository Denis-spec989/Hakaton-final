package com.example.demo.services.convertors;

import java.io.IOException;

public interface Converter<T, V> {
    V convert(T input);

    String getInputType();

    String getOutputType();
}
