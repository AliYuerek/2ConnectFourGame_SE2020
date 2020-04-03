package VG;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.paint.Color;

public class VGModel {
	
	protected VGView view;
	protected static int p;
	protected BooleanProperty spielEnde = new SimpleBooleanProperty(false);
	protected BooleanProperty tie = new SimpleBooleanProperty(false);
	protected int id = 0;
	
	public VGModel(VGView view) {
		this.view = view;
	}
	
	public boolean wol() {
		if(!this.spielEnde.getValue()) {
		for(int i = 0; i <= 2; i++)
			for(int j = 0; j <= 6; j++) {
				if((view.circle[i][j].getE().getFill() == Color.YELLOW) && (view.circle[i+1][j].getE().getFill()
						== Color.YELLOW) && 
						(view.circle[i+2][j].getE().getFill() == Color.YELLOW) &&
						(view.circle[i+3][j].getE().getFill() == Color.YELLOW)) {
					System.out.println("Spieler "+2+" gewonnen");
					this.id = 2;
					this.spielEnde.setValue(true);
				}
					if((view.circle[i][j].getE().getFill() == Color.RED) && (view.circle[i+1][j].getE().getFill()
							== Color.RED) && 
							(view.circle[i+2][j].getE().getFill() == Color.RED) &&
							(view.circle[i+3][j].getE().getFill() == Color.RED)) {
						System.out.println("Spieler "+1+" gewonnen");
						this.id = 1;
						this.spielEnde.setValue(true);
					
				}
			}
		for(int i = 0; i <= 5; i++)
			for(int j = 0; j <= 3; j++) {
				if((view.circle[i][j].getE().getFill() == Color.YELLOW) && (view.circle[i][j+1].getE().getFill()
						== Color.YELLOW) && 
						(view.circle[i][j+2].getE().getFill() == Color.YELLOW) &&
						(view.circle[i][j+3].getE().getFill() == Color.YELLOW)) {
					System.out.println("Spieler "+2+" gewonnen");
					this.id = 2;
					this.spielEnde.setValue(true);
				}
					if((view.circle[i][j].getE().getFill() == Color.RED) && (view.circle[i][j+1].getE().getFill()
							== Color.RED) && 
							(view.circle[i][j+2].getE().getFill() == Color.RED) &&
							(view.circle[i][j+3].getE().getFill() == Color.RED)) {
						System.out.println("Spieler "+1+" gewonnen");
						this.id = 1;
						this.spielEnde.setValue(true);
					
				}
			}
		for(int i = 0; i <= 2; i++)
			for(int j = 0; j <= 3; j++) {
				if((view.circle[i][j].getE().getFill() == Color.YELLOW) && (view.circle[i+1][j+1].getE().getFill()
						== Color.YELLOW) && 
						(view.circle[i+2][j+2].getE().getFill() == Color.YELLOW) &&
						(view.circle[i+3][j+3].getE().getFill() == Color.YELLOW)) {
					System.out.println("Spieler "+2+" gewonnen");
					this.id = 2;
					this.spielEnde.setValue(true);
				}
					if((view.circle[i][j].getE().getFill() == Color.RED) && (view.circle[i+1][j+1].getE().getFill()
							== Color.RED) && 
							(view.circle[i+2][j+2].getE().getFill() == Color.RED) &&
							(view.circle[i+3][j+3].getE().getFill() == Color.RED)) {
						System.out.println("Spieler "+1+" gewonnen");
						this.id = 1;
						this.spielEnde.setValue(true);
					
				}
			}
		for(int i = 0; i < 3; i++)
			for(int j = 6; j > 2; j--) {
				if((view.circle[i][j].getE().getFill() == Color.YELLOW) && (view.circle[i+1][j-1].getE().getFill()
						== Color.YELLOW) && 
						(view.circle[i+2][j-2].getE().getFill() == Color.YELLOW) &&
						(view.circle[i+3][j-3].getE().getFill() == Color.YELLOW)) {
					System.out.println("Spieler "+2+" gewonnen");
					this.id = 2;
					this.spielEnde.setValue(true);
				}
					if((view.circle[i][j].getE().getFill() == Color.RED) && (view.circle[i+1][j-1].getE().getFill()
							== Color.RED) && 
							(view.circle[i+2][j-2].getE().getFill() == Color.RED) &&
							(view.circle[i+3][j-3].getE().getFill() == Color.RED)) {
						System.out.println("Spieler "+1+" gewonnen");
						this.id = 1;
						this.spielEnde.setValue(true);
					
				}
			}
		}
		
		return spielEnde.getValue();
	}
	public boolean tie() {
		int num = 0;
		if(!this.tie.getValue()) {
			for(int i = 0; i < view.circle.length; i++) {
				for(int j = 0; j < view.circle[i].length; j++) {
					if(view.circle[i][j].getE().getFill() == Color.YELLOW || 
							view.circle[i][j].getE().getFill() == Color.RED) 
					num++;
					if(num == 42) {
						this.tie.setValue(true);
						System.out.println("TIE!!!");
						}
					}
				}
			}
		return tie.getValue();
	}
	
	public void Spielerwechsel() {
		if(this.p==1) {
			this.p=2;
		}else {
			this.p=1;
		}
	}
	public int getSpieler() {
		return this.p;
	}
}
