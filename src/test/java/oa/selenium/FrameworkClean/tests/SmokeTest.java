package oa.selenium.FrameworkClean.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import oa.selenium.FrameworkClean.base.TestBase;
import oa.selenium.FrameworkClean.pageobjects.CalcPage;

public class SmokeTest extends TestBase{
	CalcPage cp;
	
		@BeforeClass
		public void setUp() {
			
			createDriver(BrowserType.CHROME, "http://darom.kharkov.ua/calculator.php");
			cp = new CalcPage(getDriver());
		}
		
		@Test
		public void SmokeTest1(){
			cp.inputCalculate.click();
			String exp2 = "should be selected";
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertTrue(cp.result.getText().contains(exp2));
		}
		
		@Test
		public void SmokeTest2(){
			Assert.assertTrue(cp.fillInputs("2", "16", "*").getText().equals("Result: 32"));
		}
		
		@Test
		public void SmokeTest3(){
			Assert.assertTrue(cp.fillInputs("2", "60", "+").getText().equals("Result: 62"));
		}
}
