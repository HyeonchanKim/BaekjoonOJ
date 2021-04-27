import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int result[] = new int[t];
		for(int i=0; i<t; i++)
		{
			int h, w, n;
			h = sc.nextInt();
			w = sc.nextInt();
			n = sc.nextInt();
			int y = n%h;
			if(y==0)
				y = h;
			int x = n/h;
			if(y!=h)
				x += 1;
			result[i] = 100*y + x;
		}
		for(int i=0; i<t; i++)
			System.out.println(result[i]);
	}
}
