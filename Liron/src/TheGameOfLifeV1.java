import java.util.*;
public class TheGameOfLifeV1 
{
	private static boolean world  [][]=new boolean[6][6];
	private static boolean thisworld  [][]=new boolean[6][6];
	private static boolean save  [][]=new boolean[6][6];
	private static int gen=1;
	private static Scanner in;
	public static void Createwworld () 
	{
		for(int row=1;row<5;row++) 
		{
			for(int column=1;column<5;column++)
			{
				world[row][column]=(Math.random()<0.5);
		
			}
		}	
		
	}
	
	public static void PrintWorld () 
	{
		System.out.println("This is gen "+gen);
		for(int row=1;row<5;row++) 
		{
			for(int column=1;column<5;column++)
			{
				System.out.print(world[row][column]?'V':'X');
				System.out.print('\t');
			}
			System.out.println();
		}
	}
	
	public static boolean Alivecheck(int row,int column) 
	{
		int Alive=0;
		boolean curralive=thisworld[row][column];
		for(int r=-1;r<=1;r++) 
		{
			int neghiborrow=row+r;
			for(int c=-1;c<=1;c++)
			{
				int neghiborcolumn=column+c;
				if(thisworld[neghiborrow][neghiborcolumn])
				{
					Alive++;
				}
			}
		}

		if (curralive)
		{
			Alive--;
		}
		
		if(Alive==2 && curralive) 
		{
			return true;
		}
		else if(Alive==3) 
		{
			return true;
		}
		else
			return false;

	}
	public static void nextgen() 
	{
		
		gen++;
		for (int row=1;row<5;row++) 
		{
			for (int column=1;column<5;column++) 
			{
				thisworld=world;
				thisworld[row][column]=Alivecheck(row,column);
				save[row][column]=thisworld[row][column];
			}
		}
		world=save;
	}
	public static void main(String []args)
	{
		in = new Scanner(System.in);
		Createwworld ();
		PrintWorld ();
		System.out.println("how many more gens you want?");
		int numofgens=in.nextInt();
		for(int counter=0;counter<numofgens;counter++)
		{
			nextgen();
			PrintWorld();
		}
	}
}
