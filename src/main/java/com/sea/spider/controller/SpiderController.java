package com.sea.spider.controller;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sea.spider.bean.People;
import com.sea.spider.service.BaiduBaikeCrawlerService;

@Controller
public class SpiderController {

	@Autowired
	private BaiduBaikeCrawlerService baiduBaikeCrawlerService;

	@RequestMapping("/")
	public String indexRoot() {
		return "index";
	}
	@RequestMapping("/index")
	public String indexContext() {
		return "index";
	}
	
	@RequestMapping("/about")
	public String about(){
		return "about";
	}

	/**
	 * Search the info by using name, then if get results. Sort the result by
	 * the giving keywords (major, college).
	 * 
	 * @param name
	 * @param major
	 * @param college
	 * @param model
	 * @return
	 */
	@RequestMapping("/crawler")
	public String crawler(@RequestParam("name") String name, @RequestParam("major") String major,
			@RequestParam String college, Model model) {
		try {
			name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
			major = new String(major.getBytes("ISO-8859-1"), "UTF-8");
			college = new String(college.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<People> peoples = baiduBaikeCrawlerService.crawlerByName(name);
		for (People p : peoples) {
			p.setName(name);
			p.setMajor(major);
			p.setCollege(college);
		}

		// Sort it by giving keywords
		Collections.sort(peoples, new Comparator<People>() {

			public int compare(People o1, People o2) {
				boolean isMatchCondition1 = o1.getIntroduce().contains(o1.getMajor())
						|| o1.getIntroduce().contains(o1.getCollege());
				boolean isMatchCondition2 = o2.getIntroduce().contains(o2.getMajor())
						|| o2.getIntroduce().contains(o2.getCollege());
				if (isMatchCondition1 && !isMatchCondition2) {
					return -1;
				}
				if (!isMatchCondition1 && isMatchCondition2) {
					return 1;
				}
				if (!isMatchCondition1 && !isMatchCondition2) {
					return 0;
				}
				if (!isMatchCondition1 && !isMatchCondition2) {
					return 0;
				}
				return 0;
			}
		});
		model.addAttribute("name", name);
		model.addAttribute("major", major);
		model.addAttribute("college", college);
		if (peoples.size() > 0) {
			model.addAttribute("peoples", peoples);
		} else {
			model.addAttribute("message", "没有搜到任何结果");
		}
		return "crawler";
	}

	/**
	 * Show the detail info
	 * 
	 * @param url
	 * @param model
	 * @return
	 */
	@RequestMapping("/detail")
	public String getPeopleDetailInfo(@RequestParam("url") String url, Model model) {
		try {
			url = new String(url.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		People p = baiduBaikeCrawlerService.crawlerByUrl(url);
		model.addAttribute("introduce", p.getIntroduce());

		return "detail";
	}

}
