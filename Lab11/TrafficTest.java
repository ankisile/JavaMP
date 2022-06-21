import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficTest extends JFrame{
	JButton btn = new JButton("traffic light turn on"); //��ư ����
	int light =0; //��� ĥ������ �Ǵ����� ��Ÿ���� ����
	public TrafficTest() {
		setTitle("��ȣ��"); //������ Ÿ��Ʋ �ޱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ������ ������ ���α׷��� �����ϵ��� ����
		Container c =getContentPane(); 
		c.setLayout(new BorderLayout()); //����Ʈ���� ��ġ�����ڸ� BorderLayout���� ����
		btn.addActionListener(new MyListener()); //��ư�� ������ ���
		c.add(new MyPanel(), BorderLayout.CENTER); //�г��� ����� ����
		c.add(btn, BorderLayout.SOUTH); //�г��� ���ʿ� ����
		setSize(400, 500); //������ ũ�� 400x500
		setVisible(true); //������ ȭ�� ���
	}
	class MyPanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); //JPanel�� paintComponent() ȣ��
			g.drawOval(150, 100, 100, 100); //(150,100)�� 100x100�簢���� �����ϴ� �� �׸���
			g.drawOval(150, 200, 100, 100); //(150,200)�� 100x100�簢���� �����ϴ� �� �׸���
			g.drawOval(150, 300, 100, 100); //(150,300)�� 100x100�簢���� �����ϴ� �� �׸���
			if(light==0) { //light�� 0�̸�
				g.setColor(Color.RED);
				g.fillOval(150, 100, 100, 100); //(150,100)�� 100x100�簢���� �����ϴ� ���� ���������� ä��� 
			}
			else if(light==1) { //light�� 1�̸� 
				g.setColor(Color.GREEN);
				g.fillOval(150, 200, 100, 100); //(150,200)�� 100x100�簢���� �����ϴ� ���� �ʷϻ����� ä��� 
			}
			else { //light�� 3�̸�
				g.setColor(Color.YELLOW);
				g.fillOval(150, 300, 100, 100); //(150,300)�� 100x100�簢���� �����ϴ� ���� ��������� ä��� 
			}
		}
		
	}
	class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj=e.getSource(); //�̺�Ʈ �߻��� ��ü �޾ƿ���
			if(obj==btn) { //��ü�� ��ư�̸�
				light++; //light 1����
				light = light%3; //light�� 3���� ���������� ������ �ֱ�
				
				repaint(); //�ٽ� �׸��� ��û
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TrafficTest();
	}

}
