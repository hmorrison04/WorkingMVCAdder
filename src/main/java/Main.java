import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.ViewTransitionalModel;
import models.storeModel;
import views.MainController;

public class Main extends Application
{

  @Override
  public void start(Stage stage) throws Exception
  {
    storeModel model = new storeModel();
    
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Main.class.getResource("views/MainView.fxml"));
    BorderPane view = loader.load();
    MainController cont = loader.getController();
    ViewTransitionalModel vm =new ViewTransitionalModel(view,model); 
    cont.setModel(vm);
    vm.showCash();
    
    
    Scene s = new Scene(view);
    stage.setScene(s);
    stage.show();
   }

  
  public static void main(String [] args)
  {
    launch(args);
  }
  
}
