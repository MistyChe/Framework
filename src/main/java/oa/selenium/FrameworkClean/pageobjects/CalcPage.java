package oa.selenium.FrameworkClean.pageobjects;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CalcPage extends AbstractPage{
	public CalcPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "input[name='a']")
	WebElement inputNamberA;
	@FindBy(css = "input[name='b']")
	WebElement inputNamberB;
	@FindBy(css = "input[name='sub']")
	public
	WebElement inputCalculate;
	@FindBy(css = "div[name='result']")
	public
	WebElement result;
	@FindBy(css = "input[value='mult']")
	WebElement mult;
	@FindBy(css = "input[value='plus']")
	WebElement plus;
	@FindBy(css = "input[value='division']")
	WebElement division;
	@FindBy(css = "input[value='minus']")
	WebElement minus;
	
	/*public CalcPage smokeCalcClick(){
		inputCalculate.click();
		return this;
	}*/
	public WebElement smokeCalcClick(){
		inputCalculate.click();
		return result;
	}
	
	public WebElement returnAction(String actionSelect){ // выбор варианта действия
	WebElement action;
	switch (actionSelect){
		case "+":
			action = plus;
			break;
		case "-":
			action = minus;
			break;
		case "*":
			action = mult;
			break;
		case "/":
			action = division;
			break;
		default: action = plus;
		}
		return action;
	}
	
	public WebElement fillInputs(String NumberA, String NumberB, String action){ //fill information into NumberA, NumberB
		inputNamberA.click();
		inputNamberA.clear();
		inputNamberA.sendKeys(NumberA);
		inputNamberB.click();
		inputNamberB.clear();
		inputNamberB.sendKeys(NumberB);
		returnAction(action).click();
		inputCalculate.click();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ArrayList<String[]> returnArrayList() {
		BufferedReader buffer = null;
		ArrayList<String[]> resultArray = new ArrayList<String[]>();
		String[] lines;
		try {
			String line;
			buffer = new BufferedReader(new FileReader("/home/mistyche/QAutomation/SmokeTest.csv"));
			while ((line = buffer.readLine()) != null) {
				lines = line.split(",");
				resultArray.add(lines);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (buffer != null) buffer.close();
			} catch (IOException myException) {
				myException.printStackTrace();
			}
		}
		
		return resultArray;
	}
}

