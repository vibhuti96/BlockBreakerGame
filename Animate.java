class Animate implements Runnable
{BlockBuilder b;
	Animate(BlockBuilder b)
	{
		this.b=b;
	}
	public void run()
	{
		while(true)
		{
		b.update();
		try
		{
			Thread.sleep(10);
		}
		catch(Exception e)
		{
			System.out.println("exception"+e);
		}
		}
	}
}