import java.util.Scanner;

/**
   Test driver class for CannonBall class.
*/
public class ExP7_3
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);

      System.out.println("Enter the initial velocity:");
      double ivel = in.nextDouble();

      final double G = 9.81;
      double deltaT = 0.01;
      double t = 0;
      double exactPos = 0;
      double vel = ivel;

      CannonBall cb = new CannonBall(ivel);

      while (vel > 0)
      {
         for (int i = 0; vel > 0 && i < 100; i++)
         {
            cb.move(deltaT);
            t = t + deltaT;
            vel = cb.getVelocity();
         }

         exactPos = -0.5 * G * t * t + ivel * t;

         System.out.println("Simulation position: "
            + cb.getPosition()
            + " Velocity: " + cb.getVelocity());
         System.out.println("The exact formula position is: "
            + exactPos);
      }
   }
}