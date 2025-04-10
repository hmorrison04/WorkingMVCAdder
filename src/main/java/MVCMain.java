import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.AdderModel;
//import models.AdderModel;
import view.MainController;

public class MVCMain extends Application
{

	@Override
	public void start(Stage stage) throws Exception
	{
		 FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(MVCMain.class.getResource("/view/MainViews.fxml"));
		 BorderPane view = loader.load();
		
		 Scene s = new Scene(view);
		 stage.setScene(s);
		 stage.show();
	
		 MainController controller = loader.getController();
		 AdderModel am = new AdderModel();
		 controller.setModel(am);
	}

	public static void main(String[] args)
	{
		launch(args);
		
	}
	
}
