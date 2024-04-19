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
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import models.GroceryItem;
import models.ViewTransitionalModel;
import models.storeModel;
import views.GroceryController;

@ExtendWith(ApplicationExtension.class)
public class TestGroceryView
{
  
  @Start  //Before
  private void start(Stage stage)
  {
    
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(ViewTransitionalModel.class
        .getResource("../views/GroceryView.fxml"));
    try {
      Scene s = new Scene(loader.load());
      GroceryController cont = loader.getController();
      cont.setModel(new storeModel());
      
     
      stage.setScene(s);
      stage.show();
      
      
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
      
  }
  
  private void enterText(FxRobot robot, String text, String target)
  {
    robot.clickOn(target);
    robot.write(text);
  }
  
  private void addItem(FxRobot robot,String item,String cost)
  {
    enterText(robot,item,"#itemTextField");
    enterText(robot,cost,"#costTextField");
    robot.clickOn("#addItemButton");
  }
  
  
  
  
  @SuppressWarnings("unchecked")
  ListView<GroceryItem> getGrocs(FxRobot robot)

  {
   return (ListView<GroceryItem>) robot.lookup("#listView")
       .queryAll().iterator().next();
  }
  
  
  
  
  @Test
  public void testGroceries(FxRobot robot)
  {
    ListView<GroceryItem> grocs = getGrocs(robot);
    
    Assertions.assertThat(grocs).isEmpty();
        
    
    
    GroceryItem [] items = {
        new GroceryItem("cow",13.50),
        new GroceryItem("bear",27.45),
        new GroceryItem("ant",1.50)
    };
    
    for(GroceryItem i:items)
    {
      addItem(robot,i.getName(),""+i.getCost());
    }

    grocs = getGrocs(robot);
    
    Assertions.assertThat(grocs).hasExactlyNumItems(items.length);
    
    for(GroceryItem i:items)
    {
     Assertions.assertThat(grocs).hasListCell(i); 
      
    }
 }
    
    
    
    
 
  

}
