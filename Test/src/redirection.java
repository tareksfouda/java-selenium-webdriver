import java.util.List;
import java.util.concurrent.TimeUnit;

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

public class redirection {
	static String content;
public static void main (String[] args) throws InterruptedException {
	System.out.println("fdfdsfd");
	
	  
	  System.setProperty("webdriver.gecko.driver", "geckodriver");
	  WebDriver driver = new FirefoxDriver();
	  driver.get("http://TRI-LIFT.com.demo.prod.cwsplatform.com/wp-admin");
	  driver.findElement(By.xpath("//*[@id=\"layout-static\"]/div/div/div/div/div/div/form/div/div[1]/div[2]/input")).sendKeys("USERNAME");
	  driver.findElement(By.xpath("//*[@id=\"layout-static\"]/div/div/div/div/div/div/form/div/div[1]/div[3]/input")).sendKeys("PASSWORD");
	  driver.findElement(By.xpath("//*[@id=\"layout-static\"]/div/div/div/div/div/div/form/div/div[2]/div/input")).click();
	  //driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-view-my-site\"]/a/span")).click();
	  //driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-view-my-site\"]/a/span")).click();
	 // driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wp-admin-bar-view-my-site\"]/a/span")));
	  
	  //click on tools
	  
	  driver.findElement(By.xpath("//*[@id=\"menu-tools\"]/a/div[3]")).click();
	  
	  waitForPageToLoad(driver);
	  
	  //click on redirect
	  
	  driver.findElement(By.xpath("//*[@id=\"menu-tools\"]/ul/li[6]/a")).click();
	  
	  waitForPageToLoad(driver);
	  
	
	  
	   


	  
	  try {
			File file = new File("/Users/tarekfouda/t.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				//*[@id="react-ui"]/div/div[3]/div[3]/div/form/table/tbody/tr[1]/td/input
				
				
				 waitForPageToLoad(driver);
				//String[] parts = line.split("#");
				//String part1 = parts[0]; // 004
				//String part2 = parts[1]; // 034556
				String source = "/custompage.asp?pg=" + line;
				driver.findElement(By.xpath("//*[@id=\"react-ui\"]/div/div[2]/div[3]/div/form/table/tbody/tr[1]/td/input")).sendKeys(source);
			    WebDriverWait wait2 = new WebDriverWait(driver,30);
			    //wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//*[@id=\"old\"]")), source));
			//	waitForPageToLoad(driver);
			    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				String newsource = "/" + line;
				driver.findElement(By.xpath("//*[@id=\"react-ui\"]/div/div[2]/div[3]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/input")).sendKeys(newsource);
			    //wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//*[@id=\\\"target\\\"]/td/input")), newsource));
				waitForPageToLoad(driver);
				  driver.findElement(By.xpath("//*[@id=\"react-ui\"]/div/div[2]/div[3]/div/form/table/tbody/tr[4]/td/div/input")).click();
				  waitForPageToLoad(driver);
				
				  waitForPageToLoad(driver);
				/*String source = "testsource";
				driver.findElement(By.xpath("//*[@id=\"old\"]")).sendKeys(source);
				waitForPageToLoad(driver);
				String newsource = "newsource";
				driver.findElement(By.xpath("//*[@id=\"target\"]/td/input")).sendKeys(newsource);
				waitForPageToLoad(driver);
				  driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
				
				
				break;
				*/
				  
				 
			}
			fileReader.close();
			//System.out.println("Contents of file:");
			//System.out.println(stringBuffer.toString());
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
