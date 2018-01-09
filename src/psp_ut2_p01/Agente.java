package psp_ut2_p01;

public class Agente extends Thread {	
	
	private Mesa mesa;
		
	public Agente(Mesa mesa) {;
		this.mesa = mesa;
	}

	public void run() {	
		
		while(true){
			try{
				mesa.nuevosIngredientes();
				
			}catch (InterruptedException ex) {
				ex.printStackTrace();
			}			
		}		
	}
}
