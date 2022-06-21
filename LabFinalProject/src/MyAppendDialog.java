import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.util.*;

class MyAppendDialog extends JDialog{
	JRadioButton rbMovie, rbBook;
	JPanel info = new JPanel(); //�г� ����
	JPanel infoInput= new JPanel();
	Border infoBorder;
	String strMovie [] = {"����","����","���","�帣","���","�����⵵","������","����"};
	String strBook [] = {"����","����","���ǻ�","���ǳ⵵","å�̹���","����"};
	JTextField infoTF [] =new JTextField [3];
	JTextField filepath = new JTextField(10);
	JButton ok = new JButton("OK");
	JButton open = new JButton("�ҷ�����");
	JComboBox <String> genre, rate, year;
	String strGenre [] = {"���","�θེ","�׼�","�̽��͸�","����"};
	String strRate [] = {"��ü","12�� �̻�","15�� �̻�","û�ҳ� ���� �Ұ�"};
	String strYear [] = {"2020","2019","2018","2017","2016","2015","2014","2013","2012","2011","2010"};
	JSlider sl;
	JPanel files = new JPanel();
	JPanel downRight = new JPanel();
	JTextArea infoTA[] = new JTextArea[2];
	MyButtonListener mbl = new MyButtonListener();
	ItemCollections ic;
	
	public MyAppendDialog(JFrame frame, String title) {
	
		super(frame, title,true); //true�� ��� Ÿ���� ���鵵�� ����
		setLayout(new BorderLayout()); //BorderLayout���� ����
		ic = new ItemCollections();
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); //X��ư Ȱ��ȭ X
		
		JPanel up = new JPanel(); //�г� ����(��Ʈ)
		ButtonGroup group = new ButtonGroup(); //��ư �׷� ��ü ����
		//���� ��ư ����
		rbMovie = new JRadioButton("Movie", true);
		rbMovie.addItemListener(new MyRadioListener());
		rbBook = new JRadioButton("Book");
		rbBook.addItemListener(new MyRadioListener());
		group.add(rbMovie); group.add(rbBook);
		up.add(rbMovie);up.add(rbBook);
		
		infoBorder = BorderFactory.createTitledBorder("��ȭ����"); //������ �ٿ��� ��� ����
		info.setBorder(infoBorder); //��� ���
		info.setLayout(new BorderLayout());
		JPanel infoup = new JPanel();
		JPanel infoLeft = new JPanel();
		infoLeft.setLayout(new GridLayout(0,1,15,30));
		for(int i=0;i<strMovie.length;i++) {
			infoLeft.add(new JLabel(strMovie[i]));
		}
		JPanel infoRight = new JPanel();
		infoRight.setLayout(new GridLayout(0,1,15,5));
		for(int i=0;i<infoTF.length;i++) {
			infoTF[i]=new JTextField(20);
			infoRight.add(infoTF[i]);
		}
		//�޺��ڽ� ���
		genre = new JComboBox<String>(strGenre);
		rate = new JComboBox<String>(strRate);
		year = new JComboBox<String>(strYear);
		//�̹��� ���ϰ�� 
		filepath.setEditable(false);
		filepath.setText("");
		open.addActionListener(mbl);
		files.add(filepath); files.add(open);
		//�����̵� ����
		sl=new JSlider(JSlider.HORIZONTAL, 1, 10, 5); //�����̴� ����. �����̰� 1~10 ������ ������ 5 �ʱⰪ
		sl.setPaintLabels(true); //�����̴��� ���� ����
		sl.setPaintTicks(true); //�����̴� ������ ����
		sl.setPaintTrack(true); //�����̴� Ʈ���� ����
		sl.setMajorTickSpacing(1); //�����̴� ū ���� ���� 1
		infoRight.add(genre);infoRight.add(rate);infoRight.add(year);infoRight.add(files);infoRight.add(sl);
		
		infoup.add(infoLeft, BorderLayout.WEST);
		infoup.add(infoRight, BorderLayout.CENTER);

		JPanel infodown = new JPanel();

