import java.util.Scanner;


public class TheGameOfLifeV2
{
	public final static int dimension=5;
	private static Cell[][] cells= new Cell[dimension][dimension];
	private static int gen=1;
	private static Scanner in;
	
	
	private static void createWorld () 
	{
		for(int row=0;row<dimension;row++) 
		{
			for(int column=0;column<dimension;column++)
				cells[row][column]= new Cell((Math.random()<0.5), row, column);
		}	
	}
	
	private static void printWorld () 
	{
		System.out.println("This is gen "+gen);
		for(int row=0;row<dimension;row++) 
		{
			for(int column=0;column<dimension;column++)
			{
				System.out.print(cells[row][column].isAlive()?'V':'X');
				System.out.print('\t');
			}
			System.out.println();
		}
	}
	
	private static void aliveCount() 
	{
		for(int row=0;row<dimension;row++) 
		{
			for(int column=0;column<dimension;column++)
			{
				cells[row][column].friend(cells);
			}
		}	
	}
	
	
	private static void nextGen() 
	{
		gen++;
		aliveCount();
		for (int row=0;row<dimension;row++) 
		{
			for (int column=0;column<dimension;column++) 
			{	
				cells[row][column].nextGen();
			}
		}
	}
	public static void main(String []args)
	{
		in = new Scanner(System.in);
		createWorld ();
		printWorld ();
		System.out.println("how many gens you want?");
		int numofgens=in.nextInt();
		for(int counter=0;counter<numofgens;counter++)
		{
			nextGen();
			printWorld();
		}
	}
}
