import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseEventFrame extends JFrame{
	private JLabel la;
	public MouseEventFrame() {
		setTitle("마우스 올리기 내리기");//프레임 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 윈도우 닫으면 프로그램을 종료하도록 설정
		
		Container c =getContentPane(); //컨텐트 팬을 알아낸다.
		c.setLayout(new FlowLayout()); //컨텐트 팬에 FlowLayout 배치관리자 설정
		
		la= new JLabel("사랑해"); //라벨 생성. 라벨의 문자열의 초기값이 "사랑해"
		la.addMouseListener(new MouseAdapter() { //라벨에 리스너 등록. 라벨과 관련해서 이벤트가 발생함.익명클래스로 리스너 작성.
			//MouseAdapter 상속 받고 바로 메소드 작성. 동시에 new로 인스턴스 생성
			@Override
			public void mouseEntered(MouseEvent e) { //마우스가 구역안에 들어갔을때. 즉 라벨안에 들어갔을때
				la.setText("Love Java"); //라벨의 글씨가 "Love Java"로 바뀜.
			}

			@Override
			public void mouseExited(MouseEvent e) { //마우스가 구역에서 나왔을때. 라벨 밖으로 나왔을때
				la.setText("사랑해"); //라벨의 글씨가 "사랑해"로 바뀜
			}
		 
		});
		
		c.add(la); //라벨 컴포넌트에 부착
		setSize(300,200); //프레임 크기 300x200
		setVisible(true); //프레임 화면 출력
	}
	public static void main(String[] args) {
		new MouseEventFrame();

	}

}
