import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PhoneOpen {

	public static void main(String[] args) throws IOException{ //���� ó��
		FileReader fin = null; //FileReader ��ü ����
		File f = new File("c:\\temp\\phone.txt"); //File ��ü ����
		
		System.out.println(f.getPath()+"�� ����մϴ�."); //File Ŭ������ getPath() �޼ҵ� �̿��Ͽ� ��θ� �ҷ�����
		fin = new FileReader(f); // ���� �Է� ��Ʈ�� ��ü ����
		int c; 
		while((c=fin.read())!=-1) { //�ѹ��ھ� ���� ������ �д´�.
			System.out.print((char)c); //���ڸ� ����ϴµ� intŸ���̹Ƿ� char�� Ÿ��ĳ���� �Ͽ� ���
		}
		fin.close();
	}

}