		JPanel downLeft = new JPanel();
		downLeft.setLayout(new GridLayout(0,1,15,60));
		downLeft.add(new JLabel("�ٰŸ�"));
		downLeft.add(new JLabel("������"));
		//�ؽ�Ʈ ������
		downRight.setLayout(new GridLayout(0,1,15,5));
		for(int i=0;i<infoTA.length;i++) {
			infoTA[i]=new JTextArea(5, 20);
			downRight.add(new JScrollPane(infoTA[i]));
			infoTA[i].setLineWrap(true);
			}
		infodown.add(downLeft, BorderLayout.WEST);
		infodown.add(downRight, BorderLayout.CENTER);
		
		infoInput.add(infoup,BorderLayout.CENTER);
		infoInput.add(infodown, BorderLayout.SOUTH);
		info.add(infoInput,BorderLayout.CENTER);	
		//ok ��ư
		JPanel but = new JPanel();
		ok.addActionListener(mbl);
		but.add(ok);
		info.add(infoInput,BorderLayout.CENTER);info.add(but,BorderLayout.SOUTH);
		
		add(up, BorderLayout.NORTH);add(info, BorderLayout.CENTER);
		setSize(300,750); 
		
	}
	class MyRadioListener implements ItemListener{ //������ ���� ������
		@Override
		public void itemStateChanged(ItemEvent e) {
			infoInput.removeAll();
			infoInput.repaint();
			if(rbMovie.isSelected()) { //��ȭ ����
				infoBorder = BorderFactory.createTitledBorder("��ȭ����"); //������ �ٿ��� ��� ����
				info.setBorder(infoBorder); //��� ���
				JPanel infoup = new JPanel();
				JPanel infoLeft = new JPanel();
				infoLeft.setLayout(new GridLayout(0,1,15,30));
				for(int i=0;i<strMovie.length;i++) {
					infoLeft.add(new JLabel(strMovie[i]));
				}
				JPanel infoRight = new JPanel();
				infoRight.setLayout(new GridLayout(0,1,15,5));
				for(int i=0;i<infoTF.length;i++) {
					infoTF[i]=new JTextField(20);
					infoRight.add(infoTF[i]);
				}
			
				filepath.setText(""); //�ؽ�Ʈ �ʵ� �ʱ�ȭ
			
				sl.setValue(5); //�����̵尪 �ʱ�ȭ
			
				genre.setSelectedIndex(0);rate.setSelectedIndex(0);year.setSelectedIndex(0); //�޺��ڽ� �� �ʱ�ȭ
				infoRight.add(genre);infoRight.add(rate);infoRight.add(year);infoRight.add(files);infoRight.add(sl);
				
				infoup.add(infoLeft, BorderLayout.WEST);
				infoup.add(infoRight, BorderLayout.CENTER);

				JPanel infodown = new JPanel();

				JPanel downLeft = new JPanel();
				downLeft.setLayout(new GridLayout(0,1,15,60));
				downLeft.add(new JLabel("�ٰŸ�"));
				downLeft.add(new JLabel("������"));
				//�ؽ�Ʈ ������ �ʱ�ȭ
				infoTA[0].setText("");
				infoTA[1].setText(""); 
				infodown.add(downLeft, BorderLayout.WEST);
				infodown.add(downRight, BorderLayout.CENTER);
				
				infoInput.add(infoup,BorderLayout.CENTER);
				infoInput.add(infodown, BorderLayout.SOUTH);
				
				info.add(infoInput,BorderLayout.CENTER);				
			}
			if(rbBook.isSelected()) { //book ����

				infoBorder = BorderFactory.createTitledBorder("��������"); //������ �ٿ��� ��� ����
				info.setBorder(infoBorder); //��� ���
				JPanel infoup = new JPanel();
				JPanel infoLeft = new JPanel();
				infoLeft.setLayout(new GridLayout(0,1,15,30));
				for(int i=0;i<strBook.length;i++) {
					infoLeft.add(new JLabel(strBook[i]));
				}
				JPanel infoRight = new JPanel();
				infoRight.setLayout(new GridLayout(0,1,15,5));
				for(int i=0;i<infoTF.length;i++) {
					infoTF[i]=new JTextField(20);
					infoRight.add(infoTF[i]);
				}
			
				year.setSelectedIndex(0); //�޺��ڽ� �� �ʱ�ȭ
		
				filepath.setText(""); //�̹��� ��� �ʱ�ȭ
				sl.setValue(5); //�����̵� �� �ʱ�ȭ

				infoRight.add(year);infoRight.add(files);infoRight.add(sl);

				infoup.add(infoLeft, BorderLayout.WEST);
				infoup.add(infoRight, BorderLayout.CENTER);

				JPanel infodown = new JPanel();

				JPanel downLeft = new JPanel();
				downLeft.setLayout(new GridLayout(0,1,15,60));
				downLeft.add(new JLabel("å�Ұ�"));
				downLeft.add(new JLabel("������"));
				//�ؽ�Ʈ ������ �ʱ�ȭ
				infoTA[0].setText("");
				infoTA[1].setText("");
				infodown.add(downLeft, BorderLayout.WEST);
				infodown.add(downRight, BorderLayout.CENTER);
				
				infoInput.add(infoup,BorderLayout.CENTER);
				infoInput.add(infodown, BorderLayout.SOUTH);
				
				info.add(infoInput,BorderLayout.CENTER);
			}
			info.validate();
		}	
	}
	public void setInitialize() { //���̾�αװ� ������ ���� ȣ���. �Էµ� ������ ������
		rbMovie.setSelected(true);
		for(int i=0;i<infoTF.length;i++) {
			infoTF[i].setText("");
		}
		genre.setSelectedIndex(0);
		rate.setSelectedIndex(0);
		year.setSelectedIndex(0);
		filepath.setText("");
		sl.setValue(5);
		for(int i=0;i<infoTA.length;i++) {
			infoTA[i].setText("");
		}
	}
	class MyButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			JButton bobj = (JButton)obj;
			if(bobj.getText().equals("�ҷ�����")) { //�ҷ����� ��ư
				JFileChooser chooser = new JFileChooser(".//");
				int ret = chooser.showOpenDialog(null);
				if(ret != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�", "���", JOptionPane.WARNING_MESSAGE);
					return;
				}
				String pathName = chooser.getSelectedFile().getPath();
				filepath.setText(pathName);
			}
			else if(obj==ok) { //ok��ư
				//�Էµ� ���� �ϳ��� ���� ���
				for(int i=0;i<infoTF.length;i++) {
					if(infoTF[i].getText().length()==0) {
						JOptionPane.showMessageDialog(null, "�Է����� ���� ���� �ֽ��ϴ�.", "���", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				for(int i=0;i<infoTA.length;i++) {
					if(infoTA[i].getText().length()==0) {
						JOptionPane.showMessageDialog(null, "�Է����� ���� ���� �ֽ��ϴ�.", "���", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				if(rbMovie.isSelected()) { //��ȭ ��ư�� ������ ������
					Item i = new Movie(infoTF[0].getText(),infoTF[1].getText(),infoTF[2].getText(),strGenre[genre.getSelectedIndex()],
							strRate[rate.getSelectedIndex()],Integer.parseInt(strYear[year.getSelectedIndex()]),
							filepath.getText(),sl.getValue(),infoTA[0].getText(),infoTA[1].getText());
					ic.create(i); //���Ϳ� �ֱ�
				}
				else if(rbBook.isSelected()) { //å ��ư�� ������ ������
					Item i = new Book(infoTF[0].getText(),infoTF[1].getText(),infoTF[2].getText(),
							Integer.parseInt(strYear[year.getSelectedIndex()]),
							filepath.getText(),sl.getValue(),infoTA[0].getText(),infoTA[1].getText());
					ic.create(i); //å �ֱ�
				}
			
				setVisible(false);
			}
			System.gc();	
		}
	}
}
