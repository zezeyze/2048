import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/* Test class for SlideGame.*/
public class SlideGameTest
{
  private SlideGame slideGame;  
  @Before
  public void setUp()
  {
    slideGame = new SlideGame();
  }
  
  /* Test the slideLeft method.
  * All numbers slide left.
  */
  @Test
  public void slideLeftTest()
  {
    int[][] input =
    {
      {0, 4, 1, 0},
      {8, 16, 4, 0},
      {2, 0, 0, 2},
      {2, 2, 2, 2}
    };
    
    int[][] expectedOutput =
    {
      {4, 1, 0, 0},
      {8,16, 4, 0},
      {2, 2, 0, 0},
      {2, 2, 2, 2}
    };
    
    int[][] actualOutput = slideGame.slideLeft(input);
    assertArrayEquals(expectedOutput, actualOutput);
  }
  
  /*if it is equal to the one on the left, 
  * it adds up and the numbers slides to the left.*/
  @Test
  public void addLeftTest()
  {   
    int[][] input =
    {
      {16, 0, 0, 0},
      {1, 0, 0, 2},
      {8, 0, 4, 4},
      {1, 4, 1, 1}
    };
    
    int[][] expectedOutput =
    {
      {16, 0, 0, 0},
      {1, 0, 0, 2},
      {8, 0, 8, 0},
      {1, 4, 2, 0}
    };
    
    int[][] actualOutput = slideGame.addLeft(input);   
    assertArrayEquals(expectedOutput, actualOutput);
  }
  
  /* Test the slideRight method.
  * All numbers slide right.
  */
  @Test
  public void slideRightTest()
  {
    int[][] input =
    {
      {64, 1, 2, 4},
      {4, 4, 1, 0},
      {1, 2, 0, 0},
      {128, 0, 0, 0}
    };
    
    int[][] expectedOutput =
    {
      {64, 1, 2, 4},
      {0, 4, 4, 1},
      {0, 0, 1, 2},
      {0, 0, 0, 128}
    };
    
    int[][] actualOutput = slideGame.slideRight(input);
    assertArrayEquals(expectedOutput, actualOutput);
  }
  
  /*if it is equal to the one on the right, 
  * it adds up and the numbers slides to the right.*/
  @Test
  public void addRightTest()
  {  
    int[][] input =
    {
      {64, 1, 1, 1},
      {8, 8, 2, 0},
      {1, 4, 0, 0},
      {128, 128, 1, 0}
    };
    
    int[][] expectedOutput =
    {
      {64, 1, 0, 2},
      {0, 16, 2, 0},
      {1, 4, 0, 0},
      {0, 256, 1, 0}
    };
    
    int[][] actualOutput = slideGame.addRight(input);   
    assertArrayEquals(expectedOutput, actualOutput);
  }
  
  /* Test the slideBottom method.
  * All numbers slide bottom.
  */
  @Test
  public void slideBottomTest()
  {
    int[][] input =
    {
      {4, 1, 8, 2},
      {0, 16, 2, 4},
      {1, 4, 0, 2},
      {0, 0, 256, 0}
    };
    
    int[][] expectedOutput =
    {
      {0, 0, 0, 0},
      {0, 1, 8, 2},
      {4, 16, 2, 4},
      {1, 4, 256, 2}
    };
    
    int[][] actualOutput = slideGame.slideBottom(input);
    assertArrayEquals(expectedOutput, actualOutput);
  }
  
  /*if it is equal to the one on the bottom, 
  * it adds up and the numbers slides to the bottom.*/
  @Test
  public void addBottomTest()
  {
    
    int[][] input =
    {
      {64, 1, 2, 1},
      {8, 1, 2, 1},
      {8, 4, 0, 2},
      {128, 2, 8, 2}
    };
    
    int[][] expectedOutput =
    {
      {64, 0, 0, 0},
      {0, 2, 4, 2},
      {16, 4, 0, 0},
      {128, 2, 8, 4}
    };
    
    int[][] actualOutput = slideGame.addBottom(input);   
    assertArrayEquals(expectedOutput, actualOutput);
  }
  
  /* Test the slideTop method.
  * All numbers slide top.
  */
  @Test
  public void slideTopTest()
  {
    int[][] input =
    {
      {4, 1, 8, 2},
      {4, 4, 1, 0},
      {0, 2, 4, 0},
      {128, 0, 0, 0}
    };
    
    int[][] expectedOutput =
    {
      {4, 1, 8, 2},
      {4, 4, 1, 0},
      {128, 2, 4, 0},
      {0, 0, 0, 0}
    };
    
    int[][] actualOutput = slideGame. slideTop(input);
    assertArrayEquals(expectedOutput, actualOutput);
  }
  
  /*if it is equal to the one on the top, 
  * it adds up and the numbers slides to the top.*/
  @Test
  public void addTopTest()
  {   
    int[][] input =
    {
       {64, 1, 1, 1},
      {64, 2, 2, 4},
      {128, 2, 1, 4},
      {128, 0, 2, 1}
    };
    
    int[][] expectedOutput =
    {
      {128, 1, 1, 1},
      {0, 4, 2, 8},
      {256, 0, 1, 0},
      {0, 0, 2, 1}
    };
    
    int[][] actualOutput = slideGame.addTop(input);   
    assertArrayEquals(expectedOutput, actualOutput);
  }  
}
