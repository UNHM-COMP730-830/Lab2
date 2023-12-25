import javax.swing.ImageIcon;

public class Planet {

	// attributes
	private String name;
	private ImageIcon image;
	private double surfaceGravity;

	// constructor
	public Planet(String name, ImageIcon image, double surfaceGravity) {
		this.name = name;
		this.image = image;
		this.surfaceGravity = surfaceGravity;
	}
	
	
	public String getName() {
		return name;
	}
	
	public ImageIcon getImage() {
		return image;
	}
	
	public double getSurfaceGravity() {
		return surfaceGravity;
	}
	
	public double calculateWeight(double mass) {
		return mass * surfaceGravity;
	}
}
