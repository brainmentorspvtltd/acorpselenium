package com.brainmentors.apps.xrmtesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import com.brainmentors.apps.xrmtesting.utils.BundleReader;



public class ExcelReader {
	
	public  ArrayList<User> readLoginXLS() throws IOException {
		int sheetNumber=0;
		ArrayList<User> users = new ArrayList<>();
		String filePath = BundleReader.getValue("xlspath");
		File file = new File(filePath);
		if(!file.exists()) {
			System.out.println("Invalid Path , File Not Exist");
			return null;
		}
		FileInputStream fs = new FileInputStream(file);
		// xlsx
		//XSSFWorkbook
		// xls
		HSSFWorkbook workBook = new HSSFWorkbook(fs);
		try {
			HSSFSheet workSheet =  workBook.getSheetAt(sheetNumber);
			Iterator<Row> rows = workSheet.rowIterator();
			int cellCounter = 0;
			boolean isFirstRowPass = false;
			while(rows.hasNext()) {
				Row row = rows.next();
				if(!isFirstRowPass) {
					isFirstRowPass = true;
					continue;
				}
				User user = new User();
				Iterator<Cell> cells = row.cellIterator();
				cellCounter=1;
				while(cells.hasNext()) {
					Cell cell = cells.next();
					if(cell.getCellType()== CellType.STRING) {
						String value = cell.getStringCellValue();
						switch(cellCounter) {
						case 1:
							user.setUserid(value);
							break;
						case 2:
							user.setPassword(value);
							break;
						case 3:
							user.setStatus(value);
							break;
						}
						
					}
					else
					if(cell.getCellType()==CellType.NUMERIC) {
						double val = cell.getNumericCellValue();
					}
					cellCounter++;
				} // Cell Loop ends
				users.add(user);
			} // Row Loop Ends
			
		}finally {
			if(workBook!=null)
				workBook.close();
			fs.close();
		}
		
		
		
		System.out.println(users);
		return users;
	}

	
	
}