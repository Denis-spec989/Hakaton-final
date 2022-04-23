package com.example.demo.services.convertors.impl;

import com.example.demo.services.convertors.Convertable;

public class Foo implements Convertable {
    private final String name;

    public Foo() {
        this.name = "fooooooooo";
    }

    public String getName() {
        return name;
    }
}
