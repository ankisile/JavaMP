import java.awt.*;
import javax.swing.*;

public class GuiTest extends JFrame{
	public GuiTest() {
		setTitle("GUI TEST"); //프레임 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 윈도우 닫으면 프로그램을 종료하도록 설정
		
		Container c =getContentPane(); //컨텐트 팬을 알아낸다.
		c.setLayout(new BorderLayout(10, 10)); //컨탠트팬에 BorderLayout 배치관리자 설정. 수평간격 10, 수직간격 10로 설정
		
		JPanel p1= new JPanel(); //패널 생성
		p1.setLayout(new GridLayout(0,1)); //패널에 대한 배치관리자를 GridLayout으로 지정. 열을 1로 고정이고 행은 자동으로 추가되는 만큼 확장됨.
		p1.add(new JLabel("이 름")); //패널에 라벨 삽입
		p1.add(new JLabel("학 번")); //패널에 라벨 삽입
		p1.add(new JLabel("전 공")); //패널에 라벨 삽입
		p1.add(new JLabel("연락처")); //패널에 라벨 삽입
		c.add(p1, BorderLayout.WEST); //컨탠트팬에 p1 패널을 서쪽에 부착
		
		JPanel p2= new JPanel(); //패널 생성
		p2.setLayout(new GridLayout(0,1)); //패널에 대한 배치관리자를 GridLayout으로 지정. 열을 1로 고정이고 행은 자동으로 추가되는 만큼 확장됨.
		p2.add(new JTextField(20)); //패널에 text field 삽입. text field 크기 20으로 설정
		p2.add(new JTextField(20)); //패널에 text field 삽입. text field 크기 20으로 설정
		p2.add(new JTextField(20)); //패널에 text field 삽입. text field 크기 20으로 설정
		p2.add(new JTextField(20)); //패널에 text field 삽입. text field 크기 20으로 설정
		c.add(p2, BorderLayout.CENTER); //컨텐트 팬에 p2 패널을 중앙에 부착
		
		JPanel p3= new JPanel(); //패널 생성
		p3.add(new JButton("확인")); //패널에 버튼 삽입
		p3.add(new JButton("취소")); //패널에 버튼 삽입 
		c.add(p3, BorderLayout.SOUTH); //컨텐트 팬에 p3 패널을 남쪽에 부착
		
		setSize(300,200); //프레임 크기 300x200
		setVisible(true); //프레임 화면 출력
	}
	public static void main(String[] args) {
		new GuiTest();
	}

}
