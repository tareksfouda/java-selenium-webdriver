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


/* this code loops through all the pages in wordpress and add the content for it*/
public class Content {
	static String content;
	static String domain= "http://rsequipment.com";
public static void main (String[] args) throws InterruptedException {
	System.out.println("Start of the code");
	
	  
	  System.setProperty("webdriver.gecko.driver", "geckodriver");
	  WebDriver driver = new FirefoxDriver();
	//following line is the site name on DEMO
	  String wordpressUrlSuffix = ".demo.prod.cwsplatform.com/wp-admin/";
	  String wholeWordPressUrl = domain + wordpressUrlSuffix;
	  
	  driver.get(wholeWordPressUrl);
	  //the following two lines are the username and password for wordpress login
	  driver.findElement(By.xpath("//*[@id=\"layout-static\"]/div/div/div/div/div/div/form/div/div[1]/div[2]/input")).sendKeys("tfouda");
	  driver.findElement(By.xpath("//*[@id=\"layout-static\"]/div/div/div/div/div/div/form/div/div[1]/div[3]/input")).sendKeys("##");
	  driver.findElement(By.xpath("//*[@id=\"layout-static\"]/div/div/div/div/div/div/form/div/div[2]/div/input")).click();

	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wp-admin-bar-view-my-site\"]/a/span")));
	  // clicking pages button
	driver.findElement(By.xpath("//*[@id=\"menu-pages\"]/a/div[3]")).click();
	//number of sections that contain pages.
	String numberOfPages =driver.findElement(By.xpath("//*[@id=\"table-paging\"]/span/span")).getText();
	System.out.println(numberOfPages);
	// changing number of pages from String to integer
	int noOfPages = Integer.parseInt(numberOfPages);
//initial counter Global Count. First section
	int globalCount =1;

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
		
	    boolean flag=true;
	    
	    
	    // set flag = false if the page is any of the following; we do not want to add content for these pages.
	    if(titleOfPages[j].equals("Employment Application") || 
	    		titleOfPages[j].equals("Financing") ||
	    		titleOfPages[j].equals("Guestbook") ||
	    		titleOfPages[j].equals("Inventory") ||
	    		titleOfPages[j].equals("Parts") ||
	    		titleOfPages[j].equals("Service") ||
	    		titleOfPages[j].equals("Survey") ||
	    		titleOfPages[j].equals("Showrooms") ||
	    		titleOfPages[j].equals("Contact")||
	    		titleOfPages[j].equals("cws-login") ||
	    		titleOfPages[j].equals("Disclaimer")||
	    		titleOfPages[j].equals("Policies")||
	    		titleOfPages[j].equals("Privacy")||
	    		titleOfPages[j].equals("Promotions")||
	    		titleOfPages[j].equals("Terms & Conditions") ||
	    		titleOfPages[j].equals("Rentals")||
	    		titleOfPages[j].equals("Sales")) {  
	    	flag=false;
	    	System.out.println(titleOfPages[j]);
	    	
	    	
	    }
	    

		
	    //Execute this block only if the content is empty and flag is true
	    
		if(contentCheck.isEmpty() && flag ){
			
			String sourceUrl="";
			// add the prefix of the live site + the title of the custom page
			if(titleOfPages[j].equals("About Us") ) {
				 sourceUrl =domain + "/aboutus.asp";
			} else if(titleOfPages[j].equals("Map & Hours")) {
				 sourceUrl =domain + "/map_hours.asp";

			}
			else if(titleOfPages[j].equals("Staff")) {
				 sourceUrl =domain + "/staff.asp";

			}
			else if(titleOfPages[j].equals("Photo Gallery")) {
				 sourceUrl =domain + "/photo_gallery.asp";

			}
			else if(titleOfPages[j].equals("Links")) {
				 sourceUrl =domain + "/links.asp";

			}
			else if(titleOfPages[j].equals("Testimonials")) {
				 sourceUrl =domain + "/testimonials_display2.asp";

			}
			else if(titleOfPages[j].equals("Service Request")) {
				 sourceUrl =domain + "/service_request.asp";

			}
			else if(titleOfPages[j].equals("Site Map")) {
				 sourceUrl =domain + "/site_map.asp";

			}
			else {
				 sourceUrl =domain +"/custompage.asp?pg=" + titleOfPages[j];
			}
			
			
			waitForPageToLoad(driver);
	
			
			driver.get(sourceUrl);
			waitForPageToLoad(driver);
			String urlnow = driver.getCurrentUrl();

			System.out.println("-----");
			// change the innerhtml of the content div
			try {
			String thecode= driver.findElement(By.xpath("//*[@id=\"content-detail\"]")).getAttribute("innerHTML");
			
			System.out.println("-----");

		    driver.navigate().back();

		    waitForPageToLoad(driver);
		    
		    

			
			driver.findElement(By.xpath("//*[@id=\"content\"]")).sendKeys(thecode);
			driver.findElement(By.xpath("//*[@id=\"publish\"]")).click();
			}
			catch (NoSuchElementException e) {
			    System.out.println("Element Not Found");
			  
			}
		 	waitForPageToLoad(driver);
			
			
	
				driver.navigate().back();
			    waitForPageToLoad(driver);
		
	
		}
	   

	    driver.navigate().back();
	    waitForPageToLoad(driver);

	 }
	

	//go to the next section
	driver.findElement(By.className("next-page")).click();
	

	waitForPageToLoad(driver);
	globalCount++;

	}
	//writing the testing report
	write(content);
	    driver.quit();
	
}



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
	 String FILENAME = "/Users/tarekfouda/t.txt";
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