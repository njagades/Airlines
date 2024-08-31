package project.pageobjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    WebDriver driver;
	QAClickJetLandingPage qaClick;
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public QAClickJetLandingPage getQAClickJetLandingPage()
	{
	
		qaClick= new QAClickJetLandingPage(driver);
	 return qaClick;
	}
}
