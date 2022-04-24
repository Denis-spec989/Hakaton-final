package com.example.demo.services.convertors.impl;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.services.convertors.Converter;
import com.example.demo.services.convertors.impl.models.PXML;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class XmlConverter implements Converter<PXML, Iterable<PetrolStationDto>> {

    @Override
    public ArrayList<PetrolStationDto> convert(PXML input) {
        MultipartFile mF = input.getMultipartFile();
        ArrayList<PetrolStationDto> psDtoList = new ArrayList<PetrolStationDto>();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(mF.getInputStream());
            System.out.println(doc.getTextContent());
            // Получаем корневой элемент
            Node root = doc.getDocumentElement();
            // Просматриваем все подэлементы корневого - т.е. заправки
            NodeList petrolStations = root.getChildNodes();
            for(int i = 0; i<petrolStations.getLength();i++){
                Node petrolStation = petrolStations.item(i);
                // Если нода не заправке, то это книга - заходим внутрь
                if(petrolStation.getNodeType() != Node.TEXT_NODE) {
                    NodeList psProps = petrolStation.getChildNodes();
                    int m =0;
                    PetrolStationDto  psDto = new PetrolStationDto();
                    for(int j=0; j<psProps.getLength();j++) {
                        Node psProp = psProps.item(j);
                        // Если нода не текст, то это один из параметров книги - печатаем
                        if (psProp.getNodeType() != Node.TEXT_NODE && psProp.getChildNodes().item(0).getTextContent()!=null) {
                            switch (m){
                                case 0 : {psDto.setAddress(psProp.getChildNodes().item(0).getTextContent());
                                    System.out.println("Address=");
                                    System.out.println(psDto.getAddress());
                                m++;}
                                    break;
                                case 1 : {
                                    psDto.setName(psProp.getChildNodes().item(0).getTextContent());
                                    psDto.setLatitude(Double.parseDouble(psDto.getName()));
                                    System.out.println("latitude=");
                                    System.out.println(psDto.getLatitude());
                                    m++;}break;
                                case 2 : {
                                    psDto.setName(psProp.getChildNodes().item(0).getTextContent());
                                    psDto.setLongtitude(Double.parseDouble(psDto.getName()));
                                    System.out.println("longtitude=");
                                    System.out.println(psDto.getLongtitude());
                                    m++;} break;
                                case 3 : {
                                    psDto.setName(psProp.getChildNodes().item(0).getTextContent());
                                    System.out.print("Name=");
                                    System.out.println(psDto.getName());
                                    m++;}break;
                                case 4 : {psDto.setCountry(psProp.getChildNodes().item(0).getTextContent());
                                    System.out.println("Country=");
                                    System.out.println(psDto.getCountry());
                                    m++;}; break;
                                case 5 : {psDto.setPhone(psProp.getChildNodes().item(0).getTextContent());
                                    System.out.println("Phone=");
                                    System.out.println(psDto.getPhone());
                                    m++;}; break;
                                case 6 : {psDto.setRegion(psProp.getChildNodes().item(0).getTextContent());
                                    System.out.println("Region=");
                                    System.out.println(psDto.getRegion());
                                    m++;} break;

                            }
                        }

                    }
                    psDtoList.add(psDto);
                }
            }
            return psDtoList;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public String getInputType() {
        return PXML.class.getName();
    }

    @Override
    public String getOutputType() {
        return Iterable.class.getName();
    }
}
