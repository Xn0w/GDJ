package com.gdu.appsearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiSearchBook {

	public static void main(String[] args) {
		
		String clientId = "b1R4Dud4xlfeN0wtphqw";
		String clientSecret = "Oc7AUkKjXZ";
		
		
		
		try {
								
			Scanner sc = new Scanner(System.in);
			
			String a = URLEncoder.encode("a","UTF-8");
			
			String apiURL = "https://openapi.naver.com/v1/search/book?query=자바";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			
			BufferedReader br = null;
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			StringBuilder sb = new StringBuilder();
			String line; 
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			br.close();

			con.disconnect();
			
			JSONObject obj = new JSONObject(sb.toString());

			
			File dir = new File("C:\\download", "자바.html");
			if(dir.exists() == false) {
				dir.mkdirs();
			}
			
			File file = new File(dir, "자바.html");
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				writer.write(sb.toString());
				writer.close();
			} catch(IOException e) {
				System.out.println("파일 생성 실패");
			}
			PrintWriter out = new PrintWriter(file);
			out.println("<DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>능력단위평가</title>");
			out.println("<body>");
			out.println("<h1>능력단위평가</h1>");
			out.println("<a href=\"https://openapi.naver.com/v1/search/book?query=자바\"><button>자바</button></a>");
			out.println("</body>");
			out.println("</html>");
			out.close();
			
			JSONObject response = obj.getJSONObject("response");
			JSONObject body = response.getJSONObject("body");
			JSONObject items = body.getJSONObject("items");
			JSONArray item = items.getJSONArray("item");
			for(int i = 0; i < item.length(); i++) {
				JSONObject element= item.getJSONObject(i);
				System.out.println(element.getString("category") + " : " + element.getString("obsrValue"));
			}
			
			return;
			
		} catch(Exception e) {
			
			try {
				//
				File dir = new File("C:\\download", "error_log.txt");
				if(dir.exists() == false) {
					dir.mkdirs();
				}
				//
				File file = new File(dir, "error_log.txt");
				PrintWriter out = new PrintWriter(file);
				out.println();
				out.close();
				
			} catch(Exception e2) {
				e2.printStackTrace();
			}
			 
			
		}
		
		
	}
	
}
