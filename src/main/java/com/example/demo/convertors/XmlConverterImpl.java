package com.example.demo.convertors;

import com.example.demo.dto.PetrolStationDto;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.*;
import java.util.ArrayList;

public  class XmlConverterImpl  {



    public static ArrayList<PetrolStationDto> parseXML(MultipartFile file)  {
        ArrayList<PetrolStationDto> psDtoList = new ArrayList<PetrolStationDto>();
        try {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(convertMultiPartToFile(file)));
            while (reader.hasNext()) {
                PetrolStationDto station = new PetrolStationDto();
                XMLEvent nextEvent = reader.nextEvent();
                if (nextEvent.isStartElement()) {
                    StartElement startElement = nextEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "Address":
                            //station = new Station();
                            nextEvent = reader.nextEvent();
                            if (!nextEvent.isCharacters()) {
                                station.setAddress("");
                            } else {
                                station.setAddress(nextEvent.asCharacters().getData());
                            }break;
                        case "latitude":
                            nextEvent = reader.nextEvent();
                            if (!nextEvent.isCharacters()) {

                            } else {
                                station.setLatitude(Double.parseDouble(nextEvent.asCharacters().getData()));
                            }break;

                        case "longtitude":
                            nextEvent = reader.nextEvent();
                            if (!nextEvent.isCharacters()) {

                            } else {
                                station.setLongtitude(Double.parseDouble(nextEvent.asCharacters().getData()));
                            }break;


                        case "Name":
                            nextEvent = reader.nextEvent();
                            station.setName(nextEvent.asCharacters().getData());
                            break;
                        case "Country":
                            nextEvent = reader.nextEvent();
                            if (!nextEvent.isCharacters()) {
                                station.setCountry("-");
                            } else {
                                station.setCountry(nextEvent.asCharacters().getData());
                            }
                            break;
                        case "Phone":
                            nextEvent = reader.nextEvent();
                            if (!nextEvent.isCharacters()) {
                                station.setPhone("-");
                            } else {
                                station.setPhone(nextEvent.asCharacters().getData());
                            }
                            break;
                        case "Region":
                            nextEvent = reader.nextEvent();
                            if (!nextEvent.isCharacters()) {
                                station.setRegion("-");
                            } else {
                                station.setRegion(nextEvent.asCharacters().getData());
                            }
                            break;

                    }
                }
                psDtoList.add(station);
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return psDtoList;
        //return null;
    }
      /*  System.out.println("#####");
    try {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file.getInputStream());
        System.out.println(doc);
    } catch (ParserConfigurationException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (SAXException e) {
        e.printStackTrace();
    }
return null;

        try {
            ArrayList<PetrolStationDto> psDtoList = new ArrayList<PetrolStationDto>();
            System.out.println("######");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            //File ioFile = new File();
            //file.transferTo(ioFile);
            Document doc = db.parse(file.getInputStream());
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
                                    psDto.setLatitude(Double.parseDouble(psProp.getChildNodes().item(0).toString()));
                                    System.out.println("latitude=");
                                    System.out.println(psDto.getLatitude());}break;
                                case 3 : {
                                    psDto.setLongtitude(Double.parseDouble(psProp.getChildNodes().item(0).toString()));
                                    System.out.println("longtitude=");
                                    System.out.println(psDto.getLongtitude());} break;


                                case 4 : {
                                    psDto.setName(psProp.getChildNodes().item(0).getTextContent());
                                    System.out.print("Name=");
                                    System.out.println(psDto.getName());}break;
                                case 5 : {psDto.setCountry(psProp.getChildNodes().item(0).getTextContent());
                                    System.out.println("Country=");
                                    System.out.println(psDto.getCountry());}; break;
                                case 6 : psDto.setPhone(psProp.getChildNodes().item(0).getTextContent()); break;
                                case 7 : psDto.setRegion(psProp.getChildNodes().item(0).getTextContent()); break;

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
    */
      private static File convertMultiPartToFile(MultipartFile file) throws IOException {
          File convFile = new File( file.getOriginalFilename() );
          FileOutputStream fos = new FileOutputStream( convFile );
          fos.write( file.getBytes() );
          fos.close();
          return convFile;
      }
}
