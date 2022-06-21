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
		setTitle("Grid TEST"); //������ Ÿ��Ʋ �ޱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ������ ������ ���α׷��� �����ϵ��� ����
		
		Container c =getContentPane(); //����Ʈ ���� �˾Ƴ���.
		c.setLayout(new BorderLayout(10, 10)); //����Ʈ�ҿ� BorderLayout ��ġ������ ����. ���򰣰� 10, �������� 10�� ����
		
		JPanel p0 = new JPanel(); //�г� ����
		p0.add(new JLabel("�л� ���� �Է�")); //�гο� �� ����
		c.add(p0, BorderLayout.NORTH); //p0��� �г��� ����Ʈ���� ���ʿ� ����
		
		JPanel p1= new JPanel(); //�г� ����
		p1.setLayout(new GridLayout(5,4)); //�гο� ���� ��ġ�����ڸ� 5x4�� GridLayout���� ����. 
		p1.add(new JLabel("�� ��")); //�гο� �� ����. ������Ʈ�� ���ʿ��� ���������� ��ġ�Ǳ� ������ ������� ����
		p1.add(new JLabel("�� ��")); //�гο� �� ����
		p1.add(new JLabel("�� ��")); //�гο� �� ����
		p1.add(new JLabel("����ó")); //�гο� �� ����
		for(int i=0;i<16;i++) //16�� �ݺ�
			p1.add(new JTextField("")); //text field�� �гο� ����
		c.add(p1, BorderLayout.CENTER); //p1�̶�� �г��� ����Ʈ ���� ����� ����
		 
		JPanel p2= new JPanel(); //�г� ����
		p2.add(new JButton("�߰�")); //�гο� ��ư ����
		p2.add(new JButton("���")); //�гο� ��ư ����
		c.add(p2, BorderLayout.SOUTH); //p2��� �г��� ����Ʈ ���� ���ʿ� ����
		
		setSize(400,250); //������ ũ�� 400x250
		setVisible(true); //������ ȭ�� ���
	}
	public static void main(String[] args) {
		new GridTest();

	}

}
