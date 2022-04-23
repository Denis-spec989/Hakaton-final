package com.example.demo.services.convertors;

// T - тип в который нужно переводить. В нашем случаем это PetrolStationDto
public interface SuperConverter<T> {

    boolean hasConverter(InputType type);

    Iterable<InputType> getAvailableTypes();

    <V> T convert(InputType type, V input);

    // TODO: попробовать сделать так чтобы он сам находил конверторы, а не они его
    void addConverter(Converter<?, T> converter);
}
