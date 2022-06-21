import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileAppend {

	public static void main(String[] args) throws IOException{ //���� ó��
		Scanner scan = new Scanner(System.in);
		System.out.println("��ü ��θ��� �ƴ� ���� �̸��� �Է��ϴ� ���, ������ ������Ʈ ������ �־�� �մϴ�.");
		System.out.print("ù��° ���� �̸��� �Է��ϼ���>>");
		String first = scan.nextLine(); //���� �̸� �ޱ�
		System.out.print("�ι�° ���� �̸��� �Է��ϼ���>>");
		String second = scan.nextLine(); //���� �̸� �ޱ�
		System.out.print("��ġ�� ���� �̸��� �Է��ϼ���>>");
		String append = scan.nextLine(); //���� �̸� �ޱ�
		FileReader fr1 = new FileReader(first); //ù��° ���Ͽ� ���� �Է� ��Ʈ��
		FileReader fr2 = new FileReader(second); //�ι�° ���Ͽ� ���� �Է� ��Ʈ��
		FileWriter fw = new FileWriter(append); //��ġ�� ���Ͽ� ���� ��� ��Ʈ��
		int c;
		while((c=fr1.read())!=-1) { //ù��° ���Ͽ��� ���ڸ� ���� ������ ��������
			fw.write((char)c); //��ġ�� ���Ͽ� ���ڸ� �ۼ�. c�� int Ÿ���̹Ƿ� charŸ������ Ÿ�� ĳ����
		}
		fw.write("\r\n"); //ù��° ������ ���簡 �� ������ �ٹٲ޹��ڸ� �־ �ٹٲ���
		while((c=fr2.read())!=-1) { //�ι�° ���Ͽ��� ���ڸ� ���� ������ ���� ����
			fw.write((char)c); //��ġ�� ���Ͽ� ���ڸ� �ۼ�. c�� int Ÿ���̹Ƿ� charŸ������ Ÿ�� ĳ����. �̶� ����� �ʰ� �߰������� �ۼ��Ǵ� ��
		}
		System.out.println("������Ʈ ���� �ؿ� "+append+" ���Ͽ� �����Ͽ����ϴ�.");
		fr1.close();
		fr2.close();
		fw.close();
		scan.close();
	}

}
