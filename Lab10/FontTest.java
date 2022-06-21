import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

public class FontTest extends JFrame{
	JRadioButton rbfont1, rbfont2, rbfont3;
	JCheckBox ckbold, ckitalic;
	JTextField tfsize, tftext;
	JLabel result;

	public FontTest() {
		setTitle("Font ����"); //������ Ÿ��Ʋ �ޱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ������ ������ ���α׷��� �����ϵ��� ����
		
		Container c =getContentPane(); //����Ʈ ���� �˾Ƴ���.
		c.setLayout(new BorderLayout(10, 10)); //����Ʈ�ҿ� BorderLayout ��ġ������ ����. ���򰣰� 10, �������� 10�� ����
	
		JPanel left = new JPanel(); //�г� ����
		left.setLayout(new GridLayout(0,1,10,10)); //�гο� GridLayout ��ġ������ ����.���� 1�� �����̰� ���� �ڵ����� �߰��Ǵ� ��ŭ Ȯ���. ����, �������� 10
		//�гο� ����
		left.add(new JLabel("Font ����")); 
		left.add(new JLabel("Style ����"));
		left.add(new JLabel("Size ����"));
		left.add(new JLabel("Text ����"));

		
		MyRadioListener mrl = new MyRadioListener(); //������ư�� ���� ������ ��ü ����
		MyCheckListener mcl = new MyCheckListener(); //üũ�ڽ��� ���� ������ ��ü ����

		JPanel center = new JPanel(); //�г� ����
		center.setLayout(new GridLayout(0,1,10,10)); //�гο� GridLayout ��ġ������ ����.���� 1�� �����̰� ���� �ڵ����� �߰��Ǵ� ��ŭ Ȯ���. ����, �������� 10
		
		JPanel panelFont = new JPanel(); //�г� ����(��Ʈ)
		ButtonGroup font = new ButtonGroup(); //��ư �׷� ��ü ����
		rbfont1 = new JRadioButton("����"); //���� ��ư ����
		rbfont1.addItemListener(mrl); //������ư�� ������ ���
		rbfont2 = new JRadioButton("����", true); //���� ��ư ����. �ʱ�� ���õǰ� ��
		rbfont2.addItemListener(mrl); //������ư�� ������ ���
		rbfont3 = new JRadioButton("�ü�"); //���� ��ư ����
		rbfont3.addItemListener(mrl); //������ư�� ������ ���

		font.add(rbfont1);font.add(rbfont2);font.add(rbfont3); //��ư �׷쿡 ����
		panelFont.add(rbfont1);	panelFont.add(rbfont2);	panelFont.add(rbfont3); //�гο� ����

		JPanel panelStyle = new JPanel(); //�г� ����(��Ÿ��)
		ckbold = new JCheckBox("BOLD"); //üũ�ڽ� ����
		ckbold.addItemListener(mcl); //üũ�ڽ��� ������ ���
		ckitalic = new JCheckBox("ITALIC"); //üũ�ڽ� ����
		ckitalic.addItemListener(mcl); //üũ�ڽ��� ������ ���
		panelStyle.add(ckbold);	panelStyle.add(ckitalic); //�гο� ����

		tfsize= new JTextField("20"); //�ؽ�Ʈ�ʵ� ����. �ʱⰪ 20
		tfsize.addActionListener(new ActionListener(){//�͸�Ŭ������ �ؽ�Ʈ�ʵ忡 ������ ���
			public void actionPerformed(ActionEvent e) {
				Font f = result.getFont(); //font�� �޾ƿ�
				result.setFont(new Font(f.getFontName(), f.getStyle(), Integer.parseInt(tfsize.getText()))); //�۾��� size�� �ٲ���
			}
		});

		tftext = new JTextField("Hello Java"); //�ؽ�Ʈ�ʵ� ����. �ʱⰪ "Hello Java"
		tftext.addActionListener(new ActionListener(){ //�͸�Ŭ������ �ؽ�Ʈ �ʵ忡 ������ ���
			public void actionPerformed(ActionEvent e) {
				result.setText(tftext.getText()); //�Է��� text�� �޾ƿͼ� ����� �����ִ� Label�� set��
			}
		});

		center.add(panelFont);	center.add(panelStyle);	center.add(tfsize);	center.add(tftext); //�г� ����

		
		JPanel bottom = new JPanel(); //�г� ����
		Border resultBorder = BorderFactory.createTitledBorder("Font ���� ���"); //������ �ٿ��� ��� ����
		bottom.setBorder(resultBorder); //��� ���
		result = new JLabel(); //�� ����. ������� ������
 		result.setText(tftext.getText()); //�Է��� text�� �޾ƿͼ� ����� �����ִ� Label�� set��
		result.setFont(new Font("����", Font.PLAIN, Integer.parseInt(tfsize.getText()))); //�ʱⰪ�� �޾ƿͼ� result(���)�� �۾� ����
		bottom.add(result); //�гο� ����
		
		c.add(left, BorderLayout.WEST); c.add(center, BorderLayout.CENTER); c.add(bottom, BorderLayout.SOUTH);//����Ʈ�ҿ� ����
		
		setSize(300,250); //������ ũ�� 300x250
		setVisible(true); //������ ȭ�� ���
	}
	
	class MyRadioListener implements ItemListener{ //���� ��ư�� ���� ������
		@Override
		public void itemStateChanged(ItemEvent e) {
			Font f= result.getFont(); //font�޾ƿ�
			
			if(rbfont1.isSelected()) { //������ ���õǾ�����
				result.setFont(new Font("����",f.getStyle(), f.getSize())); //�������� ��Ʈ�ٲ���	
			}
			else if(rbfont2.isSelected()) { //������ ���õǾ�����
				result.setFont(new Font("����",f.getStyle(),f.getSize())); //�������� ��Ʈ�ٲ���	
			}
			else if(rbfont3.isSelected()) { //�ü��� ���õǾ�����
				result.setFont(new Font("�ü�",f.getStyle(),f.getSize()));	//�ü��� ��Ʈ�ٲ���
			}
		
		}
		
	}
	class MyCheckListener implements ItemListener{ //üũ�ڽ��� ���� ������
		@Override
		public void itemStateChanged(ItemEvent e) {
			Font f= result.getFont(); //font�� �޾ƿ�
			
			if(ckbold.isSelected() &&ckitalic.isSelected()) { //BOLD�� ITALIC�� üũ�Ǿ�������
				result.setFont(new Font(f.getFontName(),Font.BOLD+Font.ITALIC, f.getSize())); //BOLD�� ITALIC���� ��Ʈ ��Ÿ�� �ٲ���
			}
			else if(ckbold.isSelected()) { //BOLD�� üũ�Ǿ�������
				result.setFont(new Font(f.getFontName(),Font.BOLD, f.getSize())); //BOLD�� ��Ÿ�� �ٲ���
			}
			else if(ckitalic.isSelected()){ //ITALIC�� üũ�Ǿ�������
				result.setFont(new Font(f.getFontName(),Font.ITALIC, f.getSize())); //ITALIC���� ��Ÿ�� �ٲ���
			}
			else { //üũ�� ������
				result.setFont(new Font(f.getFontName(),Font.PLAIN, f.getSize())); //�⺻ ��Ÿ�Ϸ� �ٲ���
			}
		}	
	}
	
	
	public static void main(String[] args) {
		new FontTest();
	}

}
