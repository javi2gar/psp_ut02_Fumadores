package psp_ut2_p01;

import java.util.Random;

public class Agente extends Thread {

	private Mesa mesa;
	private Random r = new Random();

	public Agente(Mesa mesa) {
		this.mesa = mesa;
	}

	public void run() {

		while (true) {
			int ingrediente = r.nextInt(3);
			try {
				Thread.sleep(r.nextInt(4000));
				mesa.nuevosIngredientes(ingrediente);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
