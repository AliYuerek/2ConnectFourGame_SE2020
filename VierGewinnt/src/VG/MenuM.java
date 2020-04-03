package VG;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuM extends MenuBar{

	public Menu menuM = new Menu("Menu");
	public Menu infoM = new Menu("Game instruction");
	public Menu quitM = new Menu("Exit Game?");
	
	public MenuItem exit = new MenuItem("Exit");
	
	public MenuM() {
		super();
		quitM.getItems().addAll(exit);
		menuM.getItems().addAll(infoM, quitM);
		this.getMenus().addAll(menuM);
		this.setId("menuM");
		menuM.setId("menuMM");
		quitM.setId("menuML");
		exit.setId("menuMS");
		infoM.setId("menuMD");
	}
}
