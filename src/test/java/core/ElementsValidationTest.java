package core;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class ElementsValidationTest {

	      public static ElementsValidation elValid = new ElementsValidation ();
 
  @BeforeClass
  public void beforeClass() throws Exception{
	  elValid.before();
	 
  }

  @AfterClass
  public void afterClass() {
	  
  }

  
  
  @Test 
  public void testJsonFile () {
	  for (MainPageElements mpe : elValid.lampe) {
		  System.out.println("collection element #" + elValid.lampe.indexOf((Object)mpe) + " with locator=" + mpe.locator);
		  test_0101_dynText_qoute_isPresent(mpe);
		  test_0102_dynText_qoute_Validation (mpe);
	  }
  }
 
  //@Test  
  public void test_0101_dynText_qoute_isPresent (MainPageElements mpe) {
	//String   el_locator = elValid.dynText_qoute;
    Assert.assertEquals(elValid.element_isPresent(mpe.locator), (boolean)mpe.isPresent);
  }
    
  //@Test   
  public void test_0102_dynText_qoute_Validation (MainPageElements mpe) {

	  Assert.assertEquals((boolean)elValid.element_isDisplayed(mpe.locator), (boolean)mpe.isDisplayed);
	  Assert.assertEquals((boolean)elValid.element_isEnabled(mpe.locator), (boolean)mpe.isEnabled);
	  Assert.assertEquals((int)elValid.get_element_Location(mpe.locator).getX(), (int)mpe.location_X);
	  Assert.assertEquals((int)elValid.get_element_Location(mpe.locator).getY(), (int)mpe.location_Y);
	  Assert.assertEquals((int)elValid.get_element_Dimension(mpe.locator).getWidth(), (int)mpe.sizeWidth);
	  Assert.assertEquals((int)elValid.get_element_Dimension(mpe.locator).getHeight(), (int)mpe.sizeHeight);
  }
 
  
/*  
 * @Test 
  public void testJsonFile () {
	  for (MainPageElements mpe : elValid.lampe) {
		  System.out.println("collection element #" + elValid.lampe.indexOf((Object)mpe) + " with locator=" + mpe.locator);
		  test_0101_dynText_qoute_isPresent(mpe);
		  test_0102_dynText_qoute_Validation (mpe);
	  }
  }
 
  //@Test  
  public void test_0101_dynText_qoute_isPresent (MainPageElements mpe) {
	//String   el_locator = elValid.dynText_qoute;
    Assert.assertEquals(elValid.element_isPresent(mpe.locator), (boolean)mpe.isPresent);
  }
    
  //@Test   
  public void test_0102_dynText_qoute_Validation (MainPageElements mpe) {

	  Assert.assertEquals((boolean)elValid.element_isDisplayed(mpe.locator), (boolean)mpe.isDisplayed);
	  Assert.assertEquals((boolean)elValid.element_isEnabled(mpe.locator), (boolean)mpe.isEnabled);
	  Assert.assertEquals((int)elValid.get_element_Location(mpe.locator).getX(), (int)mpe.location_X);
	  Assert.assertEquals((int)elValid.get_element_Location(mpe.locator).getY(), (int)mpe.location_Y);
	  Assert.assertEquals((int)elValid.get_element_Dimension(mpe.locator).getWidth(), (int)mpe.sizeWidth);
	  Assert.assertEquals((int)elValid.get_element_Dimension(mpe.locator).getHeight(), (int)mpe.sizeHeight);
  }
 * 
 * 
 * 
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
