import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MoveStringFrame extends JFrame{
	private JLabel la;
	public MoveStringFrame() {
		setTitle("Left 키로 문자열 이동"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 윈도우 닫으면 프로그램을 종료하도록 설정

		Container c =getContentPane(); //컨텐트 팬을 알아낸다.
		c.setLayout(new FlowLayout()); //컨텐트 팬에 FlowLayout 배치관리자 설정
		
		c.addKeyListener(new MyKeyListener()); //컨텐트 팬에 리스너 등록
		
		la = new JLabel("Love Java"); //라벨 생성
		c.add(la); //컨텐트 팬에 라벨 부착
		
		setSize(300, 200); //프레임크기 300x200
		setVisible(true); //프레임 화면 출력
		
		//컨텐트 팬이 키 입력받을 수 있도록 포커스 강제 지정
		c.setFocusable(true);
		c.requestFocus();
	}
	private class MyKeyListener extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_LEFT) { //왼쪽 방향키가 눌러지면
				String s =la.getText(); //la의 문자열을 받아서 s에 저장
				s = s.substring(1)+s.substring(0,1); 
				//substring을 이용하여 문자열 분리. substring(1)을 이용하여 인덱스 1부터의 문자열을 분리하고 substring(0,1)을 이용하여 인덱스 0에 해당하는 문자열 분리.그리고 둘이 합침
				la.setText(s); //setText를 이용하여 라벨의 문자열을 s로 바꿔줌.
			}
			
		}
		
	}
	public static void main(String[] args) {
		new MoveStringFrame();

	}

}
