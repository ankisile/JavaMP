import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MoveStringFrame extends JFrame{
	private JLabel la;
	public MoveStringFrame() {
		setTitle("Left Ű�� ���ڿ� �̵�"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ������ ������ ���α׷��� �����ϵ��� ����

		Container c =getContentPane(); //����Ʈ ���� �˾Ƴ���.
		c.setLayout(new FlowLayout()); //����Ʈ �ҿ� FlowLayout ��ġ������ ����
		
		c.addKeyListener(new MyKeyListener()); //����Ʈ �ҿ� ������ ���
		
		la = new JLabel("Love Java"); //�� ����
		c.add(la); //����Ʈ �ҿ� �� ����
		
		setSize(300, 200); //������ũ�� 300x200
		setVisible(true); //������ ȭ�� ���
		
		//����Ʈ ���� Ű �Է¹��� �� �ֵ��� ��Ŀ�� ���� ����
		c.setFocusable(true);
		c.requestFocus();
	}
	private class MyKeyListener extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_LEFT) { //���� ����Ű�� ��������
				String s =la.getText(); //la�� ���ڿ��� �޾Ƽ� s�� ����
				s = s.substring(1)+s.substring(0,1); 
				//substring�� �̿��Ͽ� ���ڿ� �и�. substring(1)�� �̿��Ͽ� �ε��� 1������ ���ڿ��� �и��ϰ� substring(0,1)�� �̿��Ͽ� �ε��� 0�� �ش��ϴ� ���ڿ� �и�.�׸��� ���� ��ħ
				la.setText(s); //setText�� �̿��Ͽ� ���� ���ڿ��� s�� �ٲ���.
			}
			
		}
		
	}
	public static void main(String[] args) {
		new MoveStringFrame();

	}

}
