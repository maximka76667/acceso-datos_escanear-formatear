package _3;

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
			ficheroentrada = new BufferedReader(new FileReader("src\\_3\\input.txt"));
			entrada = new Scanner(ficheroentrada);
			entrada.useDelimiter("\\s\n");

			System.out.println("Articulo PVP Unidades Importe");

			int total = 0;
			while (entrada.hasNext()) {
				String line = entrada.next();
				Scanner lineScanner = new Scanner(line);
				lineScanner.useDelimiter("\\s*;\\s*|\\s*\n\\s*");
				while (lineScanner.hasNext()) {
					String articulo = lineScanner.next();
					Double pvp = Double.parseDouble(lineScanner.next());
					int unidades = Integer.parseInt(lineScanner.next());
					double importe = unidades * pvp;
					System.out.println(articulo + " " + pvp + " " + unidades + " " + importe);
					total += importe;
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
