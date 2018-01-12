package psp_ut2_p01;

public class Main {

	public static void main(String[] args) {

		Mesa mesa = new Mesa();
		Agente agente = new Agente(mesa);
		Fumador[] fumador = new Fumador[3];

		for (int i = 0; i < fumador.length; i++) {
			fumador[i] = new Fumador(i, mesa);
		}
		agente.start();
		for (int i = 0; i < fumador.length; i++) {
			fumador[i].start();
		}

	}
}
