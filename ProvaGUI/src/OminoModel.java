
public class OminoModel {
	private int x, y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	public OminoModel() {
		x=0;
		y=300;
	}
	
	public void vaiAvanti() {
		x+=2;
	}
	
	public void salta() {
		y-=20;
	}
	
	public void ritornaGiu() {
		y+=20;
	}
	
}
