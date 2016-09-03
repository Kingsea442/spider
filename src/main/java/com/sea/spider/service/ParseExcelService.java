package com.sea.spider.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sea.spider.bean.People;
/**
 * For parseing the excel
 * @author sea
 *
 */
@Service
public class ParseExcelService {
	
	public List<People> pareseExcel(InputStream inputStream) {
		List<People> list = new ArrayList<People>();
		try {
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = sheet.rowIterator();
			while (iterator.hasNext()) {
				Row row = iterator.next();
				Cell cell = row.getCell(0);
				Cell cell2 = row.getCell(1);
				People people = new People();
				people.setName(cell.getStringCellValue());
				people.setMajor(cell2.getStringCellValue());
				people.setCollege("清华大学");
				list.add(people);
			}
			list.remove(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
		
	}

}
