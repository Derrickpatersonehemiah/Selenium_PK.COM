package testNG;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;


import com.google.inject.spi.DependencyAndSource;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class PKtest {
	
	WebDriver driver; 
	
	  @BeforeMethod
	  public void general() {
		  try {
				System.setProperty("webdriver.chrome.driver","D:\\Program Files\\SELENIUM\\Chromedriver\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
				driver.get("https://pf.com.pk/");
			
						 
			} catch (Exception e) {
				e.printStackTrace();
			}
	  }
	
	 void scrshot() throws IOException {

			Date d = new Date();
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("screenshot_" + System.currentTimeMillis() + ".png"));
	 	}
	
	
	
	@Test(enabled=true,priority=1)
	public void ScrollPageAndAssertLogo() {
		
		Reporter.log("1.Scrolling the page from top to bottom and asserting the logo");
		Reporter.log("        ");
		 try {
			
			// Scroll the page from top to bottom
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			Thread.sleep(3000);
			Reporter.log("valid entry sucessful!");
			// Assert the logo
	        WebElement logo = driver.findElement(By.xpath("(//*[@alt=\"logo\"])[2]"));
	        if (logo.isDisplayed()) {
	            System.out.println("Logo is displayed.");
	        } else {
	            System.out.println("Logo is not displayed.");
	        }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
  @Test(enabled=true,priority=2)
  public void OpenAllHeadersAndTakeSS() {
	  
	  Reporter.log("2.Open Headers in Tabs and take screenshots :");
	  Reporter.log("        ");
	  //To navigate to and fill a job application form.
	  List<WebElement> headers = driver.findElements(By.cssSelector("header a"));

	    for (WebElement header : headers) {
	        String newTabScript = "window.open(arguments[0], '_blank');";
	        ((JavascriptExecutor) driver).executeScript(newTabScript, header.getAttribute("href"));
	    }
	    for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            try {
				this.scrshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    driver.close();
	   }
  
  
  @Test(enabled=true,priority=3) 
  public void FillAJobApplication() {
	  try {
		    Reporter.log("3.Click Apply button and fill out a job application :");
		    Reporter.log("        ");
		    //To navigate to and fill a job application form.
		  	WebElement applyNowButton = driver.findElement(By.xpath("(//*[@href=\"/apply-now\"])[2]"));
	        applyNowButton.click();

	        WebElement position = driver.findElement(By.xpath("//*[@id=\"post-239\"]/div/div[3]/div/div/div/div[2]/div[1]/a/p"));
	        position.click();
	        
	        WebElement genderRadioMale = driver.findElement(By.xpath("//*[@id=\"gender\"]/span[1]/label/input"));
	        WebElement nameField = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"email\"]"));
	        WebElement cnic = driver.findElement(By.xpath("//*[@id=\"cnic\"]"));
	        WebElement phoneField = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
	        WebElement Address = driver.findElement(By.xpath("//*[@id=\"address\"]"));
	        WebElement City = driver.findElement(By.xpath("//*[@id=\"city\"]"));
	        WebElement qualification = driver.findElement(By.xpath("//*[@id=\"qualification\"]"));
	        WebElement other = driver.findElement(By.xpath("//*[@id=\"qualification\"]/option[9]"));
	        WebElement YOC = driver.findElement(By.xpath("//*[@id=\"yr-of-comp\"]"));
	        WebElement YOCD = driver.findElement(By.xpath("//*[@id=\"yr-of-comp\"]/option[9]"));
	        WebElement university = driver.findElement(By.xpath("//*[@id=\"university\"]"));
	        WebElement cgpa = driver.findElement(By.xpath("//*[@id=\"cgpa_cd\"]"));
	        WebElement wsNo = driver.findElement(By.xpath("//*[@id=\"cur-working\"]/span[2]/label/input"));
	        WebElement salaryExp = driver.findElement(By.xpath("//*[@id=\"salry-expt\"]"));
	        //WebElement DOJ = driver.findElement(By.xpath("//*[@id=\"doj\"]"));
	        WebElement datePicker = driver.findElement(By.id("doj"));
	        WebElement hearAbtUs = driver.findElement(By.xpath("//*[@id=\"hear-abt-us\"]"));
	        WebElement expDrpdwn = driver.findElement(By.xpath("//*[@id=\"experiance\"]"));
	        WebElement expDrpdwnVal = driver.findElement(By.xpath("//*[@id=\"experiance\"]/option[4]"));
	        WebElement resumeField = driver.findElement(By.xpath("//*[@id=\"resume\"]"));
	        //WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"submit-btn\"]"));
	        

	        genderRadioMale.click();
	        nameField.sendKeys("Tester");
	        emailField.sendKeys("Test@example.com");
	        cnic.sendKeys("123456789012");
	        phoneField.sendKeys("1234567890");
	        Address.sendKeys("Test, Test123");
	        City.sendKeys("Mumbai");
	        qualification.click();
	        Thread.sleep(1000);
	        other.click();
	        YOC.click();
	        Thread.sleep(1000);
	        YOCD.click();
	        university.sendKeys("IIT");
	        cgpa.sendKeys("6.7");
	        wsNo.click();
	        salaryExp.sendKeys("100000");
	        //DOJ.sendKeys("25-052024");
	        datePicker.click();
	        selectDate(driver, "25-15-2024");
	        hearAbtUs.sendKeys("LinkedIn");
	        expDrpdwn.click();
	        Thread.sleep(1000);
	        expDrpdwnVal.click();
	        resumeField.sendKeys("D:\\My Files\\Testing\\Automation\\Selenium Automation\\Workspace\\fbb\\Test artifacts\\RESUME.pdf");
	        //submitButton.click();
		
	  } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  driver.close();
  }
  private static void selectDate(WebDriver driver, String date) {
      WebElement dateInput = driver.findElement(By.cssSelector("input[type='date']")); // Adjust the selector as necessary
      dateInput.sendKeys(date);
  }

}
