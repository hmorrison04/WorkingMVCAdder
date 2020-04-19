package view;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.Main;
import models.ViewTransitionModelInterface;
import views.MainController;

@ExtendWith(ApplicationExtension.class)
public class TestMainView implements ViewTransitionModelInterface
{
  @Start  //Before
  private void start(Stage stage)
  {
    cashCalled=0;
    grocsCalled = 0;
       
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Main.class.getResource("../views/MainView.fxml"));
    BorderPane view;
    try {
      view = loader.load();
    
    MainController cont = loader.getController(); 
    cont.setModel(this);
   
    
    
    Scene s = new Scene(view);
    stage.setScene(s);
    stage.show();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }

  int cashCalled = 0;
  int grocsCalled = 0;
  
  
  @Override
  public void showCash()
  {
    cashCalled++;
    
  }

  @Override
  public void showGroceries()
  {
    grocsCalled++;
    
  }
  
  @Test
  public void testCashButton(FxRobot robot)
  {
    robot.clickOn("#cashButton");
    Assertions.assertThat(cashCalled).isEqualTo(1);
    Assertions.assertThat(grocsCalled).isEqualTo(0);
    
    robot.clickOn("#cashButton");
    Assertions.assertThat(cashCalled).isEqualTo(2);
    Assertions.assertThat(grocsCalled).isEqualTo(0);
    //AssertEquals(cashCalled,1);
    
    
  }
  
  @Test
  public void testButtons(FxRobot robot)
  {
    robot.clickOn("#glButton");
    Assertions.assertThat(cashCalled).isEqualTo(0);
    Assertions.assertThat(grocsCalled).isEqualTo(1);
    
    robot.clickOn("#glButton");
    Assertions.assertThat(cashCalled).isEqualTo(0);
    Assertions.assertThat(grocsCalled).isEqualTo(2);
    
    robot.clickOn("#cashButton");
    Assertions.assertThat(cashCalled).isEqualTo(1);
    Assertions.assertThat(grocsCalled).isEqualTo(2);
    
    robot.clickOn("#glButton");
    Assertions.assertThat(cashCalled).isEqualTo(1);
    Assertions.assertThat(grocsCalled).isEqualTo(3);
    
    
    
  }
  
  
  
  
}
