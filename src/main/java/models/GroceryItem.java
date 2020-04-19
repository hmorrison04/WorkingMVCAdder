package models;

public class GroceryItem
{
  String name;
  Double cost;
  /**
   * @param name
   * @param cost
   */
  public GroceryItem(String name, Double cost)
  {
    super();
    this.name = name;
    this.cost = cost;
  }
  /**
   * @return the name
   */
  public String getName()
  {
    return name;
  }
  /**
   * @param name the name to set
   */
  public void setName(String name)
  {
    this.name = name;
  }
  /**
   * @return the cost
   */
  public Double getCost()
  {
    return cost;
  }
  /**
   * @param cost the cost to set
   */
  public void setCost(Double cost)
  {
    this.cost = cost;
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
    return name + " : " + cost ;
  }
  
  
  
  
  
  
  
}
