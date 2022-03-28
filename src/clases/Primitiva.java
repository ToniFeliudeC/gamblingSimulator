package clases;

import java.util.ArrayList;
import java.util.Scanner;

import excepciones.NotInPrimitivaRange;
import excepciones.NotUpperCase;

public class Primitiva extends Apuesta {

	//Atributos
	private static Scanner teclado = new Scanner(System.in);
	private ArrayList<Integer> listaNum = new ArrayList<Integer>();
	private int aciertos = 0;
	
	//Constructor vacío
	public Primitiva() {
		super();
	}

	//Getters & Setters
	public ArrayList<Integer> getListaNum() {
		return listaNum;
	}

	public void setListaNum(ArrayList<Integer> listaNum) {
		this.listaNum = listaNum;
	}

	public int getAciertos() {
		return aciertos;
	}

	public void setAciertos(int aciertos) {
		this.aciertos = aciertos;
	}
	
	//Métodos
	public void mostrarApuesta() {
		super.mostrarApuesta();
		System.out.println("Lista de números: " + this.listaNum);
		System.out.println("Número de aciertos: " + this.aciertos);
	}
	
	public static void crearApuestaPrimitiva() throws NotUpperCase, NotInPrimitivaRange {
		
		Primitiva nuevaPrimitiva = new Primitiva();
		
		System.out.println("Introduce tu nombre en mayúsculas:");
		nuevaPrimitiva.setNombre(teclado.nextLine());
		
		System.out.println("Introduce tus apellidos en mayúsculas: ");
		nuevaPrimitiva.setApellidos(teclado.nextLine());
		
		System.out.println("Introduce uno a uno, los 6 números de tu primitiva: ");
		for (int i = 0; i < 6; i++) {
			System.out.println("Número " + (i+1) + ":");
			int numero = Integer.parseInt(teclado.nextLine());
			if (numero >= 1 && numero <= 49) {
				nuevaPrimitiva.getListaNum().add(numero);
			}
			else {
				throw new NotInPrimitivaRange("ERROR: Cada número debe ser mayor que 0 y menor que 50.");
			}
		}
		
		SimulacionLoteria.getListaPrimitivas().add(nuevaPrimitiva);
		
		
	}
	
	
}
