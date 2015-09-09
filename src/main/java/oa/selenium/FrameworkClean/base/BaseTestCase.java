package oa.selenium.FrameworkClean.base;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import oa.selenium.FrameworkClean.pageobjects.CalcPage;

public class BaseTestCase extends TestBase {
	
	@BeforeClass
	void initPageFactory(){
	PageFactory.initElements(getDriver(), CalcPage.class);
	}
}
