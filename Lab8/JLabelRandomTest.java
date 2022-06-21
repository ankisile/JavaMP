import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JLabelRandomTest extends JFrame{
	public JLabelRandomTest(){
		setTitle("Random Labels"); //프레임 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 윈도우 닫으면 프로그램을 종료하도록 설정
		
		Container c =getContentPane(); //컨텐트 팬을 알아낸다.
		c.setLayout(null); //컨텐트팬의 배치관리자 제거
		
		for(int i=0;i<20;i++) { //20번 반복
			JLabel label =new JLabel(Integer.toString(i)); //라벨 생성. label안에 숫자(인덱스값)를 써줘야함. 인자로 문자열을 전달해야 되기 때문에 Integer.toString(i)를 이용하여 숫자를 문자열로 바꿔줌
			label.setBackground(Color.BLUE); //label의 배경색을 파란색으로 지정
			int x = (int)(Math.random()*200) + 50; //좌표의 x 값. 50~250사이의 랜덤한 값
			int y = (int)(Math.random()*200) + 50; //좌표의 y 값. 50~250사이의 랜덤한 값
			label.setLocation(x,y); //label의 위치 설정
			label.setSize(10,10); //label의 크기 10x10으로 설정
			label.setOpaque(true); //label에 배경색이 보이도록 함
			c.add(label); //label을 컨텐트 팬에 부착
		}
		setSize(300,300); //프레임의 크기 300x300
		setVisible(true); //화면에 프레임 출력
	}
	public static void main(String[] args) {
		new JLabelRandomTest();

	}

}
