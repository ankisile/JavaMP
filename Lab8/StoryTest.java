import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StoryTest extends JFrame{
	public StoryTest() {
		setTitle("SM Story"); //������ Ÿ��Ʋ �ޱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ������ ������ ���α׷��� �����ϵ��� ����
		
		Container c =getContentPane();  //����Ʈ ���� �˾Ƴ���.
		c.setLayout(null); //����Ʈ���� ��ġ������ ����
		
		JLabel label1 = new JLabel("SM Story"); //�� ����
		label1.setLocation(15, 15); //label1�� ��ġ�� (15,15)�� ����
		label1.setSize(80, 20); //label1�� ũ�⸦ 80x20���� ����
		c.add(label1); //label1�� ����Ʈ �ҿ� ����
		
		JLabel label2 = new JLabel("������"); //�� ���� 
		label2.setLocation(75, 45); //label2�� ��ġ�� (75,45)�� ����
		label2.setSize(50, 20); //label2�� ũ�⸦ 50x20���� ����
		c.add(label2); //label2�� ����Ʈ �ҿ� ����
		
		JTextField text= new JTextField(""); //text field ����
		text.setLocation(135,75); //text�� ��ġ�� (135,75)�� ����
		text.setSize(50, 20); //text�� ũ�⸦ 50x20���� ����
		c.add(text); //text�� ����Ʈ �ҿ� ����
		
		JLabel label3 = new JLabel("�̴�"); //�� ����
		label3.setLocation(195, 105); //label3�� ��ġ�� (195, 105)�� ����
		label3.setSize(50, 20); //label3�� ũ�⸦ 50x20���� ����
		c.add(label3); //label3�� ����Ʈ �ҿ� ����
		
		setSize(300,200); //������ ũ�� 300x200
		setVisible(true); //������ ȭ�� ���
		
	}
	public static void main(String[] args) {
		new StoryTest();

	}

}
