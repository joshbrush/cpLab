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

public class mazeCanvas extends Canvas
{

String myFile = "maze.txt";
GraphicsContext gc = getGraphicsContext2D();
int[][] myMaze = new int [21][21];
int x, y;
FlowPane root = new FlowPane();

 //Create the constructor
 public mazeCanvas(FlowPane root)
 {
 //Set up the drawing
 this.root = root;
 setHeight(525);
 setWidth(525);
 root.setOnKeyPressed(new KeyListener()); 
  try
 {
 //Scan in the file
 Scanner scan = new Scanner(new File(myFile));
 int a;
 int b;
 
 //Read from array
 for(int j=0; j<21; j++)
  {
   for(int i=0; i<21; i++)
   {
   myMaze[j][i] = scan.nextInt();
   
   //White Squares
   if(myMaze[j][i] == 0)
   {
   a=i*25;
   b=j*25;
   gc.setFill(Color.WHITE);
   gc.fillRect(a,b,25,25);
   }
   //Black Squares
   if(myMaze[j][i] == 1)
   {
   a=i*25;
   b=j*25;
   gc.setFill(Color.BLACK);
   gc.fillRect(a,b,25,25);
   //Blue Square
   if(myMaze[0][i]==0)
    {
    y = 0;
    x = i;
    gc.setFill(Color.CYAN);
    myMaze[0][i]=2;
    gc.fillRect(x*25,y*25,25,25);
    }
    
    
    
   }
  }
  
 }
 




}
catch(FileNotFoundException FNFE)
 {
 System.out.println("File not found");
 }

}
public class KeyListener implements EventHandler<KeyEvent>     
  {       
  public void handle(KeyEvent event)       
   { 
   try{
   
     int stop=0;
      //If up key is pressed      
     if(event.getCode() == KeyCode.UP)
     {
      for(int j=0; j<21&&stop!=1; j++)
         {
           for(int i=0; i<21&&stop!=1; i++)
            {
            if(myMaze[j][i]==2 && myMaze[j-1][i]==0&&i<21&&j<21)
               { 
                 gc.clearRect(i*25,j*25,25,25);
                 gc.setFill(Color.CYAN);
                 gc.fillRect((i*25),(j*25)-25,25,25);
                 myMaze[j][i]=0;
                 myMaze[j-1][i]=2;
                 stop=1;
               }
               
             }
            
         }
      stop=0;
     }
     
      //If down key is pressed
      if(event.getCode() == KeyCode.DOWN)
      {
     
        for(int j=0; j<21&&stop!=1; j++)
         {
             for(int i=0; i<21&&stop!=1; i++)
            {
            if(myMaze[j][i]==2 && myMaze[j+1][i]==0&&i<20&&j<20)
               { 
                 gc.clearRect(i*25,j*25,25,25);
                 gc.setFill(Color.CYAN);
                 gc.fillRect((i*25),(j*25)+25,25,25);
                 myMaze[j][i]=0;
                 myMaze[j+1][i]=2;
                 stop=1;
                 //Winner
                 if(myMaze[20][i]==2)
                 {
                 System.out.println("You Win");
                 gc.clearRect(0,0,525,525);
                 gc.setFill(Color.GREEN);
                 gc.fillRect(5,5,515,515);
                 gc.setFill(Color.BLACK);
                 gc.fillText("You Win",250,250);                 

                 
                 }

               }
              
             }
            
         }
         stop=0;
          
      }
      //If right is pressed
       if(event.getCode() == KeyCode.RIGHT)
      {
     
        for(int j=0; j<21&&stop!=1;j++)
         {
             for(int i=0; i<21&&stop!=1;i++)
            {
            if(myMaze[j][i]==2 && myMaze[j][i+1]==0&&i<20)
               { 
                 gc.clearRect(i*25,j*25,25,25);
                 gc.setFill(Color.CYAN);
                 gc.fillRect((i*25)+25,(j*25),25,25);
                 myMaze[j][i]=0;
                 myMaze[j][i+1]=2;
                 stop=1;
               }
               
             }
            
         }
         stop=0;
          
      }
      //If left is pressed
       if(event.getCode() == KeyCode.LEFT)
      {
     
        for(int j=0; j<21&&stop!=1; j++)
         {
             for(int i=0; i<21&&stop!=1; i++)
            {
            if(myMaze[j][i]==2 && myMaze[j][i-1]==0&&i>0)
               { 
                 gc.clearRect(i*25,j*25,25,25);
                 gc.setFill(Color.CYAN);
                 gc.fillRect((i*25)-25,(j*25),25,25);
                 myMaze[j][i]=0;
                 myMaze[j][i-1]=2;
                 stop=1;
               }
               
             }
            
         }
         stop=0;
          
      }


      
    }
    catch(ArrayIndexOutOfBoundsException e)
    {
    }
    
    }

  }  
 }
  


