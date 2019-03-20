package WebFormFillingFromExcel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class TC1_LeanTestingRegisterExcelData
	{
	WebDriver driver;
	
	@BeforeMethod
	public void aplicationSetup()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\stepanyuk\\IdeaProjects\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://auth.leantesting.com/sign-up");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test(dataProvider = "registerData")
	public void LeanTestingRegister(String yourEmail, String yourUserName, String password) throws InterruptedException
	{
		
		driver.findElement(By.id("email")).sendKeys(yourEmail);
		driver.findElement(By.id("username")).sendKeys(yourUserName);
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.xpath("//*[@id=\"user-signup-form\"]/div[4]/button")).click();
		
		Thread.sleep(5000);
		
		Assert.assertTrue(driver.getTitle().contains("Your CrowdTesting account has been created"));
				
		System.out.println("Register has been completed successfully");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();	
	}
	
	
		
	@DataProvider(name = "registerData")
	public Object[][] passData()
	{
		ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\stepanyuk\\IdeaProjects\\Excel_Read_WebForm_Filling\\src\\test\\TestData\\InputTestData.xlsx");
		
		int rowsQty = config.getRowCount(0);
		// 0-because it is the first sheet in Excel file
				
		Object[][] data=new Object[rowsQty][3];


		for(int i=0;i<rowsQty;i++)
			
		{

		data[i][0]=config.getData(0, i, 1);
		// (0, i, 1) - 0-sheet of Excel, i-row of Excel, 1-column of Excel
		
		data[i][1]=config.getData(0, i, 2);
		data[i][2]=config.getData(0, i, 3);
		
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
	
