import java.util.Scanner;
import java.util.Vector;

public class VectorTest {
	public static void printVector(Vector<Integer> v) { //컬렉션을 매개변수로 받는 메소드 선언
		System.out.print("[");
		for(int i=0;i<v.size()-1;i++) { //i=0부터 i가 v.size()-2까지의 인덱스 i요소 출력
			System.out.print(v.get(i)+", ");
		}
		System.out.println(v.get(v.size()-1)+"]"); //인덱스 i=v.size()-1요소 출력
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //스캐너 객체 생성
		
		Vector <Integer>v = new Vector<Integer>(); //정수값만 다루는 벡터 생성
		System.out.print("정수(-1이 입력될 때까지)>> ");
		while(true) { 
			int num= scan.nextInt(); //값 입력받아 변수에 저장
			if(num==-1) break; //num이 -1이면 무한 루프 빠져나감
			v.add(num); //벡터에 값 삽입
		}
		System.out.print("삭제전 :");
		printVector(v); //printVector()메소드 호출
		
		int max=0; //가장 큰 값을 나타내는 index을 저장하는 max변수 선언. 0으로 초기화
		for(int i=0;i<v.size();i++) { //i는 0부터 i는 v.size()(벡터가 포함하는 요수 개수)전까지 다음을 반복
			if(v.get(max)<v.get(i)) { //인덱스 i번째 정수와 비교해서 i번째 정수가 크다면
				max=i; //max에 i 저장
			}
		}
		System.out.println("가장 큰 수 "+v.get(max)+" 삭제");
		v.remove(max);  //벡터에서 인덱스 max의 요소 삭제
		printVector(v); //printVector()메소드 호출
		
		int min=0; //가장 작은 값을 나타내는 index을 저장하는 min변수 선언. 0으로 초기화
		for(int i=0;i<v.size();i++) { //i는 0부터 i는 v.size()(벡터가 포함하는 요수 개수)전까지 다음을 반복
			if(v.get(min)>v.get(i)) { //인덱스 i번째 정수와 비교해서 i번째 정수가 작다면
				min=i; //min에 i 저장
			}
		}
		System.out.println("가장 작은 수 "+v.get(min)+" 삭제");
		v.remove(min); //벡터에서 인덱스 min의 요소 삭제
		printVector(v);	//printVector()메소드 호출	
		
		scan.close();
	}

}
