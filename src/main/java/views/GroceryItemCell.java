package views;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import models.GroceryItem;
import models.ViewTransitionalModel;

public class GroceryItemCell extends ListCell<GroceryItem>
{

	GroceryItemController cont;
	Node node;

	String undoName;
	Double undoCost;
	
	
	public GroceryItemCell(ListView<GroceryItem> view)
	{
		
		FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(ViewTransitionalModel.class
	        .getResource("../views/GroceryItemView.fxml"));
	    try {
	      node = loader.load(); //store for later
	      
	      cont = loader.getController(); //store for later
	      cont.setModel(this);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
			
		showUneditable();
	}


	//Common to have a Node (graphic) for the editable and use strings for speed for uneditable
	//Could have a second graphical for the uneditable as well and swap between.
	private void showEditable()
	{
		this.setGraphic(node);
		this.textProperty().set("");;
		
	}
	
	
	private void showUneditable()
	{
		this.setGraphic(null);
		textProperty().setValue(getItem() != null?getItem().toString():"");
	}
	
	


	@Override
	protected void updateItem(GroceryItem item, boolean empty)
	{
		if(empty)		{
			//nothing to do here.			
		}
		else
		{
			cont.setModel(this);
			textProperty().setValue(item.toString());
		}
		super.updateItem(item, empty);//really important! always keep!
	}


	@Override
	public void startEdit()
	{
		if(getItem()!=null)
		{
			undoName = getItem().getName();
				
			undoCost = getItem().getCost();
		
			showEditable();
		}
		super.startEdit();//really important! always keep!
	}


	@Override
	public void commitEdit(GroceryItem newValue)
	{
		//newValue.setName(tf.getText());
		showUneditable();
		
		super.commitEdit(newValue);//really important! always keep!
		
	}


	@Override
	public void cancelEdit()
	{
		//need to undo everything
		getItem().setName(undoName);
		getItem().setCost(undoCost);
		cont.setModel(this);
		
		
		showUneditable();
		
		super.cancelEdit();//really important! always keep!
	}
	
	
	
	
}
