package com.example.demo.services.convertors;

import java.io.IOException;

public interface ConverterService<T> {
    public <V> T convert(V input) throws IOException;
}
