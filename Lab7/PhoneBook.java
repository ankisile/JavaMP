import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {

	public static void main(String[] args) throws IOException { //���� ó��
		HashMap<String, String> phoneMap = new HashMap<String, String>(); //�ؽø� ����
		Scanner fScanner = new Scanner(new FileReader("c:\\temp\\phone.txt")); //���� �Է� ��Ʈ���� Scanner �̿��Ͽ� ������ �о��
		Scanner scan = new Scanner(System.in); //��ĳ�� ��ü ����
		while(fScanner.hasNext()) { //���Ͽ� ������ ������
			String name = fScanner.next(); //���Ͽ��� �о��
			String tel = fScanner.next(); //���Ͽ��� �о��
			phoneMap.put(name, tel); //���Ͽ��� �о�� ������ phoneMap�� ����
		}
		System.out.println("�� "+phoneMap.size()+"���� ��ȭ��ȣ�� �о����ϴ�.");  //HashMap�� size()�޼ҵ� �̿��Ͽ� Ű�� ���� ���
		
		while(true) {
			System.out.print("�̸�>> ");
			String search = scan.next(); //ã�� �̸� �Է�
			if(search.equals("�׸�")) break; //search��  "�׸�"�� ������ ���� ��������
			String line = phoneMap.get(search); //line�� search��� Ű���� value�� ����
			if(line==null) //line�� null�̸� ���ٴ� ��
				System.out.println("ã�� �̸��� �����ϴ�.");
			else
				System.out.println(line);
		}
		scan.close();

	}

}
