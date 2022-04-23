package com.example.demo.services;

import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.http.HttpResponse;

public class XMLServiceImpl implements XMLInterface {


    @Override
    public void parseXML(HttpResponse response) {
       try {
           DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
           DocumentBuilder db = dbf.newDocumentBuilder();
           Document doc = db.parse(new URL("").openStream());

       } catch (ParserConfigurationException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } catch (SAXException e) {
           e.printStackTrace();
       }


    }
}
