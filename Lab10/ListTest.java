import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListTest extends JFrame{
	JTextField tfInput, tfOutput;
	JButton btnRevise, btnDelete;
	Vector<String> v = new Vector<String>(); //���� ����
	JList<String> strList;
	int index; //��Ͽ��� ���õ� ���Ұ� ���° �������� �޾ƿ��� ����
	
	public ListTest() {
		setTitle("����Ʈ �׽�Ʈ"); //������ Ÿ��Ʋ �ޱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ������ ������ ���α׷��� �����ϵ��� ����
		
		Container c =getContentPane(); //����Ʈ ���� �˾Ƴ���.
		c.setLayout(new BorderLayout()); //����Ʈ�ҿ� BorderLayout ��ġ������ ����. 
		
		MyListener ml= new MyListener(); //������ ��ü ����
		
		tfInput = new JTextField(); //text field ����
		tfInput.addActionListener(ml); //text field�� ������ ���
		
		strList = new JList<String>(v); //���ڿ� ����Ʈ ����
		strList.addListSelectionListener(new ListListener()); //����Ʈ�� ������ ���
		
		JPanel down = new JPanel(); //�г� ����
		down.setLayout(new FlowLayout()); //�гο� FlowLayout ��ġ������ ����
		tfOutput= new JTextField(10); //���� ������ 10ĭ�� textfield ����

		btnRevise = new JButton("����"); //��ư ����
		btnRevise.addActionListener(ml); //��ư�� ������ ���

		btnDelete = new JButton("����"); //��ư ����
		btnDelete.addActionListener(ml);//��ư�� ������ ���

		down.add(tfOutput);down.add(btnRevise);down.add(btnDelete);//�гο� ����
		
		c.add(tfInput, BorderLayout.NORTH);
		c.add(new JScrollPane(strList), BorderLayout.CENTER); //strList�� ��ũ���ҿ� ����
		c.add(down, BorderLayout.SOUTH);
		//����Ʈ �ҿ� ����
		
		setSize(300,250); //������ ũ�� 300x250
		setVisible(true); //������ ȭ�� ���
	}
	class MyListener implements ActionListener{ //text field�� ���� �Է��ϰų� ��ư�� �������� �߻��ϴ� �̺�Ʈ ����

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource(); //�̺�Ʈ �ҽ� ������Ʈ�� ���۷����� ���Ϲ޾� ����
			if(obj==tfInput) { //���۷����� tfInput�̸�(tfInput�� ���� �Է�)
				v.add(tfInput.getText()); //���Ϳ� tfInput���� ���� ���� �����ͼ� ����
				tfInput.setText(""); //�ؽ�Ʈ �ʵ忡 �Էµ� ���������
			}
			if(obj==btnRevise) { //���۷����� btnRevise��(���� ��ư ����)
				v.set(index, tfOutput.getText()); //tfOutput���� ���� �޾ƿͼ� ���Ϳ� index�� �ش��ϴ� ���� ���� �ٲ���
				tfOutput.setText(""); //�ؽ�Ʈ �ʵ忡 �Էµ� ���������
			}
			if(obj==btnDelete) { //���۷����� btnDelete��(���� ��ư ����)
				v.remove(index); //���Ϳ��� index�� �ش��ϴ� ���� ���� ����
				tfOutput.setText(""); //�ؽ�Ʈ �ʵ忡 �Էµ� ���������
			}
			strList.setListData(v); //���Ϳ� �Էµ� ��� �̸����� ����Ʈ ���� �����
		}
	}
	class ListListener implements ListSelectionListener{ 

		@Override
		public void valueChanged(ListSelectionEvent e) {
			String name = (String)strList.getSelectedValue(); //��Ͽ��� ���õ� ���� �޾ƿͼ� name�� ����
			tfOutput.setText(name); //tfOutput�� �ؽ�Ʈ �ʵ带 name���� �ٲ���
			index=strList.getSelectedIndex(); //��Ͽ��� ���õ� index�� �޾ƿͼ� index�� ����
		}
		
	}
	
	public static void main(String[] args) {
		new ListTest();
	}

}
