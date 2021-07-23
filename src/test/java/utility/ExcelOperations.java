package utility;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperations {
	String filePath;
	Sheet sh;
	Workbook wb;

	public ExcelOperations(String sheetName) {
		filePath = "E:\\NewIDEEclipse\\NewIDEWorkspace\\seleniumGridTesting\\src\\test\\resources\\dummyFolder\\Userdata.xlsx";

		File testdataFile = new File(filePath);

		try {
			wb = WorkbookFactory.create(testdataFile);
		} catch (IOException e) {

			e.printStackTrace();
		}

		sh = wb.getSheet(sheetName);
		System.out.println(sheetName);

	}

	public HashMap<String, String> getTestDataInMap(int rowNum) throws IOException {

		// XSSFWorkbook wb= new XSSFWorkbook(fis);
		// XSSFSheet sheet = wb.getSheetAt(0);

		// int rowCount = sheet.getLastRowNum();
		// int columnCount = sheet.getRow(1).getLastCellNum();

		// define the object
		// Object[][] obj = new Object[rowCount][1];

		HashMap<String, String> hm = new HashMap<String, String>();

		for (int i = 0; i < sh.getRow(0).getLastCellNum(); i++) {
			sh.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
			hm.put(sh.getRow(0).getCell(i).toString(), sh.getRow(rowNum).getCell(i).toString());
		}

		return hm;

	}

	public int getRowCount() {
		return sh.getLastRowNum();
	}

	public int getColumnCount() {
		return sh.getRow(0).getLastCellNum();
	}

	public static void main(String[] args) throws IOException {
		//ExcelOperations eo = new ExcelOperations();
		//System.out.println(eo.getTestDataInMap(2));
	}

}
