import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneSave {
	public static void main(String[] args) throws IOException{ //���� ó��
		Scanner scan = new Scanner(System.in); //��ĳ�� ��ü ����
		FileWriter fout = null; //FileWriter ��ü ����
		File f = new File("c:\\temp\\phone.txt"); //File ��ü ����
		System.out.println("��ȭ��ȣ �Է� ���α׷��Դϴ�."); 
		fout = new FileWriter(f); //���ϰ� ����� ��� ���� ��Ʈ�� ����
		while(true) {
			System.out.print("�̸� ��ȭ��ȣ >> ");
			String str = scan.nextLine(); //�����б�
			if(str.equals("�׸�"))	break;	//str�� "�׸�"�ϰ� ������ ���ѷ������� ����������
			fout.write(str); //���� ���ڿ� ���Ͽ� ����
			fout.write("\r\n"); //���� ��� ���� "\r\n" ���Ͽ� ����
		}
		System.out.println(f.getPath()+"�� �����Ͽ����ϴ�."); //file Ŭ������ getPath()�޼ҵ� ����Ͽ� ��θ� ��ü�� ���ڿ��� ����
		fout.close();
		scan.close();
	}

}
