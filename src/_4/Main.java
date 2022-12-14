package _4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		BufferedReader ficheroentrada = null;
		Scanner entrada = null;
		PrintWriter ficherosalida = null;

		try {
			ficheroentrada = new BufferedReader(new FileReader("src\\_4\\input.csv"));
			ficherosalida = new PrintWriter(new FileWriter("src\\_4\\output.txt"), false);
			entrada = new Scanner(ficheroentrada);
			entrada.useDelimiter("\s\n");
			double total = 0;
			double totalComisiones = 0;

			System.out.format("ACME %n");
			System.out.format("Total ventas del mes de %s del %d %n", "enero", 2012);
			System.out.format("%n");

			System.out.format("%-8s%-12s%-16s%-16s%-10s%-11s %n", "ID", "Nombre", "Apellido1", "Apellido2", "Ventas",
					"Comision");

			System.out.format("%n");

			while (entrada.hasNext()) {
				String line = entrada.next();
				Scanner lineScanner = new Scanner(line);
				lineScanner.useDelimiter("\\s*;\\s*|\\s*\n\\s*");
				while (lineScanner.hasNext()) {
					int id = Integer.parseInt(lineScanner.next());
					String nombre = lineScanner.next();
					String ape1 = lineScanner.next();
					String ape2 = lineScanner.next();
					double importe = Double.parseDouble(lineScanner.next().replace(',', '.'));
					double comision = importe * 0.07;
					System.out.format("%04d    %-12s%-16s%-16s%8.2f €%9.2f €%n", id, nombre, ape1, ape2, importe,
							comision);
//					ficherosalida.format("%-15d%10.2f €%n", nombreArticulo, precio);
					total += importe;
					totalComisiones += comision;

				}

				lineScanner.close();

			}

			System.out.format("%-52s%8.2f €%9.2f €", "TOTALES", total, totalComisiones);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
