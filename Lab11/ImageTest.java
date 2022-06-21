import javax.swing.*;
import java.awt.*;

public class ImageTest extends JFrame{

	public ImageTest() {
		setTitle("�׷��� �̹��� ����"); //������ Ÿ��Ʋ �ޱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ������ ������ ���α׷��� �����ϵ��� ����
		setContentPane(new MyPanel()); //������ �г��� ����Ʈ������ ���
		
		setSize(500, 500); //������ ũ�� 500x500
		setVisible(true); //������ ȭ�� ���
	}
	class MyPanel extends JPanel{
		private ImageIcon icon =new ImageIcon("Back.jpg"); //�̹��� ���� �б�
		private Image img = icon.getImage(); //�̹��� ���� ����
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); //JPanel�� paintComponent() ȣ��
			int w = getWidth(); //�г��� ���� ������ ����
			int h= getHeight(); //�г��� ���̸� ������ ����
			int iw = img.getWidth(this); //�̹����� ���� ������ ����
			int ih = img.getHeight(this); //�̹����� ���̸� ������ ����
			g.drawImage(img,0,0,(w/2)-5,(h/2)-5,0,0,iw/2,ih/2,this); //4��� ������ ���� ���� ������ �гο��� (0,0)���� (�г��� ��/2-5,�г��� ����/2-5)�� ����
			g.drawImage(img,(w/2)+5,0,w,(h/2)-5,iw/2,0,iw,ih/2,this); //4��� ������ ������ ���� ������ �гο��� (�г��� ��/2+5,0)���� (�г��� ��,�г��� ����/2-5)�� ����
			g.drawImage(img,0,h/2+5,(w/2)-5,h,0,ih/2,iw/2,ih,this); //4��� ������ ���� �Ʒ��� ������ �гο��� (0,�г��� ����/2+5)���� (�г��� ��/2-5,�г��� ����)�� ����
			g.drawImage(img,w/2+5,h/2+5,w,h,iw/2,ih/2,iw,ih,this); //4��� ������ ������ �Ʒ��� ������ (�г��� ��/2+5,�г��� ����/2+5)���� (�г��� ��,�г��� ����)�� ����

		}
		
	}
	public static void main(String[] args) {
		new ImageTest();
	}

}
