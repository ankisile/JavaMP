import java.io.File;

public class class9 {

	public static void main(String[] args) {
		File f = new File("c:\\temp");
		File[] subfiles = f.listFiles();
		int n=0;
		for(int i=0;i<subfiles.length;i++) {
			String s = subfiles[i].getName();
			int index= s.lastIndexOf(".txt");
			if(index==-1)
				continue;
			subfiles[i].delete();
			n++;
		}

	}

}
