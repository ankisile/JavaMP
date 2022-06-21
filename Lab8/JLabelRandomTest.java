import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JLabelRandomTest extends JFrame{
	public JLabelRandomTest(){
		setTitle("Random Labels"); //������ Ÿ��Ʋ �ޱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ������ ������ ���α׷��� �����ϵ��� ����
		
		Container c =getContentPane(); //����Ʈ ���� �˾Ƴ���.
		c.setLayout(null); //����Ʈ���� ��ġ������ ����
		
		for(int i=0;i<20;i++) { //20�� �ݺ�
			JLabel label =new JLabel(Integer.toString(i)); //�� ����. label�ȿ� ����(�ε�����)�� �������. ���ڷ� ���ڿ��� �����ؾ� �Ǳ� ������ Integer.toString(i)�� �̿��Ͽ� ���ڸ� ���ڿ��� �ٲ���
			label.setBackground(Color.BLUE); //label�� ������ �Ķ������� ����
			int x = (int)(Math.random()*200) + 50; //��ǥ�� x ��. 50~250������ ������ ��
			int y = (int)(Math.random()*200) + 50; //��ǥ�� y ��. 50~250������ ������ ��
			label.setLocation(x,y); //label�� ��ġ ����
			label.setSize(10,10); //label�� ũ�� 10x10���� ����
			label.setOpaque(true); //label�� ������ ���̵��� ��
			c.add(label); //label�� ����Ʈ �ҿ� ����
		}
		setSize(300,300); //�������� ũ�� 300x300
		setVisible(true); //ȭ�鿡 ������ ���
	}
	public static void main(String[] args) {
		new JLabelRandomTest();

	}

}
