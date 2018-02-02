import java.util.*;
public class MazeMain  
{
	private static Stack<Maze> options=new Stack<Maze>();
	static int [][] maze = 
		{ 
			 {1,1,1,1,1,1,1,1,1,1},
			 {1,0,1,0,1,0,1,0,0,1},
			 {1,0,1,0,0,0,1,0,1,1},
			 {1,0,0,0,1,1,1,0,0,1},
			 {1,0,1,0,0,0,0,0,1,1},
			 {1,0,1,0,1,1,1,0,1,1},
			 {1,0,1,0,1,0,0,0,1,1},
			 {1,0,1,0,1,1,1,0,1,1},
			 {1,0,0,1,0,0,0,0,0,1},
			 {1,1,1,1,1,1,1,1,1,1}
		};	
	
	public static void printMaze() {
		for(int row=0;row<maze.length;row++) 
		{
			for(int column=0;column<maze.length;column++)
			{	
				if(maze[row][column]==1)
					System.out.print("X ");
				else if(maze[row][column]==2)
					System.out.print("+ ");
				else
					System.out.print("  ");
			
			}
			System.out.println();
		}
		System.out.println();
	}

	public static int options(int row,int col) 
	{
		int opt=0;
		opt=opt+checkBorder(row+1,col);
		opt=opt+checkBorder(row-1,col);
		opt=opt+checkBorder(row,col+1);
		opt=opt+checkBorder(row,col-1);
		return opt;
	}

	public static int checkBorder (int row, int col)
	{
		int opt=0;
		try {
			if(maze[row][col]==0)
			{
				options.push(new Maze(row,col));
				opt++;
			}
		} catch (Exception e) {	}
		return opt;
	}
	
	public static Maze oneOptionMove(int row, int col)
	{
		maze[row][col]=2;
		row =options.peek().getX();
		col =options.pop().getY();
		return new Maze(row,col);
		
	}

	public static Maze move(int row,int col)
	{
		maze[row][col]=2;
		row =options.peek().getX();
		col=options.pop().getY();
		return new Maze(row,col);		
	}
	
	
	public static void main(String []args)
	{
		Maze Maze =new Maze (1,1);
		while (maze[8][8]==0)
		{
			int opt=options(Maze.getX(),Maze.getY());
			
			if(opt==0&&Maze.getX()==8&&Maze.getY()==8)
				maze[8][8]=2;
			
			else if(opt==1)
			{
				Maze =oneOptionMove(Maze.getX(),Maze.getY());
			}
			
			else 
			{
				while(opt!=0)
				{
					Maze =move(Maze.getX(),Maze.getY());
					opt=options(Maze.getX(),Maze.getY());
				}
					Maze.setX(options.peek().getX());
					Maze.setY(options.pop().getY());
			}
		}
		printMaze();
	}
}
