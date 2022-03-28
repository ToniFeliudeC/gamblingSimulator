package clases;

import java.util.Scanner;

import excepciones.NotUpperCase;
import funciones.Funciones;

public abstract class Apuesta {

	//Atributos
	private static Scanner teclado = new Scanner(System.in);
	private String nombre;
	private String apellidos;
	private int numApuesta;
	private static int contador = 1;
	
	//Constructor vac�o
	public Apuesta() {
		this.numApuesta = contador++;
	}
	
	//Constructor completo
	public Apuesta(String nombre, String apellidos) throws NotUpperCase {
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.numApuesta = contador++;
	}
	
	//Constructor copia
	public Apuesta(Apuesta apuesta) {
		this.nombre = apuesta.nombre;
		this.apellidos = apuesta.apellidos;
		this.numApuesta = contador++;
	}

	//Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws NotUpperCase {
		if (!(Funciones.isStringUppercase(nombre))) {
			throw new NotUpperCase("ERROR: El nombre debe estar en may�scula.");
		}
		else {
			this.nombre = nombre;
		}
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) throws NotUpperCase {
		if (!(Funciones.isStringUppercase(apellidos))) {
			throw new NotUpperCase("ERROR: El apellido debe estar en may�scula.");
		}
		else {
			this.apellidos = apellidos;
		}
		this.apellidos = apellidos;
	}

	public int getNumApuesta() {
		return numApuesta;
	}

	public void setNumApuesta(int numApuesta) {
		this.numApuesta = numApuesta;
	}
	
	//M�todos
	public void mostrarApuesta() {
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Apellidos: " + this.apellidos);
		System.out.println("N�mero de apuesta: " + this.numApuesta);
	}
}
