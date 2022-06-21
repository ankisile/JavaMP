import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseEventFrame extends JFrame{
	private JLabel la;
	public MouseEventFrame() {
		setTitle("���콺 �ø��� ������");//������ Ÿ��Ʋ �ޱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ������ ������ ���α׷��� �����ϵ��� ����
		
		Container c =getContentPane(); //����Ʈ ���� �˾Ƴ���.
		c.setLayout(new FlowLayout()); //����Ʈ �ҿ� FlowLayout ��ġ������ ����
		
		la= new JLabel("�����"); //�� ����. ���� ���ڿ��� �ʱⰪ�� "�����"
		la.addMouseListener(new MouseAdapter() { //�󺧿� ������ ���. �󺧰� �����ؼ� �̺�Ʈ�� �߻���.�͸�Ŭ������ ������ �ۼ�.
			//MouseAdapter ��� �ް� �ٷ� �޼ҵ� �ۼ�. ���ÿ� new�� �ν��Ͻ� ����
			@Override
			public void mouseEntered(MouseEvent e) { //���콺�� �����ȿ� ������. �� �󺧾ȿ� ������
				la.setText("Love Java"); //���� �۾��� "Love Java"�� �ٲ�.
			}

			@Override
			public void mouseExited(MouseEvent e) { //���콺�� �������� ��������. �� ������ ��������
				la.setText("�����"); //���� �۾��� "�����"�� �ٲ�
			}
		 
		});
		
		c.add(la); //�� ������Ʈ�� ����
		setSize(300,200); //������ ũ�� 300x200
		setVisible(true); //������ ȭ�� ���
	}
	public static void main(String[] args) {
		new MouseEventFrame();

	}

}
