package oa.selenium.FrameworkClean.tests;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import oa.selenium.FrameworkClean.base.TestBase;
import oa.selenium.FrameworkClean.pageobjects.CalcPage;


public class FanctionalTest extends TestBase{
	private WebDriver driver;
	
	CalcPage cp = new CalcPage(driver);	
		@BeforeClass
		public void setUp() {
			driver=getDriver(BrowserType.FIREFOX, "http://darom.kharkov.ua/calculator.php");
			
		}
		
		@Test
		public void plusTest() {
			ArrayList<String[]> parameters = new ArrayList<String[]>();
			CalcPage cp = new CalcPage(driver);	
			parameters = cp.returnArrayList();
			for (String[] a:parameters){
				if (a[3].toString().equals("+")){
				System.out.println(a[0].toString() + " " + a[1].toString() + " " + a[2].toString());
				Assert.assertTrue(cp.fillInputs(a[0].toString(),a[1].toString(),a[3].toString()).getText().equals("Result: " + a[2].toString()));
				
				}
			}
		}
		
		@Test
		public void minusTest() {
			ArrayList<String[]> parameters = new ArrayList<String[]>();
			CalcPage cp = new CalcPage(driver);	
			parameters = cp.returnArrayList();
			for (String[] a:parameters){
				if (a[3].toString().equals("-")){
				System.out.println(a[0].toString() + " " + a[1].toString() + " " + a[2].toString());
				Assert.assertTrue(cp.fillInputs(a[0].toString(),a[1].toString(),a[3].toString()).getText().equals("Result: " + a[2].toString()));
				
				}
			}
		}
		
		@Test
		public void multTest() {
			ArrayList<String[]> parameters = new ArrayList<String[]>();
			CalcPage cp = new CalcPage(driver);	
			parameters = cp.returnArrayList();
			for (String[] a:parameters){
				if (a[3].toString().equals("*")){
				System.out.println(a[0].toString() + " " + a[1].toString() + " " + a[2].toString());
				Assert.assertTrue(cp.fillInputs(a[0].toString(),a[1].toString(),a[3].toString()).getText().equals("Result: " + a[2].toString()));
				
				}
			}
		}
		@Test
		public void divisionTest() {
			ArrayList<String[]> parameters = new ArrayList<String[]>();
			CalcPage cp = new CalcPage(driver);	
			parameters = cp.returnArrayList();
			for (String[] a:parameters){
				if (a[3].toString().equals("/")){
				System.out.println(a[0].toString() + " " + a[1].toString() + " " + a[2].toString());
				Assert.assertTrue(cp.fillInputs(a[0].toString(),a[1].toString(),a[3].toString()).getText().contains("Result: " + a[2].toString()));
				
				}
			}
		}
		
}
