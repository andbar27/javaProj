
public class TriangoloRettangolo {
	private double cat1;
	private double cat2;
	private double hyp;
	private double area;
	private double perimetro;
	
	public double getCat1() {
		return cat1;
	}
	public void setCat1(double cat1) {
		this.cat1 = cat1;
		
		updateFunctionalRelactionship();
	}
	public double getCat2() {
		return cat2;
	}
	public void setCat2(double cat2) {
		this.cat2 = cat2;
		
		updateFunctionalRelactionship();
	}
	public double getHyp() {
		return hyp;
	}
	public double getArea() {
		return area;
	}
	public double getPerimetro() {
		return perimetro;
	}
	private void updateFunctionalRelactionship() {
		hyp = Math.sqrt(cat1*cat1 + cat2*cat2);
		perimetro = cat1 + cat2 + hyp;
		area = cat1*cat2/2;
	}
	
	public TriangoloRettangolo(int cat1, int cat2) {
		super();
		this.cat1 = cat1;
		this.cat2 = cat2;
		
		updateFunctionalRelactionship();
		
	}
	@Override
	public String toString() {
		return "Triangolo Rettangolo [cat1=" + cat1 + ", cat2=" + cat2 + ", hyp=" + hyp + ", area=" + area
				+ ", perimetro=" + perimetro + "]";
	}
	
	
	
	
	
}
