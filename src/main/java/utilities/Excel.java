package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static String getData(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("D:\\Automation\\ZerodhaProject\\src\\test\\resources\\Test Data.xlsx");
		String value = WorkbookFactory.create(file).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
}
