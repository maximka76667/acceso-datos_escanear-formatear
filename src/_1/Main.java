package _1;

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
			ficheroentrada = new BufferedReader(new FileReader("src\\_1\\input.txt"));
			entrada = new Scanner(ficheroentrada);
			int count = 0;
			while (entrada.hasNext()) {
				Scanner lineScanner = new Scanner(entrada.next());
				while (lineScanner.hasNext()) {
					System.out.println(lineScanner.next());
					count++;
				}

			}

			System.out.println(count);

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
