import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MyFrame extends JFrame
{BlockBuilder bBuild;
	MyFrame(String s)
	{
	super(s);
		setSize(408,600);
		setVisible(true);
		setResizable(false);
		//setLayout(new FlowLayout());
		bBuild=new BlockBuilder(this);
		getContentPane().add(bBuild);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
void drawDialogStart()
{
	ImageIcon i=new ImageIcon("enter.jpg");
		ImageIcon j=new ImageIcon("leftArrow.png");
		ImageIcon k=new ImageIcon("rightArrow.png");
		JComponent[] jcomp=new JComponent[]{new JLabel("press enter to start"),new JLabel(i),new JLabel("left arrow to move slider left"),new JLabel(j),new JLabel("right arrow to move slider right"),new JLabel(k)};
		JOptionPane.showMessageDialog(bBuild,jcomp,"info",JOptionPane.INFORMATION_MESSAGE);
}
}