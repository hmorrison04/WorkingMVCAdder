package models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class storeModel
{
  DoubleProperty money = new SimpleDoubleProperty();
  ObservableList<GroceryItems> groceries = 
      FXCollections.observableArrayList();
  
  public storeModel()
  {
    
    
  }

  /**
   * @return the money
   */
  public DoubleProperty getMoney()
  {
    return money;
  }

  /**
   * @return the groceries
   */
  public ObservableList<GroceryItems> getGroceries()
  {
    return groceries;
  }
  
  
  public void deltaMoney(double amt)
  {
    money.add(amt);
  }
  
}
