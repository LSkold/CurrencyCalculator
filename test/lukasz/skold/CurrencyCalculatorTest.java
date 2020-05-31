/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lukasz.skold;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lukasz Skold
 */
public class CurrencyCalculatorTest {
    
    @Test
    public void checkIfEverythingIsFine() {
        //Arrange
        CurrencyCalculator cc = new CurrencyCalculator();
        String goodValue = "1.3";
        int currentIndex;
        int wantedIndex;
        
        //Act     
        cc.setInputText(goodValue);
        
        currentIndex = cc.getCurrentCurrencyIndex();
        wantedIndex = cc.getWantedCurrencyIndex();
        double outValue = Double.parseDouble(goodValue)*cc.docParser.arrayOfValues.get(wantedIndex)/cc.docParser.arrayOfValues.get(currentIndex);
        String outValueS = String.format("%.2f", outValue);
        outValueS = outValueS.replace(',', '.');
        
        cc.enterPressed();
        
        //Assert
        assertEquals(cc.getOutputText(),outValueS);
        
    }
    @Test
    public void doNotTryWithNonNumberValue() {
        
        //Arrange 
        CurrencyCalculator cc = new CurrencyCalculator();
        String goodValue = "3.14";
        String badValue = "aaa";
        int currentIndex;
        int wantedIndex;
        
        //Act     
        cc.setInputText(goodValue);
        
        currentIndex = cc.getCurrentCurrencyIndex();
        wantedIndex = cc.getWantedCurrencyIndex();
        double outValue = Double.parseDouble(goodValue)*cc.docParser.arrayOfValues.get(wantedIndex)/cc.docParser.arrayOfValues.get(currentIndex);
        String outValueS = String.format("%.2f", outValue);
        outValueS = outValueS.replace(',', '.');
        
        cc.enterPressed();
        
        cc.setInputText(badValue);
        cc.enterPressed();
        
        //Assert
        assertEquals(cc.getOutputText(),outValueS);
        
    }
    
    @Test
    public void selfchanging(){
        //Arrange 
        CurrencyCalculator cc = new CurrencyCalculator();
        
        String goodValue = "4.20";
        int index = 2;
        
        //Act     
        cc.setInputText(goodValue);
        cc.setCurrentCurrencyIndex(index);
        cc.setWantedCurrencyIndex(index);
        
        cc.enterPressed();
        //Assert
        assertEquals(cc.getOutputText(),cc.getInputText());
    }
    
}
