import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = {1, 3};
		for(int i=1; i<n; i++)
		{
			int temp = (dp[1]*2 + dp[0])%9901;
			dp[0] = dp[1];
			dp[1] = temp;
		}
		System.out.println(dp[1]);
	}
}
