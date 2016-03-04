
public class Balle {
	private double rayon = 2;
	
	private double x;
	private double y;
	private double vx;
	private double vy;
	
	/**
	 * Constructeur de la classe Balle
	 * 
	 * @param 	double[]	pos0	Position initiale de la balle
	 * @param 	double[]	v0		Vitesse initiale de la balle
	 * @param	double		rayon	Rayon de la balle
	 */
	public Balle(double[] pos0, double[] v0, double rayon) {
		this.rayon = rayon;
		
		this.x = pos0[0];
		this.y = pos0[1];
		
		this.vx = v0[0];
		this.vy = v0[1];
	}
	
	/**
	 * Permet de calculer la nouvelle position de la balle
	 * 
	 * @param 	Espace	espace
	 * @param 	double	pas
	 */
	public void move(Espace espace, double pas) {
		//this.vx = constante
		this.vy += espace.G * pas;
			
		this.x += this.vx * pas;
		this.y += - this.vy * pas - 0.5 * espace.G * pas;
		
		if ((this.y - this.rayon) <= 0 || (this.y + this.rayon) >= espace.getHauteur()) {
			
			if((this.y - this.rayon) <=0)
				this.y = this.rayon; 
			else
				this.y = espace.getHauteur() - this.rayon;
			
			this.vy = -this.vy;
		}
		
		if ((this.x - this.rayon) <= 0.0 || (this.x + this.rayon) >= espace.getLongueur()) {
			if((this.x - this.rayon) <= 0)
				this.x = this.rayon;
			else
				this.x = espace.getLongueur() - this.rayon;	
			this.vx = -this.vx;
		}
	}
	
	/**
	 * Permet de dessiner la balle
	 */
	public void draw() {
		StdDraw.clear(StdDraw.GRAY);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledCircle(x, y, this.rayon);
		StdDraw.show(50);
	}

	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
		this.vy = vy;
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
