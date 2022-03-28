package funciones;

public class Funciones {

	// Métodos
	public static boolean isStringUppercase(String string) {
		// Convertimos la string a array
		char[] charArray = string.toCharArray();

		for (int i = 0; i < charArray.length; i++) {

			// Comprobamos que el caracter sea una letra
			if (Character.isLetter(charArray[i])) {

				// Si algún caracter no es maýuscula, devolvemos false
				if (!Character.isUpperCase(charArray[i]))
					return false;
			}
		}

		return true;
	}
}
