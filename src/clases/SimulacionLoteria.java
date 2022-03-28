package clases;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import excepciones.NotInPrimitivaRange;
import excepciones.NotUpperCase;
import excepciones.NotValidQuinielaInput;

public class SimulacionLoteria {

	// Atributos
	private static Scanner teclado = new Scanner(System.in);
	private static ArrayList<Primitiva> listaPrimitivas = new ArrayList<Primitiva>();
	private static  ArrayList<Quiniela> listaQuinielas = new ArrayList<Quiniela>();

	// Getterse & Setters
	public static ArrayList<Primitiva> getListaPrimitivas() {
		return listaPrimitivas;
	}

	public static void setListaPrimitivas(ArrayList<Primitiva> listaPrimitivas) {
		SimulacionLoteria.listaPrimitivas = listaPrimitivas;
	}

	public static ArrayList<Quiniela> getListaQuinielas() {
		return listaQuinielas;
	}

	public static void setListaQuinielas(ArrayList<Quiniela> listaQuinielas) {
		SimulacionLoteria.listaQuinielas = listaQuinielas;
	}

	// Métodos
	public String realizarSimulacion() {
		System.out.println("Introduce el número de veces que deseas simular una primitiva: ");
		int numPrimitiva = Integer.parseInt(teclado.nextLine());

		System.out.println("Introduce el número de veces que deseas simular una quiniela: ");
		int numQuiniela = Integer.parseInt(teclado.nextLine());

		Random random = new Random();

		for (int i = 0; i < numPrimitiva; i++) {
			ArrayList<Integer> resultadoPrimitiva = new ArrayList<Integer>();
			for (int j = 1; j < 6; j++) {
				int randomNumber = random.nextInt(50 - 1) + 1;
				resultadoPrimitiva.add(randomNumber);
			}

			for (i = 0; i < listaPrimitivas.size(); i++) {
				if (listaPrimitivas.get(i).getListaNum().equals(resultadoPrimitiva)) {
					return "Has ganado una primitiva!";
				}
			}

		}

		for (int i = 0; i < numQuiniela; i++) {

			String resultadoQuiniela = "";

			for (int j = 1; j < 15; j++) {
				int randomNumber = random.nextInt(3 - 1) + 1;
				if (randomNumber == 1) {
					resultadoQuiniela += "1";
				} else if (randomNumber == 2) {
					resultadoQuiniela += "2";
				} else {
					resultadoQuiniela += "x";
				}
			}

			for (i = 0; i < listaQuinielas.size(); i++) {
				if (listaQuinielas.get(i).getResultados() == resultadoQuiniela) {
					return "Has ganado una quiniela!";
				}
			}
		}

		return "No has ganado nada...";

	}

	public static void main(String[] args) throws NotUpperCase, NotInPrimitivaRange, NotValidQuinielaInput {

		SimulacionLoteria simulador = new SimulacionLoteria();
		boolean salir = false;

		while (!salir) {
			System.out.println("1.-Crea apuesta primitiva");
			System.out.println("2.-Crea apuesta quiniela");
			System.out.println("3.-Realizar simulación");

			String choice = teclado.nextLine();

			switch (choice) {
			case "1":
				Primitiva.crearApuestaPrimitiva();
				break;
			case "2":
				Quiniela.crearApuestaQuiniela();
				break;
			case "3":
				System.out.println(simulador.realizarSimulacion());
				break;
			}
		}

	}

}
