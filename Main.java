
public class Main {
	    public static void main(String[] args) {
	        Banco banco = new Banco();
	        final double LAMBDA = 5;
	        
	        System.out.println("\tREGISTRO DE LLEGADAS AL BANCO:");
	        for (int i = 1; i <= 8; i++) {
	            System.out.println("En la hora " + i + ":");
	            int arrivals = poissonRandom(LAMBDA);
	            System.out.println("Llegaron " + arrivals + " clientes al banco.");

	            for (int j = 1; j <= arrivals; j++) {
	                banco.recibirClientes(new Cliente(j));
	            }

	            banco.atenderClientes();

	            try {
	                Thread.sleep(6000); 
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }

	        banco.cerrar();
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
