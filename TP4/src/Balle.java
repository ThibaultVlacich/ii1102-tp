
public class Balle {
	
	private double masse;
	
	private double x;
	private double y;
	private double vx;
	private double vy;
	
	public Balle(double[] pos0, double[] v0, double masse_) {
		masse = masse_;
		
		x = pos0[0];
		y = pos0[1];
		
		vx = v0[0];
		vy = v0[1];
	}
	
	public void move(double pas, double G) {
		double posx = this.getPosx();
		double posy = this.getPosy();
		double instantSpeed = this.getInstantSpeed();
		
		this.setInstantSpeed(instantSpeed + G * pas);
		this.setPosy(posy - this.getInstantSpeed() * pas);
	}
	
	public void draw() {
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledCircle(x, y, 20);
		StdDraw.show(50);
	}
	
	public double[] getInstantSpeed() {
		double[] instantSpeed = {vx, vy};
		
		return instantSpeed;
	}

	public void setInstantSpeed(double[] instantSpeed) {
		this.vx = instantSpeed[0];
		this.vy = instantSpeed[1];
	}

	public double getPosx() {
		return x;
	}

	public void setPosx(double posx) {
		this.x = posx;
	}

	public double getPosy() {
		return y;
	}

	public void setPosy(double posy) {
		this.y = posy;
	}
	
}
