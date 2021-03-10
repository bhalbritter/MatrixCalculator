package aufgabenblatt1;

public abstract class Matrix {

	public abstract void Init();
	
	public abstract void Print();
	
	public abstract void Input();
	
	public abstract void RandomFill();
	
	public abstract MyMatrix Add(MyMatrix m);
	
	public abstract MyMatrix Sub(MyMatrix m);
	
	public abstract MyMatrix Mult(MyMatrix m);
}
