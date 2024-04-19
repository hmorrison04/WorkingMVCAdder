package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.GroceryItem;

public class GroceryItemController
{

	GroceryItemCell model;
	
	public void setModel(GroceryItemCell model)
	{
		this.model=model;
		GroceryItem item = model.getItem();
		if(item!=null)
		{
			NameTF.textProperty().set(model.getItem().getName());
		
			
			CostTF.textProperty().set(""+model.getItem().getCost());
		}
	}
	
		@FXML
	    private TextField CostTF;

	    @FXML
	    private TextField NameTF;

	    
	    private double getAmt()
	    {
	      String val = CostTF.textProperty().get();
	      double amt = 0;
	      
	      try
	      {
	        amt = Double.parseDouble(val);
	      }
	      catch(NumberFormatException e)
	      {
	        CostTF.textProperty().set("");
	      }
	      return amt;
	    }
	    
	    
	    @FXML
	    void OnCommitItem(ActionEvent event) {
	    	
	    	model.getItem().setName(NameTF.getText());
	    	model.getItem().setCost(getAmt());
	    	
	    	
	    	model.commitEdit(model.getItem());
	    }

	    @FXML
	    void onCancelItem(ActionEvent event) {
	    	model.cancelEdit();

	    }
	    
	    
	    
	    
	    

	
}
