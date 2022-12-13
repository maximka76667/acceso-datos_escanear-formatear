package _4;

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
			ficheroentrada = new BufferedReader(new FileReader("src\\_4\\input.csv"));
			entrada = new Scanner(ficheroentrada);
			entrada.useDelimiter("\s\n");
			int total = 0;
			while (entrada.hasNext()) {
				String line = entrada.next();
				Scanner lineScanner = new Scanner(line);
				System.out.println(line);
				lineScanner.useDelimiter("\\s*;\\s*|\\s*\n\\s*");
				while (lineScanner.hasNext()) {
					int id = Integer.parseInt(lineScanner.next());
					String nombre = lineScanner.next();
					String ape1 = lineScanner.next();
					String ape2 = lineScanner.next();
					double importe = Double.parseDouble(lineScanner.next().replace(',', '.'));
					System.out.println(importe);
				}

				lineScanner.close();

			}

			System.out.println("TOTAL " + total);

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
