import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileLineNumber {

	public static void main(String[] args) throws IOException{ //���� ó��
		Scanner fScanner = new Scanner(new FileReader("c:\\windows\\system.ini")); //���� �Է� ��Ʈ���� Scanner �̿��Ͽ� ������ �о��
		System.out.println("C:\\windows\\system.ini ������ �о� ����մϴ�.");
		int lineNumber=1; //lineNumber�� 1�� �ʱ�ȭ. lineNumeber�� ���� ��ȣ�� ���� ����
		while(fScanner.hasNext()) { //���Ͽ� ���������� ������ true�� ������ �ݺ�, ������ false�� while�� ��������
			String line = fScanner.nextLine(); //���Ͽ��� ���� �о��
			System.out.printf("%4d: ", lineNumber); //���� ��ȣ ���
			System.out.println(line); //line ���
			lineNumber++; //lineNumber 1����
		}
		
		fScanner.close();

	}

}
