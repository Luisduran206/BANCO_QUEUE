import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

////LUIS DURÁN FLORES  - 177406 E IKER ISLA TORRE - (ID)

public class PoissonSimulation extends Thread{
    
    private static final double LAMBDA = 5;
    
    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> list = new LinkedList<Integer>(); 
        CajasBanco caja1 = new CajasBanco();
        CajasBanco caja2 = new CajasBanco();
        CajasBanco caja3 = new CajasBanco();
        CajasBanco caja4 = new CajasBanco();
        
    	for (int i = 0; i < 8; i++) {
    		int tiempoHora = 0;
    		int arrivals = poissonRandom(LAMBDA);
    		System.out.println("En la hora " + (i + 1) + ", llegaron " + arrivals + " clientes.");
    		
    		for(int j = 1; j <= arrivals; j++) {
            	list.add(j);
            }
    		
    		for(int x = 1; x <= arrivals; x++) {
    			int random = randomTime();
    			int cliente = list.poll();
            	if(caja1.Caja1(list, random)) {
            		tiempoHora += random;
            		System.out.println("Se atendió al cliente " + cliente + " en la Caja1 y se tardó " + random + " minutos");
            		continue;
            	}else {
            		if(caja2.Caja2(list, random)) {
                		tiempoHora += random;
                		System.out.println("Se atendió al cliente " + cliente + " en la Caja2 y se tardó " + random + "minutos");
                		continue;
                	} else {
                		if(caja3.Caja3(list, random)) {
                    		tiempoHora += random;
                    		System.out.println("Se atendió al cliente " + cliente + " en la Caja3 y se tardó " + random + "minutos");
                    		continue;
                    	} else {
                    		if(caja4.Caja4(list, random)) {
                        		tiempoHora += random;
                        		System.out.println("Se atendió al cliente " + cliente + " en la Caja4 y se tardó " + random + "minutos");
                        		continue;
                        	}
                    	}
                	}
            	}
            	try {
        			Thread.sleep(700);
        		} catch (InterruptedException e) {
                    e.printStackTrace();
        		}
    		}
        	
    		System.out.println("El tiempo en atender a todos fue de: " + tiempoHora + " minutos");
            //System.out.println(list);
    		list.clear();
    		
        }
    }
    
    public static int randomTime() {
    	Random randomTime = new Random();
    	int numRandom = randomTime.nextInt(11);
    	if(numRandom == 0) {
    		numRandom++;
    	}
    	return numRandom;
    }
    
    public static int poissonRandom(double lambda) {
        int k = 0;
        double p = 1.0;
        double expLambda = Math.exp(-lambda);
        do {
            k++;
            p *= Math.random();
        } while (p >= expLambda);
        
        return k - 1;
    }
}