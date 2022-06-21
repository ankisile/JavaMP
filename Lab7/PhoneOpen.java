import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PhoneOpen {

	public static void main(String[] args) throws IOException{ //예외 처리
		FileReader fin = null; //FileReader 객체 선언
		File f = new File("c:\\temp\\phone.txt"); //File 객체 생성
		
		System.out.println(f.getPath()+"를 출력합니다."); //File 클래스의 getPath() 메소드 이용하여 경로명 불러오기
		fin = new FileReader(f); // 문자 입력 스트림 객체 생성
		int c; 
		while((c=fin.read())!=-1) { //한문자씩 파일 끝까지 읽는다.
			System.out.print((char)c); //문자를 출력하는데 int타입이므로 char로 타입캐스팅 하여 출력
		}
		fin.close();
	}

}
