package VG;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VGView {
	
	protected VGModel model;
	protected Stage stage;
	protected static IntegerProperty Z = new SimpleIntegerProperty(6);
	protected static IntegerProperty S = new SimpleIntegerProperty(7);
	protected static Elli [] [] circle = new Elli [Z.getValue()][S.getValue()];
	protected MenuM menu;
	protected Scene scene1, scene, scene2, scene4;
	protected Button b2;
	protected Button b3;
	protected Button b4;
	protected TextField pf1;
	protected TextField pf2;
	protected TextField pf3;
	protected TextField pf4;
	protected Label s1;
	protected Label s2;
	protected Label info;
	protected Label info2;
	protected Label pl1; 
	protected int i = 1;
	
	public VGView(VGModel model, Stage stage) {
		this.model = model;
		this.stage = stage;
		
		for(int i = 0; i < Z.getValue(); i++) {
			for(int j = 0; j < S.getValue(); j++) {
				circle[i][j] = new Elli(this.i);
				this.i++;
			}
		}
		GridPane g = new GridPane();
		g.getStyleClass().add("gbox");
		for(int i = 0; i < Z.getValue(); i++) {
			for(int j = 0; j < S.getValue(); j++) {
				g.add(circle[i][j], j, i);
				System.out.println(circle[i][j].getEID());
			}
		}	
		menu = new MenuM();
		menu.menuM.getStyleClass().add("menuM");
		menu.getStyleClass().add("menu");
	
		BorderPane pane = new BorderPane();
		pane.setCenter(g);
		pane.setLeft(leftpane());
		pane.setRight(rightpane());
		pane.setTop(menu);
		pane.setBottom(bottompane());
		scene = new Scene(pane);
		
		scene1 = new Scene(pane3(), 500, 500);
		scene4 = new Scene(pane4(), 500, 500);
		
		BorderPane pane2 = new BorderPane();
		pane2.setCenter(zweiteBox());
		scene2= new Scene(pane2, 500, 500);
		
		stage.setResizable(false);
		scene1.getStylesheets().add(getClass().getResource("VG.css").toExternalForm());
		scene.getStylesheets().add(getClass().getResource("VG.css").toExternalForm());
		scene2.getStylesheets().add(getClass().getResource("VG.css").toExternalForm());
		scene4.getStylesheets().add(getClass().getResource("VG.css").toExternalForm());
		stage.setScene(scene1);
		stage.setX(100);
		stage.setY(100);
		stage.setTitle("Connect four");
		stage.centerOnScreen();
	}
	public Pane pane3() {
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(25, 25, 25, 25));
		
		Label pl1 = new Label("Name of Player 1:");
		Label pl2 = new Label("Name of Player 2:");
		
		pane.add(pl1, 0, 0);
		pane.add(pl2, 0, 1);

		this.pf1 = new TextField();
		this.pf2 = new TextField();
		this.b3 = new Button("Start game");
		Label d = new Label();
		d.setText("This is a mini project for the Software Engineering\" module.\n Attention: The game can be addictive!");
		d.getStyleClass().add("d");
		
		Region r = new Region();
		
		pane.add(pf1, 1, 0);
		pane.add(pf2, 1, 1);
		pane.add(this.b3, 1, 4);
		pane.add(r, 1, 5);
		pane.add(d, 0, 6, 2, 6);

		pane.getStyleClass().add("bboxx");
		pl1.getStyleClass().add("bboxx");
		pl2.getStyleClass().add("bboxx");
		this.b3.getStyleClass().add("bboxxB");
		return pane;
	}
	public Pane pane4() {
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(25, 25, 25, 25));
		
		this.pl1 = new Label();

		this.b4 = new Button("Quit game");
		pane.add(this.pl1, 0, 0);
		pane.add(this.b4, 1, 0);
		
		pane.getStyleClass().add("bboxx2");
		this.pl1.getStyleClass().add("bboxx2");
		this.b4.getStyleClass().add("bboxxB2");
		return pane;
	}
	public Pane zweiteBox() {
		VBox box2 = new VBox();
		Label label = new Label(); 
		label.setText("Each player has 21 pieces of the same color. \n "
				+ "When a player drops a tile into a column, \n "
				+ "it occupies the lowest free space in the column. \n"
				+ "The winner is the player who first manages to line up four \n"
				+ "or more of his tokens horizontally, vertically or diagonally.\n\n"
				+ "Source: https://de.wikipedia.org/wiki/Vier_gewinnt");
		b2 = new Button("Back to game");
		box2.getChildren().addAll(label, b2);
		box2.setSpacing(30);
		box2.setAlignment(Pos.CENTER);
		box2.getStyleClass().add("bboxx");
		label.getStyleClass().add("bboxx");
		this.b2.getStyleClass().add("bboxxB");
		return box2;
	}
	public Pane bottompane() {
		HBox box = new HBox();
		info = new Label("It's Player 1's turn.");
		info2 = new Label("");
		Region region = new Region();
		HBox.setHgrow(region, Priority.ALWAYS);
		box.getChildren().addAll(info, region, info2);
		box.getStyleClass().add("bbox");
		info.getStyleClass().add("info"); 
		info2.getStyleClass().add("info2"); 
		return box;
	}
	public Pane rightpane() {
		VBox box = new VBox();
		s1 = new Label("Player 2");
		s1.setId("s1");
		box.getChildren().add(s1);
		box.setAlignment(Pos.CENTER);
		box.getStyleClass().add("box1");
		return box;
	}
	public Pane leftpane() {
		VBox box = new VBox();
		s2 = new Label("Player 1");
		s2.setId("s2");
		box.getChildren().add(s2);
		box.setAlignment(Pos.CENTER);
		box.getStyleClass().add("box2");
		return box;
	}
	public void start() {
		stage.show();
	}
	public Stage getStage() {
		return stage;
	}	
	public void stop() {
		stage.hide();
	}
}
