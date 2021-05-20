import java.util.*;
   import java.text.*;
   import java.io.*;
   import java.lang.*;
   import javafx.application.*;
   import javafx.event.*;
   import javafx.stage.*;
   import javafx.scene.canvas.*;
   import javafx.scene.paint.*;
  import javafx.scene.*;
  import javafx.scene.input.*;
  import javafx.scene.layout.*;
  import javafx.animation.*;
  import javafx.scene.control.*;
  import javafx.scene.image.*;
  import java.net.*;
  import javafx.geometry.*;

public class mazeGame extends Application
{
 //Create the root
 FlowPane root = new FlowPane();
 mazeCanvas theGame = new mazeCanvas(root);
 
//Start scene
public void start(Stage stage)
  {    
  Scene scene = new Scene(root,525,525);
  stage.setTitle("my box");
  stage.setScene(scene);
  stage.show();
  
  //Add the square to the flowpane
  root.getChildren().add(theGame);
  //Request focus
  theGame.requestFocus();  
 
  }
  public static void main(String[] args) 
    {
     launch(args);
    }
}