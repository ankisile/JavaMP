import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawGraphic extends JFrame{
	Container c;
	JButton line, rect, circle, tri, color;
	int x1, y1, x2, y2;
	int menu; //��ư�� ������ ���ȴ����� ������ �����ϴ� ����. menu��� ������ ���� � ��ư�� ���ȴ��� �� �� ����
	Color col;
	public DrawGraphic() {
		setTitle("�׷��� �׸���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ������ ������ ���α׷��� �����ϵ��� ����
		c =getContentPane();
		createToolBar(); // ���� ����, �����ӿ� ����
		c.add(new MyPanel(), BorderLayout.CENTER); //�г� ������ ����Ʈ�ҿ� ����
		setSize(500,500); //������ ũ�� 500x500
		setVisible(true);
	}
	
	class MyPanel extends JPanel{ //�׸� �׸��� �г�
		public MyPanel() {
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) { //���콺�� ��������
					x1=e.getX(); //���콺 ��ǥ�� �޾ƿ���
					y1=e.getY();
				}
				@Override
				public void mouseReleased(MouseEvent e) { //���콺�� ����������
					x2=e.getX(); //���콺 ��ǥ�� �޾ƿ���
					y2=e.getY();
					repaint(); //�ٽñ׸��� ��û
				}
			});
			addMouseMotionListener(new MouseAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) { //���콺�� ������ �����϶�
					x2=e.getX(); //���콺 ��ǥ�� �޾ƿ���
					y2=e.getY();
					repaint(); //�ٽñ׸��� ��û
				}
			});
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); //JPanel�� paintComponent() ȣ��
			g.setColor(col); //col�� �� ����
			int x = Math.min(x1, x2); //x�� x1�� x2�� ���� ��
			int y = Math.min(y1, y2); //y�� y1�� y2�� ���� ��
			int w = Math.abs(x1-x2); //w�� x1-x2�� ���밪
			int h=Math.abs(y1-y2); //h�� y1-y2�� ���밪
			if(menu==1) //menu�� 1 �̸�
				g.drawLine(x1, y1, x2, y2); //�� �׸���
			else if (menu==2) //menu�� 2�̸�
				g.drawRect(x,y,w,h); //�簢�� �׸���
			else if (menu==3) //menu�� 3�̸�
				g.drawOval(x, y, w, h); //��(Ÿ��)�׸���
			else if (menu==4) { //menu�� 4�̸�
				int xArr[]= {x1+(x2-x1)/2,x1,x2};
				int yArr[]= {y1,y2,y2};
				g.drawPolygon(xArr, yArr, xArr.length); //�ﰢ�� �׸���
			}
				
		}
	
	}
	//���ٸ� �����Ͽ� �������ҿ� ����
	private void createToolBar() {
		JToolBar toolBar = new JToolBar("Menu"); //���� ����
		toolBar.setBackground(Color.LIGHT_GRAY); //���� ���� ���� ȸ��
		
		toolBar.setLayout(new GridLayout(1,0)); //���� GridLayout���� ����
		//���ٿ� �޴��� ����� ������Ʈ ����
		toolBar.add(new JLabel("����")); //���ٿ� �� ����
		MyListener ml = new MyListener(); //������ ����
		line = new JButton(" �� "); //��ư ����
		line.addActionListener(ml); //��ư�� ������ ���
		rect = new JButton(" �� "); //��ư ���� 
		rect.addActionListener(ml); //��ư�� ������ ���
		circle = new JButton(" �� "); //��ư ����
		circle.addActionListener(ml);  //��ư�� ������ ���
		tri = new JButton(" �� "); //��ư ����
		tri.addActionListener(ml); //��ư�� ������ ���
		toolBar.add(line);toolBar.add(rect);toolBar.add(circle);toolBar.add(tri); //���ٿ� ��ư ����
		toolBar.add(new JLabel("�� ����")); //���ٿ� �� ����
		color = new JButton("��"); //��ư ����
		color.addActionListener(ml); //��ư�� ������ ���
		toolBar.add(color);  //���ٿ� ��ư ����
		c.add(toolBar,BorderLayout.NORTH); //���ٸ� ����Ʈ �ҿ� ����
	}
	class MyListener implements ActionListener{ //��ư �������� ������

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource(); //�۵��� ��ü �޾ƿ���
			if(obj==line) { //�۵��� ��ü�� line�̸�
				menu=1;
			}
			else if(obj==rect) { //�۵��� ��ü�� rect�̸�
				menu=2;
			}
			else if(obj==circle) { //�۵��� ��ü�� circle�̸�
				menu=3;
			}
			else if(obj==tri) { //�۵��� ��ü�� tri�̸�
				menu=4;
			}
			else if(obj==color) { //�۵��� ��ü�� color�̸�
				Color selectedColor = JColorChooser.showDialog(null, "���� ����", Color.YELLOW); //�÷� ���̾�α׸� ����ϰ� ����ڰ� ������ ���� �˾ƿ´� 
				if(selectedColor !=null) //����ڰ� ���� �����ϰ� "Ȯ��"��ư�� �������
					col=selectedColor; //����ڰ� ������ ������ ���ڿ� �� ����
			}
		}
		
	}

	public static void main(String[] args) {
		new DrawGraphic();
	}

}
