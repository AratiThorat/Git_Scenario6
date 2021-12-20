package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	private WebDriver driver;

	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}

	By section=By.xpath("//a[contains(text(),'Women')]");
	By subsection=By.xpath("//a[normalize-space()='Kurtas & Suits']");
	
	
	public WebElement setSection()
	{
		return driver.findElement(section);
	}
	
	public SectionPage setSubSection()
	{
		driver.findElement(subsection).click();
		SectionPage sp=new SectionPage(driver);
		return sp;
	}
}
