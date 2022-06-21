
public class twoDArray {

	public static void main(String[] args) {
		int arr[][] = new int[4][4]; //4*4 배열 생성
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++)
				arr[i][j]=0; // 배열의 모든 원소들 0으로 초기화
		}
		
		for(int i=0;i<10;) { //반복문 돌면서 10개만 랜덤한 정수 생성
			int n = (int)(Math.random()*10 + 1);
			int row = (int)(Math.random()*4); //배열의 행 인덱스 랜덤하게 생성
			int col = (int)(Math.random()*4); //배열의 열 인덱스 랜덤하게 생성
			
			if(arr[row][col]!=0) continue; //배열 원소가 0이 아니면 이미 저장된 값이므로 건너뜀
			else arr[row][col]=n; //그렇지 않다면 랜덤숫자(1~10) 저장
			i++;//생성된 숫자 개수 증가
		}
		for(int i=0;i<4;i++){//2차원 배열 출력
			for(int j=0;j<4;j++)
				System.out.print(arr[i][j]+"\t");
			System.out.println();
		}

	}

}
