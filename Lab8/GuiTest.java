import java.awt.*;
import javax.swing.*;

public class GuiTest extends JFrame{
	public GuiTest() {
		setTitle("GUI TEST"); //������ Ÿ��Ʋ �ޱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ������ ������ ���α׷��� �����ϵ��� ����
		
		Container c =getContentPane(); //����Ʈ ���� �˾Ƴ���.
		c.setLayout(new BorderLayout(10, 10)); //����Ʈ�ҿ� BorderLayout ��ġ������ ����. ���򰣰� 10, �������� 10�� ����
		
		JPanel p1= new JPanel(); //�г� ����
		p1.setLayout(new GridLayout(0,1)); //�гο� ���� ��ġ�����ڸ� GridLayout���� ����. ���� 1�� �����̰� ���� �ڵ����� �߰��Ǵ� ��ŭ Ȯ���.
		p1.add(new JLabel("�� ��")); //�гο� �� ����
		p1.add(new JLabel("�� ��")); //�гο� �� ����
		p1.add(new JLabel("�� ��")); //�гο� �� ����
		p1.add(new JLabel("����ó")); //�гο� �� ����
		c.add(p1, BorderLayout.WEST); //����Ʈ�ҿ� p1 �г��� ���ʿ� ����
		
		JPanel p2= new JPanel(); //�г� ����
		p2.setLayout(new GridLayout(0,1)); //�гο� ���� ��ġ�����ڸ� GridLayout���� ����. ���� 1�� �����̰� ���� �ڵ����� �߰��Ǵ� ��ŭ Ȯ���.
		p2.add(new JTextField(20)); //�гο� text field ����. text field ũ�� 20���� ����
		p2.add(new JTextField(20)); //�гο� text field ����. text field ũ�� 20���� ����
		p2.add(new JTextField(20)); //�гο� text field ����. text field ũ�� 20���� ����
		p2.add(new JTextField(20)); //�гο� text field ����. text field ũ�� 20���� ����
		c.add(p2, BorderLayout.CENTER); //����Ʈ �ҿ� p2 �г��� �߾ӿ� ����
		
		JPanel p3= new JPanel(); //�г� ����
		p3.add(new JButton("Ȯ��")); //�гο� ��ư ����
		p3.add(new JButton("���")); //�гο� ��ư ���� 
		c.add(p3, BorderLayout.SOUTH); //����Ʈ �ҿ� p3 �г��� ���ʿ� ����
		
		setSize(300,200); //������ ũ�� 300x200
		setVisible(true); //������ ȭ�� ���
	}
	public static void main(String[] args) {
		new GuiTest();
	}

}
