import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.*;
class BlockBuilder extends JPanel
{
	int flag=0,flag2=0,flag3=0,alert=0;
	MyFrame f;
	Thread t1;
	Main main;
	ArrayList<Block> blocks=new ArrayList<Block>();
	ArrayList<Block> powers=new ArrayList<Block>();
	ArrayList<Block> balls=new ArrayList<Block>();
	Random random=new Random();
	Block slider=new Block(174,450,60,12,"slider.png");
	Animate animate;
	BlockBuilder me=this;
	BlockBuilder(MyFrame f)
	{this.f=f;
	this.main=main;
		int i;
	//add to list
	for(i=0;i<8;i++)
	blocks.add(new Block(50*i+2,0,50,25,"pic1.png"));
    for(i=0;i<8;i++)
	blocks.add(new Block(50*i+2,25,50,25,"pic2.png"));
for(i=0;i<8;i++)
	blocks.add(new Block(50*i+2,50,50,25,"pic3.png"));
for(i=0;i<8;i++)
	blocks.add(new Block(50*i+2,75,50,25,"pic4.png"));
for(i=0;i<8;i++)
	blocks.add(new Block(50*i+2,100,50,25,"pic5.png"));
for(i=0;i<8;i++)
	blocks.add(new Block(50*i+2,125,50,25,"pic6.png"));
balls.add(new Block(192,426,24,24,"MyBall.png"));
blocks.get(random.nextInt(32)).power=true;
blocks.get(random.nextInt(32)).power=true;
blocks.get(random.nextInt(32)).power=true;
blocks.get(random.nextInt(32)).power=true;
blocks.get(random.nextInt(32)).power=true;
blocks.get(random.nextInt(32)).power=true;

//keyEvent handling using adapter class

addKeyListener(new KeyAdapter(){
	public void keyPressed(KeyEvent ke)
	{
		if(ke.getKeyCode()==KeyEvent.VK_ENTER&&flag3==0)
		{
			
			animate=new Animate(me);
			Thread t=new Thread(animate);
			t.start();
			t1=t;
			flag3=1;
		}
		else if(ke.getKeyCode()==KeyEvent.VK_LEFT&&slider.x>=0)
		{
			slider.x-=8;
			slider.left.x-=8;
			slider.right.x-=8;
		}
			else if(ke.getKeyCode()==KeyEvent.VK_RIGHT&&slider.x<348)
			{
				slider.x+=8;
				slider.left.x+=8;
			slider.right.x+=8;
			}
				
	}
});
setFocusable(true);
	}
	//paintComponent method override
	public void paintComponent(Graphics g)
	{
		
	super.paintComponent(g);
     for(Block b:blocks)
{
	if(b.banged==false)
	b.drawBlock(g,this);
}
	slider.drawBlock(g,this);
	for(Block ball:balls)
	ball.drawBlock(g,this);
for(Block b:powers)
	if(!b.banged)
	b.drawBlock(g,this);
	}
	public void update()
	{Object[] options={"Start Again","Exit"};
	flag=0;
	flag2=0;
	int choice=0;
	for(Block b:blocks)
	{
		if(!b.banged)
		{
			flag=1;
			break;
		}
	}
			for(Block b:balls)
			{
		if(!b.banged)
		{
			flag2=1;
			break;
		}
			}
	if(flag==0)
	{
		ImageIcon i=new ImageIcon("win.jpg");
		JComponent[] jcomp=new JComponent[]{new JLabel("Yes you won the game!."),new JLabel(i),new JLabel("\nDo you want to start again or exit?")};
			choice=JOptionPane.showOptionDialog(this,jcomp,"end",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
	        if(choice==JOptionPane.YES_OPTION)
		   {
			Main.startAgain();
			//f.revalidate();
			t1.stop();
		   }
			else
			{
				f.setVisible(false);
				t1.stop();
			}
	}
		else if(flag2==0)
		{
			ImageIcon i=new ImageIcon("loose.jpg");
		JComponent[] jcomp=new JComponent[]{new JLabel("Oh! you lost the game."),new JLabel(i),new JLabel("\nDo you want to start again or exit?")};
			choice=JOptionPane.showOptionDialog(this,jcomp,"end",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
	if(choice==JOptionPane.YES_OPTION)
	{
            Main.startAgain();
			//f.revalidate();
			t1.stop();
	}
			else
			{
				f.setVisible(false);
				t1.stop();
			}
		}
		for(Block b:powers)
		{
			if(!b.banged)
			{
			b.y++;
			if(b.intersects(slider))
			{
				balls.add(new Block(slider.x+30-12,slider.y-24,24,24,"MyBall.png"));
				b.banged=true;
			}
		}
		}
		for(Block ball:balls)
		{
		ball.x+=ball.dx;
	if(ball.x>getWidth()-ball.width||ball.x<0)
	{
		ball.dx*=-1;
		ball.x+=ball.dx;
	}
	if(ball.y<0||ball.intersects(slider))
	{
		ball.dy*=-1;
	}
	ball.y+=ball.dy;
	for(Block b:blocks)
	{
		if((b.left.intersects(ball)||b.right.intersects(ball))&&!b.banged)
		{
			b.banged=true;
			b.dx*=-1;
			if(b.power==true)
			{
				powers.add(new Block(b.x,b.y,65,65,"FlyingBall.png"));
			}
		}
	else if(ball.intersects(b)&&!b.banged)
	{
		b.banged=true;
		ball.dy*=-1;
		if(b.power==true)
			{
				powers.add(new Block(b.x,b.y,65,65,"FlyingBall.png"));
			}
	}
	}
if(ball.y>getHeight())
	ball.banged=true;
		}
	repaint();
	}
}