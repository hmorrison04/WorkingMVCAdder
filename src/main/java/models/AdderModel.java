package models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class AdderModel
{
	DoubleProperty num1 = new SimpleDoubleProperty();
	DoubleProperty num2 = new SimpleDoubleProperty();
	DoubleProperty answer = new SimpleDoubleProperty();
	public AdderModel()
	{
		
	}

	public DoubleProperty getNum1()
	{
		return num1;
	}

	public DoubleProperty getNum2()
	{
		return num2;
	}
	
	public DoubleProperty getAnswer()
	{
		return answer;
	}
	
	public void addNumbers(double amt)
	{
		answer.set(amt);
		//answer.set(answer.get() + amt);
	}
	
	
}
