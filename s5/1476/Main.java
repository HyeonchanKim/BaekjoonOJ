import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int e, s, m;
		e = sc.nextInt();
		s = sc.nextInt();
		m = sc.nextInt();

		int x = 1;
		while((x-e) % 15 != 0 || (x-s) % 28 != 0 || (x-m) % 19 != 0)
			x += 1;
		System.out.println(x);
	}
}
