package ex02_datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EX06_SimpleDateFormat {

	public static void main(String[] args) {
		
		// java.text.SimpleDateFormat 클래스
		// 패턴이 적용된 String 타빙의 날짜 반환
		
		Date date1 = new Date();
		java.sql.Date date2 = new java.sql.Date(System.currentTimeMillis()); // 이미 Date라는 것을 임포트 했기 때문에 이렇게 길게 쓴다.
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String result1 = sdf.format(date1);
		String result2 = sdf.format(date2);

		System.out.println(result1);
		System.out.println(result2);
		
	}

}
