package ex03_string;

public class EX01_String {

	public static void main(String[] args) {
		
		String str1 = "hello";
		String str2 = "hello";
		
		/*
		 * str1 0x123
		 * str2 0x123
		 * 		hello	0x123
		 */
		
		System.out.println(str1 == str2);
		
		String str3 = new String("hi");
		String str4 = new String("hi");
		
		/*
		 * str3 0x123
		 * str4 0x456
		 * 		hi		0x123
		 * 		hi		0x456
		 */

		System.out.println(str3 == str4);
		
		// 1. 문자열 동등 비교
		boolean result1 = str1.equals(str2);
		boolean result2 = str3.equals(str4);
		
		System.out.println(result1);
		System.out.println(result2);
		
		if(str1.equals(str2)) {
			System.out.println("str1, str2는 같아요");
		} else {
			System.out.println("str1, str2는 달라요");
		}
		
		if(!str3.equals(str4)) {
			System.out.println("str3, str4는 달라요");
		} else {
			System.out.println("str3, str4는 같아요");
		}
		
		// 2. 대소문자를 무시한 문자열 동등 비교
		String str5 = "Hello World";
		String str6 = "hELLO wORLD";
		
		System.out.println(str5.equals(str6));
		
		boolean result3 = str5.equalsIgnoreCase(str6); // 대소문자 문자열 무시하고 동등비교
		
		System.out.println(result3);
		
		// 3. 문자열의 길이 반환
		String name = "우영우";
		int length = name.length();
		System.out.println("글자 수 : " + length);
		
		// 4. 특정 위치의 문자(char)만 반환
		// 특정 위치
		// 인덱스(Index)라고 함
		// 글자마다 부여된 정수값
		// 0으로 시작
		System.out.println(name.charAt(0));
		System.out.println(name.charAt(1));
		System.out.println(name.charAt(2));
		
		// 5. 문자열의 일부 문자열(String)을 반환
		//    1) substring(begin) : 인덱스 begin부터 끝까지 반환
		//    2) substring(begin, end) : 인덱스 begin(포함)부터 인덱스 end(불포함)까지 반환
		System.out.println(name.substring(0, 1));
		System.out.println(name.substring(1));
		
		// 6. 특정 문자열을 찾아서 해당 인덱스(int)를 반환
		//    1) indexOf
		//       (1) 발견된 첫 번째 문자열의 인덱스를 변환
		//		 (2) 발견된 문자열이 없는 경우 -1을 반환
		//	  2) lastIndexOf
		//		 (1) 발견된 마지막 문자열의 인덱스를 반환
		//		 (2) 발견된 문자열이 없는 경우 -1을 반환
		int idx1 = name.indexOf("우");
		int idx2 = name.indexOf("원규");
		int idx3 = name.lastIndexOf("우");
		int idx4 = name.lastIndexOf("원규");
		System.out.println(idx1);
		System.out.println(idx2);
		System.out.println(idx3);
		System.out.println(idx4);
		
		// 7. 문자열이 특정 패턴으로 시작하는지 boolean(true, false) 반환
		//	  startWith(문자열)		
		if(name.startsWith("민")) {
			System.out.println("민씨입니다.");
		} else {
			System.out.println("민씨가 아닙니다.");
		}
		
		// 8. 문자열이 특정 패턴으로 끝나는지 여부를 boolean(true, false) 반환
		//    endWith(문자열)
		String filename = "image.jpg";	// jpg, png로 끝나면 이미지로 가정
		if(filename.endsWith("jpg") || filename.endsWith("png")) {
			System.out.println("이미지입니다.");
		} else {
			System.out.println("이미지가 아닙니다.");
		}
		
		
		// 9. 문자열이 특정 패턴을 포함하는지 여부를 boolean(true, false) 반환
		//    contains(문자열)
		String email = "lyinsics@gmail.com";
		if(email.contains("@") && email.contains(".")) {
			System.out.println("이메일입니다.");
		} else {
			System.out.println("이메일이 아닙니다");
		}
		
		
		// 10. 불필요한 공백 제거(좌우 공백(중간 공백은 지워지지 않음))
		String message = "  안녕  하세요  ";
		System.out.println(message.trim());
		System.out.println(message.trim().length());
		
		// 11. 대소문자 변환하기
		// toUpperCase() : 대문자로 변환하기
		// toLowerCase() : 소문자로 변환하기
		String source = "best of best";
		System.out.println(source.toUpperCase());
		System.out.println(source.toLowerCase());
		
		// 12. 찾아 바꾸기
		// replace(old, new) : old를 new로 변환하기
		String replaced = source.replace("best", "worst");
		System.out.println(source);
		System.out.println(replaced);
		
		// 주의. replaceAll() 메소드는 특정 문자열을 찾아서 변환하는 것이 아님.
		String ip = "192.168.101.91";
		String replacedIp = ip.replaceAll(".", "_"); // 192_168_101_91를 기대
		System.out.println(replacedIp);
		
		// 13. isEmpty() 빈 문자열인지 여부를 검사한 뒤 boolean(true, false) 반환
		String id = " ";
		if(id.isEmpty()) {
			System.out.println("빈 문자열");
		} else {
			System.out.println("빈 문자열 아님");			
		}
		
		// 연습. 파일이름을 파일명과 확장자로 분리
		// 단, jpg, git, png 이미지인 경우에만 작업을 진행한다. ㅡ 복습할 것
		String fullName = "apple.jpg";
		String fileName = ""; // apple
		String exitName = ""; // jpg
		
		int idxOfDot = fullName.lastIndexOf(".");
		fileName = fullName.substring(0, idxOfDot);
		exitName = fullName.substring(idxOfDot + 1);
		
		System.out.println(fileName);
		System.out.println(exitName);
		
		/* 나의 정답
		System.out.println(fullName.substring(0, 5));
		System.out.println(fullName.substring(6));
		*/
		
		// 연습. 문자열 "abc12345def67890ghijk"에서
		// 아라비아 숫자 1234567890은 제외하고 한 글자씩 화면에 출력 ㅡ 복습할 것
		
		String str = "abc12345def67890ghijk";
			
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if(ch >= '0' && ch <= '9') {
					continue;
				}
			System.out.println(ch);
		}
		
	}

}

