import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StoryTest extends JFrame{
	public StoryTest() {
		setTitle("SM Story"); //프레임 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 윈도우 닫으면 프로그램을 종료하도록 설정
		
		Container c =getContentPane();  //컨텐트 팬을 알아낸다.
		c.setLayout(null); //컨텐트팬의 배치관리자 제거
		
		JLabel label1 = new JLabel("SM Story"); //라벨 생성
		label1.setLocation(15, 15); //label1의 위치를 (15,15)로 설정
		label1.setSize(80, 20); //label1의 크기를 80x20으로 설정
		c.add(label1); //label1을 컨텐트 팬에 부착
		
		JLabel label2 = new JLabel("가을은"); //라벨 생성 
		label2.setLocation(75, 45); //label2의 위치를 (75,45)로 설정
		label2.setSize(50, 20); //label2의 크기를 50x20으로 설정
		c.add(label2); //label2를 컨텐트 팬에 부착
		
		JTextField text= new JTextField(""); //text field 생성
		text.setLocation(135,75); //text의 위치를 (135,75)로 설정
		text.setSize(50, 20); //text의 크기를 50x20으로 설정
		c.add(text); //text를 컨텐트 팬에 부착
		
		JLabel label3 = new JLabel("이다"); //라벨 생성
		label3.setLocation(195, 105); //label3의 위치를 (195, 105)로 설정
		label3.setSize(50, 20); //label3의 크기를 50x20으로 설정
		c.add(label3); //label3를 컨텐트 팬에 부착
		
		setSize(300,200); //프레임 크기 300x200
		setVisible(true); //프레임 화면 출력
		
	}
	public static void main(String[] args) {
		new StoryTest();

	}

}
