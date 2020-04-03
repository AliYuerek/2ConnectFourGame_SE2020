package VG;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Elli extends Label{
	
	protected Ellipse elli;
	protected int EID;
	
	public Elli(int id) {
		this.EID = id;
		
		this.elli = new Ellipse();
		this.elli.setRadiusX(37);
		this.elli.setRadiusY(37);
		this.elli.setFill(Color.LIGHTGRAY);
		this.setGraphic(elli);
	}
	public int getEID() {
		return EID;
	}
	public Ellipse getE() {
		return elli;
	}
	public void setEID(int n) {
		this.EID = n;
	}

}
