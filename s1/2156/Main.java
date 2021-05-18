import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
	static int max(int[][] dp, int n)
	{
		int _max = 0;
		_max = dp[n][0]>dp[n][1]?dp[n][0]:dp[n][1];
		_max = _max>dp[n][2]?_max:dp[n][2];
		return _max;
	}
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] cup = new int[n];
		for(int i=0; i<n; i++)
			cup[i] = Integer.parseInt(bf.readLine());
		int[][] dp = new int[n][3];
		dp[0][0] = cup[0];
		dp[0][1] = cup[0];
		dp[0][2] = 0;
		for(int i=1; i<n; i++)
		{
			dp[i][0] = dp[i-1][2] + cup[i];
			dp[i][1] = dp[i-1][0] + cup[i];
			dp[i][2] = max(dp, i-1);
		}
		System.out.println(max(dp, n-1));
	}
}
