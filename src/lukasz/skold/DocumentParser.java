/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lukasz.skold;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.w3c.dom.NodeList;
/**
 *
 * @author Lukasz Skold
 */
public class DocumentParser {
    
    public ArrayList<String> arrayOfNames;
    public ArrayList<Double> arrayOfValues;
    
    /**
     * Reads xml file and creates arrays
     */
    
    public DocumentParser(String fileURL){
        arrayOfNames = new ArrayList<String>();
        arrayOfValues = new ArrayList<Double>();
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc =  builder.parse(DocumentParser.class.getResource(fileURL).toString());
            NodeList currencyList = doc.getElementsByTagName("Cube");
           
            arrayOfNames.add("EUR");
            arrayOfValues.add(1.0);
             
            for(int i=0;i<currencyList.getLength();i++){
                Node c = currencyList.item(i);
                if(c.getNodeType()==Node.ELEMENT_NODE){
                    Element cube = (Element)c;
                    String currName = cube.getAttribute("currency");
                    if(currName.equals("")) {
                    } else {                
                        arrayOfNames.add(currName);
                    }                
                    String currValue = cube.getAttribute("rate");
                    if(currValue.equals("")) {
                    } else {                
                        double currValueD = Double.parseDouble(currValue);
                        arrayOfValues.add(currValueD);
                    }    
                }
            }                   
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DocumentParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DocumentParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DocumentParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
