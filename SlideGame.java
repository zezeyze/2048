/**
* A class that represents the Slide Game.
* 
* @Author: github.com/zezeyze
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.lang.Math;
import javafx.scene.layout.GridPane;
import java.util.Scanner;

public class SlideGame extends Application{
  
  //stores the array of buttons that represents the screen
  private Button[][] buttons;
  
  // represents numbers on the game board.
  private  int[][] numbers;
  
  /** 
   * creates the GUI display
   * @param primaryStage the main window
   */
  public void start(Stage primaryStage) {
    //stores the width/length of the board
    int width=4;
    int length=4;
    
    buttons = new Button[length][width];
    numbers = new int[length][width];
    GridPane grid = new GridPane();
    //initializes every button as a blank button
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < width; j++) {
        buttons[i][j] = new Button("  ");
          buttons[i][j].setPrefSize(100, 100);          
          buttons[i][j].setStyle("-fx-font-size:20");  
      }      
      grid.addRow(i, buttons[i]);
    }
    
    //stores the two indices to start one random square off as one
    int indOne = (int) (Math.random() * width);
    int indTwo = (int) (Math.random() * length);
    buttons[indOne][indTwo].setText("1"); 
    
   //------------------------------------------------LEFT--------------------------------------------------------------
       /* Uses an anonymous class and EventHandler for left column.
        * A class that responds to a button click to slide the clicked button to its left column.
        * 
        */
        EventHandler<ActionEvent> leftColumnEventHandler = event ->
        {
          //Convert buttons to numbers for to be able to slide left and add.
          numbers = buttonToInt(buttons);
          //Slide the number to left.
          numbers = slideLeft(numbers);
          //Addition for the left side.
          numbers = addLeft(numbers);
          //After the numbers are added, slide left column again for the new layout. 
          numbers = slideLeft(numbers);
          //Calls the addOne function, for after each click and random add "1" somewhere.
          numbers = addOne(numbers);
          //Convert numbers to buttons for show the number on the screen.
          intToButton(numbers);  
        };
  //-----------------------------------------------------RIGHT---------------------------------------------------------
        /* Uses an anonymous class and EventHandler for right column.
        * A class that responds to a button click to slide the clicked button to its right column.
        * 
        */
        EventHandler<ActionEvent> rightColumnEventHandler = event ->
        {
          //Convert buttons to numbers for to be able to slide right and add.
          numbers = buttonToInt(buttons);
          //Slide the number to right.
          numbers = slideRight(numbers);
          //Addition for the right side.
          numbers = addRight(numbers);
          //After the numbers are added, slide right column again for the new layout. 
          numbers = slideRight(numbers);
          //Calls the addOne function, for after each click and random add "1" somewhere.
          numbers = addOne(numbers);
          //Convert numbers to buttons for show the number on the screen.
          intToButton(numbers);
        };

  //------------------------------------------------------TOP----------------------------------------------------------
        /* Uses an anonymous class and EventHandler for top column.
        * A class that responds to a button click to slide the clicked button to its top column.
        * 
        */
        EventHandler<ActionEvent> topColumnEventHandler = event ->
        {
          //Convert buttons to numbers for to be able to slide top and add.
          numbers = buttonToInt(buttons);
          //Slide the number to top.
          numbers = slideTop(numbers);
          //Addition for the top side.
          numbers = addTop(numbers);
          //After the numbers are added, slide top column again for the new layout. 
          numbers = slideTop(numbers);
          //Calls the addOne function, for after each click and random add "1" somewhere.
          numbers = addOne(numbers);
          //Convert numbers to buttons for show the number on the screen.
          intToButton(numbers);  
        };
        
   //-------------------------------------------------------BOTTOM-----------------------------------------------------
        /* Uses an anonymous class and EventHandler for top column.
        * A class that responds to a button click to slide the clicked button to its bottom column.
        * 
        */
        EventHandler<ActionEvent> bottomColumnEventHandler = event ->
        {
          //Convert buttons to numbers for to be able to slide bottom and add.
          numbers = buttonToInt(buttons);
          //Slide the number to bottom.
          numbers = slideBottom(numbers);
          //Addition for the bottom side.
          numbers = addBottom(numbers);
          //After the numbers are added, slide bottom column again for the new layout. 
          numbers = slideBottom(numbers);
          //Calls the addOne function, for after each click and random add "1" somewhere.
          numbers = addOne(numbers);
          //Convert numbers to buttons for show the number on the screen.
          intToButton(numbers);
        };
        
        //To show which button controls which EventColumnHandler.
        buttons[1][0].setOnAction(leftColumnEventHandler);    
        buttons[2][0].setOnAction(leftColumnEventHandler);
        buttons[1][3].setOnAction(rightColumnEventHandler);
        buttons[2][3].setOnAction(rightColumnEventHandler);
        buttons[0][1].setOnAction(topColumnEventHandler);
        buttons[0][2].setOnAction(topColumnEventHandler);
        buttons[3][1].setOnAction(bottomColumnEventHandler);
        buttons[3][2].setOnAction(bottomColumnEventHandler);
        
        //buttons on the left side clicked

        //buttons.setOnAction(new HandleClick);

        //butons on the right side clicked
        
        //buttons on the top clicked

        //buttons on the bottom clicked

        //new scene for the grid
        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
   
   
  
  /** 
   * helper method to convert from an array of ints to an array of buttons
   * @param ints an array of ints
   */
  public void intToButton(int[][] ints) {
    //loops through each of the ints to set the text on buttons
    for (int i = 0; i < ints.length; i++) {
      for (int j = 0; j < ints[i].length; j++) {
        if (ints[i][j] == 0) {
          buttons[i][j].setText("  ");
        }
        else {
          buttons[i][j].setText(Integer.toString(ints[i][j]));
        }
      }
    }
  }
  
  /**
   * helper method to convert an array of buttons to an array of ints
   * @param buttons an array of buttons
   * @return an array of ints
   */
  public int[][] buttonToInt(Button[][] buttons) {
    //stores the final array of ints
    int[][] finalArray = new int[buttons.length][buttons[0].length];
    //runs through each button intiliaze ints based off the text
    for (int i = 0; i < buttons.length; i++) {
      for (int j = 0; j < buttons[i].length; j++) {
        if (buttons[i][j].getText().equals("  ")) {
          finalArray[i][j] = 0;
        }
        else {
          
          finalArray[i][j] = Integer.parseInt(buttons[i][j].getText());
        }
      }
    }
    return finalArray;
  }
  
  /**
   * helper method to generate an extra one
   * @param ints an array of ints
   * @return an array of ints with a new one tile
   */
  public static int[][] addOne(int[][] ints) {
    int indOne = (int) (Math.random() * ints.length);
    int indTwo = (int) (Math.random() * ints[0].length);
    //stores whether or not there is an empty space
    boolean isSpace = false;
    //checks to make sure that there is an empty space
    for (int i = 0; i < ints.length; i++) {
      for(int j = 0; j < ints[i].length; j++) {
        if (ints[i][j] == 0) {
          isSpace = true;
        }
      }
    }
    //if there is space on the board, it will keep generating numbers until it hits a blank space
    while (ints[indOne][indTwo] != 0 && isSpace) {
      indOne = (int) (Math.random() * ints.length);
      indTwo = (int) (Math.random() * ints[0].length);
    } 
    ints[indOne][indTwo] = 1;
    return ints;
  }
  
   /**
   * helper to determine the number of non-zeroes in a method, to test addOne
   * @param ints a multidimensional array
   * @return the number of non-zeros in the method
   */
  public static int numberNonZero(int[][] ints) {
    int numNonZero = 0;
    //loops through the array
    for (int i = 0; i < ints.length; i++) {
      for (int j = 0; j < ints[i].length; j++) {
        if (ints[i][j] != 0) {
          numNonZero++;
        }
      }
    }
    return numNonZero;
  }
  
  //------------------------------------------------------------------------------------------------------------
  
  /*Slides the numbers in all row of array to left.
  * 
  * @param ints - the integer array to be modified.
  * @return - returns numbers shifted to left.*/
  public static int[][] slideLeft(int[][] ints)
  {
    for (int i = 0; i < ints.length; i++)
    {   
      for (int j = 0; j < ints[i].length-1; j++)
      {        
        boolean isClicked = false;
        int S = 0;
        //If button is empty,  
        if (ints[i][j]==0)
        {
          for(int k=1; k+j<ints[i].length && !isClicked; k++)
          {            
            if(ints[i][j+k]!=0)
            {
              isClicked = true;
              S = k;
            }
          }
          if(isClicked)
          {
            ints[i][j] = ints[i][j+S];
            ints[i][j+S] = 0;
          }
        }       
      }
    }
    return ints;
  }
    
  /*Slides the numbers in all row of array to right.
  * 
  * @param ints - the integer array to be modified.
  * @return - returns numbers shifted to right.*/
  public static int[][] slideRight(int[][] ints)
  {
    int[][] X = new int[ints.length][ints[0].length];   
    for (int i = 0; i < ints.length; i++)
    {     
      for (int j = 0; j < ints[i].length; j++)
      {        
        X[i][j]=ints[i][ints[i].length-j-1];
      }
    }   
    X = slideLeft(X);    
    for (int i = 0; i < ints.length; i++)
    {
      
      for (int j = 0; j < ints[i].length; j++)
      {        
        ints[i][j]=X[i][ints[i].length-j-1];
      }
    }   
   return ints;
  }
  
  /*Slides the numbers in all row of array to bottom.
  * 
  * @param ints - the integer array to be modified.
  * @return - returns numbers shifted to bottom.*/
  public static int[][] slideBottom(int[][] ints)
  {
    int[][] X = new int[ints.length][ints[0].length];    
    for (int i = 0; i < ints.length; i++)
    {      
      for (int j = 0; j < ints[i].length; j++)
      {        
        X[i][j]=ints[ints[i].length-j-1][i];
      }
    }    
    X = slideLeft(X);    
    for (int i = 0; i < ints.length; i++)
    {      
      for (int j = 0; j < ints[i].length; j++)
      {        
        ints[i][j]=X[j][ints[i].length-i-1];
      }
    }   
    return ints;
  }
  
  /*Slides the numbers in all row of array to top.
  * 
  * @param ints - the integer array to be modified.
  * @return - returns numbers shifted to top.*/
  public static int[][] slideTop(int[][] ints)
  {
    int[][] X = new int[ints.length][ints[0].length];   
    for (int i = 0; i < ints.length; i++)
    {      
      for (int j = 0; j < ints[i].length; j++)
      {        
        X[i][j]=ints[j][ints[i].length-i-1];
      }
    }    
    slideLeft(X);   
    for (int i = 0; i < ints.length; i++)
    {     
      for (int j = 0; j < ints[i].length; j++)
      {        
        ints[i][j]=X[ints[i].length-j-1][i];
      }
    }    
    return ints;
  }
  
  
  /** If two adjacent numbers are equal,
  * these numbers are added together.
  * 
  *@param ints -  array to be modified.
  *@return - returns numbers slide to the left after addition.
  */
  public static int[][] addLeft(int[][] ints)
  {
    for (int i = 0; i < ints.length; i++)
    {     
      for (int j = 0; j < ints[i].length-1; j++)
      {        
        if(ints[i][j]==ints[i][j+1])
        {
          ints[i][j] = 2*ints[i][j];
          ints[i][j+1] = 0;
        }
      }
    }
    return ints;
  }
   
  
  /** First the right inverted numbers of the array are assigned.
  * the addLeft function is called and numbers are added together, if they are equals. 
  * Finally, inverted numbers of the X array are placed to the right.
  * 
  *@param ints -  array to be modified.
  *@return - returns numbers slide to the left after addition.
  */
  public static int[][] addRight(int[][] ints)
  {
    int[][] X = new int[ints.length][ints[0].length];    
    for (int i = 0; i < ints.length; i++)
    {      
      for (int j = 0; j < ints[i].length; j++) 
      {        
        X[i][j]=ints[i][ints[i].length-j-1];
      }
    }    
    X = addLeft(X);    
    for (int i = 0; i < ints.length; i++) 
    {      
      for (int j = 0; j < ints[i].length; j++) 
      {        
        ints[i][j]=X[i][ints[i].length-j-1];
      }
    }    
    return ints;
  }
  
  /** First the bottom inverted numbers of the array are assigned.
  * the addLeft function is called and numbers are added together, if they are equals. 
  * Finally, inverted numbers of the X array are placed to the bottom.
  * 
  *@param ints -  array to be modified.
  *@return - returns numbers slide to the left after addition.
  */
  public static int[][] addBottom(int[][] ints)
  {
    int[][] X = new int[ints.length][ints[0].length];
    
    for (int i = 0; i < ints.length; i++)
    {      
      for (int j = 0; j < ints[i].length; j++)
      {        
        X[i][j]=ints[ints[i].length-j-1][i];
      }
    }    
    X = addLeft(X);
    for (int i = 0; i < ints.length; i++)
    {      
      for (int j = 0; j < ints[i].length; j++)
      {        
        ints[i][j]=X[j][ints[i].length-i-1];
      }
    }
    return ints;
  }
  
  /** First the top inverted numbers of the array are assigned.
  * the addLeft function is called and numbers are added together, if they are equals. 
  * Finally, inverted numbers of the X array are placed to the bottom.
  * 
  *@param ints -  array to be modified.
  *@return - returns numbers slide to the left after addition.
  */
  public static int[][] addTop(int[][] ints)
  {
    int[][] X = new int[ints.length][ints[0].length];    
    for (int i = 0; i < ints.length; i++)
    {      
      for (int j = 0; j < ints[i].length; j++)
      {        
        X[i][j]=ints[j][ints[i].length-i-1];
      }
    }    
    addLeft(X);    
    for (int i = 0; i < ints.length; i++)
    {    
     for (int j = 0; j < ints[i].length; j++)
     {        
        ints[i][j]=X[ints[i].length-j-1][i];
      }
    }    
    return ints;
  }
  
  /** 
    * The main method to run the program  
    * @param args the command line arguments  
    */ 
  public static void main(String[] args) { 
    SlideGame.launch(args);              
  }
}