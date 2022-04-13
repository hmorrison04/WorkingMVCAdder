package models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GroceryItem
{
 public  StringProperty name = new SimpleStringProperty();
  public DoubleProperty cost = new SimpleDoubleProperty();
  /**
   * @param name
   * @param cost
   */
  public GroceryItem(String name, Double cost)
  {
    super();
    this.name.set(name);
    this.cost.set(cost);
  }
  
  
  
 



/**
   * @return the name
   */
  public String getName()
  {
    return name.get();
  }
  /**
   * @param name the name to set
   */
  public void setName(String name)
  {
    this.name.set(name);
  }
  /**
   * @return the cost
   */
  public Double getCost()
  {
    return cost.get();
  }
  /**
   * @param cost the cost to set
   */
  public void setCost(Double cost)
  {
    this.cost.set(cost);
  }
  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((cost == null) ? 0 : cost.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }
  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    GroceryItem other = (GroceryItem) obj;
    if (cost == null) {
      if (other.cost != null)
        return false;
    } else if (!cost.equals(other.cost))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }
  @Override
  public String toString()
  {
    return name.get() + " : " + cost.get() ;
  }
  
  
  
  
  
  
  
}
