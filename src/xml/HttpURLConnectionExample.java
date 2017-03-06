/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

/**
 *
 * @author tuf52965
 */
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.File;
import java.net.URLConnection;
import java.util.Scanner;
import static java.util.stream.DoubleStream.builder;
import static java.util.stream.IntStream.builder;
import static java.util.stream.Stream.builder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import javax.net.ssl.HttpsURLConnection;

public class HttpURLConnectionExample {

	private final String USER_AGENT = "Mozilla/5.0";
        private static String idn;

	public static void main(String[] args) throws Exception {

            HttpURLConnectionExample http = new HttpURLConnectionExample();

            System.out.println("Testing 1 - Send Http GET request");
		//http.sendGet(); FOR TESTING
                
            System.out.println("Input ID Please...");
            Scanner scan= new Scanner(System.in);
            idn=scan.nextLine();
                
               
            try{
                new HttpURLConnectionExample().start();
            }catch (Exception e){}


	}
        
        private void start() throws Exception{
            URL url= new URL ("http://129.32.92.49/xml/grade.php?id="+idn);
            URLConnection connection = url.openConnection();
            Document doc = parseXML(connection.getInputStream());
            NodeList name = doc.getElementsByTagName("name");
            NodeList grade = doc.getElementsByTagName("grade");
            NodeList suc = doc.getElementsByTagName("success");
            NodeList time = doc.getElementsByTagName("timestamp");

            System.out.print("Success: ");
            for(int i=0; i<suc.getLength();i++)
            {
                System.out.println(suc.item(i).getTextContent());
            }
            System.out.print("Timestamp: ");
            for(int i=0; i<time.getLength();i++)
            {
                System.out.println(time.item(i).getTextContent());
            }

            System.out.print("Name: ");

            for(int i=0; i<name.getLength();i++)
            {
                System.out.println(name.item(i).getTextContent());
            }
            System.out.print("Grade: ");
            for(int i=0; i<grade.getLength();i++)
            {
                System.out.println(grade.item(i).getTextContent());
            }

            }
        
        private Document parseXML(InputStream stream)throws Exception
        {
            DocumentBuilderFactory objDocumentBuilderFactory = null;
            DocumentBuilder objDocumentBuilder = null;
            Document doc = null;
            try
            {
                objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
                objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();

                doc = objDocumentBuilder.parse(stream);
            }
            catch(Exception ex)
            {
                throw ex;
            }       

            return doc;
    }

	// HTTP GET request
	/*private void sendGet() throws Exception {

		String url = "http://129.32.92.49/xml/grade.php?id=100";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
                System.out.println("_______________");

	}*/


}