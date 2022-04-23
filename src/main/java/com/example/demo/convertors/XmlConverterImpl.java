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
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class XmlConverterImpl implements XMLInterface {


    @Override
    public ArrayList<PetrolStationDto> parseXML(MultipartFile file) {

       try {
           ArrayList<PetrolStationDto> psDtoList = new ArrayList<PetrolStationDto>();
           DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
           DocumentBuilder db = dbf.newDocumentBuilder();
           File ioFile = new File("/resources/XMLFiles/File.tmp");
           file.transferTo(ioFile);
           Document doc = db.parse(ioFile);
           // Получаем корневой элемент
           Node root = doc.getDocumentElement();
           // Просматриваем все подэлементы корневого - т.е. заправки
           NodeList petrolStations = root.getChildNodes();
           for(int i = 0; i<petrolStations.getLength();i++){
            Node petrolStation = petrolStations.item(i);
            // Если нода не заправке, то это книга - заходим внутрь
            if(petrolStation.getNodeType() != Node.TEXT_NODE) {
                NodeList psProps = petrolStation.getChildNodes();
                for(int j=0; j<psProps.getLength();j++) {
                   Node psProp = psProps.item(j);
                    PetrolStationDto psDto = new PetrolStationDto();
                    // Если нода не текст, то это один из параметров книги - печатаем
                    if (psProp.getNodeType() != Node.TEXT_NODE) {
                        switch (j){
                            case 0 : psDto.setAddress(psProp.getChildNodes().item(0).getTextContent());
                            case 1 : psDto.setLatitude(Double.parseDouble(psProp.getChildNodes().item(0).getTextContent()));
                            case 2 : psDto.setLongitude(Double.parseDouble(psProp.getChildNodes().item(0).getTextContent()));
                            case 3 : psDto.setName(psProp.getChildNodes().item(0).getTextContent());
                            case 4 : psDto.setCountry(psProp.getChildNodes().item(0).getTextContent());
                            case 5 : psDto.setPhone(psProp.getChildNodes().item(0).getTextContent());
                            case 6 : psDto.setRegion(psProp.getChildNodes().item(0).getTextContent());
                        }
                        psDtoList.add(psDto);
                    }
                }
            }
           }
           FileUtils.deleteDirectory(ioFile);
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
