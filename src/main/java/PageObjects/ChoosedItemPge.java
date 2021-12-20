package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChoosedItemPge {
	
	private WebDriver driver;

	public ChoosedItemPge(WebDriver driver)
	{
		this.driver=driver;
	}

	By size=By.xpath("//div[@class='size-buttons-size-buttons']//div[2]//div[1]//button[1]");
	By addbutton=By.xpath("//div[normalize-space()='ADD TO BAG']");
	By bag=By.xpath("//span[@class='myntraweb-sprite desktop-iconBag sprites-headerBag']");
	

	public WebElement setdsize()
	{
		return driver.findElement(size);
	}
	
	public WebElement addbutton()
	{
		return driver.findElement(addbutton);
	}
	
	public BagPage checkBag()
	{
		String c=driver.findElement(By.cssSelector(".desktop-badge.desktop-melon")).getText();
		int count=Integer.parseInt(c);
		
		if(count>0)
		{
			System.out.println("item added into bag");
		}
		driver.findElement(bag).click();
		BagPage bp=new BagPage(driver);
		return bp;
	}
	
	
	

}
