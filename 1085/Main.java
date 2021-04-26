import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int x, y, w, h;
		x = sc.nextInt();
		y = sc.nextInt();
		w = sc.nextInt();
		h = sc.nextInt();
		System.out.println(Math.min(Math.min(x, y), Math.min(w-x, h-y)));
	}
}
