package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiMain {

	public static void main(String[] args) {
		
		StringBuilder urlBuilder = new StringBuilder();

		// API 주소	(주소 + 요청 파라미터)
		try {
			String serviceKey = "kdBmRoUSOOptUUBQPksWbIkTC9wYv2gqPczD4nmmeIlb/pxBcJdJit6RxY0TOVjQt3/2MtpC9b6JEEEu9gk5bA==";
			urlBuilder.append("http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath");
			urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&searchYear=2021");
			urlBuilder.append("&siDo=1100");
			urlBuilder.append("&guGun=1125");
			urlBuilder.append("&type=json");
			urlBuilder.append("&numOfRows=10");
			urlBuilder.append("&pageNo=1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		HttpURLConnection con = null;
		
		try {			
			URL url = new URL(urlBuilder.toString());
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		} catch(MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch(IOException e) {
			System.out.println("API 접속 실패");
		}
		
		StringBuilder sb = new StringBuilder();
		try {
			
			BufferedReader reader = null;
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			while((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			// 스트림 종료
			reader.close();
			
		} catch(IOException e) {
			System.out.println("API 응답 실패");
		}	
		
		StringBuilder result = new StringBuilder();
		List<Accident> accidents = new ArrayList<Accident>();
		JSONObject obj = new JSONObject(sb.toString());
		JSONArray itemList = obj.getJSONObject("items")
				.getJSONArray("item");
		for(int i = 0; i < itemList.length(); i++) {
			
		}
	}

}
