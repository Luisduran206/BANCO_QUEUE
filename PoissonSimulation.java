import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

////LUIS DURÁN FLORES  - 177406 E IKER ISLA TORRE - (ID)

public class PoissonSimulation {

    private static final double LAMBDA = 5;
    private static final int NUMERO_DE_CAJAS = 4;

    public static void atenderClientesEnCajas(Queue<Integer> fila, int[] clientesAtendidosPorCaja) {
        int[] tiemposAtencion = new int[NUMERO_DE_CAJAS];
        Random random = new Random();

        while (!fila.isEmpty())
        {
            int cajaMasRapida = nextCaja(tiemposAtencion);

            if (cajaMasRapida != -1)
            {
                Integer clienteAtendido = fila.poll();
                int tiempoAtencion = randomTime(); 

                System.out.println("Cliente " + clienteAtendido + " está siendo atendido en la caja " + (cajaMasRapida + 1) + ". Atendido en " + tiempoAtencion + " minutos");
                tiemposAtencion[cajaMasRapida] += tiempoAtencion;

                clientesAtendidosPorCaja[cajaMasRapida]++;
            }

        }
    }

    public static int nextCaja(int[] tiemposAtencion) 
    {
        int cajaMasRapida = -1;
        int tiempoMasCorto = Integer.MAX_VALUE;

        for (int i = 0; i < NUMERO_DE_CAJAS; i++)
        {
            if (tiemposAtencion[i] < tiempoMasCorto)
            {
                tiempoMasCorto = tiemposAtencion[i];
                cajaMasRapida = i;
            }
        }

        return cajaMasRapida;
    }

    public static void main(String[] args) 
    {
        Queue<Integer> fila = new LinkedList<>(); 
        int[] clientesAtendidosPorCaja = new int[NUMERO_DE_CAJAS]; 

        for (int i = 0; i < 8; i++) 
        { 
            int arrivals = poissonRandom(LAMBDA);
            System.out.println("\nEn la hora " + (i + 1) + ", llegaron " + arrivals + " clientes.");
            for (int j = 1; j <= arrivals; j++)
            {
                fila.add(j);
            }
            System.out.println(fila);
            atenderClientesEnCajas(fila, clientesAtendidosPorCaja);
        }

        for (int i = 0; i < NUMERO_DE_CAJAS; i++) 
        {
            System.out.println("Caja " + (i + 1) + " atendió a " + clientesAtendidosPorCaja[i] + " clientes.");
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
