package clases;


import java.util.Scanner;

import excepciones.NotUpperCase;
import excepciones.NotValidQuinielaInput;

public class Quiniela extends Apuesta {

	//Atributos
	private static Scanner teclado = new Scanner(System.in);
	private String resultados = "";
	
	//Constructor vacío
	public Quiniela() {
		super();
	}
	
	//Getters & Setters
	public String getResultados() {
		return resultados;
	}



	public void setResultados(String resultados) {
		this.resultados = resultados;
	}



	//Métodos
	public void mostrarApuesta() {
		super.mostrarApuesta();
		System.out.println("Resultados: " + this.resultados);

	}
	
	public static void crearApuestaQuiniela() throws NotUpperCase, NotValidQuinielaInput {
		
		Quiniela nuevaQuiniela = new Quiniela();
		
		System.out.println("Introduce tu nombre en mayúsuculas: ");
		nuevaQuiniela.setNombre(teclado.nextLine());
		
		System.out.println("Introduce tus apellidos en mayúsculas: ");
		nuevaQuiniela.setApellidos(teclado.nextLine());
		
		System.out.println("Introduce los resultados de los 15 partidos de uno en uno:");
		System.out.println("Gana local: 1");
		System.out.println("Empate: x");
		System.out.println("Gana visitante: 2");
		
		for (int i = 0; i < 15; i++) {			
			System.out.println("Partido " + (i+1) + ":");
			String caracter = teclado.nextLine();
			if (caracter.equals("1") || caracter.equals("x") || caracter.equals("2")) {
				nuevaQuiniela.setResultados(nuevaQuiniela.getResultados() + caracter);
			}
			else {
				throw new NotValidQuinielaInput("ERROR: Cada resultado debe ser: '1', '2' o 'x'");
			}
		}
		
		SimulacionLoteria.getListaQuinielas().add(nuevaQuiniela);
		
	}
}
