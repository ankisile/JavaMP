import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileAppend {

	public static void main(String[] args) throws IOException{ //예외 처리
		Scanner scan = new Scanner(System.in);
		System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
		System.out.print("첫번째 파일 이름을 입력하세요>>");
		String first = scan.nextLine(); //파일 이름 받기
		System.out.print("두번째 파일 이름을 입력하세요>>");
		String second = scan.nextLine(); //파일 이름 받기
		System.out.print("합치는 파일 이름을 입력하세요>>");
		String append = scan.nextLine(); //파일 이름 받기
		FileReader fr1 = new FileReader(first); //첫번째 파일에 대한 입력 스트림
		FileReader fr2 = new FileReader(second); //두번째 파일에 대한 입력 스트림
		FileWriter fw = new FileWriter(append); //합치는 파일에 대한 출력 스트림
		int c;
		while((c=fr1.read())!=-1) { //첫번째 파일에서 문자를 파일 끝까지 읽을동안
			fw.write((char)c); //합치는 파일에 문자를 작성. c는 int 타입이므로 char타입으로 타입 캐스팅
		}
		fw.write("\r\n"); //첫번째 파일의 복사가 다 끝나면 줄바꿈문자를 넣어서 줄바꿔줌
		while((c=fr2.read())!=-1) { //두번째 파일에서 문자를 파일 끝까지 읽을 동안
			fw.write((char)c); //합치는 파일에 문자를 작성. c는 int 타입이므로 char타입으로 타입 캐스팅. 이때 덮어쓰지 않고 추가적으로 작성되는 것
		}
		System.out.println("프로젝트 폴더 밑에 "+append+" 파일에 저장하였습니다.");
		fr1.close();
		fr2.close();
		fw.close();
		scan.close();
	}

}
