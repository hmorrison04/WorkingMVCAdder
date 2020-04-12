package models;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ViewTransitionalModel implements ViewTransitionModelInterface
{

  BorderPane mainview;
  
  public ViewTransitionalModel(BorderPane view)
  {
    mainview = view;
  }
  
  
  
  @Override
  public void showCash()
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(ViewTransitionalModel.class
        .getResource("../views/CashView.fxml"));
    try {
      Pane view = loader.load();
      mainview.setCenter(view);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  @Override
  public void showGroceries()
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(ViewTransitionalModel.class
        .getResource("../views/GroceryView.fxml"));
    try {
      Node view = loader.load();
      mainview.setCenter(view);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


  }

}
