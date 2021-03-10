package aufgabenblatt1;


public class Strassen {

	
	
	private static MyMatrix aufteilen (MyMatrix arr, int von_hoehe, int bis_hoehe ,int von_breite, int bis_breite){
		
		int lenght = arr.getLenght()/2;
		
		MyMatrix neu = new MyMatrix(lenght, lenght);
		int h = 0;
		int b = 0;
				
		for(int i = von_hoehe; i < bis_hoehe; i++) {
			for(int j = von_breite; j < bis_breite; j++) {
				  neu.setValue(h, b, arr.getValue(i, j));
				b++;
			}
			h++;
			b = 0;
		}
				
		return neu;
	}
	
	private static MyMatrix zusammenfuegen(MyMatrix o_1_1, MyMatrix o_1_2, MyMatrix o_2_1, MyMatrix o_2_2) {
		MyMatrix o = new MyMatrix((o_1_1.getHeight())*2, (o_1_1.getLenght())*2);
		
		for(int i = 0; i < o.getHeight(); i++) {
			for(int j = 0; j < o.getLenght(); j++) {
				if(j < o_1_1.getHeight() && i < o_1_1.getLenght()){
					o.setValue(i, j, o_1_1.getValue(i, j));
				}
				
				if(j >= o_1_1.getHeight() && i < o_1_1.getLenght()){
					o.setValue(i, j, o_1_2.getValue(i, j-o_1_1.getLenght()));
				}
				
				if(j < o_1_1.getHeight() && i >= o_1_1.getLenght()){
					o.setValue(i, j, o_2_1.getValue(i-o_1_1.getLenght(), j));
				}
				
				if(j >= o_1_1.getHeight() && i >= o_1_1.getLenght()){
					o.setValue(i, j, o_2_2.getValue(i-o_1_1.getHeight(), j-o_1_1.getLenght()));
				}
				
			}
		}
		
		return o;
	}
	
	private static MyMatrix strassen(MyMatrix m, MyMatrix n) {
		
		int groesse = m.getLenght();
		
		MyMatrix c = new MyMatrix(groesse, groesse);
		//512
		if (groesse <= 512){
			// standart multiplikation
			c = m.Mult(n);
		}else {
			
			MyMatrix m_1_1 = aufteilen(m, 0, groesse/2, 0, groesse/2);
			MyMatrix m_1_2 = aufteilen(m, 0, groesse/2,groesse/2, groesse);
			MyMatrix m_2_1 = aufteilen(m, groesse/2, groesse, 0, groesse/2);
			MyMatrix m_2_2 = aufteilen(m, groesse/2, groesse,  groesse/2, groesse);
			
			MyMatrix n_1_1 = aufteilen(n, 0, groesse/2, 0, groesse/2);
			MyMatrix n_1_2 = aufteilen(n, 0, groesse/2,groesse/2, groesse);
			MyMatrix n_2_1 = aufteilen(n, groesse/2, groesse, 0, groesse/2);
			MyMatrix n_2_2 = aufteilen(n, groesse/2, groesse,  groesse/2, groesse);
			
			MyMatrix h_1 = strassen(m_1_1.Add(m_2_2), n_1_1.Add(n_2_2));
			MyMatrix h_2 = strassen(m_2_1.Add(m_2_2), n_1_1);
			MyMatrix h_3 = strassen(m_1_1, n_1_2.Sub(n_2_2));
			MyMatrix h_4 = strassen(m_2_2, n_2_1.Sub(n_1_1));
			MyMatrix h_5 = strassen(m_1_1.Add(m_1_2), n_2_2);
			MyMatrix h_6 = strassen(m_2_1.Sub(m_1_1), n_1_1.Add(n_1_2));
			MyMatrix h_7 = strassen(m_1_2.Sub(m_2_2), n_2_1.Add(n_2_2));
			
			MyMatrix o_1_1 = ((h_1.Add(h_4)).Sub(h_5)).Add(h_7);
			MyMatrix o_1_2 = h_3.Add(h_5);
			MyMatrix o_2_1 = h_2.Add(h_4);
			MyMatrix o_2_2 = ((h_1.Sub(h_2)).Add(h_3)).Add(h_6);
			
			c = zusammenfuegen(o_1_1,o_1_2, o_2_1, o_2_2);
			
		}
		
		
		
		return c;
	}
	
	
	public static void main(String[] args) {

		double matrizengroesse = 15;
		int groesse = (int) Math.pow(2, matrizengroesse);
		
		
		MyMatrix m = new MyMatrix(groesse, groesse);
		MyMatrix n = new MyMatrix(groesse, groesse);
		MyMatrix c;
		
		m.RandomFill();
		n.RandomFill();
		
		m.Print();
		n.Print();
		
		c = strassen(m,n);
		
		c.Print();
		
	}

}
