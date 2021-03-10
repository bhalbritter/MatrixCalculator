package aufgabenblatt1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyMatrix extends Matrix {

	private int[][] matrix;
	private int height;
	private int lenght;

	public MyMatrix(int m, int n) {
		this.matrix = new int[m][n];
		this.height = m;
		this.lenght = n;
	}

	@Override
	public void Init() {

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < lenght; j++) {
				matrix[i][j] = 0;
			}
		}

	}

	@Override
	public void Print() {

		System.out.println("\n");
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < lenght; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}

	@Override
	public void Input() {
		System.out.println("\nBitte die werte der Matrix reihenweise einlesen:");
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < lenght; j++) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String name = "0";
				try {
					name = reader.readLine();
				} catch (IOException e) {
					System.err.println("Fehler beim Einlesen!!");
					return;
				}
				if (name.equals("")) {
					name = "0";
				}
				matrix[i][j] = Integer.parseInt(name);
				Print();
			}
		}

	}

	@Override
	public void RandomFill() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < lenght; j++) {
				matrix[i][j] = (int) ((Math.random()) * 10 + 1);
			}
		}

	}
	
	@Override
	public MyMatrix Sub(MyMatrix m) {
		MyMatrix c = new MyMatrix(m.getHeight(), m.getLenght());
		int wert = 0;
		if (height == m.getHeight() && lenght == m.getLenght()) {

			for (int i = 0; i < m.lenght; i++) {
				for (int j = 0; j < m.height; j++) {

					wert = this.matrix[i][j] - m.matrix[i][j];
				c.setValue(i, j, wert);	

				}

				//System.out.println();
			}

		} else {
			System.out.println("Diese Matrizen sind nicht addierbar");
		}
		
		return c;
	}

	@Override
	public MyMatrix Add(MyMatrix m) {
		//System.out.println("\nAddiert:\n ");

		MyMatrix c = new MyMatrix(m.getHeight(), m.getLenght());
		int wert = 0;
		if (height == m.getHeight() && lenght == m.getLenght()) {

			for (int i = 0; i < m.lenght; i++) {
				for (int j = 0; j < m.height; j++) {

					wert = this.matrix[i][j] + m.matrix[i][j];
				c.setValue(i, j, wert);	

				}

				//System.out.println();
			}

		} else {
			System.out.println("Diese Matrizen sind nicht addierbar");
		}
		
		return c;

	}

	@Override
	public MyMatrix Mult(MyMatrix m) {
		//System.out.println("\nMultipliziert:\n ");

		MyMatrix c = new MyMatrix(m.lenght, m.height);
		
		if (lenght == m.getHeight()) {

			int summe = 0;

			for (int k = 0; k < m.height; k++) {
				summe = 0;
				for (int i = 0; i < m.lenght; i++) {
					for (int j = 0; j < m.height; j++) {

						summe += matrix[k][j] * m.matrix[j][i];

					}
					c.setValue(k,i,summe);
					//System.out.print(summe + " ");
					summe = 0;
				}

				
			}
		} else {
			System.out.println("Diese Matrizen sind nicht multiplizierbar");
		}
		

		return c;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setValue(int h, int b, int wert) {
		this.matrix[h][b] = wert;
	}
	
	public int getValue(int h, int b) {
		return this.matrix[h][b];
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

}
