
public class Rectangle {
	private int x, y, width, height; //사각형을 구성하는 점과 크기 정보
	
	public Rectangle(int x, int y, int width, int height) {//x, y, width, height 값을 매개변수로 받아 필드를 초기화 하는 생성자
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public int square(){//사각형의 넓이 리턴
		return width*height;
	}
	public void show() {//사각형의 좌표와 넓이를 화면에 출력
		System.out.println("("+x+","+y+")에서 크기가 "+width+"x"+height+"인 사각형");
	}
	public boolean contains(Rectangle r) { //매개변수로 받은 r이 현 사각형 안에 있으면 true 리턴 아니면 false 리턴
		if((r.x>=x)&&(r.y>=y)&&((r.x+r.width)<=(x+width))&&((r.y+r.height)<=(y+height))) {
			return true;
		}
		else
			return false;
	}
	
	public static void main(String[] args) {
		Rectangle r = new Rectangle(2, 2, 8, 7);
		Rectangle s = new Rectangle(5, 5, 6, 6);
		Rectangle t = new Rectangle(1, 1, 10, 10); //Rectangle 객체 생성
		
		r.show(); //show()를 통해 r의 정보 출력
		System.out.println("s의 면적은 "+s.square()); //square()를 통해 s의 사각형의 넓이를 구한후 리턴된값 출력
		if(t.contains(r)) System.out.println("t는 r을 포함합니다."); //r이 t에 포함되면 출력
		if(t.contains(s)) System.out.println("t는 s를 포함합니다."); //s가 t에 포함되면 출력
		

	}

}
