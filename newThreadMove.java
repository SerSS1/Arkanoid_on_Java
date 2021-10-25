package test2;

import javax.swing.JOptionPane;

public class newThreadMove extends BallMove implements Runnable {		//Создаёт новый поток

	String name;
	Thread thread;
	
	public newThreadMove(String threadname) {		//Конструктор
		name = threadname;
		thread = new Thread(this, name);
	}
	
	public void run() {
		thread = Thread.currentThread();
		while(true){
			try {
				Thread.sleep(4);				//Скорость передвижения мячика
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(win==1){
				JOptionPane.showMessageDialog(null, "Вы выиграли!");
				return;
			}
			else if(win == 2){
				JOptionPane.showMessageDialog(null, "У вас закончились жизни.\nВы проиграли.");
				return;
			}
			else{						//Передвигаем мячик и проверяем не столкнулся ли он с чем то
				perevirka();
				coordX+=moveOnX;
				coordY+=moveOnY;
				BallDraw.ballImg.setLocation(coordX, coordY);
			}
			
		}
	}
}
