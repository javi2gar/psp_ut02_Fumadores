package psp_ut2_p01;

import java.util.ArrayList;

public class Mesa {
		
	private String ingrediente1;
	private String ingrediente2;
	private boolean mesaLibre = true;	

	public Mesa(String ingrediente1, String ingrediente2) {
		super();
		this.ingrediente1 = ingrediente1;
		this.ingrediente2 = ingrediente2;
	}

	public synchronized void nuevosIngredientes(String ingr) throws InterruptedException{
		
		if(ingrediente1.equals(ingr)||ingrediente2.equals(ingr)){
			wait();
		}else{
			System.out.println("Agente pone en la mesa " + ingr);
			notify();
		}		
	}
	
	public synchronized void quieroFumar(int id) throws InterruptedException{
		wait();
        System.out.println("Fumador " + id + " empieza a fumar");
        mesaLibre = false;
	}
	
	public synchronized void finFumar(int id){
		mesaLibre = true;
        System.out.println("Fumador " + id + " termina de fumar");
        notify();
	}

}
