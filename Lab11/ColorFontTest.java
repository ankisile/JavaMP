import javax.swing.*;
import java.awt.*;

public class ColorFontTest extends JFrame{
	private MyPanel panel = new MyPanel();
	public ColorFontTest() {
		setTitle("Color, Font ��� ����"); //������ Ÿ��Ʋ �ޱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ������ ������ ���α׷��� �����ϵ��� ����
		setContentPane(panel); //������ panel �г��� ����Ʈ������ ���
		
		setSize(700, 250); //������ ũ�� 700x250
		setVisible(true); //������ ȭ�� ���
	}

	class MyPanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); //JPanel�� paintComponent() ȣ��
			g.setColor(Color.BLUE); //�Ķ��� ����
			g.setFont(new Font("�ü�",Font.BOLD,30)); //��Ʈ�� �ü�, ����, ������� 30
			g.drawString("����: ���ѹα�(��Ʈ:�ü�)", 50, 50); //(50,50)��ġ�� ���ڿ� ���
			g.setColor(Color.RED); //������ ����
			g.setFont(new Font("�޸վƹ�ü", Font.BOLD, 25)); //��Ʈ�� �޸վƹ�ü, ����, ������� 25
			g.drawString("�ּ� : ��⵵ ���� (��Ʈ:�޸վƹ�ü)", 50, 90); //(50,90)��ġ�� ���ڿ� ���
			g.setColor(Color.ORANGE); //��Ȳ�� ����
			g.setFont(new Font("�޸ո���ü", Font.PLAIN, 30)); //��Ʈ�� �޸ո���ü, ����, ������� 30
			g.drawString("���� : �۹ο� (��Ʈ:�޸ո���ü)", 50, 130); //(50,130)��ġ�� ���ڿ� ���
			g.setColor(Color.darkGray); //����ȸ�� ����
			g.setFont(new Font("�޸�����ü", Font.PLAIN, 15)); //��Ʈ�� �޸�����ü, ����, ������� 15
			g.drawString("�й�: 1916737 (�޸�����ü)", 50, 150); //(50,150)��ġ�� ���ڿ� ���
		}
		
	}
	public static void main(String[] args) {
		new ColorFontTest();

	}

}
