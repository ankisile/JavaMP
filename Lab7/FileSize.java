import java.io.File;

public class FileSize {

	public static void main(String[] args) {
		File f = new File("c:\\"); //File ��ü ����
		File[] subfiles = f.listFiles(); //���͸��� �ִ� ���� ����Ʈ ���. ����Ʈ �� �迭�� ����
		File maxFile = null; //File ��ü ����
		for(int i=0;i<subfiles.length;i++) { //�迭�� ũ�⸸ŭ �ݺ�
			if(i==0) //i�� 0�̸�
				maxFile = subfiles[i]; //maxFile�� subFiles[i]�� ����
			if(maxFile.length()<subfiles[i].length()) { //maxFile�� ũ��� subfiles[i]�� ũ�⸦ ���ؼ� subfiles[i]�� ũ�Ⱑ ũ��
				maxFile = subfiles[i]; //maxFile�� subFiles[i]�� ����
			}
		}
		System.out.println("���� ū ������ "+maxFile.getPath()+" "+maxFile.length()+"����Ʈ"); //File Ŭ������ getPath()�� length() �޼ҵ� ���
	}

}
