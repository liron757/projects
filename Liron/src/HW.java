import java.util.*;
public class HW
{
	public static void main(String[]args)
	{
		Random rnd=new Random();
		int a,b;
		int mone=0;
		
		do
		{
			a=rnd.nextInt(6)+1;
			b=rnd.nextInt(6)+1;
			System.out.println(a+","+b);
			mone++;
		}
		while(a!=b);
		System.out.println("mone="+mone);
	}
}
