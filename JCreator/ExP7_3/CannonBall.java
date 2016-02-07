/**
   This class simulates a cannonball fired up in the air.
*/
public class CannonBall
{
   /**
      Creates a CannonBall object and measure its velocity
      and the exact location of which it lands.
      @param aIvel the inital velocity
   */
   public CannonBall(double aIvel)
   {
      ivel = aIvel;
      pos = 0;
   }

   /**
      Method used to calculate the velcoity of the cannonball.
      @param deltaT the time interval
   */
   public void move(double deltaT)
   {
      pos = pos + ivel * deltaT;
      ivel = ivel - G * deltaT;
   }

   /**
      Method used to get the velocity of the cannonball.
      @return the velocity
   */
   public double getVelocity()
   {
      return ivel;
   }

   /**
      Method used to get the position of the cannonball.
      @return the position
   */
   public double getPosition()
   {
      return pos;
   }

   private static final double G = 9.81;

   private double ivel;
   private double pos;
}