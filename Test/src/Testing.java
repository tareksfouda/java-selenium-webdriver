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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Testing {
	static String content;
public static void main (String[] args) throws InterruptedException {
	System.out.println("ssss");
	
	  
	  System.setProperty("webdriver.gecko.driver", "geckodriver");
	  WebDriver driver = new FirefoxDriver();
	  driver.get("http://crewetractor.com.demo.prod.cwsplatform.com/wp-admin");
	  driver.findElement(By.xpath("//*[@id=\"layout-static\"]/div/div/div/div/div/div/form/div/div[1]/div[2]/input")).sendKeys("tfouda");
	  driver.findElement(By.xpath("//*[@id=\"layout-static\"]/div/div/div/div/div/div/form/div/div[1]/div[3]/input")).sendKeys("####");
	  driver.findElement(By.xpath("//*[@id=\"layout-static\"]/div/div/div/div/div/div/form/div/div[2]/div/input")).click();

	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wp-admin-bar-view-my-site\"]/a/span")));
	  // clicking pages button
	  driver.findElement(By.xpath("//*[@id=\"menu-pages\"]/a/div[3]")).click();
	String numberOfPages =driver.findElement(By.xpath("//*[@id=\"table-paging\"]/span/span")).getText();
	System.out.println(numberOfPages);
	int noOfPages = Integer.parseInt(numberOfPages);

	int globalCount =1;
	System.out.println(noOfPages +" and " + globalCount);

	
	
	while(globalCount <= noOfPages){
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"posts-filter\"]/table")));
	WebElement Webtable=driver.findElement(By.xpath("//*[@id=\"posts-filter\"]/table")); // Replace TableID with Actual Table ID or Xpath
	List<WebElement> TotalRowCount=Webtable.findElements(By.xpath("//*[@id=\"posts-filter\"]/table/tbody/tr"));

	System.out.println("No. of Rows in the WebTable: "+TotalRowCount.size());
	// Now we will Iterate the Table and save ids of the rows  
	int i=0;
	String [] idsOfTableRows= new String[TotalRowCount.size()];
	for(WebElement rowElement:TotalRowCount)
	{
		idsOfTableRows[i] = rowElement.getAttribute("id");
		//System.out.println("array ids : " + idsOfTableRows[i]);
		i++;
	}
	//System.out.println("first loop success");
	for(int j = 0; j < TotalRowCount.size();j++)
	{
		
		
		String id = idsOfTableRows[j];
		String path = "//*[@id=\"" +id + "\"]/td[1]/strong/a";
		driver.findElement(By.xpath(path)).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wp-admin-bar-view\"]/a")));
	    String contentCheck = driver.findElement(By.xpath("//*[@id=\"content\"]")).getText();
	  
	    driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-view\"]/a")).click();
	    waitForPageToLoad(driver);
	    String url = driver.getCurrentUrl();
		content =  content + "\n" + "-----------" +driver.getCurrentUrl() + "-----------";
		if(contentCheck.isEmpty()){content =content + "\n There is no content in this page: " + url + "\n";};
	    if(driver.getPageSource().contains(".asp")){content =content + "\n asp links on this page : " + url + "\n";};
	    if(driver.getPageSource().contains("psndealer")){ content= content + "\n psndealer on this page : " + url + "\n";};
	  try{  
		  for (WebElement image : driver.findElements(By.cssSelector("img")))
	    {
	        isImageBroken(image);
	    }
	  }
	  catch(NoSuchElementException e){
		  continue;
	  }
	    driver.navigate().back();
	    waitForPageToLoad(driver);
	    driver.navigate().back();
	    waitForPageToLoad(driver);
	 }
	driver.findElement(By.xpath("//*[@id=\"posts-filter\"]/div[2]/div[3]/span[2]/a")).click();
	waitForPageToLoad(driver);
	globalCount++;

	}
	//writing the testing report
	write(content);
	    driver.quit();
	
}


//WebDriver driver = new FirefoxDriver();

public static void waitForPageToLoad(WebDriver driver) {
    ExpectedCondition<Boolean> expectation = new
            ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                }
            };
    try {
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(expectation);
    } catch (Throwable error) {
        System.out.println("Timeout waiting for Page Load Request to complete.");
    }
}





//method to write into file

public static void write(String content) {
	 String FILENAME = "/home/tarek-fouda/filename.txt";
	try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {


		bw.write(content);

		// no need to close it.
		//bw.close();

		System.out.println("Done");

	} catch (IOException e) {

		e.printStackTrace();

	}

}




//method to check if image is broken 
public static void isImageBroken(WebElement image)
{
    if (image.getAttribute("naturalWidth").equals("0"))
    {
        content = content + image.getAttribute("outerHTML") + " is broken.";
    }
}
}