import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileLineNumber {

	public static void main(String[] args) throws IOException{ //예외 처리
		Scanner fScanner = new Scanner(new FileReader("c:\\windows\\system.ini")); //파일 입력 스트림과 Scanner 이용하여 파일을 읽어옴
		System.out.println("C:\\windows\\system.ini 파일을 읽어 출력합니다.");
		int lineNumber=1; //lineNumber를 1로 초기화. lineNumeber는 라인 번호를 가진 변수
		while(fScanner.hasNext()) { //파일에 읽을내용이 있으면 true로 다음을 반복, 없으면 false로 while문 빠져나옴
			String line = fScanner.nextLine(); //파일에서 한줄 읽어옴
			System.out.printf("%4d: ", lineNumber); //라인 번호 출력
			System.out.println(line); //line 출력
			lineNumber++; //lineNumber 1증가
		}
		
		fScanner.close();

	}

}
