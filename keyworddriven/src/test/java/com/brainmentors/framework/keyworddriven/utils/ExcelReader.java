package com.brainmentors.framework.keyworddriven.utils;

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

import com.brainmentors.framework.keyworddriven.dto.CommandDTO;


public class ExcelReader {
	
//	public static void main(String[] args) {
//		ExcelReader obj = new ExcelReader();
//		try {
//			ArrayList<CommandDTO> commands = obj.readXLS();
//			System.out.println(commands);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
	public  ArrayList<CommandDTO> readXLS() throws IOException {
		int sheetNumber=0;
		ArrayList<CommandDTO> commands = new ArrayList<>();
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
				CommandDTO commandDTO = new CommandDTO();
				Iterator<Cell> cells = row.cellIterator();
				cellCounter=1;
				while(cells.hasNext()) {
					Cell cell = cells.next();
					if(cell.getCellType()== CellType.STRING) {
						String value = cell.getStringCellValue();
						switch(cellCounter) {
						case 1:
							commandDTO.setCommandName(value);
							break;
						case 2:
							commandDTO.setTarget(value);
							break;
						case 3:
							commandDTO.setValue(value);
							break;
						}
						
					}
					
					cellCounter++;
				} // Cell Loop ends
				commands.add(commandDTO);
			} // Row Loop Ends
			
		}finally {
			if(workBook!=null)
				workBook.close();
			fs.close();
		}
		
		
		
		//System.out.println(commands);
		return commands;
	}

	
	
}