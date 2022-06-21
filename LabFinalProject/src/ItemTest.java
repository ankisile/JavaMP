import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ItemTest extends JFrame{
	ItemCollections ic;
	JTabbedPane pane;
	String strList []= {""};
	String sortList [] ={"����","����"}; 
	//����Ʈ ����
	JList<String> listTotal = new JList<String>(strList); 
	JList<String> listMovie = new JList<String>(strList); 
	JList<String> listBook = new JList<String>(strList); 
	JList<String> listSearch = new JList<String>(strList); 
	JButton append, revise, delete, search;
	JTextArea plotTA, reviewTA;
	JTextField searchTF ;
	JPanel write= new JPanel();
	JPanel detail = new JPanel();
	JPanel searchPanel = new JPanel();
	MyAppendDialog appendDialog;
	MyReviseDialog reviseDialog;
	//�޺��ڽ� ����
	JComboBox <String> sort = new JComboBox <String> (sortList);
	String strMovie [] = {"����","����","���","�帣","���","�����⵵","����"};
	String strBook [] = {"����","����","���ǻ�","���ǳ⵵","����"};
	int index=-1;
	
	public ItemTest() {
		setTitle("JAVA 04 1916737 �۹ο�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ������ ������ ���α׷��� �����ϵ��� ����
		
		Container c =getContentPane();
		createMenu(); // �޴� ����, �����ӿ� ����
		 ic = new ItemCollections(); //ItemCollections�� ���� ��ü ����
		//���
		JPanel top = new JPanel();
		top.setLayout(new BorderLayout());
		top.add(new MyLabel(), BorderLayout.EAST); //MyLabel�� �ð��� ǥ���ϴ� ��. ���� ���� ��ܿ� �־��� 
		JLabel l = new JLabel("My Notes"); //"My Notes"�� ���ִ� �� ����. 
		l.setFont(new Font("TimesRoman",3,40));  //�� ��Ʈ
		l.setForeground(Color.blue); //�� ��
		top.add(l, BorderLayout.CENTER);
		//����
		JPanel left = new JPanel();
		left.setLayout(new BorderLayout());
		JTabbedPane pane = createTabbedPane(); //���� ����
		append = new JButton("�߰�");
		append.addActionListener(new MyButtonListener()); //��ư�� ������ ���
		JPanel p = new JPanel();
		p.add(append);
		left.add(pane,BorderLayout.CENTER); left.add(p,BorderLayout.SOUTH);
		appendDialog = new MyAppendDialog(this,"�Է�"); //���̾�α׵� ���
		//����
		JPanel right = new JPanel(); //���⿡ �� �ϳ� �־�� �Ǳ� �ҵ�.
		right.setLayout(new BorderLayout());
		JPanel result = new JPanel();
		Border resultBorder = BorderFactory.createTitledBorder("�󼼺���"); //������ �ٿ��� ��� ����
		result.setBorder(resultBorder); //��� ���
		result.setLayout(new BorderLayout());
		//���λ���
		detail.setLayout(new GridLayout(1,0));
		ImagePanel img= new ImagePanel(); //�̹��� �г� ����
		detail.add(img);detail.add(write); 
		JPanel text = new JPanel();
		text.setLayout(new GridLayout(0,1));
		//�ٰŸ�
		JPanel plot = new JPanel();
		Border plotBorder = BorderFactory.createTitledBorder("�ٰŸ�"); //������ �ٿ��� ��� ����
		plot.setBorder(plotBorder); //��� ���
		plotTA= new JTextArea(6,65); //ũ�� ����
		plot.add(new JScrollPane(plotTA)); //��ũ���� ���
		plotTA.setLineWrap(true); //�ڵ� �ٹٲ�
		//������
		JPanel review = new JPanel();
		Border reviewBorder = BorderFactory.createTitledBorder("������"); //������ �ٿ��� ��� ����
		review.setBorder(reviewBorder); //��� ���
		reviewTA= new JTextArea(6,65); //ũ�� ����
		review.add(new JScrollPane(reviewTA)); //��ũ���� ���
		reviewTA.setLineWrap(true); //�ڵ� �ٹٲ�
		
		text.add(plot); text.add(review);		
		result.add(detail,BorderLayout.CENTER); result.add(text, BorderLayout.SOUTH);
		
		revise = new JButton("����");
		delete = new JButton("����");
		//��ư�� ������ ���
		revise.addActionListener(new MyButtonListener());
		delete.addActionListener(new MyButtonListener());
		
		JPanel btn = new JPanel();
		btn.add(revise); btn.add(delete); //		
		right.add(result, BorderLayout.CENTER);right.add(btn, BorderLayout.SOUTH);
		
		c.add(top, BorderLayout.NORTH);	c.add(left, BorderLayout.WEST);c.add(right, BorderLayout.CENTER);
		
		setSize(1000,800); //������ ũ�� 1000x800
		setVisible(true);
	}
	
	//�޴��� ����� �����ӿ� �����Ѵ�
	private void createMenu() {
		MyMenuListener mml = new MyMenuListener(); //������ ��ü ����
		JMenuBar mb = new JMenuBar(); //�޴��� ����
			
		JMenu fileMenu = new JMenu("����"); //���� �޴� ����
		JMenuItem fileItem [] = new JMenuItem[3]; 
		String fileStr [] = {"�ҷ�����","�����ϱ�","����"};
		//3���� �޴��������� ���� �޴��� ����
		for(int i=0;i<2;i++) { //2���� �޴� �������� ���� �޴��� ����
			fileItem[i] = new JMenuItem(fileStr[i]); //�޴� ������ ����
			fileItem[i].addActionListener(mml); //�޴� �����ۿ� ������ ���
			fileMenu.add(fileItem[i]); //�޴��������� ���� �޴��� ����
		}
		fileMenu.addSeparator(); //�и��� ����
		fileItem[2] = new JMenuItem(fileStr[2]); //�޴� ������ ����
		fileItem[2].addActionListener(mml); //�޴������ۿ� ������ ���
		fileMenu.add(fileItem[2]); //�޴� �������� ���� �޴��� ����
			
		JMenu helpMenu = new JMenu("����"); //���� �޴� ����
		//1���� �޴� �������� ���� �޴��� ����
		JMenuItem helpItem = new JMenuItem("�ý��� ����"); //�޴� ������ ����
		helpItem.addActionListener(mml); //�޴� �����ۿ� ������ ���
		helpMenu.add(helpItem); //�޴� �������� ���� �޴��� ����
			
		mb.add(fileMenu);mb.add(helpMenu); //�޴��ٿ� ����, ���� �޴� ����
			
		setJMenuBar(mb); //�޴��ٸ� �����ӿ� ����
    }
	
	private JTabbedPane createTabbedPane() {
		pane = new JTabbedPane();
		searchPanel.setLayout(new BorderLayout());
		JPanel up = new JPanel(); 
		searchTF = new JTextField(15); //�˻��ϴ� textfield
		search = new JButton("�˻�");//�˻� ��ư �����
		search.addActionListener(new MySearchListener()); //��ư�� ������ ���
		up.add(sort,BorderLayout.WEST); //����, �������� ������ �޺��ڽ� ���
		up.add(searchTF,BorderLayout.CENTER);
		up.add(search,BorderLayout.EAST);
		searchPanel.add(up,BorderLayout.NORTH);
		searchPanel.add(listSearch,BorderLayout.CENTER);
		
		 //����Ʈ�� ������ ���
		listTotal.addListSelectionListener(new ListListener());
		listMovie.addListSelectionListener(new ListListener()); 
		listBook.addListSelectionListener(new ListListener()); 
		listSearch.addListSelectionListener(new ListListener());
		pane.addTab("��ü", listTotal);
		pane.addTab("��ȭ", listMovie);
		pane.addTab("����", listBook);
		pane.addTab("�˻�", searchPanel);
		
		return pane;
	}
	class ListListener implements ListSelectionListener{ //����Ʈ�� ���� �̺�Ʈ ó��
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if(pane.getSelectedIndex()==1) { //��ȭ�ΰ��
				String listname = listMovie.getSelectedValue(); //select�� ���� �޾ƿ� 
				index = ic.getIndex(listname); //�� ���� �ε����� �޾ƿ�
				//��ȭ ���� ������ �ǿ� ���ؼ� selection�� clear��Ŵ
				listTotal.clearSelection();
				listBook.clearSelection();
				listSearch.clearSelection();
			}
			else if(pane.getSelectedIndex()==2) { //å�� ���
				String listname = listBook.getSelectedValue();  //select�� ���� �޾ƿ�
				index = ic.getIndex(listname);  //�� ���� �ε����� �޾ƿ�
				//���� ���� ������ �ǿ� ���ؼ� selection�� clear��Ŵ
				listTotal.clearSelection();
				listMovie.clearSelection();
				listSearch.clearSelection();
			}
			else if(pane.getSelectedIndex()==3) { //�˻��� ���
				String listname = listSearch.getSelectedValue();  //select�� ���� �޾ƿ�
				index = ic.getIndex(listname); //�� ���� �ε����� �޾ƿ�
				//�˻� ���� ������ �ǿ� ���ؼ� selection�� clear��Ŵ
				listTotal.clearSelection();
				listMovie.clearSelection();
				listBook.clearSelection();
			}
			else {
				index=listTotal.getSelectedIndex(); //��Ͽ��� ���õ� index�� �޾ƿͼ� index�� ����
				//��ü ���� ������ �ǿ� ���ؼ� selection�� clear 
				listMovie.clearSelection();
				listBook.clearSelection();
				listSearch.clearSelection();
			}

			if(index!=-1&&ic.getType(index)!=null) {
				write.removeAll();
				write.repaint();
				JPanel detailleft= new JPanel();
				detailleft.setLayout(new GridLayout(0,1,0,30));
				JPanel detailright = new JPanel();
				detailright.setLayout(new GridLayout(0,1,0,30));
				if(ic.getType(index).equals("Movie")) { //������ ���� movie�� ���
					for(int i=0;i<strMovie.length;i++) {
						detailleft.add(new JLabel(strMovie[i]));
					}
				Movie mov = (Movie)ic.getItem(index);
				detailright.add(new JLabel(mov.getTitle()));
				detailright.add(new JLabel(mov.getWriter()));
				detailright.add(new JLabel(mov.getActor()));
				detailright.add(new JLabel(mov.getGenre()));				
				detailright.add(new JLabel(mov.getGrade()));
				detailright.add(new JLabel(mov.getYear()));
				detailright.add(new JLabel(mov.getStar()));
				plotTA.setText(mov.getPlot());
				reviewTA.setText(mov.getReview());
				}
				else if(ic.getType(index).equals("Book")&&ic.getType(index)!=null){ //������ ���� ������ ���
					for(int i=0;i<strBook.length;i++) {
						detailleft.add(new JLabel(strBook[i]));
					}
					Book book = (Book)ic.getItem(index);
					detailright.add(new JLabel(book.getTitle()));
					detailright.add(new JLabel(book.getWriter()));
					detailright.add(new JLabel(book.getPublisher()));
					detailright.add(new JLabel(book.getYear()));
					detailright.add(new JLabel(book.getStar()));
					plotTA.setText(book.getPlot());
					reviewTA.setText(book.getReview());
			}

			write.add(detailleft, BorderLayout.WEST);
			write.add(detailright,BorderLayout.CENTER);
			write.revalidate();
			}
			if(ic.getType(index)==null) { //�� ���� �������� ���
				write.removeAll();
				write.repaint();
				plotTA.setText("");
				reviewTA.setText("");
			}
			repaint();
			
		}
	}
	class MySearchListener implements ActionListener{ //�˻� ��ư�� ���� ������

		@Override
		public void actionPerformed(ActionEvent e) {
			if(searchTF.getText().length()==0) { //�˻� ���ڿ��� ���� ���
				JOptionPane.showMessageDialog(null, "�Էµ��� �ʾҽ��ϴ�","���",JOptionPane.WARNING_MESSAGE);
				return;	
			}
			if(sort.getSelectedIndex()==0) { //�޺��ڽ��� ����
				if(ic.getStrTitle(searchTF.getText())==null) {
					JOptionPane.showMessageDialog(null, "ã�� ������ �����ϴ�","���",JOptionPane.WARNING_MESSAGE);
					return;	
				}
				else {
					listSearch.setListData(ic.getStrTitle(searchTF.getText()));
				}
				
			}
			else { //�޺��ڽ��� ����
				if(ic.getStrStar(searchTF.getText())==null) {
					JOptionPane.showMessageDialog(null, "ã�� ������ �����ϴ�","���",JOptionPane.WARNING_MESSAGE);
					return;	
				}
				else {
					listSearch.setListData(ic.getStrStar(searchTF.getText()));
				}
			}
			
		}
		
	}
	class MyButtonListener implements ActionListener{ //������ ��ư�� ���� ������
	
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			
			if(obj == append) { //�߰� ��ư
				appendDialog.setVisible(true);
				appendDialog.setInitialize();
				listTotal.clearSelection();
				listMovie.clearSelection();
				listBook.clearSelection();
			}
			else if(obj==revise) { //���� ��ư
				reviseDialog = new MyReviseDialog(null,"����",index);
				if(index==-1||index>=ic.getVSize()) {
					JOptionPane.showMessageDialog(null, "�������� �ʾҽ��ϴ�","���",JOptionPane.WARNING_MESSAGE);
					return;
				}
				else {
					reviseDialog.setVisible(true);
				}
			}
			else if(obj==delete) { //���� ��ư
				int result = JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�?", "���� Ȯ��", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					if(index==-1||index>=ic.getVSize()) {
						JOptionPane.showMessageDialog(null, "�������� �ʾҽ��ϴ�","���",JOptionPane.WARNING_MESSAGE);
						return;
					}
					ic.delete(index);//�����ϱ�
				}
			}	
			if(ic.getVSize()!=0) { //���Ϳ� ����ִ°� ���� ���
				listTotal.setListData(ic.getTotal()); 
				listMovie.setListData(ic.getStrMovie());// ����Ʈ ���� �����
				listBook.setListData(ic.getStrBook());
			}
			else {
				listTotal.setListData(strList); 
				listMovie.setListData(strList);// ����Ʈ ���� �����
				listBook.setListData(strList);
			}
			searchTF.setText("");
			listSearch.setListData(strList);
		
		}
	}
	
	class MyMenuListener implements ActionListener{
		private JFileChooser chooser  = new JFileChooser(".//"); //���� ���̾�α� ����
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int ret;
			String filePath;
			
			String cmd= e.getActionCommand(); //����ڰ� ������ �޴� �������� ���ڿ� ����
			switch (cmd) { //�޴� �������� ���� ����
			case "�ҷ�����": //���⸦ �������� 
				ret=chooser.showOpenDialog(null); //���� ���̾�α� ���
				if(ret != JFileChooser.APPROVE_OPTION) { //����ڰ� ������ â�� �ݾҰų� ��� ��ư�� ���� ��� ���â �߰���
					JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�","���",JOptionPane.WARNING_MESSAGE);
					return; 
				}
				//���� �����ϰ� ���� ��ư ���� ���
				filePath = chooser.getSelectedFile().getPath(); //���� ��θ� ����
				try {
					ic.open(filePath);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e2.getMessage(), "���", JOptionPane.WARNING_MESSAGE);
				}
				if(ic.getVSize()!=0) {
					listTotal.setListData(ic.getTotal()); 
					listMovie.setListData(ic.getStrMovie());// ����Ʈ ���� �����
					listBook.setListData(ic.getStrBook());
				}
				else {
					listTotal.setListData(strList); 
					listMovie.setListData(strList);// ����Ʈ ���� �����
					listBook.setListData(strList);
				}
				break;
			case "�����ϱ�":
				ret=chooser.showSaveDialog(null); //���� ���̾�α� ���
				if(ret != JFileChooser.APPROVE_OPTION) {//����ڰ� ������ â�� �ݾҰų� ��� ��ư�� ���� ��� ���â �߰� ��
					JOptionPane.showMessageDialog(null, "������ ������� �ʾҽ��ϴ�","���",JOptionPane.WARNING_MESSAGE);
					return;
				}
				//���� �����ϰ� ���� ��ư ���� ���
				//���� �����ϱ⸸ �ϸ� ����
				filePath = chooser.getSelectedFile().getPath(); //���� ��θ� ����
				try {
					ic.store(filePath);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(), "���", JOptionPane.WARNING_MESSAGE);
				} 
				
				break;
			case "����": //���� ��������
				System.exit(0); //�ý��� ����
				break;
			case "�ý��� ����": //���� ���� ��������
				JOptionPane.showMessageDialog(null,"MyNotes �ý��� v 1.0�Դϴ�","Message",JOptionPane.INFORMATION_MESSAGE); //�޽��� ���̾�α� ����
				break;
			}
		}
		
	}
	class ImagePanel extends JPanel{
		private ImageIcon icon;
		Image img;
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			if(index==-1) { 
				g.drawLine(20,20,250,300);
				g.drawLine(250,20,20,300);
				g.drawString("�̹��� ����", 100, 170);
			}
			else {
				if(ic.getpath(index)!=null) { //�̹��� ��θ��� ������쿡�� �̹��� �׸�
					icon = new ImageIcon(ic.getpath(index));
					img = icon.getImage();
					g.drawImage(img,20,20,230,280,this);
				}
				else {
					g.drawLine(20,20,250,300);
					g.drawLine(250,20,20,300);
					g.drawString("�̹��� ����", 100, 170);
				}
			}
			
		}
	}

	public static void main(String[] args) throws Exception{
		new ItemTest();

	}

}
