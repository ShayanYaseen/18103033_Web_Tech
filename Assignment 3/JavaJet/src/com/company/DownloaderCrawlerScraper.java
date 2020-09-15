package com.company;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import org.apache.commons.io.FilenameUtils;

public class DownloaderCrawlerScraper {
    public static void main(String[] args) throws IOException {
        String url = "https://pec.ac.in/"; //Initial argument

        Set<String> url_HashMap = new HashSet<String>(); // Hash map to store visited pages
        //download_pdf("https://pec.ac.in/sites/default/files/uploads/events/Email_Manual.pdf","name"+".pdf");
        page_process(url,url_HashMap);
    }
    private static void page_process(String url,Set<String> url_HashMap) throws IOException{
        url_HashMap.add(url); //Visited this page
        print("Fetching %s...", url);
        List<String> urlsOnThisPage = new ArrayList<String>();

        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");

        print("\nLinks: (%d)", links.size());
        for (Element link : links) {
            urlsOnThisPage.add(link.attr("abs:href"));
            //print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
            String tmp = link.attr("abs:href");
            if(tmp.endsWith(".pdf")){
                //System.out.println("Pdf Found at " + tmp + "\nDownloading........" + link.text());
                print(tmp,link.text());
                download_pdf(tmp,link.text());
            }
        }

        for (String urls : urlsOnThisPage){
            if(url_HashMap.contains((urls))) continue; //Not visiting again
            if(!url.contains("https://pec.ac.in/")) continue;
            if(url.endsWith(".pdf")) continue;
            page_process(urls,url_HashMap);
        }
    }
    private static void download_pdf(String url,String name){
        if(url.endsWith(".pdf")){
            System.out.println("Pdf Found at " + url + "\nDownloading........");
            File file = new File(name);
            URL urls = null;
            try {
                urls = new URL(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            //Downloading the pdf
            try {
                FileUtils.copyURLToFile(urls, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }
}
