import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 0;
		for(int i=1; i<=n; i++)
		{
			int temp = i;
			int sum = i;
			while(temp > 0)
			{
				sum += temp%10;
				temp /= 10;
			}
			if(sum == n)
			{
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
}
