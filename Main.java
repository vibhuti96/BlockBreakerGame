import javax.swing.*;
class Main
{static MyFrame f,f1;
	public static void main(String args[])
	{
		/*SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
		MyFrame f=new MyFrame("Block Breaker");
		}
		});*/
		f=new MyFrame("Block Breaker");
		f.drawDialogStart();
	}
	public static void startAgain()
	{
		f.setVisible(false);
		f1=new MyFrame("Block Breaker");
	}
}