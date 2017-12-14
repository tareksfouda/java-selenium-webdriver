import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class changinghrefs {
	static String content;
public static void main (String[] args) throws InterruptedException {
	System.out.println("Start of the code");
	
	  
	  System.setProperty("webdriver.gecko.driver", "geckodriver");
	  WebDriver driver = new FirefoxDriver();
	  driver.get("http://williamsequipment.com.demo.prod.cwsplatform.com/wp-admin");
	  driver.findElement(By.xpath("//*[@id=\"layout-static\"]/div/div/div/div/div/div/form/div/div[1]/div[2]/input")).sendKeys("tfouda");
	  driver.findElement(By.xpath("//*[@id=\"layout-static\"]/div/div/div/div/div/div/form/div/div[1]/div[3]/input")).sendKeys("$$");
	  driver.findElement(By.xpath("//*[@id=\"layout-static\"]/div/div/div/div/div/div/form/div/div[2]/div/input")).click();

	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wp-admin-bar-view-my-site\"]/a/span")));
	  // clicking pages button
	  driver.findElement(By.xpath("//*[@id=\"menu-pages\"]/a/div[3]")).click();
	String numberOfPages =driver.findElement(By.xpath("//*[@id=\"table-paging\"]/span/span")).getText();
	System.out.println(numberOfPages);
	int noOfPages = Integer.parseInt(numberOfPages);

	int globalCount =35;
	driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);
	 driver.findElement(By.className("next-page")).click();
	 waitForPageToLoad(driver);

	
	//*[@id="posts-filter"]/div[2]/div[3]/span[2]/a[1]
	//*[@id="posts-filter"]/div[2]/div[3]/span[2]/a[2]
	//*[@id="posts-filter"]/div[2]/div[3]/span[2]/a[3]
	//*[@id="posts-filter"]/div[2]/div[3]/span[2]/a[3]
	while(globalCount <= noOfPages){
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"posts-filter\"]/table")));
	WebElement Webtable=driver.findElement(By.xpath("//*[@id=\"posts-filter\"]/table")); // Replace TableID with Actual Table ID or Xpath
	List<WebElement> TotalRowCount=Webtable.findElements(By.xpath("//*[@id=\"posts-filter\"]/table/tbody/tr"));

	System.out.println("No. of Rows in the WebTable: "+TotalRowCount.size());
	// Now we will Iterate the Table and save ids of the rows  
	int i=0;
	String [] idsOfTableRows= new String[TotalRowCount.size()];
	String [] titleOfPages = new String[TotalRowCount.size()];
	for(WebElement rowElement:TotalRowCount)
	{
		idsOfTableRows[i] = rowElement.getAttribute("id");
		
		System.out.println("array ids : " + idsOfTableRows[i]);
		String xpathTitle =  "//*[@id=\"" +idsOfTableRows[i] + "\"]/td[1]/strong/a";
		System.out.println("title of the pages " + driver.findElement(By.xpath(xpathTitle)).getText()); // title of the page
		titleOfPages[i]= driver.findElement(By.xpath(xpathTitle)).getText();
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
	  
	    driver.findElement(By.xpath("//*[@id=\"content-html\"]")).click();
	  //  waitForPageToLoad(driver);
	   // String url = driver.getCurrentUrl();
		
	    
	    

		
	    
		if(contentCheck.isEmpty() ){
			
			boolean flag= false;
			System.out.println("name is my " + titleOfPages[j]); //printing the title of the page
			String sourceUrl = "http://williamsequipment.com/custompage.asp?pg=" + titleOfPages[j];
			waitForPageToLoad(driver);
	
			
			driver.get(sourceUrl);
			waitForPageToLoad(driver);
			String urlnow = driver.getCurrentUrl();
			System.out.println(urlnow+ "url nowwwww");
			try {
			//get the source code
		//	String wholesourcecode = driver.getPageSource();
			System.out.println("-----");
			String thecode= driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div/div")).getAttribute("innerHTML");
			
			System.out.println("-----");
			System.out.println(thecode + "the codeee111");

		    driver.navigate().back();
		    
		    System.out.println(thecode + "the codeee222");
		    waitForPageToLoad(driver);
		    
		    
			 
			
			System.out.println(thecode + "the codeee");
			
			driver.findElement(By.xpath("//*[@id=\"content\"]")).sendKeys(thecode);
			driver.findElement(By.xpath("//*[@id=\"publish\"]")).click();
		 	waitForPageToLoad(driver);
			}
			
			catch(Exception e) {
				flag=true;
				driver.navigate().back();
			    waitForPageToLoad(driver);
			}
			if(!flag) {
		    driver.navigate().back();
		    waitForPageToLoad(driver);
			}
		}
		else {
			
			String slash = "/";
			String result = contentCheck.replaceAll("http://www.williamsequipment.com/custompage.asp\\?pg=", slash);
			System.out.println(result +"Sssss" );
			String result2 = result.replaceAll("/custompage.asp\\?pg=", slash);
			String empty = "";
			String finalresult = result2.replaceAll(".asp", empty);
			System.out.println(finalresult +"bbbbssss" );
			
			String final2 = finalresult.replaceAll("http://cdn-5.psndealer.com/e2/dealersite/images/williamsequipment/", slash);
			
			
			
			driver.findElement(By.xpath("//*[@id=\"content\"]")).sendKeys(final2);
			driver.findElement(By.xpath("//*[@id=\"publish\"]")).click();
		 	waitForPageToLoad(driver);
		 	 driver.navigate().back();
			    waitForPageToLoad(driver);
		}
	   

	    driver.navigate().back();
	    waitForPageToLoad(driver);
	    //driver.navigate().back();
	    //waitForPageToLoad(driver);
	 }
	
	//String xpathofnextPage = "//*[@id=\"posts-filter\"]/div[2]/div[3]/span[2]/a" + "[" + globalCount + "]";
	driver.findElement(By.className("next-page")).click();
	
	
	//*[@id="posts-filter"]/div[2]/div[3]/span[2]/a[1]
	//*[@id="posts-filter"]/div[2]/div[3]/span[2]/a[2]          //*[@id="posts-filter"]/div[2]/div[3]/span[2]/a[1]
	//*[@id="posts-filter"]/div[2]/div[3]/span[2]/a[3]
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