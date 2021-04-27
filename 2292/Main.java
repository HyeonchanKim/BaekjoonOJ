import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 1, last_num = 1;
		while(n>last_num)
			last_num += 6*(count++);
		System.out.println(count);
	}
}
