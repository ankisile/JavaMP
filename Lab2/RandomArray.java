import java.util.Scanner;

public class RandomArray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //스캐너 객체 생성
		System.out.print("정수 몇개? "); //사용자로부터 입력을 받기 위한 출력문
		int n = scan.nextInt(); // 스캐너를 통한 입력값 저장
		
		int arr[] = new int[n]; //입력받은 값의 크기만큼 정수 배열 생성
		for(int i=0;i<arr.length;i++) { //배열의 크기만큼 반복하면서
			int r = (int)(Math.random()*100 + 1); // 1~100범위의 랜덤 정수 r 생성
			
			int chk=0; //배열에 중복되는 값이 있는지 확인하는 변수. 있으면 1 아니면 0. 0으로 초기화.
			for(int j=0;j<i;j++) //0부터 i-1까지 확인하면서
				if(r==arr[j]) { //배열에 정수값 r이 있으면
					i--; //중복되는 값이 있으면 i값이 증가하면 안된다. 그러나 바깥 for문에서 이와 상관없이 i값이 증가하므로  이를 방지하기 위해 i값을 1 줄여줌
					chk=1; //chk에 1 저장 후 break를 통해 for문 빠져나오기
					break;
				}
			if(chk==0)  //chk가 0이면 배열에 중복되는 값이 없으므로 배열에 r을 저장
				arr[i]=r;
		}	
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" "); //배열을 화면에 출력
			if(i%10==9) System.out.println(); //각 행에 10개만 출력되도록 만들어줌
		}
		scan.close();
	}
}
