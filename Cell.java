
public class Cell {

	private boolean alive;
	private int friends;
	private int row;
	private int col;
	
	public Cell(boolean alive,int row,int col)
	{
		this.alive =alive;
		this.row = row;
		this.col = col;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getfriends() {
		return friends;
	}

	public void setfriends(int friends) {
		this.friends = friends;
	}
	
	public void friend(Cell[][] a)	
	{
		for(int r=-1;r<=1;r++) 
		{
			int neghiborrow=this.row+r;
			for(int c=-1;c<=1;c++)
			{
				try
				{
				int neghiborcolumn=this.col+c;
				if(a[neghiborrow][neghiborcolumn].isAlive())
					this.friends++;
				}
				catch (Exception e) {
					
				}
			}
		}
		if (this.alive)
		{
			this.friends--;
		}
	}
	public void nextGen()
	{

		if(this.friends==2 && this.alive) 
		{
			this.alive=true;
		}
		else if(this.friends==3) 
		{
			this.alive=true;
		}
		else
		{	
			this.alive=false;
		}
	}
}
