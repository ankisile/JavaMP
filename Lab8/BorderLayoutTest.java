import java.awt.*;
import javax.swing.*;

public class BorderLayoutTest extends JFrame{
	public BorderLayoutTest() {
		setTitle("BorderLayout Practice"); //프레임 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 윈도우 닫으면 프로그램을 종료하도록 설정
		Container c =getContentPane(); //컨텐트 팬을 알아낸다.
		
		c.setLayout(new BorderLayout(5,7)); //컨탠트팬에 BorderLayout 배치관리자 설정. 수평간격 5, 수직간격 7로 설정
		c.add(new JButton("North"), BorderLayout.NORTH); //북쪽에 버튼 삽입
		c.add(new JButton("West"), BorderLayout.WEST); //서쪽에 버튼 삽입
		c.add(new JButton("East"), BorderLayout.EAST); //동쪽에 버튼 삽입
		c.add(new JButton("South"), BorderLayout.SOUTH); //남쪽에 버튼 삽입
		c.add(new JButton("Center"), BorderLayout.CENTER); //가운데에 버튼 삽입

		setSize(400,200); //프레임크기 400x200 설정
		setVisible(true); //화면에 프레임 출력
	}
	public static void main(String[] args) {
		new BorderLayoutTest();

	}

}
