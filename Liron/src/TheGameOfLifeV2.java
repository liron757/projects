import java.util.Scanner;

public class TheGameOfLifeV2
{
	private static boolean world  [][]=new boolean[6][6];
	private static int AliveCounter  [][]=new int[6][6];
	private static int gen=1;
	private static Scanner in;
	
	private static void Createwworld () 
	{
		for(int row=1;row<5;row++) 
		{
			for(int column=1;column<5;column++)
				world[row][column]=(Math.random()<0.5);
		}	
	}
	
	private static void PrintWorld () 
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
	
	private static void AliveCount(int row,int column) 
	{
		int Alive=0,neghiborrow,neghiborcolumn;
		boolean curralive=world[row][column];
		
		for(int r=-1;r<=1;r++) 
		{
			neghiborrow=row+r;
			for(int c=-1;c<=1;c++)
			{
				neghiborcolumn=column+c;
				if(world[neghiborrow][neghiborcolumn])
					Alive++;
			}
		}
		if (curralive)
		{
			Alive--;
		}
		AliveCounter[row][column]=Alive;
	}
	
	private static boolean rules (int row,int column)
	{
		boolean curralive=world[row][column];
		int Alive=AliveCounter[row][column];
		
		if(Alive==2 && curralive) 
		{
			return true;
		}
		else if(Alive==3) 
		{
			return true;
		}
		else
		{	
			return false;
		}
	}
	
	private static void nextgen() 
	{
		gen++;
		for (int row=1;row<5;row++) 
		{
			for (int column=1;column<5;column++) 
			{	
				AliveCount(row,column);
			}
		}
		for (int row=1;row<5;row++) 
		{
			for (int column=1;column<5;column++) 
			{	
				world[row][column]=rules(row,column);
			}
		}
	}
	public static void main(String []args)
	{
		in = new Scanner(System.in);
		Createwworld ();
		PrintWorld ();
		System.out.println("how many gens you want?");
		int numofgens=in.nextInt()-1;
		for(int counter=0;counter<numofgens;counter++)
		{
			nextgen();
			PrintWorld();
		}
	}
}
