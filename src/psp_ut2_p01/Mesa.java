package psp_ut2_p01;

public class Mesa {

	private int id;
	private int ingr;
	private String nombreIngrediente;
	private boolean fumando = false;
	private boolean ingrMesa = false;

	public synchronized void nuevosIngredientes(int ingr) throws InterruptedException {

		while (fumando || ingrMesa) 
			wait();
			this.ingr = ingr;
			ingrMesa = true;
			if (ingr == 0) {
				nombreIngrediente = "tabaco";
			} else if (ingr == 1) {
				nombreIngrediente = "papel";
			} else {
				nombreIngrediente = "cerillas";
			}
			System.out.println("\n\nAgente pone en la mesa " + nombreIngrediente);
			notifyAll();
		
	}

	public synchronized void quieroFumar(int id) throws InterruptedException {

		while (!ingrMesa || fumando || ingr != id) 
			wait();
			System.out.println("Fumador   " + id + " empieza a fumar");		
		
		ingrMesa = false;
		fumando = true;
	}

	public synchronized void finFumar(int id) {
		fumando = false;
		System.out.println("Fumador   " + id + " termina de fumar");
		notifyAll();
	}

}
