import java.util.Scanner;

public class BSearch 
{
	private static Scanner in;
	public static boolean IntegerCheck (String s) 
	{
		try {	
			int num1 = Integer.parseInt(s.substring(0, s.indexOf("-")));
			int num2 = Integer.parseInt(s.substring(s.indexOf("-")+1));	
		} catch (Exception e) {
			return false;
		}
		return true;
	}	
	
	public static boolean pluscheck(String inputString) {
	    if (inputString.length() == 1)
        {
            return true;
        }else 
        	return false;
	}
	public static void placefix(int highnum,int lownum)
	{
	
	}
	public static void BinarySearch(int highnum,int lownum) 
	{
		int mid;
		do 
		{
			
		
		mid=(highnum+lownum)/2;
		System.out.println("Higer(+) or lower/equal(-) then "+mid);
		String c=in.nextLine();
		while(!pluscheck(c)) 
		{
			System.out.println("Input rejected, Higer(+) or lower/equal(-) then "+mid);
			c=in.nextLine();
		}
		char g=c.charAt(0);	
		if(g=='+') 
		{
			lownum=mid;
			++lownum;
		}	
		if(g=='-') 	
				highnum=mid;
		}while(highnum!=lownum);		
		System.out.println("your number is "+highnum);
	}	
	public static void main (String[]args )
	{
			in = new Scanner(System.in);
			int highnum,lownum;
			
			do
			{

				System.out.println("Enter the range of numbers ");
				String s= in.nextLine();
				while(!IntegerCheck(s))
				{
					System.out.println("Wrong range,enter new one ");
					s= in.nextLine();
				}
				highnum = Integer.parseInt(s.substring(0, s.indexOf("-")));
				lownum = Integer.parseInt(s.substring(s.indexOf("-")+1));
				
			}
			while(highnum==lownum && highnum<lownum);
			if (lownum>highnum)
			{
				int b;
				b=highnum;
				highnum=lownum;
				lownum=b;
			}
			
			BinarySearch(highnum,lownum);
	
	} 
}
