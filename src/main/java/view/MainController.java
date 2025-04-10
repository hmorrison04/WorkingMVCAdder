package view;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;	
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import models.AdderModel;

public class MainController
{
	
		AdderModel model;
		

		@FXML
	    private Label finalAnswer;

	    @FXML
	    private TextField numEntryBox1;

	    @FXML
	    private TextField numEntryBox2;
	   
	    public void setModel(AdderModel newModel)
		{
			model = newModel;
			//bind label
			StringConverter<Number> answerLabel = new NumberStringConverter();
		
			Bindings.bindBidirectional(finalAnswer.textProperty(), model.getAnswer(), answerLabel);
		}
	    @FXML
	    void onClickEnter(ActionEvent event) {
	    	
	    	double answer = getFinalAnswer();
	    	model.addNumbers(answer);	    
	    }

	    @FXML
	    void onNumBox1Click(ActionEvent event) {

	    }

	    @FXML
	    void onNumBox2Click(ActionEvent event) {

	    }
	    private double getFinalAnswer()
	    {
	    	//model.addNumbers(0);
	    	String val1 = numEntryBox1.textProperty().get();
	    	String val2 = numEntryBox2.textProperty().get();
	    	double amt1 = 0;
	    	double amt2 = 0;
	    	double finalAnswer = 0;
	    	try
	    	{
	    		amt1 = Double.parseDouble(val1);
	    		amt2 = Double.parseDouble(val2);
	    		finalAnswer = amt1 + amt2;
	    	}
	    	catch(NumberFormatException e)
	    	{
	    		numEntryBox1.accessibleTextProperty().set("");
	    		numEntryBox2.accessibleTextProperty().set("");
	    		
	    	}
	  
	    	return finalAnswer;
	    	
	    	
	    }

	


}
