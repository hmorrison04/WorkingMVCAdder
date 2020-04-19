package models;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import views.CashController;
import views.GroceryController;

public class ViewTransitionalModel implements ViewTransitionModelInterface
{

  BorderPane mainview;
  storeModel model;
  
  public ViewTransitionalModel(BorderPane view,storeModel newModel)
  {
    mainview = view;
    model = newModel;
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
      CashController cont = loader.getController();
      cont.setModel(model);
      
      
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
      GroceryController cont = loader.getController();
      cont.setModel(model);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


  }

}
