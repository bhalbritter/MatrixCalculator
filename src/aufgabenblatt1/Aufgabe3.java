package aufgabenblatt1;


import java.time.LocalDate;
import java.time.LocalTime;

public class Aufgabe3 {

	public static void main(String[] args) {
		
		MyMatrix matrix;
		MyMatrix matrix2;
		long startzeit;
		long endzeit;
		long benoetigteZeit;
		
		for(int i = 500; i <= 50000; i = i + 500) {
		
			
			matrix = new MyMatrix(i,i);
			matrix2 = new MyMatrix(i,i);
			
			matrix.RandomFill();
			matrix2.RandomFill();
						
			startzeit = new java.util.Date().getTime();
			
			matrix.Add(matrix2);
			
			endzeit = new java.util.Date().getTime();
			 
			benoetigteZeit = endzeit - startzeit;
			
			System.out.println("Addition von Matritzen der Form n x m = " + i + "\nBenötigte Zeit in Sekunden: " + (double) benoetigteZeit/1000);
			
			
			
		}
		
		
		//matrix2.RandomFill();
		//matrix.RandomFill();
		//matrix.Print();
		//matrix2.Print();
		
		
		//matrix.Mult(matrix2);
		
	}

}
