import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ModalDialog extends JDialog{
	String [] font = {"����","����","�ü�","���� ���"};
	JComboBox <String> strCombo;
	JTextField tfsize;
	JCheckBox ckbold, ckitalic;
	int style; //�۾� ��Ÿ���� ������ ����
	public ModalDialog(JFrame frame, String title) {
		super(frame, title, true); //true�� ��� Ÿ���� ���鵵�� ����
		setLayout(new BorderLayout()); //BorderLayout���� ����
		JPanel left = new JPanel(); //�г� ����
		left.setLayout(new GridLayout(0,1)); //�г��� GridLayout���� ����
		//�гο� ����
		left.add(new JLabel("��Ʈ ����")); 
		left.add(new JLabel("��Ʈ ��Ÿ��"));
		left.add(new JLabel("��Ʈ ũ��"));
		
		JPanel right = new JPanel(); //�г� ����
		right.setLayout(new GridLayout(0,1)); //�г� GridLayout���� ����
		strCombo = new JComboBox<String>(font); //���ڿ� �޺��ڽ�
		right.add(strCombo); //�гο� �޺��ڽ� ����
		JPanel panelStyle = new JPanel(); //�г� ����(��Ÿ��)
		MyCheckListener mcl = new MyCheckListener(); //üũ�ڽ��� ���� ������ ��ü ����
		ckbold = new JCheckBox("BOLD"); //üũ�ڽ� ����
		ckbold.addItemListener(mcl); //üũ�ڽ��� ������ ���
		ckitalic = new JCheckBox("ITALIC"); //üũ�ڽ� ����
		ckitalic.addItemListener(mcl); //üũ�ڽ��� ������ ���
		panelStyle.add(ckbold);	panelStyle.add(ckitalic); //�гο� ����
		right.add(panelStyle); //�гο� ��Ÿ�� �г� ����
		tfsize = new JTextField(); //text field ����
		right.add(tfsize); //text field �гο� ����
		
		JPanel down = new JPanel();//�г� ����
		JButton ok = new JButton("����"); //��ư ����
		ok.addActionListener(new ActionListener() { //�͸� Ŭ����
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false); //���̾�α� ����
			
			}
		});
		down.add(ok);//�гο� ��ư ����
		add(left,BorderLayout.WEST);add(right,BorderLayout.CENTER);	add(down, BorderLayout.SOUTH); //�гο� ����
		setSize(230,180); //ũ�� 250x150
	}
	class MyCheckListener implements ItemListener{ //üũ�ڽ��� ���� ������
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(ckbold.isSelected() &&ckitalic.isSelected()) { //BOLD�� ITALIC�� üũ�Ǿ�������
				style=3; 
			}
			else if(ckbold.isSelected()) { //BOLD�� üũ�Ǿ�������
				style=1;
			}
			else if(ckitalic.isSelected()){ //ITALIC�� üũ�Ǿ�������
				style=2;
			}
			else { //üũ�� ������
				style=0;
			}
		}	
	}
	public String getFontName() {
		int index =strCombo.getSelectedIndex(); //�޺��ڽ����� ������ �ε��� �޾ƿ���
		return font[index]; //font[index]����
	}

	public String getFontSize() {
		if(tfsize.getText().length()==0) return null; //�ؽ�Ʈ �ʵ忡 �Էµ� ���� ������ null ����
		else return tfsize.getText(); //�ƴϸ� �ؽ�Ʈ�ʵ忡�� ���� �޾ƿͼ� ����
	}

	public int getStyle() {
		return style; //��Ÿ�� ����
	}
	/*public int getFlag() {
		return flag; //"����"��ư�� ���ȴ��� ����
	}*/
}
public class SwingTest extends JFrame{
	JLabel lb = new JLabel("Text"); //�� ����
	ModalDialog dialog;
	public SwingTest() {
		setTitle("Menu ����� ����"); //������ Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ������ ������ ���α׷��� �����ϵ��� ����
		Container c =getContentPane();
		createMenu(); // �޴� ����, �����ӿ� ����
		c.setLayout(new FlowLayout()); //����Ʈ���� FlowLayout���� ����
		c.add(lb); //���� ����Ʈ�ҿ� ����
		
		dialog = new ModalDialog(this, " "); //��� ���̾�α� ����
		lb.setToolTipText("������ ���� ����� �����Դϴ�."); //�󺧿� ���� �ޱ�
		ToolTipManager m = ToolTipManager.sharedInstance(); //ToolTipManager ��ü�� ���
		m.setInitialDelay(0); //�ʱ� ���� ��� ���� �ð��� 0�ʷ� ����
			
		setSize(300,200); //������ ũ�� 300x200
		setVisible(true);
	}
	//�޴��� ����� �����ӿ� �����Ѵ�
	private void createMenu() {
		MyListener ml = new MyListener(); //������ ��ü ����
		JMenuBar mb = new JMenuBar(); //�޴��� ����
		
		JMenu fileMenu = new JMenu("����"); //���� �޴� ����
		JMenuItem fileItem [] = new JMenuItem[3]; 
		String fileStr [] = {"����","����","����"};
		//3���� �޴��������� ���� �޴��� ����
		for(int i=0;i<2;i++) { //2���� �޴� �������� ���� �޴��� ����
			fileItem[i] = new JMenuItem(fileStr[i]); //�޴� ������ ����
			fileItem[i].addActionListener(ml); //�޴� �����ۿ� ������ ���
			fileMenu.add(fileItem[i]); //�޴��������� ���� �޴��� ����
		}
		fileMenu.addSeparator(); //�и��� ����
		fileItem[2] = new JMenuItem(fileStr[2]); //�޴� ������ ����
		fileItem[2].addActionListener(ml); //�޴������ۿ� ������ ���
		fileMenu.add(fileItem[2]); //�޴� �������� ���� �޴��� ����
		

		JMenu editMenu = new JMenu("����"); //���� �޴� ����
		JMenuItem editItem [] = new JMenuItem[3]; 
		String editStr [] = {"�� ����","��Ʈ","�ؽ�Ʈ ����"};
		//3���� �޴��������� ���� �޴��� ����
		for(int i=0;i<editItem.length;i++) {
			editItem[i] = new JMenuItem(editStr[i]); //�޴� ������ ����
			editItem[i].addActionListener(ml); //�޴� �����ۿ� ������ ���
			editMenu.add(editItem[i]); //�޴� �������� ���� �޴��� ����
		}
		
		JMenu helpMenu = new JMenu("����"); //���� �޴� ����
		//1���� �޴� �������� ���� �޴��� ����
		JMenuItem helpItem = new JMenuItem("���� ����"); //�޴� ������ ����
		helpItem.addActionListener(ml); //�޴� �����ۿ� ������ ���
		helpMenu.add(helpItem); //�޴� �������� ���� �޴��� ����
		
		mb.add(fileMenu);mb.add(editMenu);mb.add(helpMenu); //�޴��ٿ� ����, ����, ���� �޴� ����
		
		setJMenuBar(mb); //�޴��ٸ� �����ӿ� ����
	}
	
