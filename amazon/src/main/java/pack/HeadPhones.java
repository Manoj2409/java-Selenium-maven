package pack;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class HeadPhones extends LoginPage{
	public HeadPhones() throws IOException {
		
		WebElement search=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.click();
		search.sendKeys("headphones");
		search.sendKeys(Keys.RETURN);
		sleep(2000);
		ArrayList<String> Names=headphoneNames();
		WriteDataExcel(Names);
		sleep(2000);
		driver.quit();
	}
	
	public ArrayList<String> headphoneNames() {
		//span[@class='a-size-medium a-color-base a-text-normal' ]
		ArrayList<WebElement> headphoneNames=(ArrayList<WebElement>) driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal' ]"));
		ArrayList<String> Names=new ArrayList();
		for(int i=0;i<headphoneNames.size();i++) {
			Names.add(headphoneNames.get(i).getText());
		}
		for(int i=0;i<Names.size();i++) {
			System.out.println(Names.get(i));
		}
		return Names;
	}
	
	public void WriteDataExcel(ArrayList<String> Names) throws IOException {
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Headphones");
		
		
		for(int i=0;i<Names.size();i++) {
			XSSFRow row=sheet.createRow(i);
			XSSFCell cell=row.createCell(0);
			cell.setCellValue(Names.get(i));
		}
		String filePath=".//test.xlsx";
		
		FileOutputStream os=new FileOutputStream(filePath);
		
		workbook.write(os);
		workbook.close();
		System.out.println();
		System.out.println("Names are successfully written in Excel sheet");
}
}
