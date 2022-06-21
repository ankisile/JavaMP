
public class Print2DArray {

	public static void main(String[] args) {
		int n[][] = {{1}, {1, 2, 3}, {1}, {1, 2, 3, 4}, {1, 2}}; //배열 선언
		
		for(int i=0;i<n.length;i++) { //행의 개수만큼 반복하면서
			for(int j=0;j<n[i].length;j++) //각 행의 열의 개수만큼 반복하면서
				System.out.print(n[i][j]+"\t"); //그 행과 열에 해당하는 수 출력
			System.out.println(); //한 행이 다 끝나면 println을 통해 한 줄띄기
		}

	}

}
