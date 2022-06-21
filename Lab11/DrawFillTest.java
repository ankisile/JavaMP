import javax.swing.*;
import java.awt.*;

public class DrawFillTest extends JFrame{

	public DrawFillTest() {
		setTitle("Draw Fill ��� ����"); //������ Ÿ��Ʋ �ޱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ������ ������ ���α׷��� �����ϵ��� ����
		Container c =getContentPane();
		c.setLayout(new GridLayout(0,3)); //����Ʈ���� ��ġ�����ڸ� 0x3¥�� GridLayout���� ����
		c.add(new MyPanel1()); c.add(new MyPanel2()); c.add(new MyPanel3()); //����Ʈ�ҿ� �г� 3�� ����
		setSize(1000, 400); //������ ũ�� 1000x400
		setVisible(true); //������ ȭ�� ���
	}
	
	class MyPanel1 extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); //JPanel�� paintComponent() ȣ��
			g.drawRoundRect(15, 15, 300, 300, 30, 30); //(15,15)��ġ���� 300x300¥�� �ձ� �簢�� �׸���
			g.setColor(Color.red); 
			g.fillRect(55, 60, 40, 230); //(55,60)��ġ���� 40x230 ������ �簢�� ĥ�ϱ�
			g.setColor(Color.blue);
			g.fillRect(115, 100, 40, 190); //(115,100)��ġ���� 40x190 �Ķ��� �簢�� ĥ�ϱ�
			g.setColor(Color.orange);
			g.fillRect(175, 160, 40, 130); //(175,160)��ġ���� 40x130 ��Ȳ�� �簢�� ĥ�ϱ�
			g.setColor(Color.green);
			g.fillRect(235, 100, 40, 190); //(235,100)��ġ���� 40x190 �ʷϻ� �簢�� ĥ�ϱ�
		}
	
	}
	class MyPanel2 extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); //JPanel�� paintComponent() ȣ��
			g.drawRoundRect(15, 15, 300, 300, 30, 30); //(15,15)��ġ���� 300x300¥�� �ձ� �簢�� �׸���
			g.setColor(Color.green);
			g.fillArc(40,40,250,250,-30, 110); //(40,40)��ġ���� 250x250 �簢���� �����ϴ� ��ȣ -30������ 110�� ��ŭ �ʷϻ����� ĥ�ϱ�
			g.setColor(Color.red);
			g.fillArc(40,40,250,250,80, 120); //(40,40)��ġ���� 250x250 �簢���� �����ϴ� ��ȣ 80������ 120�� ��ŭ ���������� ĥ�ϱ�
			g.setColor(Color.blue);
			g.fillArc(40,40,250,250,200, 40); //(40,40)��ġ���� 250x250 �簢���� �����ϴ� ��ȣ 200������ 40�� ��ŭ �Ķ������� ĥ�ϱ�
			g.setColor(Color.yellow);
			g.fillArc(40,40,250,250,240, 90); //(40,40)��ġ���� 250x250 �簢���� �����ϴ� ��ȣ 240������ 90�� ��ŭ ��������� ĥ�ϱ�
			

		}
	}
	class MyPanel3 extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); //JPanel�� paintComponent() ȣ��
			g.drawRoundRect(15, 15, 300, 300, 30, 30); //(15,15)��ġ���� 300x300¥�� �ձ� �簢�� �׸���
			g.setColor(Color.MAGENTA); //����Ÿ �� ����
			int x[]= {165,140,55,123,100,165,230,210,270,190,165 };
			int y[]= {40,120,120,170,260,200,260,170,120,120,40};
			g.fillPolygon(x,y,x.length); //x[]�� y[]�� ������ ������ ����Ÿ�� �ٰ��� ĥ�ϱ�

		}
	}
	public static void main(String[] args) {
		new DrawFillTest();
	}

}
