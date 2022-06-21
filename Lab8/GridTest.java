import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GridTest extends JFrame{

	public GridTest() {
		setTitle("Grid TEST"); //프레임 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 윈도우 닫으면 프로그램을 종료하도록 설정
		
		Container c =getContentPane(); //컨텐트 팬을 알아낸다.
		c.setLayout(new BorderLayout(10, 10)); //컨탠트팬에 BorderLayout 배치관리자 설정. 수평간격 10, 수직간격 10로 설정
		
		JPanel p0 = new JPanel(); //패널 생성
		p0.add(new JLabel("학생 정보 입력")); //패널에 라벨 삽입
		c.add(p0, BorderLayout.NORTH); //p0라는 패널을 컨텐트팬의 북쪽에 부착
		
		JPanel p1= new JPanel(); //패널 생성
		p1.setLayout(new GridLayout(5,4)); //패널에 대한 배치관리자를 5x4의 GridLayout으로 지정. 
		p1.add(new JLabel("이 름")); //패널에 라벨 삽입. 컴포넌트가 왼쪽에서 오른쪽으로 배치되기 때문에 순서대로 삽입
		p1.add(new JLabel("학 번")); //패널에 라벨 삽입
		p1.add(new JLabel("학 과")); //패널에 라벨 삽입
		p1.add(new JLabel("연락처")); //패널에 라벨 삽입
		for(int i=0;i<16;i++) //16번 반복
			p1.add(new JTextField("")); //text field를 패널에 삽입
		c.add(p1, BorderLayout.CENTER); //p1이라는 패널을 컨탠트 팬의 가운데에 부착
		 
		JPanel p2= new JPanel(); //패널 생성
		p2.add(new JButton("추가")); //패널에 버튼 삽입
		p2.add(new JButton("취소")); //패널에 버튼 삽입
		c.add(p2, BorderLayout.SOUTH); //p2라는 패널을 컨탠트 팬의 남쪽에 부착
		
		setSize(400,250); //프레임 크기 400x250
		setVisible(true); //프레임 화면 출력
	}
	public static void main(String[] args) {
		new GridTest();

	}

}
