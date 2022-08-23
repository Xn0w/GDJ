package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ApiMain  {
	
	public static void m1() {
		
		// 인증키(Decoding)
		String apiURL = "http://apis.data.go.kr/B552061/AccidentDeath";
		String serviceKey = "kdBmRoUSOOptUUBQPksWbIkTC9wYv2gqPczD4nmmeIlb/pxBcJdJit6RxY0TOVjQt3/2MtpC9b6JEEEu9gk5bA==";

		// API 주소	(주소 + 요청 파라미터)
		StringBuilder urlBuilder = new StringBuilder();
		try {
			urlBuilder.append("http://apis.data.go.kr/B552061/AccidentDeath");
			urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&occrrnc_dt=201911622");
			urlBuilder.append("&occrrnc_day_cd=4");
			urlBuilder.append("&dth_dnv_cnt=0");
			urlBuilder.append("&injpsn_cnt=1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// API 주소 접속
		URL url = null;
		HttpURLConnection con = null;
		
		try {			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		} catch(MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch(IOException e) {
			System.out.println("API 접속 실패");
		}
		
		// 입력 스트림 생성
		// 1. 서버가 보낸 데이터를 읽어야 하므로 입력 스트림이 필요
		// 2. 서버와 연결된 입력 스트림은 바이트 스트림이므로 문자 스트림으로 변환해야 함
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		try {
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			// 스트림 종료
			reader.close();
			
		} catch(IOException e) {
			System.out.println("API 응답 실패");
		}
		
		// API로부터 전달받은 xml 데이터
		String response = sb.toString();
		
		// XML File 생성
		File file = new File("C:\\storage", "accident.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
public static void m2() {
		
		File file = new File("C:\\storage", "accident.xml");
		List<Accident> defs = new ArrayList<>();
		
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			NodeList boxOfficeList = doc.getElementsByTagName("Accident");
			
			for(int i = 0; i < boxOfficeList.getLength(); i++) {
				
				Element boxOffice = (Element)boxOfficeList.item(i);
				/*
				NodeList occrrncDtList = boxOffice.getElementsByTagName("occrrncDt");
				Node occrrncDtNode = occrrncDtList.item(0);
				String occrrncDt = occrrncDtNode.getTextContent();
				*/
				String occrrncDt = boxOffice.getElementsByTagName("occrrncDt").item(0).getTextContent();
				String occrrncDayCd = boxOffice.getElementsByTagName("occrrncDayCd").item(0).getTextContent();
				String dthDnvCnt = boxOffice.getElementsByTagName("dthDnvCnt").item(0).getTextContent();
				String injpsnCnt = boxOffice.getElementsByTagName("injpsnCnt").item(0).getTextContent();
				
				Accident def = Accident.builder()
						.occrrncDt(occrrncDt)
						.occrrncDayCd(occrrncDayCd)
						.dthDnvCnt(dthDnvCnt)
						.injpsnCnt(injpsnCnt)
						.build();
				
				defs.add(def);
				
			}  // for
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(Accident def : defs) {
			System.out.println(def);
		}

	}

	public static void main(String[] args) {
		
		m2();
	}

}
