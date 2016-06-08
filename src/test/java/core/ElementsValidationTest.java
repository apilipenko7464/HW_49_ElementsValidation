package core;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class ElementsValidationTest {

	public static ElementsValidation elValid = new ElementsValidation ();
		  
	public ArrayList<MainPageElements> lampe = new ArrayList<MainPageElements>();



/**
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
 **/ 
  
  @BeforeClass
  public void beforeClass() throws Exception{
	  elValid.before();
	  loadTestData("./src/test/resources/data/mainPage.json");

  }

  @AfterClass
  public void afterClass() {
	  
  }

  public void loadTestData(String path){
	     Long tmp = 0L;
	     JSONParser parser = new JSONParser();
	      //int i = 0;
	    try {
	        JSONArray a = (JSONArray) parser.parse(new FileReader(path));
	        for (Object o : a)
	        {
	        	MainPageElements mpe = new MainPageElements();
	            JSONObject elements= (JSONObject) o;

	            mpe.locator = (String) elements.get("locator");                    
	            mpe.isPresent = (Boolean) elements.get("isPresent");            
	            mpe.isDisplayed = (Boolean) elements.get("isDisplayed");         
	            mpe.isEnabled = (Boolean) elements.get("isEnabled");   
	            tmp = (Long)elements.get("location_X");   
	            mpe.location_X = tmp.intValue();   
	            tmp = (Long)elements.get("location_Y"); 
	            mpe.location_Y = tmp.intValue();      
	            tmp = (Long)elements.get("sizeWidth"); 
	            mpe.sizeWidth = tmp.intValue();   
	            tmp = (Long)elements.get("sizeHeight");
	            mpe.sizeHeight = tmp.intValue();

	            lampe.add(mpe);
	            
	            //String   key = lampe.get(0).locator;
	      //    String   element = lampe.get(i).locator;
	     //     String   element = lampe.get(i).locator;
	            //System.out.println("collection element #" + i + ": " + key);
	            //i++;
	        }


	    } catch (FileNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (ParseException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	  
} 

  @Test 
  public void testJsonFile () {
	  for (MainPageElements mpe : lampe) {
		  System.out.println("collection element #" + lampe.indexOf((Object)mpe) + " with locator=" + mpe.locator);
		  test_0101_dynText_qoute_isPresent(mpe);
		  test_0102_dynText_qoute_Validation (mpe);
	  }
  }
 
  //@Test   //(dataProvider = "dp")
  public void test_0101_dynText_qoute_isPresent (MainPageElements mpe) {
	//String   el_locator = elValid.dynText_qoute;
    Assert.assertEquals(elValid.element_isPresent(mpe.locator), (boolean)mpe.isPresent);
  }
    
  //@Test   
  public void test_0102_dynText_qoute_Validation (MainPageElements mpe) {
	//String   el_locator = elValid.dynText_qoute;
	  Assert.assertEquals((boolean)elValid.element_isDisplayed(mpe.locator), (boolean)mpe.isDisplayed);
	  Assert.assertEquals((boolean)elValid.element_isEnabled(mpe.locator), (boolean)mpe.isEnabled);
	  Assert.assertEquals((int)elValid.get_element_Location(mpe.locator).getX(), (int)mpe.location_X);
	  Assert.assertEquals((int)elValid.get_element_Location(mpe.locator).getY(), (int)mpe.location_Y);
	  Assert.assertEquals((int)elValid.get_element_Dimension(mpe.locator).getWidth(), (int)mpe.sizeWidth);
	  Assert.assertEquals((int)elValid.get_element_Dimension(mpe.locator).getHeight(), (int)mpe.sizeHeight);
  }
 
  
/*  
  @Test   
  public void test_0201_page_Title_isPresent () {
	String   el_locator = elValid.page_Title;
    Assert.assertEquals(elValid.element_isPresent(el_locator), true);
  }
  @Test 
  public void test_0202_dynText_qoute_Validation () {
	String   el_locator = elValid.page_Title;
	  Assert.assertEquals(elValid.element_isDisplayed(el_locator), true);
	  Assert.assertEquals(elValid.element_isEnabled(el_locator), true);
	  Assert.assertEquals(elValid.element_isEnabled(el_locator), true);
	  Assert.assertEquals(elValid.get_element_Location(el_locator).getX(), 320);
	  Assert.assertEquals(elValid.get_element_Location(el_locator).getY(), 86);
	  Assert.assertEquals(elValid.get_element_Dimension(el_locator).getWidth(), 151);
	  Assert.assertEquals(elValid.get_element_Dimension(el_locator).getHeight(), 45);
  }
  
  
  @Test   
  public void test_0301_currentLocation_isPresent () {
	String   el_locator = elValid.page_Title;
    Assert.assertEquals(elValid.element_isPresent(el_locator), true);
  }
  
  @Test
  public void test_0302_currentLocation_Validation () {
	String   el_locator = elValid.currentLocation;
	  Assert.assertEquals(elValid.element_isDisplayed(el_locator), true);
	  Assert.assertEquals(elValid.element_isEnabled(el_locator), true);
	  Assert.assertEquals(elValid.element_isEnabled(el_locator), true);
	  Assert.assertEquals(elValid.get_element_Location(el_locator).getX(), 916);
	  Assert.assertEquals(elValid.get_element_Location(el_locator).getY(), 70);
	  Assert.assertEquals(elValid.get_element_Dimension(el_locator).getWidth(), 178);
	  Assert.assertEquals(elValid.get_element_Dimension(el_locator).getHeight(), 25);
  }
  */
}
