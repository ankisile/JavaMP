import java.io.FileInputStream;
import java.util.Scanner;


public class class5 {

	public static void main(String[] args) throws Exception{
		byte a[]=new byte[1024];
		byte b[]=new byte[1024];
		Scanner scan = new Scanner(System.in);
		System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
		System.out.print("첫번째 파일 이름을 입력하세요>>");
		String name1 = scan.nextLine();
		FileInputStream fin1 = new FileInputStream(name1);
		
		System.out.print("두번째 파일 이름을 입력하세요>>");
		String name2 = scan.nextLine();
		FileInputStream fin2 = new FileInputStream(name2);
		
		fin1.read(a);
		fin2.read(b);
		System.out.println(name1+"와 "+name2+"를 비교합니다.");
		
		if(a.length!=b.length) {
			System.out.println("파일이 서로 다릅니다.");
			return;
		}
		for(int i=0;i<a.length;i++) {
			if(a[i]!=b[i]) {
				System.out.println("파일이 서로 다릅니다.");
				return;
			}
		}
		System.out.println("파일이 같습니다.");
		
		fin1.close();
		fin2.close();
		scan.close();
	}

}
