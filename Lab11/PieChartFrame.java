import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PieChartFrame extends JFrame{
	JTextField tf [] = new JTextField [4]; //�Է��� text field �迭
	int angle [] =new int[4]; //�� ���ϸ����� ������ ���� �迭
	int data[]= new int [4]; //�� ������ ��ִ����� ���� �迭
	String str [] = {"apple", "cherry", "strawberry", "prune"}; //���ϵ� ���� �ִ� �迭
	Color col [] = {Color.red,Color.blue,Color.magenta,Color.orange}; //������� �ִ� �迭
	
	public PieChartFrame() {
		setTitle("���� ��Ʈ �׸���"); //������ Ÿ��Ʋ �ޱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ������ ������ ���α׷��� �����ϵ��� ����
		Container c =getContentPane();
		c.setLayout(new BorderLayout()); //����Ʈ���� ��ġ������ BorderLayout
		JPanel panel = new JPanel(); //�г� ����
		panel.setLayout(new FlowLayout()); //�г��� ��ġ������ FlowLayout
		panel.setBackground(Color.LIGHT_GRAY); //�г��� ������ ���� ȸ��
		for(int i=0;i<tf.length;i++) { //tf.length��ŭ ������ �ݺ�
			tf[i]=new JTextField("0",7); //textField 7ĭ���� ����. "0"���� �ʱ�ȭ
			tf[i].addActionListener(new MyListener());  //text field�� ������ ���
			panel.add(new JLabel(str[i]));	panel.add(tf[i]); //�гο� ���ϸ� ���� �ϰ� text field ����
		}	
		c.add(panel, BorderLayout.NORTH); //panel�� ���ʿ� ����
		c.add(new MyPanel(), BorderLayout.CENTER); //MyPanel() ��ü�� ����� ����
		setSize(600, 500); //������ ũ�� 600x500
		setVisible(true); //������ ȭ�� ���
	}
	

	class MyPanel extends JPanel{

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); //JPanel�� paintComponent() ȣ��
			int startAngle =0; //���� ������ 0
			g.setFont(new Font(getFont().getName(),Font.BOLD,getFont().getSize())); //��Ʈ ���� ���� �ٲ���
			for(int i=0;i<tf.length;i++) {
				g.setColor(col[i]); //col[i]�� color����
				g.drawString(str[i]+" "+(int)Math.round((double)angle[i]/360*100)+"%",100*(i+1),40);
				//(100*(i+1),40)��ġ�� ���ڿ� ���. 
				//str[i]�� ���� ������� �� (double)angle[i]/360*100�� �ۼ�Ʈ�̱� ������ �̷��� ����� �� �ݿø��� ���ְ� ���������� �ٲ���. �׸��� ��� 
				//������ double�� ���̴� ������ ���������� ���� �����̱� ������ ������ ���� �Ҽ��� ������ 0�� �Ǿ����. �׷��� double�� �ٿ��� �Ҽ��� ������ �������
				g.fillArc(150, 80, 300, 300, startAngle, angle[i]); 
				//col[i]�� ��ä�� ä���. (150,80)���� 300x300�� �����ϴ� ������ startAngle�������� angle[i] ��ŭ ��ä�� �׸���
				startAngle+=angle[i]; //startAngle�� angle[i]�� �����༭ startAngle�� ������Ʈ. �״��� ������ ��ä���� �׸��� ���
			}

		}
		
	}
	class MyListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int sum=0; //sum�� ��� ���� ������ ����
			for(int i=0;i<data.length;i++) { //������ data.length��ŭ �ݺ�
				data[i]=Integer.parseInt(tf[i].getText()); //text field���� ���� ���� ���� �������� �ٲ��ְ� data[i]�� ����
				sum = sum+data[i]; //sum�� data[i]�� ������
			}
				
			for(int i=0;i<data.length;i++) //������ data.length ��ŭ �ݺ�
				angle[i]=(int) Math.round((double) data[i] / (double) sum * 360);
				//angle[i]�� ������ ����� ���� ����
			    //(double) data[i] / (double) sum * 360�� ���� ������ ���� ����. 
			    //���������� ���� �����̱� ������ ������ ���� �Ҽ��� ������ 0�� �Ǿ����. �׷��� double�� �ٿ��� �Ҽ��� ������ �������
			
			repaint(); //�ٽñ׸��� ��û
	
		}
		

	}
	public static void main(String[] args) {
		new PieChartFrame();

	}

}
