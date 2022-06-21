import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.Border;

public class MyReviseDialog extends JDialog{
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
	JTextArea infoTA[] = new JTextArea[2];
	MyButtonListener mbl = new MyButtonListener();
	ItemCollections ic;
	JPanel files = new JPanel();
	
	int index;
	public MyReviseDialog(JFrame frame, String title, int idx) {
		super(frame, title,true); //true�� ��� Ÿ���� ���鵵�� ����
		setLayout(new BorderLayout()); //BorderLayout���� ����
		ic = new ItemCollections();
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); //X��ư Ȱ��ȭ X
		
		JPanel up = new JPanel(); //�г� ����(��Ʈ)
		ButtonGroup group = new ButtonGroup(); //��ư �׷� ��ü ����		
		
		index = idx;//������ ����Ʈ�� �ε����� �����;� ��
		
		//files �гκ��� ���� ����
		filepath.setEditable(false);
		open.addActionListener(mbl);
		files.add(filepath); files.add(open);
		
		if(ic.getType(index)!=null) {
		if(ic.getType(index).equals("Movie")) { //�����ϴ°� ��ȭ�ϰ��. ����� �߰��Ҷ��� ����
			Movie mov = (Movie)ic.getItem(index); //��ü �޾ƿ�
			rbMovie = new JRadioButton("Movie", true);
			rbBook = new JRadioButton("Book");
			rbBook.setEnabled(false); //å��ư ���� ����
		
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
		//�Էµ� �� �޾ƿ�
		infoTF[0].setText(mov.getTitle()); 
		infoTF[1].setText(mov.getWriter());
		infoTF[2].setText(mov.getActor());
		//�޺��ڽ��� ���õ� �� �޾ƿ�
		int genreIdx = 0, rateIdx = 0, yearIdx = 0;
		genre = new JComboBox<String>(strGenre);
		for(int i=0;i<strGenre.length;i++) {
			if(mov.getGenre().equals(strGenre[i])) {
				genreIdx = i;
				break;
			}
		}
		genre.setSelectedIndex(genreIdx);
		
		rate = new JComboBox<String>(strRate);
		for(int i=0;i<strRate.length;i++) {
			if(mov.getGrade().equals(strRate[i])) {
				rateIdx = i;
				break;
			}
		}
		rate.setSelectedIndex(rateIdx);
		
		year = new JComboBox<String>(strYear);
		for(int i=0;i<strYear.length;i++) {
			if(mov.getYear().equals(strYear[i])) {
				yearIdx = i;
				break;
			}
		}
		year.setSelectedIndex(yearIdx);
		//�̹��� ��� �޾ƿ�
		filepath.setText(mov.getImg());
		//�����̴��� ���õ� �� �޾ƿ�
		sl=new JSlider(JSlider.HORIZONTAL, 1, 10, Integer.parseInt(mov.getStar())); //�����̴� ����. 
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
		JPanel downRight = new JPanel();
		downRight.setLayout(new GridLayout(0,1,15,5));
		for(int i=0;i<infoTA.length;i++) {
			infoTA[i]=new JTextArea(5, 20);
			downRight.add(new JScrollPane(infoTA[i]));
			infoTA[i].setLineWrap(true);
			}
		//�Էµ� �� �޾ƿ�
		infoTA[0].setText(mov.getPlot());
		infoTA[1].setText(mov.getReview());
		infodown.add(downLeft, BorderLayout.WEST);
		infodown.add(downRight, BorderLayout.CENTER);
		
		infoInput.add(infoup,BorderLayout.CENTER);
		infoInput.add(infodown, BorderLayout.SOUTH);
		info.add(infoInput,BorderLayout.CENTER);	
		}
		
		
		if(ic.getType(index).equals("Book")) { //�����ϴ°� å�� ���
			Book book = (Book)ic.getItem(index); //��ü �޾ƿ�
			rbMovie = new JRadioButton("Movie");
			rbBook = new JRadioButton("Book", true);
			rbMovie.setEnabled(false); //��ȭ ���� ����
		
		group.add(rbMovie); group.add(rbBook);
		up.add(rbMovie);up.add(rbBook);
		
		infoBorder = BorderFactory.createTitledBorder("��������"); //������ �ٿ��� ��� ����
		info.setBorder(infoBorder); //��� ���
		info.setLayout(new BorderLayout());
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
		//�Էµ� �� �޾ƿ�
		infoTF[0].setText(book.getTitle());
		infoTF[1].setText(book.getWriter());
		infoTF[2].setText(book.getPublisher());
		//�޺��ڽ� ���õ� �� �޾ƿ�
		int yearIdx = 0;
		year = new JComboBox<String>(strYear);
		for(int i=0;i<strYear.length;i++) {
			if(book.getYear().equals(strYear[i])) {
				yearIdx = i;
				break;
			}
		}
		year.setSelectedIndex(yearIdx);
		//�̹��� ��� �޾ƿ�
		filepath.setText(book.getImg());

		//�����̴� �� �޾ƿ�
		sl=new JSlider(JSlider.HORIZONTAL, 1, 10,Integer.parseInt(book.getStar())); //�����̴� ����. �����̰� 1~10 ������ ������ 5 �ʱⰪ
		sl.setPaintLabels(true); //�����̴��� ���� ����
		sl.setPaintTicks(true); //�����̴� ������ ����
		sl.setPaintTrack(true); //�����̴� Ʈ���� ����
		sl.setMajorTickSpacing(1); //�����̴� ū ���� ���� 1
		infoRight.add(year);infoRight.add(files);infoRight.add(sl);

		infoup.add(infoLeft, BorderLayout.WEST);
		infoup.add(infoRight, BorderLayout.CENTER);

		JPanel infodown = new JPanel();
		JPanel downLeft = new JPanel();
		downLeft.setLayout(new GridLayout(0,1,15,60));
		downLeft.add(new JLabel("å�Ұ�"));
		downLeft.add(new JLabel("������"));
		JPanel downRight = new JPanel();
		downRight.setLayout(new GridLayout(0,1,15,5));
		for(int i=0;i<infoTA.length;i++) {
			infoTA[i]=new JTextArea(5, 20);
			downRight.add(new JScrollPane(infoTA[i]));
			infoTA[i].setLineWrap(true);
			}
		//�Էµ� �� �޾ƿ�
		infoTA[0].setText(book.getPlot());
		infoTA[1].setText(book.getReview());
		infodown.add(downLeft, BorderLayout.WEST);
		infodown.add(downRight, BorderLayout.CENTER);
		
		infoInput.add(infoup,BorderLayout.CENTER);
		infoInput.add(infodown, BorderLayout.SOUTH);
		
		info.add(infoInput,BorderLayout.CENTER);
		}
		}
		
