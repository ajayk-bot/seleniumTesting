package orangeHRMGrid;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MapdatawithHashMap {

	@Test(dataProvider = "testdata")
	public void orangeHRM() {

	}

	@DataProvider(name="testdata")
	public Object[][] getDataProvider() throws IOException{

		String filePath = "E:\\NewIDEEclipse\\NewIDEWorkspace\\Frameworkdesing\\src\\test\\resources\\dummyFolder\\OrangeHRM.xlsx";
		
		
		FileInputStream fis = new FileInputStream(filePath);
		
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(1).getLastCellNum();
		
		//define the object
		Object[][] obj = new Object[rowCount][1];
		
		for(int i=0 ;i<rowCount;i++) {
			Map<Object, Object> dataHashMap = new HashMap<Object, Object>();
			for (int j = 0; j < columnCount; j++) {
				dataHashMap.put(sheet.getRow(0).getCell(j), sheet.getRow(i+1).getCell(j));
				
			}
			obj[i][0] = dataHashMap;
		}
		
		
	
		
		
		
		return null;
	}

}
