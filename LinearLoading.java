 /*<applet code="LinearLoading" width="1000" height="1000">
</applet>*/
import java.awt.*;
import java.applet.*;
public class LinearLoading extends Applet implements Runnable
{
	int i=0,j=0,i2=0,j2=0;
	Thread t;
	boolean secrect=false;
	public void init()
	{
		t=new Thread(this);
	}
	public void start()
	{
		t.start();
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.blue);
		g.fillRect(10+j,100,i-j-j,5);
		g.fillRect(10+j2,100,i2-j2-j2,5);
    }
	public void run()
	{
		while(true)
		{
			for (i=0;i<600;i++)
			{
				repaint();
				try
				{
					t.sleep(2);
				}
				catch(Exception e){}
				
				if (i>=400)
				{
					j+=1;
					secrect=true;
					
				}
				else
				{	
					if (i%4==0)
					{
						j+=1;
					}
				}
				if (secrect)
				{	
					if (i>=500)
					{	
						i2+=2;
					}
					else
					{	
						i2++;
					}
					if (i%3==0)
					{
						
						j2++;
					}	
				}
			}
			for(i2=i2;i2<=600;i2++)
			{
				if (i2%4==0&&i2<=360)
					{
						j2++;
					}
				else if (i2>380)
				{
					j2++;
				}
				repaint();
				try
				{
					t.sleep(2);
				}
				catch(Exception e){}
			}
			i2=0;
			j2=0;
			j=0;
			secrect=false;
			
			
		}
			
		
	}
}