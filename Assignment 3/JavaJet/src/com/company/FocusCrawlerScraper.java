package com.company;
import org.apache.poi.ss.usermodel.Row;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import java.io.File;
import java.io.FileOutputStream;

import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FocusCrawlerScraper {
    public static class excelRowInfo{
        public Integer row;
        public Integer prev;
        excelRowInfo(){
            prev= 0;
            row = 2;
        }
    }
    public static void main(String[] args) throws IOException {
        String url = "https://pec.ac.in/"; //Initial argument
        print("Focussed Crawling on site for faculty links", url);


        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFWorkbook url_workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Web Data");
        XSSFSheet url_sheet = url_workbook.createSheet("URL Data");


        excelRowInfo rowInfo = new excelRowInfo();
        excelRowInfo url_rowInfo = new excelRowInfo();
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        Map<String, Object[]> url_data = new TreeMap<String, Object[]>();

        data.put("1", new Object[] {"Tag", "Text"});
        url_data.put("1", new Object[] {"Text", "Url"});

        Set<String> url_HashMap = new HashSet<String>(); // Hash map to store visited pages
        page_process(url,url_HashMap,data,rowInfo,workbook,sheet,url_data,url_rowInfo,url_workbook,url_sheet);
    }
    private static void page_process(String url,Set<String> url_HashMap,Map data,excelRowInfo rowInfo,XSSFWorkbook workbook,XSSFSheet sheet,Map url_data,excelRowInfo url_rowInfo,XSSFWorkbook url_workbook,XSSFSheet url_sheet) throws IOException{
        url_HashMap.add(url); //Visited this page
        print("Fetching %s...", url);

        int flag = 0;
        if(url.contains("faculty")){
            flag = 1; // To indicate we are in the focus group of faculty
        }

        List<String> urlsOnThisPage = new ArrayList<String>();

        Document doc = Jsoup.connect(url).get();
        Elements paragraphs = doc.select("p");
        Elements links = doc.select("a[href]");
        Elements header1 = doc.select("h1");
        Elements header2 = doc.select("h2");
        Elements header3 = doc.select("h3");
        Elements images = doc.select("img");


        if(flag==1) data.put(String.valueOf(rowInfo.row++),new Object[] {"",""});
        if(flag==1) data.put(String.valueOf(rowInfo.row++),new Object[] {doc.title(),doc.id()});

        if(flag==1) url_data.put(String.valueOf(url_rowInfo.row++),new Object[] {"",""});
        if(flag==1) url_data.put(String.valueOf(url_rowInfo.row++),new Object[] {doc.title(),doc.id()});



        if(flag==1)  print("\nLinks: (%d)", links.size());
        for (Element link : links) {
            urlsOnThisPage.add(link.attr("abs:href"));
            if(flag==1) url_data.put(String.valueOf(url_rowInfo.row++),new Object[] {link.text(),link.attr("abs:href")});
            if(flag==1) print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
        }

        if(flag==1) print("\nparagraphs: (%d)", paragraphs.size());
        for (Element p : paragraphs) {
            if(!(p.text()).equals("")){
                if(flag==1) data.put(String.valueOf(rowInfo.row++),new Object[] {p.tagName(),p.text()});
                if(flag==1) print(" * %s <%s> (%s)", p.tagName(),p.text(), p.attr("rel"));
            }
        }

        if(flag==1) print("\nHeader 1: (%d)", header1.size());
        for (Element p : header1) {
            if(!(p.text()).equals("")){
                if(flag==1) data.put(String.valueOf(rowInfo.row++),new Object[] {p.tagName(),p.text()});
                if(flag==1) print(" * %s <%s> (%s)", p.tagName(),p.text(), p.attr("rel"));
            }
        }

        if(flag==1) print("\nHeader 2: (%d)", header2.size());
        for (Element p : header2) {
            if(!(p.text()).equals("")){
                if(flag==1) data.put(String.valueOf(rowInfo.row++),new Object[] {p.tagName(),p.text()});
                if(flag==1) print(" * %s <%s> (%s)", p.tagName(),p.text(), p.attr("rel"));
            }
        }

        if(flag==1) print("\nHeader 3: (%d)", header3.size());
        for (Element p : header3) {
            if(!(p.text()).equals("")){
                if(flag==1) data.put(String.valueOf(rowInfo.row++),new Object[] {p.tagName(),p.text()});
                if(flag==1) print(" * %s <%s> (%s)", p.tagName(),p.text(), p.attr("rel"));
            }
        }

        if(flag==1) print("\nImages: (%d)", images.size());
        for (Element p : images) {
            if(flag==1) data.put(String.valueOf(rowInfo.row++),new Object[] {p.tagName(),p.attr("src")});
            if(flag==1) print(" * %s <%s> (%s)", p.tagName(),p.text(), p.attr("rel"));
        }


        if(flag==1) writeToExcel(data,rowInfo,workbook,sheet,"tag_data.xlsx");
        if(flag==1) data.clear();
        if(flag==1) writeToExcel(url_data,url_rowInfo,url_workbook,url_sheet,"urls.xlsx");
        if(flag==1) url_data.clear();


        for (String urls : urlsOnThisPage){
            if(url_HashMap.contains((urls))) continue; //Not visiting again
            if(!url.contains("https://pec.ac.in/")) continue;
            //System.out.println(urls);
            page_process(urls,url_HashMap,data,rowInfo,workbook,sheet,url_data,url_rowInfo,url_workbook,url_sheet);
        }
    }

    private static void writeToExcel(Map data,excelRowInfo rows,XSSFWorkbook book,XSSFSheet shet,String file){
        Set<String> keyset = data.keySet();
        int rownum = rows.prev;
        //Processing the map to feed in rows and columns
        for (String key : keyset)
        {
            Row row = shet.createRow(rownum++);
            Object [] objArr = (Object[]) data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
                Cell cell = row.createCell(cellnum++);
                if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
            rows.prev = rows.row;
        }
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File(file));
            book.write(out);
            out.close();
            System.out.println(file + " written successfully on disk.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
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
