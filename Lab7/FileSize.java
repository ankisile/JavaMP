import java.io.File;

public class FileSize {

	public static void main(String[] args) {
		File f = new File("c:\\"); //File 객체 생성
		File[] subfiles = f.listFiles(); //디렉터리에 있는 파일 리스트 얻기. 리스트 얻어서 배열에 저장
		File maxFile = null; //File 객체 선언
		for(int i=0;i<subfiles.length;i++) { //배열의 크기만큼 반복
			if(i==0) //i가 0이면
				maxFile = subfiles[i]; //maxFile에 subFiles[i]를 저장
			if(maxFile.length()<subfiles[i].length()) { //maxFile의 크기와 subfiles[i]의 크기를 비교해서 subfiles[i]의 크기가 크면
				maxFile = subfiles[i]; //maxFile에 subFiles[i]를 저장
			}
		}
		System.out.println("가장 큰 파일은 "+maxFile.getPath()+" "+maxFile.length()+"바이트"); //File 클래스의 getPath()와 length() 메소드 사용
	}

}
