import java.util.Scanner;

public class EncriptadoCasero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);
		String mensaje;

		System.out.println("Dame un mensaje para encriptar");
		mensaje = teclado.nextLine();

		System.out.println("Mensaje a cifrar: " + mensaje);
		System.out.println("");

		// PROCESO DE CIFRADO
		String cifrado = "";

		char encriptado[] = mensaje.toCharArray();
		char palabraEncriptada[] = new char[mensaje.length() * 2];

		for (int i = 0; i < encriptado.length; i++) {
			// Dependiendo de la posicion en la tabla ASCII, se mueve más o menos.

			if (encriptado[i] > 0 && encriptado[i] <= 64) {
				encriptado[i] = (char) ((int) encriptado[i] + 30);
			} else if (encriptado[i] > 64 && encriptado[i] <= 90) {
				encriptado[i] = (char) ((int) encriptado[i] + 31);
			} else if (encriptado[i] > 90 && encriptado[i] <= 126) {
				encriptado[i] = (char) ((int) encriptado[i] + 32);
			} else if (encriptado[i] > 126 && encriptado[i] <= 255) {
				encriptado[i] = (char) ((int) encriptado[i] + 33);
			}
		}

		// Y AHORA METO UNA LETRA ENTRE MEDIAS DE CADA CORRECTA

		for (int i = 0; i < encriptado.length; i++) {
			palabraEncriptada[i * 2] = encriptado[i];
		}

		for (int i = 0; i < palabraEncriptada.length; i++) {
			if (i % 2 != 0) {
				palabraEncriptada[i] = (char) ((i * 3) + 100);
			}
			cifrado += palabraEncriptada[i];
		}

		System.out.println("Mensaje encriptado: " + cifrado);
		System.out.println("");

		// -------------------------------------------------------------------------
		// PROCESO DE DESCIFRADO
		// -------------------------------------------------------------------------

		String descifrado = "";
		char desencriptado[] = cifrado.toCharArray();
		char palabraDesencriptada[] = new char[cifrado.length() / 2];

		for (int i = 0; i < desencriptado.length; i++) {

			if (desencriptado[i] > 30 && desencriptado[i] <= 94) {
				desencriptado[i] = (char) ((int) desencriptado[i] - 30);
			} else if (desencriptado[i] > 95 && desencriptado[i] <= 121) {
				desencriptado[i] = (char) ((int) desencriptado[i] - 31);
			} else if (desencriptado[i] > 121 && desencriptado[i] <= 158) {
				desencriptado[i] = (char) ((int) desencriptado[i] - 32);
			} else if (desencriptado[i] > 158 && desencriptado[i] <= 255) {
				desencriptado[i] = (char) ((int) desencriptado[i] - 33);
			}
		}

		for (int i = 0; i < desencriptado.length; i++) {
			if (i % 2 == 0) {
				descifrado += desencriptado[i];
			}

		}

		System.out.println("Palabra desencriptada: " + descifrado);
	}

}
