package _2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		BufferedReader ficheroentrada = null;
		Scanner entrada = null;

		try {
			ficheroentrada = new BufferedReader(new FileReader("src\\_2\\input.txt"));
			entrada = new Scanner(ficheroentrada);
			int suma = 0;
			while (entrada.hasNext()) {
				Scanner lineScanner = new Scanner(entrada.next());
				lineScanner.useDelimiter("\\s*");
				while (lineScanner.hasNext()) {
					int number = lineScanner.nextInt();
					System.out.println(number);
					suma += number;
				}

			}

			System.out.println("Suma = " + suma);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ficheroentrada.close();
				entrada.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
