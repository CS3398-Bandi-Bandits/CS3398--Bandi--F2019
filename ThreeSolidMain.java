/*
Kenneth Omo
This is the main class to drive the rest of the program.
Creates a Manager object

Interface Segregation: does not apply to main class.

Single Responsibility: The main class has one responsibility to accomplish.
The main class is designed to drive the program and use any other classes that
are in the same package.

Open/Close: does not apply to main class.

*/
package threesolid;
import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import java.io.*;

public class ThreeSolidMain
{

   public static Manager tsManager = new Manager();

   // The entry main() method
   public static void main(String[] args)
   {

      try {
         System.out.format("Starting ... \n");
      }
      catch (Exception main_except) {
         main_except.printStackTrace();
      }

      try {
         System.out.format("Stopping ... \n");
      }
      catch (Exception main_except) {
         main_except.printStackTrace();
      }

      System.exit(0);
   }
 }
