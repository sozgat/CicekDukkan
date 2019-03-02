package com.utility;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.model.Order;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelRead {
    public static final String FILE_NAME = "./orders.xlsx";
    
    public static void main(String[] args) throws InvalidFormatException, IOException {
		getExcelData();
	}

    public static ArrayList<Order> getExcelData() throws IOException, InvalidFormatException {
    	ArrayList<Order> orders = new ArrayList<Order>();
        // Creating a Workbook from an Excel file (.xls or .xlsx)
    	
    	try {
        	FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
        	Workbook workbook = new XSSFWorkbook(excelFile);
    

            // Getting the Sheet at index zero
            Sheet sheet = workbook.getSheetAt(0);


            // 1. You can obtain a rowIterator and columnIterator and iterate over them
            Iterator<Row> rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // Now let's iterate over the columns of the current row
                Iterator<Cell> cellIterator = row.cellIterator();
                Order order = new Order();
                while (cellIterator.hasNext()) {
                	
                    Cell cell = cellIterator.next();
                    int columnIndex=cell.getColumnIndex();
                   
                    if (columnIndex==0) {
                    	order.setOrderId(Integer.parseInt(cell.getStringCellValue()));
					}
                    else if(columnIndex==1){
                    	order.setLatitude(Double.valueOf(cell.getStringCellValue()));
                    }
                    else if(columnIndex==2){
                    	order.setLongitude(Double.valueOf(cell.getStringCellValue()));
                    }
                   
                    
                     
                }
                
                orders.add(order);
            }

            // Closing the workbook
            workbook.close();
            
    		
			
		}  catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
       return orders;

    }
}