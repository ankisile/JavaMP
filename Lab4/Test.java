
public class Test {

	public static void main(String[] args) {
		Buyer m = new Buyer(40000); //초기 자금 40000원을 가진 Buyer 생성
		m.buy((new Food("비빔밥", 5000)), 3); //Food 객체 생성 하고 buy메소드 호출
		m.buy((new Food("라면", 3000)), 2); //Food 객체 생성 하고 buy메소드 호출
		m.buy((new Book("Java Programming", 7000,"자바")), 1); //Book 객체 생성 하고 buy메소드 호출
		m.buy((new Movie("부산행", 8000, "연상호")), 1); //Movie 객체 생성 하고 buy메소드 호출
		m.buy((new Food("김밥", 2000)), 3); //Food 객체 생성 하고 buy메소드 호출

	}

}
