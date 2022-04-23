package com.example.demo.convertors;

import com.example.demo.dto.PetrolStationDto;
import org.w3c.dom.Document;

import java.lang.annotation.Documented;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public interface XMLInterface {
   public ArrayList<PetrolStationDto> parseXML();

}
