package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import models.GroceryItem;
import models.storeModel;

public class GroceryController
{
    storeModel model;
    
    public void setModel(storeModel newModel)
    {
      model = newModel;
      grocView.setItems(model.getGroceries());
    }

  
  
  @FXML
  private ListView<GroceryItem> grocView;

  @FXML
  private TextField itemNameLabel;

  @FXML
  private TextField itemCostLabel;

  private double getAmt()
  {
    String val = itemCostLabel.textProperty().get();
    double amt = 0;
    
    try
    {
      amt = Double.parseDouble(val);
    }
    catch(NumberFormatException e)
    {
    }
    itemCostLabel.textProperty().set("");
    
    return amt;
  }
  
  
  @FXML
  void onAddItem(ActionEvent event) 
  {
    GroceryItem gi = new GroceryItem(itemNameLabel.textProperty().get(),
          getAmt());
    itemNameLabel.textProperty().set("");
    
    model.getGroceries().add(gi);
    
    
  }

}
