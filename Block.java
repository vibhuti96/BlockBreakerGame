import java.awt.*;
public class Block extends Rectangle
{
	Image image;
	int dx=2,dy=-2;
	boolean banged=false;
	Rectangle left,right;
	boolean power=false;
public Block(int abs,int ord,int wid,int hei,String Imagename)
{
	x=abs;
	y=ord;
	width=wid;
	height=hei;
	image=Toolkit.getDefaultToolkit().getImage(Imagename);
	left=new Rectangle(abs-1,ord,1,hei);
	right=new Rectangle(abs+wid+1,ord,1,hei);
}	
void drawBlock(Graphics g,Component c)
{
	g.drawImage(image,x,y,width,height,c);
}
}
