package VG;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class VGController {
	
	protected VGModel model;
	protected VGView view;
	
	public VGController(VGModel model, VGView view) {
		this.model = model;
		this.view = view;
		
		view.menu.exit.setOnAction((e) -> {
			Platform.exit();
		});	
		view.menu.infoM.setOnAction((e) ->{
			view.getStage().setScene(view.scene2);
			view.getStage().centerOnScreen();
		});
		view.b2.setOnAction((e) ->{
			view.getStage().setScene(view.scene);
			view.getStage().centerOnScreen();
		});
		view.b3.setOnAction((e) ->{
			view.getStage().setScene(view.scene);
			view.getStage().centerOnScreen();
		});
		view.pf1.textProperty().addListener((observable, oldVale, newValue)->{
			view.s2.setText(newValue);
			view.info.setText("It's "+view.s2.getText()+"'s turn.");
		});
		view.pf2.textProperty().addListener((observable, oldVale, newValue)->{
			view.s1.setText(newValue);
		});
		
		
		model.spielEnde.addListener((observable, oldValue, newValue) ->{
			if(newValue) {
				view.getStage().setScene(view.scene4);
				
				String s = (model.id == 1 ? view.s1.getText() : view.s2.getText());
				//String spieler2 = view.s1.getText(); 
				//String spieler1 = view.s2.getText();	 
				view.pl1.setText(s+" has lost the game. Please quit the game.");

				
				view.b4.setOnAction(e ->{
					Platform.exit();
				});
				view.getStage().centerOnScreen();
				
			}
		});
		
		model.tie.addListener((observable, oldValue, newValue) ->{
			if(newValue) {
				view.getStage().setScene(view.scene4);
				
				view.pl1.setText("Tie! Nobody has won. Please quit the game.");

				
				view.b4.setOnAction(e ->{
					Platform.exit();
				});
				view.getStage().centerOnScreen();
				
			}
		});
		
		for(int i = 0; i < view.Z.getValue(); i++) {
			for(int j = 0; j < view.S.getValue(); j++) {
				view.circle[i][j].setOnMouseClicked((e)->{
					process3(e); //Circle
				});
			}
		}
		
	}

	private void process3(MouseEvent e) {
		Elli c = (Elli) e.getSource();
		boolean found = false;
		boolean found2 = false;
		if(c.getE().getFill() == Color.RED || c.getE().getFill() == Color.YELLOW) {
			found = true;
			found2 = true; 
		}
			
		if(model.p==1) {
			view.info2.setText("");
			found = false;
			if(c.getE().getFill() == Color.LIGHTGRAY) {
				for(int i = 0; i < 6; i++) {
					for(int j = 0; j < 7; j++) {
						int x = view.circle[i][j].getEID();
						if((c.getEID() + 7) == x) {
							if(view.circle[i][j].getE().getFill() == Color.LIGHTGRAY) {
								view.info2.setText("Incorrect input of "+view.s2.getText()+". "+view.s1.getText()+" is in turn.");
								found = true;
						} 
					}
				}
			}
		}
			if(c.getE().getFill() == Color.LIGHTGRAY && !found) {
				c.getE().setDisable(true);
				c.getE().setFill(Color.RED);
				c.setEID(1);
				System.out.println(model.p);
				view.info.setText("It's "+view.s1.getText()+"'s turn.");
		}
	}
		
		if(model.p==2) {
			found2 = false;
			view.info2.setText("");
			if(c.getE().getFill() == Color.LIGHTGRAY) {
				for(int i = 0; i < 6; i++) {
					for(int j = 0; j < 7; j++) {
						int x = view.circle[i][j].getEID();
						if((c.getEID() + 7) == x) {
							if(view.circle[i][j].getE().getFill() == Color.LIGHTGRAY) {
								view.info2.setText("Incorrect input of "+view.s1.getText()+". "+view.s2.getText()+" is in turn.");
								found2 = true;
						} 
					}
				}
			}
		}
			if(c.getE().getFill() == Color.LIGHTGRAY && !found2) {
				c.getE().setDisable(true);
				c.getE().setFill(Color.YELLOW);	
				c.setEID(2);
				System.out.println(model.p);
				view.info.setText("It's "+view.s2.getText()+"'s turn.");			}
		}
		model.Spielerwechsel();
		model.wol();
		model.tie();
		}
}
