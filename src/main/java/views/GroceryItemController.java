package views;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
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
			NameTF.textProperty().bindBidirectional(model.getItem().name);
		
			StringConverter<Number> converter = new NumberStringConverter();
			Bindings.bindBidirectional(CostTF.textProperty(), model.getItem().cost,converter);
		}
	}
	
		@FXML
	    private TextField CostTF;

	    @FXML
	    private TextField NameTF;

	    @FXML
	    void OnCommitItem(ActionEvent event) {
	    	model.commitEdit(model.getItem());
	    }

	    @FXML
	    void onCancelItem(ActionEvent event) {
	    	model.cancelEdit();

	    }

	
}
