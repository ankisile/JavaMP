
public class Buyer {
	private int money; //멤버변수 선언
	public Buyer(int money) { //money를 매개변수로 받아서 멤버변수 설정
		this.money = money;
	}
	public void buy(Item t, int n) {
		System.out.println(t.toString()+"=>"+n+"개 구매"); 
		if(money>=t.getPrice()*n) { //money가 t.getPrice()*n 이상이면 구매 가능 하므로
			money = money - t.getPrice()*n; //money에서 t.getPrice()*n 차감
			System.out.println("구매 완료 후 잔액 : "+money); //잔액 출력
		}
		else { //구매가능하지 않으면
			System.out.println("잔액 부족: "+money); //잔액 부족 출력 후 잔액 출력
		}
	}

}
