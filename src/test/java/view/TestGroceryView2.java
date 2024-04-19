package view;

import java.io.IOException;

//import org.assertj.core.api.Assertions;
import org.testfx.assertions.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.util.WaitForAsyncUtils;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.GroceryItem;
import models.ViewTransitionalModel;
import models.storeModel;
import views.GroceryController;

@ExtendWith(ApplicationExtension.class)
public class TestGroceryView2
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
      
      storeModel model = new storeModel();
      
      GroceryItem [] items = {
    	        new GroceryItem("cow",1.0),
    	        new GroceryItem("bear",2.45),
    	        new GroceryItem("ant1",3.50),
    	        new GroceryItem("ant2",4.50),
    	        new GroceryItem("ant3",5.50),
    	        new GroceryItem("ant4",6.50),
    	        new GroceryItem("ant5",7.50),
    	        new GroceryItem("ant6",8.50),
    	        new GroceryItem("ant7",9.50),
    	        new GroceryItem("ant8",10.50)
    	        
    	    };
      
      
      model.getGroceries().addAll(items);
      
      cont.setModel(model);
      
     
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
  
  /*
  private void addItem(FxRobot robot,String item,String cost)
  {
    enterText(robot,item,"#itemTextField");
    enterText(robot,cost,"#costTextField");
    robot.clickOn("#addItemButton");
  }
  */
  
  
  
  @SuppressWarnings("unchecked")
  ListView<GroceryItem> getGrocs(FxRobot robot)

  {
   return (ListView<GroceryItem>) robot.lookup("#listView")
       .queryAll().iterator().next();
  }
  
  
  private void selectItem(FxRobot robot, int index)
  {
	  Platform.runLater(()->{
		  ListView<GroceryItem> grocs = getGrocs(robot);
		  grocs.scrollTo(index);
		  grocs.getSelectionModel().clearAndSelect(index);
	  });
	  WaitForAsyncUtils.waitForFxEvents();
}

  
  private void editItem(FxRobot robot,int index)
  {
	  Platform.runLater(()->{
		  ListView<GroceryItem> grocs = getGrocs(robot); 
		  grocs.scrollTo(index);
		  grocs.getSelectionModel().clearAndSelect(index);
		  grocs.edit(index);
	  });
	  WaitForAsyncUtils.waitForFxEvents();  
  }
  
  private void clearTextField(FxRobot robot,String selector)
  {
	  TextField tf = robot.lookup(selector)
	  .queryAs(TextField.class);
	  
	  Platform.runLater(()->{tf.clear();});
	  WaitForAsyncUtils.waitForFxEvents();
	  
  }
  
  
  @Test
  public void testGroceries(FxRobot robot)
  {
    
    try {
    	selectItem(robot,9);
    	   
    	Thread.sleep(1000);
		selectItem(robot,2);
	    Thread.sleep(1000);
	    
	    editItem (robot,6);
	    //need a little sleep before the editable thing is available! 
	    //WaitForAsyncUtils.waitForFxEvents();

	    robot.clickOn("#cellitemname");
	    clearTextField(robot,"#cellitemname");
	    robot.write("anteater");
	    robot.clickOn("Save");
	    
	    
	    //selectItem(robot,2);
	    
	    Thread.sleep(1000);
	    
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    
 }
    
    
    
    
 
  

}
