package co.spicejett.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

/**
 * This class is used o maintain all excel specific common methods
 * @author User
 *
 */

public class ExcelLibrary {
	static Workbook wb;
	/**
	 * This method is used to fetch the data from excel sheet
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	
	public static String getDataFromExcel(String sheetName, int rowNumber,int cellNumber) throws EncryptedDocumentException, IOException {

		String data = wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		return(data);
	}
	
	
	public static int StringValueOf(int i) {
		String s=String.valueOf(i);
		return i;
	}
	
	
	public static double getDataFromExcelInt(String sheetName, int rowNumber,int cellNumber) throws EncryptedDocumentException, IOException {

		double data = wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getNumericCellValue();
		return(data);
	}

	public static void openExcel(String filePath) throws EncryptedDocumentException, IOException {
		FileInputStream fisExcel=new FileInputStream(filePath);
		wb=WorkbookFactory.create(fisExcel);

		}
	
	
	public static String NumericCellValue(Cell cell) {
		DataFormatter format=new DataFormatter();
		String data = format.formatCellValue(cell);
		return data;
		
	}
	
	/**
	 * This method is used to save the data in excel
	 * @throws FileNotFoundException 
	 */
	public static void saveExcelData(String fileSavePath) throws FileNotFoundException {
		FileOutputStream fos=new FileOutputStream(fileSavePath);
		try {
			wb.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
		public static void closeExcel() {
			try {
			wb.close();
			}catch(IOException e) {
				e.printStackTrace();
				System.out.println("while closing excel some exceptions will occur please check");
			}
			
		}


		public static void quitBrowser(WebDriver driver) {
			driver.quit();
			
		}

}
