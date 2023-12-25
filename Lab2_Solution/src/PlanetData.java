import javax.swing.ImageIcon;

public class PlanetData {
	
	private Planet[] data;
	
	PlanetData() {
		data = new Planet[] {
				new Planet("Mercury", new ImageIcon("../Lab2_Images/mercury.gif"), 0.377),
				new Planet("Venus",   new ImageIcon("../Lab2_Images/venus.gif"),   0.905),
				new Planet("Moon",    new ImageIcon("../Lab2_Images/moon.gif"),    0.1654),
				new Planet("Mars",    new ImageIcon("../Lab2_Images/mars.gif"),    0.379),
				new Planet("Jupiter", new ImageIcon("../Lab2_Images/jupiter.gif"), 2.528),
				new Planet("Saturn",  new ImageIcon("../Lab2_Images/saturn.gif"),  1.065),
				new Planet("Uranus",  new ImageIcon("../Lab2_Images/uranus.gif"),  0.886),
				new Planet("Neptune", new ImageIcon("../Lab2_Images/neptune.gif"), 1.137),
				new Planet("Pltuto",  new ImageIcon("../Lab2_Images/pluto.gif"),   0.063)
		};
	}
	
	public Planet[] getData() {
		return data;
	}
	
	public String[] getNameList() {
		String[] nameList = new String[data.length];
		for (int i = 0; i < data.length; i++) {
			nameList[i] = data[i].getName();
		}
		return nameList;
	}

}
