package test2;

import javax.swing.JOptionPane;

public class newThreadMove extends BallMove implements Runnable {		//������ ����� �����

	String name;
	Thread thread;
	
	public newThreadMove(String threadname) {		//�����������
		name = threadname;
		thread = new Thread(this, name);
	}
	
	public void run() {
		thread = Thread.currentThread();
		while(true){
			try {
				Thread.sleep(4);				//�������� ������������ ������
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(win==1){
				JOptionPane.showMessageDialog(null, "�� ��������!");
				return;
			}
			else if(win == 2){
				JOptionPane.showMessageDialog(null, "� ��� ����������� �����.\n�� ���������.");
				return;
			}
			else{						//����������� ����� � ��������� �� ���������� �� �� � ��� ��
				perevirka();
				coordX+=moveOnX;
				coordY+=moveOnY;
				BallDraw.ballImg.setLocation(coordX, coordY);
			}
			
		}
	}
}
