package com.sea.spider.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.sea.spider.bean.People;

/**
 * Search the info from internet. 
 * @author sea
 *
 */
@Service
public class BaiduBaikeCrawlerService {
	public String baseUrl = "http://baike.baidu.com";

	/**
	 * Search people from baidubaike by name.
	 * 
	 * @return
	 */
	public List<People> crawlerByName(String name) {
		List<People> peoples = new ArrayList<People>();
		String url = baseUrl + "/item/" + name;
		try {
			Document doc = Jsoup.connect(url).get();
			String title = doc.title().replace("_百度百科","");
			Element bodyWrapperEle = doc.select("div.body-wrapper").first();
			if(!title.equals("百度百科——全球最大中文百科全书")){
				
				Element mainContentEle = bodyWrapperEle.select("div.main-content").first();
				String desc = doc.select("meta[name=description]").get(0).attr("content");
				
				// remove some unimportant info
				mainContentEle.select("div.lemma-picture").remove();
				Elements albumELs = mainContentEle.select("a.lemma-album");
				if(albumELs.size() > 0){
					albumELs.remove();
				}
				Elements topTools = mainContentEle.select("div.top-tool");
				if(topTools.size()>0){
					topTools.remove();
				}
				
				Elements lemmaWgtLemmaTitleEls = mainContentEle.select("div.lemmaWgt-lemmaTitle");
				if(lemmaWgtLemmaTitleEls.size() > 0){
					lemmaWgtLemmaTitleEls.get(0).select("a[href]").remove();
				}
				
				Elements editPormt = mainContentEle.select("dov.edit-prompt");
				if(editPormt.size() > 0){
					editPormt.remove();
				}
//				mainContentEle.select("div#open-tag").first().remove();
//				System.out.println(mainContentEle.toString());

				
				People p = new People();
				p.setName(name);
				p.setTitle(title);
				p.setDescription(desc);
				p.setInfoSource(url);
				p.setIntroduce(mainContentEle.toString());
				peoples.add(p);
				
				// Parse the polysemant list
//				Element beforeContentEle = bodyWrapperEle.select("div.before-content").first();
//				if(beforeContentEle.children().size() > 0){
//					Element polysemantListEle = beforeContentEle.select("div.polysemant-list > ul").first();
//					Elements polysemantLinks = polysemantListEle.select("li > a[href]");
//					for (Element link : polysemantLinks) {
//						p = crawlerByUrl(baseUrl + link.attr("href"));
//						peoples.add(p);
//					}
//				}
				Elements polysemantList = bodyWrapperEle.select("div.polysemant-list");
				if(polysemantList.size() > 0){
					Element polysemantUlEle = polysemantList.select("ul").first();
					Elements polysemantLinks = polysemantUlEle.select("li > a[href]");
					for (Element link : polysemantLinks) {
						p = crawlerByUrl(baseUrl + link.attr("href"));
						peoples.add(p);
					}
				}
				

			}else{
				System.out.println("&&&&&&&&&&&&&&&&&&&&&&&no result&&&&&&&&&&&&&&&&&");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} 

		return peoples;
	}
	
	
	public People crawlerByUrl(String url){
		People p = new People();
		try {
			Document doc = Jsoup.connect(url).get();
			String title = doc.title().replace("_百度百科","");
			Element bodyWrapperEle = doc.select("div.body-wrapper").first();
			Element mainContentEle = bodyWrapperEle.select("div.main-content").first();

			String desc = doc.select("meta[name=description]").get(0).attr("content");
			
			// remove some unimportant info
			mainContentEle.select("div.lemma-picture").remove();
			Elements albumELs = mainContentEle.select("a.lemma-album");
			if(albumELs.size() > 0){
				albumELs.remove();
			}
			Elements topTools = mainContentEle.select("div.top-tool");
			if(topTools.size()>0){
				topTools.remove();
			}
			
			Elements lemmaWgtLemmaTitleEls = mainContentEle.select("div.lemmaWgt-lemmaTitle");
			if(lemmaWgtLemmaTitleEls.size() > 0){
				lemmaWgtLemmaTitleEls.select("a[href]").remove();
			}
			
			Elements editPormt = mainContentEle.select("dov.edit-prompt");
			if(editPormt.size() > 0){
				editPormt.remove();
			}
			
			
//			mainContentEle.select("div#open-tag").first().remove();
			
			p.setTitle(title);
			p.setDescription(desc);
			p.setInfoSource(url);
			p.setIntroduce(mainContentEle.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	public static void main(String[] args) {
		BaiduBaikeCrawlerService bCrawler = new BaiduBaikeCrawlerService();
		List<People> list = bCrawler.crawlerByName("王连海");
		for (People people : list) {
			System.out.println("********************************************************");
			System.out.println(people.getTitle());
			System.out.println("****");
			System.out.println(people.getInfoSource());
			System.out.println("****");
			System.out.println(people.getIntroduce());
		}
	}
}
