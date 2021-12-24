package FlipcartAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipcartProduct {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("perfume");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        String producttitle=driver.findElement(By.xpath("//a[@class='s1Q9rs']")).getAttribute("title");
        System.out.println(producttitle);
        String price=driver.findElement(By.xpath("//div[@class='_30jeq3']")).getText();
        System.out.println("RS."+price);
        List<WebElement> productlist =driver.findElements(By.xpath("//a[@class='s1Q9rs']"));
        List<WebElement> pricelist=driver.findElements(By.xpath("//div[@class='_30jeq3']"));
        System.out.println("Total no of perfumeproductnames "+productlist.size() );
        System.out.println("Total no of perfume price "+pricelist.size());
        for(int i=0;i<productlist.size();i++) {
        	System.out.println(productlist.get(i).getText() + "               "+"RS."+pricelist.get(i).getText());
        	}


       
	

}
}
