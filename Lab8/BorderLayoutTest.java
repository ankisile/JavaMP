import java.awt.*;
import javax.swing.*;

public class BorderLayoutTest extends JFrame{
	public BorderLayoutTest() {
		setTitle("BorderLayout Practice"); //������ Ÿ��Ʋ �ޱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ������ ������ ���α׷��� �����ϵ��� ����
		Container c =getContentPane(); //����Ʈ ���� �˾Ƴ���.
		
		c.setLayout(new BorderLayout(5,7)); //����Ʈ�ҿ� BorderLayout ��ġ������ ����. ���򰣰� 5, �������� 7�� ����
		c.add(new JButton("North"), BorderLayout.NORTH); //���ʿ� ��ư ����
		c.add(new JButton("West"), BorderLayout.WEST); //���ʿ� ��ư ����
		c.add(new JButton("East"), BorderLayout.EAST); //���ʿ� ��ư ����
		c.add(new JButton("South"), BorderLayout.SOUTH); //���ʿ� ��ư ����
		c.add(new JButton("Center"), BorderLayout.CENTER); //����� ��ư ����

		setSize(400,200); //������ũ�� 400x200 ����
		setVisible(true); //ȭ�鿡 ������ ���
	}
	public static void main(String[] args) {
		new BorderLayoutTest();

	}

}
