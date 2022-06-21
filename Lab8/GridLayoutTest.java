import java.awt.*;
import javax.swing.*;

public class GridLayoutTest extends JFrame{
	
	public GridLayoutTest() {
		setTitle("Ten Color Buttons Frame"); //프레임 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //프레임 윈도우 닫으면 프로그램을 종료하도록 설정
		
		GridLayout grid = new GridLayout(1,10); //1x10 격자의 GridLayout 배치관리자 생성
		Container c =getContentPane(); //컨텐트 팬을 알아낸다.
		
		c.setLayout(grid); //grid를 컨텐트팬의 배치관리자로 설정
		
		Color[] col= {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA, Color.GRAY, Color.PINK, Color.LIGHT_GRAY};
		//col이라는 이름의 배열을 설정하여 이 배열안에 색깔을 넣어 초기화
		
		for(int i=0;i<10;i++) { //10번 반복
			JButton b = new JButton(Integer.toString(i)); //버튼 생성. 인자로 문자열을 전달해야 되기 때문에 Integer.toString(i)를 이용하여 숫자를 문자열로 바꿔줌
			b.setBackground(col[i]); //버튼의 배경색을 배열을 이용하여 설정
			b.setOpaque(true);   //배경색을 바꾼것이 화면에 보이도록 설정
			c.add(b); //버튼을 컨텐트팬에 부착
		}
		
		setSize(600,300); //프레임크기 600x300 설정
		setVisible(true); //화면에 프레임 출력
		
	}
	public static void main(String[] args) {
		new GridLayoutTest();

	}

}
