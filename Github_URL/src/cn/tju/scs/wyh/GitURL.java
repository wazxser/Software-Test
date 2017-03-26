package cn.tju.scs.wyh;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

import com.csvreader.CsvReader;

@RunWith(Parameterized.class)
public class GitURL {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private String sid;
  private String expected;
  private static List<String[]> csvList;

  public GitURL(String sid, String expected){
	this.sid = sid;
	this.expected = expected;
  }
  
  @Before
  public void setUp() throws Exception {
	  File pathToBinary = new File("E:\\firefox\\firefox.exe");
	  FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
	  FirefoxProfile firefoxProfile = new FirefoxProfile();       
	  driver = new FirefoxDriver(ffBinary,firefoxProfile);
	  baseUrl = "http://121.193.130.195:8080";
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testGitURL() throws Exception {
    	driver.get(baseUrl + "/");
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(this.sid);
        driver.findElement(By.id("pwd")).clear();
        driver.findElement(By.id("pwd")).sendKeys(this.sid.substring(4));
        new Select(driver.findElement(By.id("gender"))).selectByVisibleText("女");
        driver.findElement(By.id("submit")).click();
    	assertEquals(this.expected, driver.findElement(By.xpath("//tbody[@id='table-main']/tr[3]/td[2]")).getText());    	
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  @Parameters
  public static Collection<String[]> testData() throws FileNotFoundException, IOException{
	  int length = getGitURLFromCSV();
	  String[][] data = new String[length][];
	  for(int j = 0; j < length; j++){
		  data[j] = new String[]{csvList.get(j)[0], csvList.get(j)[2]};
	  }
	  return Arrays.asList(data);
  }
  
  private static int getGitURLFromCSV() throws IOException{
	  CsvReader reader = new CsvReader("F:\\Material\\inputgit.csv", ',', Charset.forName("GBK"));
      csvList = new ArrayList<String[]>();  
      reader.readHeaders();   
      int csvLength = 0;
      while (reader.readRecord()) {   
          csvList.add(reader.getValues());
          csvLength++;
      }  
      reader.close(); 
      return csvLength;
  }
  
  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
