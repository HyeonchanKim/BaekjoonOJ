import java.util.Scanner;

public class Main
{
	public static int get_gcd(int a, int b)
	{
		if(b==0) return a;
		else return get_gcd(b, a%b);
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int x1 = sc.nextInt(), x2 = sc.nextInt(), y1 = sc.nextInt(), y2 = sc.nextInt();
		int a = x1*y2 + x2*y1, b = x2*y2;
		int gcd = get_gcd(a, b);
		System.out.printf("%d %d\n", a/gcd, b/gcd);
	}
}
