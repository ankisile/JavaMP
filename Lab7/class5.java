import java.io.FileInputStream;
import java.util.Scanner;


public class class5 {

	public static void main(String[] args) throws Exception{
		byte a[]=new byte[1024];
		byte b[]=new byte[1024];
		Scanner scan = new Scanner(System.in);
		System.out.println("��ü ��θ��� �ƴ� ���� �̸��� �Է��ϴ� ���, ������ ������Ʈ ������ �־�� �մϴ�.");
		System.out.print("ù��° ���� �̸��� �Է��ϼ���>>");
		String name1 = scan.nextLine();
		FileInputStream fin1 = new FileInputStream(name1);
		
		System.out.print("�ι�° ���� �̸��� �Է��ϼ���>>");
		String name2 = scan.nextLine();
		FileInputStream fin2 = new FileInputStream(name2);
		
		fin1.read(a);
		fin2.read(b);
		System.out.println(name1+"�� "+name2+"�� ���մϴ�.");
		
		if(a.length!=b.length) {
			System.out.println("������ ���� �ٸ��ϴ�.");
			return;
		}
		for(int i=0;i<a.length;i++) {
			if(a[i]!=b[i]) {
				System.out.println("������ ���� �ٸ��ϴ�.");
				return;
			}
		}
		System.out.println("������ �����ϴ�.");
		
		fin1.close();
		fin2.close();
		scan.close();
	}

}
