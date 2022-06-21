import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseDraggingFrame extends JFrame{
	Container c =getContentPane(); //컨텐트 팬을 알아낸다.

	public MouseDraggingFrame() {
		setTitle("드래깅하는동안 YELLOW"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 윈도우 닫으면 프로그램을 종료하도록 설정
		
		c.addMouseMotionListener(new MyMouseListener()); //컨텐트 팬에 Mouse Motion Listener 등록
		c.addMouseListener(new MyMouseListener()); //컨텐트 팬에 Mouse Listener 등록
		
		c.setBackground(Color.GREEN); //컨텐트 팬 배경색 초록색으로 설정
		setSize(300, 200); //프레임크기 300x200
		setVisible(true); //프레임 화면 출력
	}
	private class MyMouseListener implements MouseListener,MouseMotionListener{ //MouseListener와 MouseMotionListener를 모두 가진 리스너 작성

		@Override
		public void mouseDragged(MouseEvent e) { //마우스가 드래그 될때
			c.setBackground(Color.YELLOW);	//컨텐트 팬의 배경색 노란색으로 변경
		}

		@Override
		public void mouseReleased(MouseEvent e) { //마우스가 때질때 
			c.setBackground(Color.GREEN);	//컨텐트 팬의 배경색 초록색으로 변경
			
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}


		
	}
	public static void main(String[] args) {
		new MouseDraggingFrame();
	}

}
