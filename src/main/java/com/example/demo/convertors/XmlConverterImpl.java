package com.example.demo.convertors;

import com.example.demo.dto.PetrolStationDto;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.util.ArrayList;

public  class XmlConverterImpl  {

    public static ArrayList<PetrolStationDto> parseXML(MultipartFile mF)  {


        ArrayList<PetrolStationDto> psDtoList = new ArrayList<PetrolStationDto>();
        try {

            System.out.println("######");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            //File ioFile = new File();
            //file.transferTo(ioFile);
            Document doc = db.parse(mF.getInputStream());
            System.out.println(doc.getTextContent());
            System.out.println("#####7");
            // Получаем корневой элемент
            Node root = doc.getDocumentElement();
            // Просматриваем все подэлементы корневого - т.е. заправки
            NodeList petrolStations = root.getChildNodes();
            for(int i = 0; i<petrolStations.getLength();i++){
                Node petrolStation = petrolStations.item(i);
                // Если нода не заправке, то это книга - заходим внутрь
                if(petrolStation.getNodeType() != Node.TEXT_NODE) {
                    NodeList psProps = petrolStation.getChildNodes();
                    System.out.println("psPropslength=");
                    System.out.println(psProps.getLength());
                    for(int j=0; j<psProps.getLength();j++) {
                        Node psProp = psProps.item(j);
                        PetrolStationDto  psDto = new PetrolStationDto();
                        // Если нода не текст, то это один из параметров книги - печатаем
                        if (psProp.getNodeType() != Node.TEXT_NODE) {
                            //System.out.println(psProp.getNodeName());
                            switch (j){
                                case 1 : {psDto.setAddress(psProp.getChildNodes().item(0).getTextContent());
                                    System.out.println("Address=");
                                    System.out.println(psDto.getAddress());}
                                    break;
                                case 2 : {
                                    psDto.setName(psProp.getChildNodes().item(0).getTextContent());
                                    psDto.setLatitude(Double.parseDouble(psDto.getName()));
                                    System.out.println("latitude=");
                                    System.out.println(psDto.getLatitude());}break;
                                case 6 : {
                                    psDto.setName(psProp.getChildNodes().item(0).getTextContent());
                                    psDto.setLongtitude(Double.parseDouble(psDto.getName()));
                                    System.out.println("longtitude=");
                                    System.out.println(psDto.getLongtitude());} break;


                                case 7 : {
                                    psDto.setName(psProp.getChildNodes().item(0).getTextContent());
                                    System.out.print("Name=");
                                    System.out.println(psDto.getName());}break;
                                case 9 : {psDto.setCountry(psProp.getChildNodes().item(0).getTextContent());
                                    System.out.println("Country=");
                                    System.out.println(psDto.getCountry());}; break;
                                case 11 : {psDto.setPhone(psProp.getChildNodes().item(0).getTextContent());
                                    System.out.println("Phone=");
                                    System.out.println(psDto.getPhone());}; break;
                                case 13 : {psDto.setRegion(psProp.getChildNodes().item(0).getTextContent());
                                    System.out.println("Region=");
                                    System.out.println(psDto.getRegion());} break;

                            }


                        }
                        psDtoList.add(psDto);
                    }
                }
            }
            //System.out.println(psDtoList.stream().toString());
            //PrintWriter writer = new PrintWriter(ioFile);
            //writer.print("");
            //writer.close();
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

}
