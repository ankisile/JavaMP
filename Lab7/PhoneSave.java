import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneSave {
	public static void main(String[] args) throws IOException{ //예외 처리
		Scanner scan = new Scanner(System.in); //스캐너 객체 생성
		FileWriter fout = null; //FileWriter 객체 선언
		File f = new File("c:\\temp\\phone.txt"); //File 객체 생성
		System.out.println("전화번호 입력 프로그램입니다."); 
		fout = new FileWriter(f); //파일과 연결된 출력 문자 스트림 생성
		while(true) {
			System.out.print("이름 전화번호 >> ");
			String str = scan.nextLine(); //한줄읽기
			if(str.equals("그만"))	break;	//str이 "그만"하고 같으면 무한루프에서 빠져나오기
			fout.write(str); //읽은 문자열 파일에 저장
			fout.write("\r\n"); //한줄 띄기 위해 "\r\n" 파일에 저장
		}
		System.out.println(f.getPath()+"에 저장하였습니다."); //file 클래스의 getPath()메소드 사용하여 경로명 전체를 문자열로 리턴
		fout.close();
		scan.close();
	}

}
