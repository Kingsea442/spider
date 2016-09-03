package com.sea.spider.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sea.spider.bean.People;
import com.sea.spider.service.ParseExcelService;

@Controller
public class FileUploadController {

	@Autowired
	private ParseExcelService parseExcelService;

	/**
	 * Parse the upload file and retrive the excel data, then show it on web
	 * page.
	 * 
	 * @param file
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/singleUpload", method = RequestMethod.POST)
	public String singleUpload(@RequestParam("file") CommonsMultipartFile file, Model model) {

		List<People> list = null;
		try {
			list = parseExcelService.pareseExcel(file.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("peopleList", list);
		return "index";

	}

	/**
	 * Maybe you don't want upload any file, just want to have a try, you can
	 * use this. I put the file in my program, it can read automatically.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/preexisting")
	public String usePreExisting(Model model) {
		String filePath = FileUploadController.class.getClassLoader().getResource("清华88级.xlsx").getPath();
		try {
			InputStream inputStream = new FileInputStream(filePath);
			List<People> list = parseExcelService.pareseExcel(inputStream);
			model.addAttribute("peopleList", list);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "index";
	}

}
