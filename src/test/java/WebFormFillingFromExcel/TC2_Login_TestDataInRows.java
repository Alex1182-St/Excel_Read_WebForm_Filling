package WebFormFillingFromExcel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class TC2_Login_TestDataInRows
	{
	WebDriver driver;
		String chromeDriverPath = "C:\\Users\\oleks\\IdeaProjects\\Chrome Driver\\chromedriver_win32\\chromedriver.exe";
		String excelTestDataPath = "C:\\Users\\oleks\\IdeaProjects\\Excel_Read_WebForm_Filling\\src\\test\\TestData\\LoginTestDataInRows.xlsx";
	
	@BeforeMethod
	public void applicationSetup()
	{
		System.setProperty("webdriver.chrome.driver",chromeDriverPath);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://auth.leantesting.com/sign-in");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test(dataProvider="loginData")
	public void testingLogin(String yourUserNameOrEmail, String password) throws InterruptedException
	{
		driver.findElement(By.id("username")).sendKeys(yourUserNameOrEmail);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/button")).click();
		
		Thread.sleep(5000);
		
		Assert.assertEquals("https://dashboard.leantesting.com/", driver.getCurrentUrl());
		System.out.println("SignIn is completed");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();	
	}

		
	@DataProvider(name="loginData")
	public Object[][] passData() throws IOException {

		ExcelDataReadingInTestFolder config=new ExcelDataReadingInTestFolder(excelTestDataPath);
		
		int rowsQty = config.getRowCount(0);

		/**
		 0-because, it is the first sheet in Excel file
		 */
				
		Object[][] data = new Object[rowsQty][2];

		/**
		 Object[columnsQty][2] ----- 2 - кількість веб-форм (полів), котрі потрібно заповнити
		 */
		
		for(int i=0;i<rowsQty;i++)
		{
		data[i][0]=config.getData(0, i, 1);

		/**
		 (0, i, 1) - 0-sheet of Excel, i-row of Excel, 1-column of Excel
		*/

		data[i][1]=config.getData(0, i, 2);
				
		}
		return data;
	}
	}

/**
 Direct Method of Multidimensional Arrays in Java Declaration:

 Syntax:
 data_type[][] array_name = {
 {valueR1C1, valueR1C2, ....},
 {valueR2C1, valueR2C2, ....}
 };

 For example: int[][] arr = {{1, 2}, {3, 4}};

 Accessing Elements of Two-Dimensional Arrays
 Elements in two-dimensional arrays are commonly referred by x[i][j] where ‘i’ is the row number and ‘j’ is the column number.


 https://www.geeksforgeeks.org/multidimensional-arrays-in-java/

 */


