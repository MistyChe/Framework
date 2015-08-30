package oa.selenium.FrameworkClean.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import oa.selenium.FrameworkClean.base.TestBase;
import oa.selenium.FrameworkClean.pageobjects.CalcPage;

public class SmokeTest extends TestBase{
	
	private WebDriver driver;
	
		@BeforeClass
		public void setUp() {
			
			driver=getDriver(BrowserType.FIREFOX, "http://darom.kharkov.ua/calculator.php");
		}
		
		@Test
		public void SmokeTest1(){
			CalcPage cp = new CalcPage(driver);	
			cp.inputCalculate.click();
			String exp2 = "should be selected";
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(cp.result.getText().contains(exp2));
		}
		@Test
		public void SmokeTest2(){
			CalcPage cp = new CalcPage(driver);
			Assert.assertTrue(cp.fillInputs("2", "16", "*").getText().equals("Result: 32"));
		}
		@Test
		public void SmokeTest3(){
			CalcPage cp = new CalcPage(driver);
			Assert.assertTrue(cp.fillInputs("2", "60", "+").getText().equals("Result: 62"));
		}
		
}