		//ok��ư
		JPanel but = new JPanel();
		ok.addActionListener(mbl);
		but.add(ok);
		info.add(infoInput,BorderLayout.CENTER);info.add(but,BorderLayout.SOUTH);
		
		add(up, BorderLayout.NORTH);add(info, BorderLayout.CENTER);
		setSize(300,750); 
	}
	
	
	class MyButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(obj==open) { //�ҷ�����
				JFileChooser chooser = new JFileChooser(".//");
				int ret = chooser.showOpenDialog(null);
				if(ret != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�", "���", JOptionPane.WARNING_MESSAGE);
					return;
				}
				String pathName = chooser.getSelectedFile().getPath();
				filepath.setText(pathName);
			}
			else if(obj==ok) { //ok
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
				if(rbMovie.isSelected()) { //��ȭ�� �������� ���
					Item i = new Movie(infoTF[0].getText(),infoTF[1].getText(),infoTF[2].getText(),strGenre[genre.getSelectedIndex()],
							strRate[rate.getSelectedIndex()],Integer.parseInt(strYear[year.getSelectedIndex()]),
							filepath.getText(),sl.getValue(),infoTA[0].getText(),infoTA[1].getText());
					ic.revise(index,i); //����
				}
				else if(rbBook.isSelected()) { //å�� �������� ���
					Item i = new Book(infoTF[0].getText(),infoTF[1].getText(),infoTF[2].getText(),
							Integer.parseInt(strYear[year.getSelectedIndex()]),
							filepath.getText(),sl.getValue(),infoTA[0].getText(),infoTA[1].getText());
					ic.revise(index,i); //����
				}
			
				setVisible(false);
			}
			System.gc();	
		}
	}
}
