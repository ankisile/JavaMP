import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class class7 {

	public static void main(String[] args) throws IOException{
		File src = new File("a.txt");
		File out = new File("b.txt");
		FileInputStream fr1 = new FileInputStream(src); //ù��° ���Ͽ� ���� �Է� ��Ʈ��
		FileOutputStream fr2 = new FileOutputStream(out); //�ι�° ���Ͽ� ���� �Է� ��Ʈ��
		
		long srclen = src.length()/10;
		
		int c;
		while((c=fr1.read())!=-1) {
			fr2.write((char)c);
			if(((int)out.length()%srclen)==0){
				System.out.print("*");
			}
			
		}
	}

}
