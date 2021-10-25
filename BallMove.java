package test2;

import javax.swing.JOptionPane;

public class BallMove {
	
	BallDraw ball = new BallDraw();
	int coordX = 150;
	int coordY = 200;
	int ballWidth = 20;
	int ballHeight = 20;
	int panelWidth = BallDraw.panel.getWidth() - 15;
	int moveOnX = 1;
	int moveOnY = 1;
	int blockWidth = BallDraw.blockWidth + 10;
	int blockHeight = BallDraw.blockHeight + 5;
	int winCount;
	int health = 3;
	int win = 0;
	public static newThreadMove move;
	
	
	public void move() throws InterruptedException {
		
		move = new newThreadMove("�����������");
		move.thread.start();
	}
	
	public void perevirka() {
		/*...��������� ���������� �� ��� �� �������...*/
		if(coordY==300){		//���� ��� ����� �� ������ ����� ������
				if(((coordX-20) > BallDraw.stick.getX()-40) && ((coordX-20) < BallDraw.stick.getX()+50)){  //���� ��� �������� �� �����
					moveOnY *= (-1);
				} else {		//���� ��� ���������� � �� ���� ����
					if(health>0){		//���� ��� ���� �����, �� ������� ��������� � �������� �����
						health--;
						JOptionPane.showMessageDialog(null, "�� ���������� �����\n� ��� �������� ������:" + health);
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						moveOnY *= (-1);
						coordY = 250;
					}
					else {		//���� ����������� ����� ��������� ����
						win = 2;
						return;
						
					}
				}
		}
		else if(coordY==0){		//���� �������� �� ������� ����� ������
			moveOnY *= (-1);
		}
		else if(coordX==5 || coordX == panelWidth){		//���� �������� �� ����� ��� ������ ������� ������
			moveOnX *= (-1);
		}
		else {
		/*...��������� ���������� �� ��� � ����������...*/
			winCount = 0;
			for(int i=0;i<BallDraw.blockArray.length-1;i++){
				for(int j=0;j<BallDraw.blockArray[i].length-1;j++){
					if(BallDraw.blockArray[i][j]!=null){
						if(BallDraw.blockArray[i][j].getY()<(coordY+blockHeight) && BallDraw.blockArray[i][j].getY()>(coordY-blockHeight)){
							if(BallDraw.blockArray[i][j].getX()<(coordX+blockWidth) && BallDraw.blockArray[i][j].getX()>(coordX-blockWidth)){
								if(BallDraw.blockArray[i][j].getY()<(coordY+10) && BallDraw.blockArray[i][j].getY()>(coordY-10)) {
									moveOnX *= (-1);
								}
								else {
									moveOnY *= (-1);
								}
								BallDraw.panel.remove(BallDraw.blockArray[i][j]);
								BallDraw.blockArray[i][j] = null;
								BallDraw.panel.repaint();
								break;
							}
						}
						winCount++;
					}
				}
			}
			if(winCount==0){
				win = 1;
			}
		}
	}
}
