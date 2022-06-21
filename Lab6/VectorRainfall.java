import java.util.Scanner;
import java.util.Vector;

public class VectorRainfall {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //객체 생성
		Vector <Integer>v= new Vector<Integer>(); //정수값만 다루는 벡터 생성
		
		while(true) { //무한 루프
			System.out.print("강수량 입력 (0 입력시 종료)>> ");
			int n = scan.nextInt(); //값 받아서 변수에 저장
			if(n==0) break; //n==0이면 루프 빠져나옴
			v.add(n); //벡터에 n 삽입
			int sum=0; //합을 나타내는 변수
			for(int i=0;i<v.size();i++) { //i=0부터 i=v.size()-1까지
				System.out.print(v.get(i)+" "); //인덱스 i의 요소를 받아와서 출력
				sum=sum+v.get(i); //인덱스 i의 요소를 받아와서 sum에 더해서 저장
			}
			System.out.println(); //한 줄 띄기
			System.out.println("현재 평균 "+sum/v.size()); //sum을 벡터가 포함하는 요소의 개수로 나눠주고 출력	
		}
		scan.close();
	}

}