	class MyListener implements ActionListener{
		private JFileChooser chooser  = new JFileChooser(); //���� ���̾�α� ����
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int ret;
			String filePath;
			String cmd= e.getActionCommand(); //����ڰ� ������ �޴� �������� ���ڿ� ����
			switch (cmd) { //�޴� �������� ���� ����
			case "����": //���⸦ �������� 
				ret=chooser.showOpenDialog(null); //���� ���̾�α� ���
				if(ret != JFileChooser.APPROVE_OPTION) { //����ڰ� ������ â�� �ݾҰų� ��� ��ư�� ���� ��� ���â �߰���
					JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�","���",JOptionPane.WARNING_MESSAGE);
					return; 
				}
				//���� �����ϰ� ���� ��ư ���� ���
				filePath = chooser.getSelectedFile().getPath(); //���� ��θ� ����
				lb.setText(filePath+"������ ���õǾ����ϴ�."); //���� text �ٲ�
				break;
			case "����":
				ret=chooser.showSaveDialog(null); //���� ���̾�α� ���
				if(ret != JFileChooser.APPROVE_OPTION) {//����ڰ� ������ â�� �ݾҰų� ��� ��ư�� ���� ��� ���â �߰� ��
					JOptionPane.showMessageDialog(null, "������ ������� �ʾҽ��ϴ�","���",JOptionPane.WARNING_MESSAGE);
					return;
				}
				//���� �����ϰ� ���� ��ư ���� ���
				filePath = chooser.getSelectedFile().getPath(); //���� ��θ� ����
				lb.setText(filePath+"���Ͽ� ����Ǿ����ϴ�."); //���� text �ٲ�
				break;
			case "����": //���� ��������
				int result = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?","���� Ȯ��",JOptionPane.YES_NO_OPTION); //Ȯ�� ���̾�α� ����
				if(result==JOptionPane.YES_OPTION) //Ȯ�� ��ư�� ������
					System.exit(0); //�ý��� ����
				break;
			case "�� ����": //�� ���� �������� 
				Color selectedColor = JColorChooser.showDialog(null, "���� ����", Color.YELLOW); //�÷� ���̾�α׸� ����ϰ� ����ڰ� ������ ���� �˾ƿ´� 
				if(selectedColor !=null) //����ڰ� ���� �����ϰ� "Ȯ��"��ư�� �������
					lb.setForeground(selectedColor); //����ڰ� ������ ������ ���ڿ� �� ����
				break;
			case "��Ʈ": //��Ʈ�� ������
				dialog.setVisible(true); //��� ���̾�α� �۵� ����
				String fontName = dialog.getFontName(); //���̾�α׷� ���� �۾�ü �޾ƿ���
				int fontStyle  = dialog.getStyle(); //���̾�α׷κ��� ��Ʈ ��Ÿ�� �޾ƿ���
				String fontSize= dialog.getFontSize(); //���̾�α׷κ��� ��Ʈ ũ�� �޾ƿ���
				lb.setFont(new Font(fontName,fontStyle,fontSize==null?lb.getFont().getSize():Integer.parseInt(fontSize))); //�޾ƿ� ��Ʈ �۾�ü, ��Ÿ��, ũ��� ���� ��Ʈ ����
				break;
			case "�ؽ�Ʈ ����": //�ؽ�Ʈ ���� ��������
				String text = JOptionPane.showInputDialog("������ �ؽ�Ʈ�� �Է��ϼ���"); //�Է� ���̾�α� ����
				if(text!=null)  //�Է��Ѱ� ������
					lb.setText(text); //����ڰ� �Է��� ���ڿ��� ���� text�� �ٲ���
				break;
			case "���� ����": //���� ���� ��������
				JOptionPane.showMessageDialog(null,"�׽�Ʈ v1.0","���� ����",JOptionPane.INFORMATION_MESSAGE); //�޽��� ���̾�α� ����
				break;
			}
			
		}
		
	}
	public static void main(String[] args) {
		new SwingTest();
	}

}

