import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClickPracticeFrame extends JFrame{
	private JLabel la = new JLabel("C"); //�� ����

	public ClickPracticeFrame() {
		setTitle("Ŭ�� ������ �������α׷�"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ������ ������ ���α׷��� �����ϵ��� ����

		Container c =getContentPane(); //����Ʈ ���� �˾Ƴ���.
		c.setLayout(null); //��ġ������ ����
		
		la.setSize(50,50); //���� ������ 50x50���� ����
		la.setLocation(100,100); //���� ��ġ (100,100)���� ����
		
		la.addMouseListener(new MyMouseAdapter()); //�󺧿� ������ ���
		c.add(la); //������Ʈ�� �� ����
		
		
		setSize(500, 500); //������ũ�� 500x500
		setVisible(true); //������ ȭ�� ���
	}
	private class MyMouseAdapter extends MouseAdapter{ //MouseAdapter ��ӹ޾� ������ ����

		@Override
		public void mouseClicked(MouseEvent e) { //Ŭ���� ���
			int x = (int)(Math.random()*450); //x��ǥ�� random��
			int y = (int)(Math.random()*400); //y��ǥ�� random��
			//���� �г��� ũ��� ������ũ�⺸�� �۱� ������ x, y�� �������� ������ 500���� �۰� ������־���.
			la.setLocation(x,y); //���� ��ġ x,y�� �ٲ���.
		}
		
	}
	public static void main(String[] args) {
		new ClickPracticeFrame();

	}

}
