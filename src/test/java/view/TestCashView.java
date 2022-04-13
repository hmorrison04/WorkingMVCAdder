package view;

import java.io.IOException;

//import org.assertj.core.api.Assertions;
import org.testfx.assertions.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.ViewTransitionalModel;
import models.storeModel;
import views.CashController;

@ExtendWith(ApplicationExtension.class)
public class TestCashView
{
  
  @Start  //Before
  private void start(Stage stage)
  {
    
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(ViewTransitionalModel.class
        .getResource("../views/CashView.fxml"));
    try {
      Pane view = loader.load();
      CashController cont = loader.getController();
      cont.setModel(new storeModel());
      
      Scene s = new Scene(view);
      stage.setScene(s);
      stage.show();
      
      
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
      
  }
  
  private void enterAmt(FxRobot robot, String amt)
  {
    robot.clickOn("#enterAmountText");
    robot.write(amt);
  }
  
  private void checkBalance(FxRobot robot,String bal)
  {
    Assertions.assertThat(robot.lookup("#displayAmtLabel")
        .queryAs(Label.class)).hasText(bal);    
  }
  
  private void checkAddCash(FxRobot robot, String before, String change, String after)
  {
    checkBalance(robot,before);
    enterAmt(robot,change);
    robot.clickOn("#addMoneyButton");
    checkBalance(robot,after);
  }
  
  
  private void checkRemoveCash(FxRobot robot, String before, String change, String after)
  {
    checkBalance(robot,before);
    enterAmt(robot,change);
    robot.clickOn("#removeMoneyButton");
    checkBalance(robot,after);
  }
  
  
  @Test
  public void testAdds(FxRobot robot)
  {
    checkAddCash(robot,"$0.00",".15","$0.15");
    checkAddCash(robot,"$0.15","1.15","$1.30");
    checkAddCash(robot,"$1.30","101","$102.30");
  }
  
  
  @Test
  public void testRemoves(FxRobot robot)
  {
    checkRemoveCash(robot,"$0.00",".15","-$0.15");
    checkRemoveCash(robot,"-$0.15","1.15","-$1.30");
    checkRemoveCash(robot,"-$1.30","101","-$102.30");
  }
  
  @Test
  public void testInterleave(FxRobot robot)
  {
    checkAddCash(robot,"$0.00","100","$100.00");
    checkRemoveCash(robot,"$100.00","200","-$100.00");
    checkAddCash(robot,"-$100.00","150","$50.00");
    
    
  }
  
  
  
  /*
  @Test
  public void testButton(FxRobot robot)
  {
    try {
      Thread.sleep(1000);
      
      enterAmt(robot,"100");
      robot.clickOn("#addMoneyButton");
      Thread.sleep(1000);
      
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
  */
  
  

}
