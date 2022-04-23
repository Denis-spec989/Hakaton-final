package com.example.demo.services;

import org.w3c.dom.Document;

import java.lang.annotation.Documented;
import java.net.http.HttpResponse;

public interface XMLInterface {
   public void parseXML(HttpResponse response);

}
