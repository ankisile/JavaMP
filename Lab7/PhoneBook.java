import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {

	public static void main(String[] args) throws IOException { //예외 처리
		HashMap<String, String> phoneMap = new HashMap<String, String>(); //해시맵 생성
		Scanner fScanner = new Scanner(new FileReader("c:\\temp\\phone.txt")); //파일 입력 스트림과 Scanner 이용하여 파일을 읽어옴
		Scanner scan = new Scanner(System.in); //스캐너 객체 생성
		while(fScanner.hasNext()) { //파일에 내용이 있으면
			String name = fScanner.next(); //파일에서 읽어옴
			String tel = fScanner.next(); //파일에서 읽어옴
			phoneMap.put(name, tel); //파일에서 읽어온 값들을 phoneMap에 저장
		}
		System.out.println("총 "+phoneMap.size()+"개의 전화번호를 읽었습니다.");  //HashMap의 size()메소드 이용하여 키의 개수 출력
		
		while(true) {
			System.out.print("이름>> ");
			String search = scan.next(); //찾을 이름 입력
			if(search.equals("그만")) break; //search가  "그만"과 같으면 루프 빠져나옴
			String line = phoneMap.get(search); //line에 search라는 키값의 value값 저장
			if(line==null) //line이 null이면 없다는 뜻
				System.out.println("찾는 이름이 없습니다.");
			else
				System.out.println(line);
		}
		scan.close();

	}

}
