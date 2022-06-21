import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CalcFrame extends JFrame{
	private JTextField num1, num2, result;
	private JButton equal;
	public CalcFrame() {
		setTitle("����");//������ Ÿ��Ʋ �ޱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ������ ������ ���α׷��� �����ϵ��� ����
		
		Container c =getContentPane(); //����Ʈ ���� �˾Ƴ���.
		c.setLayout(new FlowLayout()); //����Ʈ �ҿ� FlowLayout ��ġ������ ����
		
		num1= new JTextField(5); //text field ����
		num2= new JTextField(5); //text field ����
		result= new JTextField(5); //text field ����
		equal = new JButton("="); //��ư ����
		equal.addActionListener(new MyActionListener()); //��ư�� ������ ���
		c.add(num1);c.add(new JLabel("X"));c.add(num2);c.add(equal);c.add(result); //����Ʈ �ҿ� ����

		setSize(300,100); //������ ũ�� 300x300
		setVisible(true); //������ ȭ�� ���
	}
	private class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource(); //�̺�Ʈ �ҽ� ������Ʈ�� ���۷����� ���Ϲ޾� ����
			if(obj == equal) { //���۷����� equal�� ������ ���� ��ư�̶�� ��. ���� ��ư�� �����ٴ� ��
				result.setText(Integer.parseInt(num1.getText())*Integer.parseInt(num2.getText())+"");
				//result��� text field�� ���� num1*num2 �Ѱ����� �ٲ���. num1��num2�� ���� �޾ƿö� ���ڿ��� �޾ƿ� ���� ������ Warraper ��ü �̿��Ͽ� ���ڿ� ���ڷ� �ٲ���.
				//setText�� �Ҷ� ���ڿ��� ��ϵǾ�� �Ǳ� ������ ���ڳ��� ����� ""�� �ٿ��� ���ڿ��� �������
			}
		}
		
	}
	public static void main(String[] args) {
		new CalcFrame();

	}

}
