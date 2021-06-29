import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] result = new int [t];
		for(int i=0; i<t; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			result[i] = a*b/gcd(a, b);
		}
		for(int i=0; i<t; i++)
			System.out.println(result[i]);
	}
	public static int gcd(int a, int b)
	{
		int r = a%b;
		if(r==0)
			return b;
		else
			return gcd(b, r);
	}
}
