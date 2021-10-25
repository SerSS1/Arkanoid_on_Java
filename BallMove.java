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
		
		move = new newThreadMove("перемещение");
		move.thread.start();
	}
	
	public void perevirka() {
		/*...Проверяем столкнулся ли мяч со стенкой...*/
		if(coordY==300){		//Если мяч попал на нижнюю часть панели
				if(((coordX-20) > BallDraw.stick.getX()-40) && ((coordX-20) < BallDraw.stick.getX()+50)){  //Если мяч ударился об доску
					moveOnY *= (-1);
				} else {		//Если мяч пропустили и он упал вниз
					if(health>0){		//Если ещё есть жизни, то выводит сообщение и отнимает жизнь
						health--;
						JOptionPane.showMessageDialog(null, "Вы пропустили мячик\nУ вас осталось жизней:" + health);
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						moveOnY *= (-1);
						coordY = 250;
					}
					else {		//Если закончились жизни завершает игру
						win = 2;
						return;
						
					}
				}
		}
		else if(coordY==0){		//Если ударился об верхнюю часть панели
			moveOnY *= (-1);
		}
		else if(coordX==5 || coordX == panelWidth){		//Если ударился об левую или правую сторону панели
			moveOnX *= (-1);
		}
		else {
		/*...Проверяем столкнулся ли мяч с кирпичиком...*/
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
