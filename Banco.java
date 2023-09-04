import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

class Banco {
	int NUM_CAJAS = 4;
    private Queue<Cliente> colaClientes = new LinkedList<>();
    private Timer cronometro = new Timer();

    public void recibirClientes(Cliente cliente) {
        colaClientes.offer(cliente);
    }

    public void atenderClientes() {
    	for (int a = 1; a <= NUM_CAJAS; a++) {
            int x = a;
            int time = randomTime();
    		TimerTask tareaCaja = new TimerTask() {
                public void run() {
                    Cliente cliente = colaClientes.poll();
                    if (cliente != null) {
                        System.out.println("Caja " + x + ": Cliente " + cliente.getId() + " atendido en " + time + " minutos");
                    }
                }
            };
            cronometro.schedule(tareaCaja, 0, time*500);
        }
    	
    }

    public void cerrar() {
        cronometro.cancel();
    }
    
    public static int randomTime() {
    	Random randomTime = new Random();
    	int numRandom = randomTime.nextInt(11);
    	if(numRandom == 0) {
    		numRandom++;
    	}
    	return numRandom;
    }
}

class Cliente {
    private int id;

    public Cliente(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

