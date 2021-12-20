package PageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SectionPage {
	


	private WebDriver driver;

	public SectionPage(WebDriver driver)
	{
		this.driver=driver;
	}

	
	By sortby=By.xpath("//div[@class='sort-sortBy']");
	By sortbyoption=By.xpath("//ul[@class='sort-list']/li[1]");
	By brand=By.xpath("//div[@class='vertical-filters-filters brand-container']//li[8]//label[1]//div[1]");
	By price=By.xpath("//ul[1]//li[8]//label[1]//div[1]");
	By discountrange=By.xpath("//label[normalize-space()='50% and above']");
	By itemchoosed=By.xpath("//body/div[@id='mountRoot']/div/div[@class='application-base']/main[@class='search-base']/div[contains(@class,'row-base')]/div[@class='search-rightContainer column-base']/div[@id='desktopSearchResults']/div[@class='search-searchProductsContainer row-base']/section/ul[@class='results-base']/li[1]/a[1]/div[1]/div[1]");
	
	
	
	public WebElement sortby()
	{
		return driver.findElement(sortby);
	}
	
	public WebElement sortbyoption()
	{
		return driver.findElement(sortbyoption);
	}
	
	public WebElement setbrand()
	{
		return driver.findElement(brand);
	}
	
	public WebElement setprice()
	{
		return driver.findElement(price);
	}
	
	public WebElement setdiscountrange()
	{
		return driver.findElement(discountrange);
	}
	

	public ChoosedItemPge setitemchoosed()
	{
		driver.findElement(itemchoosed).click();
		
		Set<String> handles=driver.getWindowHandles();
		
		Iterator<String> it=handles.iterator();
		
		String parent= it.next();
		
		String child=it.next();
		
		driver.switchTo().window(child);
		
		ChoosedItemPge cip=new ChoosedItemPge(driver);
		return cip;
	}
	
}
