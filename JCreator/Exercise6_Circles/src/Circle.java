import java.awt.*;

class Circle {
	
	private int x,y;
	private int intR;
	private Color kleur;
	
	public Circle(int x, int y,int intR, Color kleur)
	{
		this.x = x;
		this.y = y;
		this.intR = intR;
		this.kleur = kleur;
		
	}
//	public void setIntR(int intR)
//	{
//		this.intR = intR;
//	}
//	public int getIntR()
//	{
//		return(this.intR);
//		
//	}
	public void makeSmaller()
	{
		intR = intR - 5;
	}	
	public void makeLarger()
	{
		intR = intR + 5;
	}
	
	public void tekenCircle(Graphics pen)
	{
		pen.setColor(kleur);
		pen.fillOval(x,y,intR, intR);
	}
	
}



