package piggy;
import piggy.hit;
import piggy.StdDraw;
public class play {
	private static int lieben=5;
	
	
	public static void main(String[] args) {
	StdDraw.setXscale(-1.0, 1.0);
    StdDraw.setYscale(-1.0, 1.0);
    StdDraw.enableDoubleBuffering();
    StdDraw.setPenColor(StdDraw.BLUE);
	while (true)
	{StdDraw.text(0,0,"start game");
	StdDraw.show();
		if (StdDraw.isMousePressed()&& Math.abs(StdDraw.mouseX())<0.2&&Math.abs(StdDraw.mouseY())<0.2){
		
		run();}
		
	}
    
	
    
      // main animation loop
    
  } 
public static void run()
{ 
	boolean paus=false;
    hit[] ob=new hit[5];
    int score=0;
    hit bottom=new hit(0);
    for(int i=0;i<5;i++)
    {ob[i]=new hit();  	  
  	  
    }
      // set the scale of the coordinate system
      

      // initial values
    
   

      int life=lieben;
      double rx = -0.8, ry = -0.860;     // position
      double vx = 0, vy = 0.012;     // velocity
      double radius = 0.02;              // radius
	
	
	
	while (true)  {
		
    StdDraw.setPenColor(StdDraw.BLUE); 
    StdDraw.filledCircle(0.5,0.8, 0.06);
    
       

        // bounce off wall according to law of elastic collision
     if (ry+vy-radius<=-1)
     { if(vy<-0.01)vy+=0.007;
     else vy=0;
     
	    
     }
     
    if (Math.abs(rx + vx) > 1.0 - radius) vx = -vx*0.9;
        if (Math.abs(ry + vy) > 1.0 - radius) vy = -vy;
       

        
          if (StdDraw.isMousePressed()){
          vy+=0.0005;
         }
          else { if(ry+vy-radius>-1)vy-=0.0005   ;}
          
         
          for(int i=0;i<5;i++)
	      {if(ob[i].x<-1.1)
	      {score+=1;
	        ob[i]=new hit();
	      //bottom=new hit(0);
	      }}
	      if (bottom.x<-1.1)
	    	  bottom=new hit(0);
	      
	    
	    for(int i=0;i<5;i++) {
	      
	      if( Math.abs(rx-ob[i].x+vx)<0.1 && Math.abs(ry-ob[i].y+vy)<0.1  )
	      {   life--;
	    paus=true;
	      StdDraw.clear();
	      StdDraw.text(0,0,"life--");
	      StdDraw.show();
	      StdDraw.pause(1000);
		     rx=-0.6;
		   bottom=new hit(0);
		     for(int j=0;j<5;j++)
		     {ob[j]=new hit();
		    	 
		    	 
		     }
		     ry=-1; vy = 0.012; StdDraw.filledCircle(rx, ry, radius); StdDraw.pause(1000);}
	      }

	    if ( Math.abs(rx-bottom.x+vx)<0.1 && Math.abs(ry-bottom.y+vy)<0.1  )
	      {   life--;
	      paus=true;
	      StdDraw.clear();
	      StdDraw.text(0,0,"life--");
	      StdDraw.show();
	      StdDraw.pause(1000);
		     rx=-0.6;
		     bottom=new hit(0);
		     for(int j=0;j<5;j++)
		     {ob[j]=new hit();
		    	 
		    	 
		     }
		     ry=-1; vy = 0.012; StdDraw.filledCircle(rx, ry, radius); StdDraw.pause(1000);}
	      

	    
	    

        // update position
        rx = rx + vx; 
        ry = ry + vy; 

        // clear the background
        StdDraw.clear(StdDraw.WHITE);
        for(int i=0;i<5;i++)
	      {  if(score>150)
	    	  ob[i].speedup(0.016);
	      else if(score>100)
	    	  ob[i].speedup(0.013);
	      else if(score>50)
	    	  ob[i].speedup(0.010);
	    	  
	    	  
      	  ob[i].move();
        	  
        	  StdDraw.setPenColor(StdDraw.BLACK); 
	            StdDraw.filledRectangle(ob[i].x, ob[i].y, 0.1,0.1);
	            
	      }
        if(score>150)
	    	  bottom.speedup(0.016);
	      else if(score>100)
	    	bottom.speedup(0.013);
	      else if(score>50)
	    	bottom.speedup(0.010);
	    	  
        bottom.move();
        StdDraw.filledRectangle(bottom.x, bottom.y, 0.1,0.1);
        // draw ball on the screen
        StdDraw.setPenColor(StdDraw.BLUE); 
        StdDraw.filledCircle(rx, ry, radius);
       
        StdDraw.setPenColor(StdDraw.BLACK);
        
         
   
     StdDraw.setPenColor(StdDraw.BLACK);
       
      
       
        // copy offscreen buffer to onscreen
     
        String display="You have "+Integer.toString(life)+" lives left";
        StdDraw.text(0,0.9,display);
        StdDraw.text(0.9,0.9,"pause");
        if (StdDraw.isMousePressed()&& Math.abs(StdDraw.mouseX()-0.9)<0.2&&Math.abs(StdDraw.mouseY()-0.9)<0.2)
        {while(true)
        {
        	StdDraw.text(0,0,"start");
        	StdDraw.show();
        if (StdDraw.isMousePressed()&& Math.abs(StdDraw.mouseX())<0.2&&Math.abs(StdDraw.mouseY())<0.2)
        break;}
        }
        	
        	
        	
        
        	
        	int x=score/5;
        String points =Integer.toString(x);
                  StdDraw.text(-0.8,0.8, points);
        StdDraw.show();
        // pause for 20 ms
        if(paus&&life!=0)
        {paus=false;
        StdDraw.text(0,0, "Get Ready");
        StdDraw.show();
        StdDraw.pause(2000);
       }
     StdDraw.pause(10);
if(life==0)
{  break;} }
	
	

while(true)
	
{StdDraw.clear();
StdDraw.text(0,0.5,"Game Over");
StdDraw.text(0,0,"click here to restart");
StdDraw.text(0,-0.5,"click to end game");
StdDraw.show();
	if (StdDraw.isMousePressed()&& Math.abs(StdDraw.mouseX())<0.2&&Math.abs(StdDraw.mouseY())<0.2){
	StdDraw.clear();
	StdDraw.text(0,0,"Game will restart soon");
	StdDraw.show();StdDraw.pause(2000);
	life=lieben;
	run();}
	else if (StdDraw.isMousePressed()&& Math.abs(StdDraw.mouseX())<0.2&&Math.abs(StdDraw.mouseY()+0.5)<0.2)
	{
	StdDraw.clear();
	StdDraw.text(0,0,"The End");
	 int x=score/5;
    while(true)
	 {String points ="Your final score is "+Integer.toString(x);
               StdDraw.text(0,0.8, points);
	StdDraw.show();}
	}
		
	

   }
    }

}
