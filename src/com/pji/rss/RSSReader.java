package com.pji.rss;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document; 
import org.w3c.dom.Element; 
import org.w3c.dom.NodeList;

import com.pji.article.Article; 



public class RSSReader {    
   
   private static RSSReader instance = null;    
   
   private URL rssURL;    
   
   private RSSReader() {}    
   
   public static RSSReader getInstance() {    
      if (instance == null)    
         instance = new RSSReader();    
      return instance;    
   }    
   
   public void setURL(URL url) {    
      rssURL = url;    
   }    
   
   public ArrayList<Article> writeFeed() {    
      try {    
         DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();    
         Document doc = builder.parse(rssURL.openStream());    
   
         NodeList items = doc.getElementsByTagName("item");    
         ArrayList<Article> articleList = new ArrayList<Article>();
         for (int ii = 0; ii < items.getLength(); ii++) {    
            Element item = (Element)items.item(ii);
            Article article = new Article();
            article.setTitle(getValue(item, "title"));    
            article.setDescription(getValue(item, "description"));    
            article.setLink(getValue(item, "link"));  
            article.setDate(getValue(item, "pubDate"));
            articleList.add(article);
         }
         return articleList;
      } catch (Exception e) {    
         e.printStackTrace();    
      }    
      return null;
   }    
   
  
   public String getValue(Element parent, String nodeName) {    
      return parent.getElementsByTagName(nodeName).item(0).getFirstChild().getNodeValue();    
   } 
}