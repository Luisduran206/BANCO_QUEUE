import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class CajasBanco extends Thread{

	Queue<Integer> list = new LinkedList<Integer>(); 
	int randomTime;
	
	public CajasBanco() {
	}
	
	public boolean Caja1(Queue<Integer> list, int randomTime) throws InterruptedException {
		//boolean isFree = true;
		
		try {
			Thread.sleep(randomTime * 500);
		} catch (InterruptedException e) {
            e.printStackTrace();
		}
		
		//return isFree;
		return true;
	}
	
	public boolean Caja2(Queue<Integer> list, int randomTime) throws InterruptedException {
		//boolean isFree = true;
		
		try {
			Thread.sleep(randomTime * 500);
		} catch (InterruptedException e) {
            e.printStackTrace();
		}
		
		//return isFree;
		return true;
	}
	
	public boolean Caja3(Queue<Integer> list, int randomTime) throws InterruptedException {
		//boolean isFree = true;
		
		try {
			Thread.sleep(randomTime * 500);
		} catch (InterruptedException e) {
            e.printStackTrace();
		}
		
		//return isFree;
		return true;
	}
	
	public boolean Caja4(Queue<Integer> list, int randomTime) throws InterruptedException {
		//boolean isFree = true;
		
		try {
			Thread.sleep(randomTime * 500);
		} catch (InterruptedException e) {
            e.printStackTrace();
		}
		
		//return isFree;
		return true;
	}
}
