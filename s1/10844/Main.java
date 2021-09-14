import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		long[][] dp = new long[n+1][10];
		for(int i=0; i<=n; i++)
			for(int j=0; j<10; j++)
				dp[i][j] = 0;
		for(int i=1; i<10; i++)
			dp[1][i] = 1;
		for(int i=2; i<=n; i++)
		{
			for(int j=1; j<9; j++)
			{
				dp[i][j-1] += dp[i-1][j];
				dp[i][j-1] %= 1000000000;
				dp[i][j+1] += dp[i-1][j];
				dp[i][j+1] %= 1000000000;
			}
			dp[i][1] += dp[i-1][0];
			dp[i][1] %= 1000000000;
			dp[i][8] += dp[i-1][9];
			dp[i][8] %= 1000000000;
		}
		int answer = 0;
		for(int i=0; i<10; i++)
		{
			answer += dp[n][i];
			answer %= 1000000000;
		}
		System.out.println(answer);
	}
}
