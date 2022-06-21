class Dice{
	private int value; //주사위 면이 필드. value가 주사위 면을 나타냄
	public Dice() { //생성자. value값 0으로 초기화
		value = 0;
	}
	void roll() { 
		value = (int)(Math.random()*6)+1; //랜덤함수를 사용하여 1~6사이의 값을 저장
	}
	int getValue() {
		return value; //주사위 변의 값을 반환
	}
}
public class DiceTest {

	public static void main(String[] args) {
		Dice dice1=new Dice();
		Dice dice2=new Dice(); //주사위 2개 객체 생성
		int count = 0; //주사위 굴린 횟수를 세는 변수 선언 및 초기화
		do {
			dice1.roll(); 
			dice2.roll(); //주사위 2개를 각각 굴리는 메소드 호출
			System.out.println("주사위1= "+dice1.getValue()+" 주사위2= "+dice2.getValue());// 실행결과와 같이 주사위 각 면의 값을 getValue()로 받아와서 출력
			count++; //실행횟수 증가
		}while(dice1.getValue()+dice2.getValue()!=2); //주사위 각 면의 합이 2가 아닐동안 계속 반복
		System.out.println("(1,1)이 나오는데 걸린 횟수 = "+count); //(1,1)이 나올때까지의 횟수 출력
	}

}
