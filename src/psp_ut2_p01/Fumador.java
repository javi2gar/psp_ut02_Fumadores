package psp_ut2_p01;

import java.util.Random;

public class Fumador extends Thread {

	private Mesa mesa;
	private int id;
	private Random r = new Random();

	public Fumador(int id, Mesa mesa) {
		this.id = id;
		this.mesa = mesa;
	}

	public void run() {

		while (true) {
			try {
				mesa.quieroFumar(id);
				Thread.sleep(r.nextInt(4000));
				mesa.finFumar(id);
				Thread.sleep(r.nextInt(4000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}