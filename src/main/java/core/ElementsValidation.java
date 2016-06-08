package core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class ElementsValidation 
{

  //  public  String    dynText_qoute = "id_quotes";
 //   public  String    page_Title    = "id_f_title";
 //   public  String    currentLocation = "id_current_location";
    
    
    public static String url = "http://learn2test.net/qa/apps/sign_up/v1/";
    public static   WebDriver driver ;
    
    public void before(){
 		driver = new FirefoxDriver();
 		driver.get(url);
 		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
 	}
 
    
    
 
    
    public  Dimension get_element_Dimension( String locator) {
        Dimension el_Size = driver.findElement(By.id(locator)).getSize();
    //    System.out.println("Size Width: " + el_Size.getWidth());
    //    System.out.println("Size Height: " + el_Size.getHeight());
      
        return el_Size;
    }

    public  Point get_element_Location( String locator) {

            Point el_Location = driver.findElement(By.id(locator)).getLocation();
      //      System.out.println("Location X: " + el_Location.getX());
      //      System.out.println("Location Y: " + el_Location.getY());
            return el_Location;

    }

    public  boolean element_isEnabled( String locator) {
        boolean el_isEnabled = driver.findElement(By.id(locator)).isEnabled();
        return el_isEnabled;
    }

    public  boolean element_isDisplayed(String locator ) {

            boolean el_isDisplayed = driver.findElement(By.id(locator)).isDisplayed();        
            return el_isDisplayed;
        }


    public  boolean element_isPresent( String locator) {
        boolean isPresent;

        try {
            isPresent= driver.findElements(By.id(locator)).size() > 0;
            return isPresent;

        } catch ( NoSuchElementException e ) {
            isPresent= driver.findElements(By.id(locator)).size() > 0;
            
        }
        return isPresent;
    }
    
}
