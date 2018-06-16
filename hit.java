package piggy;

public class hit {
	public double x;
	public double y;
	public double vx;
	public boolean passed;
	public boolean start;
	
	public hit()
	{ vx=-0.007;
	  x=1.1;
	  y=0.9-1.9*Math.random();
	  passed=false;
	  start=false;
		
	}
	public hit(int q)
	{vx=-0.007;
	  x=1.1;
	  y=-0.9;
	  passed=false;
	  start=false;
		
		
		
	}
	public void move() {
		x+=vx;
		
	}
	
	public void speedup(double j)
	{vx=-1*j;
		
		
	}

}
