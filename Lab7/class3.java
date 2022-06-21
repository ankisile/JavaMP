import java.io.FileReader;
import java.io.IOException;

public class class3 {

	public static void main(String[] args) {
		try {
			FileReader f = new FileReader("c:\\windows\\system.ini");
			int c;
			while((c=f.read())!=-1) {
				System.out.print(Character.toUpperCase((char)c));
			
			}
			f.close();

		}
		catch(IOException e) {
			System.out.println("error");
		}
	}

}
