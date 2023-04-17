package views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ListView.EditEvent;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import models.GroceryItem;
import models.storeModel;

public class GroceryController
{
    storeModel model;
    
    public void setModel(storeModel newModel)
    {
      model = newModel;
      
      grocView.setCellFactory(new Callback<ListView<GroceryItem>, ListCell<GroceryItem>>()
    		  {

				@Override
				public ListCell<GroceryItem> call(ListView<GroceryItem> param)
				{
					return new GroceryItemCell(param);
				}
    	  
    	  
    		  });
      
      grocView.setItems(model.getGroceries());
      grocView.setEditable(true);
      
      
      
      
      grocView.setOnEditStart(new EventHandler<EditEvent<GroceryItem>>() {
          

		@Override
		public void handle(EditEvent<GroceryItem> t)
		{
			System.out.println("Edit Start: " + t.getIndex());
			
		}
      });
      grocView.setOnEditCancel(new EventHandler<EditEvent<GroceryItem>>() {
          @Override
          public void handle(EditEvent<GroceryItem> t) {
              System.out.println("Edit Cancel: " + t.getIndex());
          }
      });
      grocView.setOnEditCommit(new EventHandler<EditEvent<GroceryItem>>() {
          @Override
          public void handle(EditEvent<GroceryItem> t) {
              System.out.println("Edit Commit: " + t.getIndex());
          }
      });
      
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

  /*
  @FXML
  void onLVEditCandle(ActionEvent event) {
	  System.out.println("Edit Cancel: ");
  }

  @FXML
  void onLVEditCommit(ActionEvent event) {
	  System.out.println("Edit Commit: ");
  }

  @FXML
  void onLVEditStart(ActionEvent event) {
	  System.out.println("Edit Start: ");
  }
  */
  
}
