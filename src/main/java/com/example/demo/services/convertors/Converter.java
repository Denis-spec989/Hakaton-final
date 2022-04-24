package com.example.demo.services.convertors;

import java.io.IOException;

public interface Converter<T, V> {
    V convert(T input) throws IOException;

    String getInputType();

    String getOutputType();
}
