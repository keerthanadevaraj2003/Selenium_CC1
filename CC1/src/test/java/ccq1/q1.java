package ccq1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    ChromeOptions co=new ChromeOptions();
			co.addArguments ("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup ();
			WebDriver driver=new ChromeDriver();
			driver.get ("https://www.saucedemo.com/");
			driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
			driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
			
			driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
			String initial = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
			driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
			String cart =  driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
			if(cart.equals(initial)) {
				System.out.println("Successfully product added to the cart");
				
			}
			else {
				System.out.println("oops");
				
			}
			String check_cart = driver.findElement(By.xpath("//*[@id=\"continue-shopping\"]")).getText();
			System.out.println(check_cart);
			if(check_cart.equals("Continue Shopping")) {
				System.out.println("HEY ! Cart is Open Smoothly ");
				
			}
			else {
				System.out.println("oops");
				
			}
			driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
			String checkout = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
			if(checkout.equals("Checkout: Your Information")) {
//				System.out.println("My information displayed");
				
			}
			else {
				System.out.println("oops");
				
			}
			driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Keerthana");
			driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Devaraj");
			driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("643004");
			driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
			String product_name = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText(); 
			String product_price = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
			if(product_name.equals(cart)) {
//				System.out.println("Entire pdt Overview is Displayed");
				System.out.println("NAME of the pdt: " + driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div")).getText());
		        System.out.println("PRICE of the pdt: " + driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div")).getText());
			}
			else {
				System.out.println(cart);
				System.out.println(product_name);
			}
			String title = driver.getTitle();
			if(title.equals("Swag Labs")) {
				System.out.println("TITLE matched");
			}
			else {
				System.out.println("TITLE mismatched");
			}
			if(driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-two.html")) {
				System.out.println("URL matched");
			}
			else {
				System.out.println("URL mismatched");

	}
	}
}