import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GuiTest extends JFrame{

	private JTextField arr [] = new JTextField [4];
	private JButton confirm, cancel;
	
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
		for(int i=0;i<arr.length;i++) { 
			arr[i] = new JTextField(20); //text field ����
			p2.add(arr[i]); //�гο� text field ����. 
		}
		c.add(p2, BorderLayout.CENTER); //����Ʈ �ҿ� p2 �г��� �߾ӿ� ����
		
		MyActionListener m1 = new MyActionListener();  //������ ��ü ����
		JPanel p3= new JPanel(); //�г� ����
		JButton confirm = new JButton("Ȯ��"); //��ư ����
		confirm.addActionListener(m1); //������ ���
		JButton cancel = new JButton("���"); //��ư ����
		cancel.addActionListener(m1); //������ ���
		p3.add(confirm); p3.add(cancel); //�гο� ��ư ���� 
		c.add(p3, BorderLayout.SOUTH); //����Ʈ �ҿ� p3 �г��� ���ʿ� ����
		
		setSize(300,200); //������ ũ�� 300x200
		setVisible(true); //������ ȭ�� ���
	}
	private class MyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource(); //Ŭ���� ��ư �˾Ƴ���
			if(b.getText().equals("Ȯ��")) { //��ư�� ���ڿ��� "Ȯ��"���� ��
				for(int i=0;i<arr.length;i++) {
					System.out.print(arr[i].getText()+"\t"); //getText�� ���� text field�� ���ڿ��� �޾Ƴ��� ���
				}
				System.out.println();
			}
			else if(b.getText().equals("���")) { //��ư�� ���ڿ��� "���"���� ��
				for(int i=0;i<arr.length;i++)
					arr[i].setText("");	//setText�� ���� text field�� ���� ���ڿ��� �ٲ���
			}	
		}
	}
	
	public static void main(String[] args) {
		new GuiTest();
	}

}
