package VG;

import javafx.application.Application;
import javafx.stage.Stage;

public class VGMVC extends Application{
	
	private VGModel model;
	private VGView view;
	private VGController controller;


	public static void main(String[] args) {
	launch(args);
	}
	public void start(Stage stage) {
		model = new VGModel(view); 
		view = new VGView(model, stage);
		controller = new VGController (model, view);
		view.start();
	}
	public void stop() {
		if(view!=null) {
			view.stop();
		}
	}
}
