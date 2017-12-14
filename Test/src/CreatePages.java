import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



/* this code reads the pages from .txt file and create the pages in wordpress*/
public class CreatePages {
	static String content;
public static void main (String[] args) throws InterruptedException {
	System.out.println("Start of the code");
	
	  
	  System.setProperty("webdriver.gecko.driver", "geckodriver");
	  WebDriver driver = new FirefoxDriver();
	  //following line is the site name on DEMO
	  driver.get("http://rsequipment.com.demo.prod.cwsplatform.com/wp-admin/");
	  //the following two lines are the username and password for wordpress login
	  driver.findElement(By.xpath("//*[@id=\"layout-static\"]/div/div/div/div/div/div/form/div/div[1]/div[2]/input")).sendKeys("tfouda");
	  driver.findElement(By.xpath("//*[@id=\"layout-static\"]/div/div/div/div/div/div/form/div/div[1]/div[3]/input")).sendKeys("##");
	  driver.findElement(By.xpath("//*[@id=\"layout-static\"]/div/div/div/div/div/div/form/div/div[2]/div/input")).click();

	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  //wait until page loads after signing in
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wp-admin-bar-view-my-site\"]/a/span")));
	  driver.findElement(By.xpath("//*[@id=\"menu-pages\"]/a/div[3]")).click();
	  waitForPageToLoad(driver);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/a")));
	  
	  // click on Add new Page buttpm
	  driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/a")).click(); // add new button
	  


	  
	  try {
		  
		  // path of the file that contains the custom pages Titles
			File file = new File("/Users/tarekfouda/t.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				//wait till text field appears
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"title\"]")));
				  //variable line contains the title of the page and put it in the title box
				
				  driver.findElement(By.xpath("//*[@id=\"title\"]")).sendKeys(line);
				  
				  // Publish the page
				  driver.findElement(By.xpath("//*[@id=\"publish\"]")).click();
				  
				  waitForPageToLoad(driver);
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/a")));
				
				  driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/a")).click();
				  waitForPageToLoad(driver);
				  //end of loop
			}
			fileReader.close();
			
			/* creating Photo Gallery, Staff, Links, Testimonials, Service Request  */
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"title\"]")));
			  //variable line contains the title of the page and put it in the title box
			
			  driver.findElement(By.xpath("//*[@id=\"title\"]")).sendKeys("Photo Gallery");
			  
			  // Publish the page
			  driver.findElement(By.xpath("//*[@id=\"publish\"]")).click();
			  
			  waitForPageToLoad(driver);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/a")));
			
			  driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/a")).click();
			  waitForPageToLoad(driver);
			  
			  
			  
			  
			  
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"title\"]")));
			  //variable line contains the title of the page and put it in the title box
			
			  driver.findElement(By.xpath("//*[@id=\"title\"]")).sendKeys("Staff");
			  
			  // Publish the page
			  driver.findElement(By.xpath("//*[@id=\"publish\"]")).click();
			  
			  waitForPageToLoad(driver);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/a")));
			
			  driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/a")).click();
			  waitForPageToLoad(driver);
			  
			  
			  
			  
			  
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"title\"]")));
			  //variable line contains the title of the page and put it in the title box
			
			  driver.findElement(By.xpath("//*[@id=\"title\"]")).sendKeys("Links");
			  
			  // Publish the page
			  driver.findElement(By.xpath("//*[@id=\"publish\"]")).click();
			  
			  waitForPageToLoad(driver);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/a")));
			
			  driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/a")).click();
			  waitForPageToLoad(driver);
			  
			  
			  
			  
			  
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"title\"]")));
			  //variable line contains the title of the page and put it in the title box
			
			  driver.findElement(By.xpath("//*[@id=\"title\"]")).sendKeys("Testimonials");
			  
			  // Publish the page
			  driver.findElement(By.xpath("//*[@id=\"publish\"]")).click();
			  
			  waitForPageToLoad(driver);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/a")));
			
			  driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/a")).click();
			  waitForPageToLoad(driver);
			  
			  
			  
			  
			  
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"title\"]")));
			  //variable line contains the title of the page and put it in the title box
			
			  driver.findElement(By.xpath("//*[@id=\"title\"]")).sendKeys("Service Request");
			  
			  // Publish the page
			  driver.findElement(By.xpath("//*[@id=\"publish\"]")).click();
			  
			  waitForPageToLoad(driver);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/a")));
			
			  driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/a")).click();
			  waitForPageToLoad(driver);
			  
			/* End of adding those .asp pages*/
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
public static void waitForPageToLoad(WebDriver driver) {
    ExpectedCondition < Boolean > pageLoad = new
    ExpectedCondition < Boolean > () {
        public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        }
    };

    Wait < WebDriver > wait = new WebDriverWait(driver, 60);
    try {
        wait.until(pageLoad);
    } catch (Throwable pageLoadWaitError) {
       System.out.println("Timeout during page load");
    }
}
}
