import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.BadLocationException;

public class SliderTest extends JFrame{
	JTextArea ta;
	JSlider sl;
	public SliderTest() {
		setTitle("TextArea Practice Frame"); //������ Ÿ��Ʋ �ޱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ������ ������ ���α׷��� �����ϵ��� ����
		
		Container c =getContentPane(); //����Ʈ ���� �˾Ƴ���.
		c.setLayout(new BorderLayout(10, 10)); //����Ʈ�ҿ� BorderLayout ��ġ������ ����.
		
		ta=new JTextArea(5, 10); //5�� 10ĭ ¥�� text area ����
		ta.addKeyListener(new MyKeyListener()); //text area�� ������ ���
		sl=new JSlider(JSlider.HORIZONTAL, 0, 100, 0); //�����̴� ����. �����̰� 0~100���� ������ ������ 0�� �ʱⰪ
		sl.setPaintLabels(true); //�����̴��� ���� ����
		sl.setPaintTicks(true); //�����̴� ������ ����
		sl.setPaintTrack(true); //�����̴� Ʈ���� ����
		sl.setMinorTickSpacing(5); //�����̴� ���� ���� ���� 5
		sl.setMajorTickSpacing(20); //�����̴� ū ���� ���� 20
		sl.addChangeListener(new MyChangeListener()); //�����̴��� ������ ���
		c.add(new JScrollPane(ta), BorderLayout.CENTER); //text area�� ��ũ���ҿ� ����
		c.add(sl, BorderLayout.SOUTH); //������Ʈ �ҿ� ����
		
		setSize(300,200); //������ ũ�� 300x200
		setVisible(true); //������ ȭ�� ���
	}
	class MyChangeListener implements ChangeListener{ //�����̴��� �ش��ϴ� ������
		@Override
		public void stateChanged(ChangeEvent e) {
			if(ta.getText().length()>sl.getValue()) { //text area�� �Էµ� ���̰� sl�� ��Ÿ���� ������ ũ�ٸ�
				try {
					ta.setText(ta.getText(0,sl.getValue())); //text area���� 0~sl�� ��Ÿ���� ������ �޾ƿͼ� �ٽ� set��
				} catch (BadLocationException e1) {	}
			}
			else { //text area�� �Էµ� ���̰� s1�� ��Ÿ���� ������ �۴ٸ�
				sl.setValue(ta.getText().length()); //�����̴��� ���� text area�� �Էµ� ���̷� �ٲ���
			}
		}
		
	}
	class MyKeyListener extends KeyAdapter{//text area�� �ش��ϴ� ������
		public void keyTyped(KeyEvent e) {
			int size = ta.getText().length(); //text area�� �Էµ� ���̸� �޾ƿͼ� ������ ����
			if(size>=100) { //size�� 100�̻��̸�
				try {
					ta.setText(ta.getText(0, 100)); //text area���� 0~100�������� �޾ƿͼ� �ٽ� set��
				} catch (BadLocationException e1) {	}
			}
			sl.setValue(size); //�����̴��� ���� size�� ����
		}
	}
	public static void main(String[] args) {
		new SliderTest();
	}

}
