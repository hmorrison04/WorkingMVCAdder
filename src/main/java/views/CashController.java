package views;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.CurrencyStringConverter;
import models.storeModel;

public class CashController
{
  
   
  storeModel model;
  @FXML
  private Label cashBalanceLabel;

  @FXML
  private TextField deltaCashTextField;

  
  
  public void setModel(storeModel newModel)
  {
    model = newModel;
    
    //bind label
    StringConverter<Number> fmt = new CurrencyStringConverter();
    
    
    Bindings.bindBidirectional(cashBalanceLabel.textProperty(),
        model.getMoney(),fmt);
  }
  
  
  private double getAmt()
  {
    String val = deltaCashTextField.textProperty().get();
    double amt = 0;
    
    try
    {
      amt = Double.parseDouble(val);
    }
    catch(NumberFormatException e)
    {
      deltaCashTextField.textProperty().set("");
    }
    deltaCashTextField.textProperty().set("");
    return amt;
  }
  
  
  @FXML
  void onAddCash(ActionEvent event) {
    double value = getAmt();
    model.deltaMoney(value);
  }

  @FXML
  void onRemoveCash(ActionEvent event) {
    double value = getAmt();
    model.deltaMoney(-1 * value);
  }

}
