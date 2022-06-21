import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseDraggingFrame extends JFrame{
	Container c =getContentPane(); //����Ʈ ���� �˾Ƴ���.

	public MouseDraggingFrame() {
		setTitle("�巡���ϴµ��� YELLOW"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ������ ������ ���α׷��� �����ϵ��� ����
		
		c.addMouseMotionListener(new MyMouseListener()); //����Ʈ �ҿ� Mouse Motion Listener ���
		c.addMouseListener(new MyMouseListener()); //����Ʈ �ҿ� Mouse Listener ���
		
		c.setBackground(Color.GREEN); //����Ʈ �� ���� �ʷϻ����� ����
		setSize(300, 200); //������ũ�� 300x200
		setVisible(true); //������ ȭ�� ���
	}
	private class MyMouseListener implements MouseListener,MouseMotionListener{ //MouseListener�� MouseMotionListener�� ��� ���� ������ �ۼ�

		@Override
		public void mouseDragged(MouseEvent e) { //���콺�� �巡�� �ɶ�
			c.setBackground(Color.YELLOW);	//����Ʈ ���� ���� ��������� ����
		}

		@Override
		public void mouseReleased(MouseEvent e) { //���콺�� ������ 
			c.setBackground(Color.GREEN);	//����Ʈ ���� ���� �ʷϻ����� ����
			
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
