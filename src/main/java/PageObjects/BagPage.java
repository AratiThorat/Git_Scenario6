package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BagPage {


	private WebDriver driver;

	public BagPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By wishlist=By.xpath("//button[normalize-space()='MOVE TO WISHLIST']");
	
	public WebElement gotoWishList()
	{
		if(driver.findElement(By.cssSelector(".itemComponents-base-invisibleBackDrop")).isDisplayed())
		{
			driver.findElement(By.cssSelector(".itemComponents-base-invisibleBackDrop")).click();
		}
		return driver.findElement(wishlist);
	}
}
