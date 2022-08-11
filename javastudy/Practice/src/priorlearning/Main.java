package priorlearning;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;



public class Main {

	public static void m1() {
		TreeMap<Integer,String> map = new TreeMap<Integer,String>() {
			{	//초기값 설정
			    put(1, "사과");		//값 추가
			    put(2, "복숭아");
			    put(3, "수박");
			}
		};
				
		System.out.println(map); 				//전체 출력 : {1=사과, 2=복숭아, 3=수박}
		System.out.println(map.get(1));			//key값 1의 value얻기 : 사과
		System.out.println(map.firstEntry());	//최소 Entry 출력 : 1=사과
		System.out.println(map.firstKey());		//최소 Key 출력 : 1
		System.out.println(map.lastEntry());	//최대 Entry 출력: 3=수박
		System.out.println(map.lastKey());		//최대 Key 출력 : 3
		System.out.println();
		
		for (Entry<Integer, String> entry : map.entrySet()) {
		    System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
	}
	
	public static void m2() {
		
		List<String> list = Arrays.asList("자바", "파이썬", "스프링", "장고");
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			String name = iterator.next();
			System.out.println(name);
		}
				
		for (String s : list) {
			System.out.println(s);
		}
			
	}
	
	public static void main(String[] args) {

		m2();
	}

}
