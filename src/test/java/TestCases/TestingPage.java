package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.BagPage;
import PageObjects.ChoosedItemPge;
import PageObjects.LandingPage;
import PageObjects.SectionPage;
import resources.Base;

public class TestingPage extends Base {
	
	public WebDriver driver;

	private static Logger log=LogManager.getLogger(TestingPage.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("driver get initialzed");
		
		driver.get("http://myntra.com/");
		log.info("website get opened");
		
	}
	
	@Test
	public void selectSection()
	{
		LandingPage lp=new LandingPage(driver);
		
		Actions ac=new Actions(driver);
		
		log.debug("cursor will move");
		
		ac.moveToElement(lp.setSection()).build().perform();
		
		log.info("cursor moved");
		
		SectionPage sp=lp.setSubSection();
		
		
		sp.sortby().click();
		log.info("sortby option clicked");
		
		sp.sortbyoption().click();
		
		sp.setbrand().click();
		log.info("brand get selected");
		
		sp.setprice().click();
		log.info("price selected");
		
		sp.setdiscountrange().click();
		log.info("discount range selected");
		
		ChoosedItemPge cip=sp.setitemchoosed();
		
		cip.setdsize().click();
		
		cip.addbutton().click();
		log.info("add to bag button clicked");
		
		BagPage bp=cip.checkBag();
		
		bp.gotoWishList().click();
		log.info("move to wish list clicked");
		
		
	}

	
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}
	

}
