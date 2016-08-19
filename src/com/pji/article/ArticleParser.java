package com.pji.article;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ArticleParser {
	private String content;
	private String author;
	
	public void startPasing(String uri){
        try {
        	this.content = "";
        	this.author = "";
        	
            URL url = new URL(uri);
            DataInputStream dis = new DataInputStream(url.openStream());
            String inputLine;
            String html = "";
             while ((inputLine = dis.readLine()) != null) {
              //  System.out.println(inputLine);
                html += inputLine;
            }
            Document doc = Jsoup.parse(html);  
            Elements rows = doc.select("div.source a");
            
            
            this.author = rows.get(0).text();
            
            rows = doc.select("div.group");
            
            for(int i=0; i<rows.size(); i++){
            	this.content += rows.get(i).toString();
            }
            
            

            dis.close();
        } catch (MalformedURLException me) {
            System.out.println("MalformedURLException: " + me);
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe);
        }
	}
	
	public String getAuthor(){
		return this.author;
	}
	
	public String getContent(){
		return this.content;
	}
}
