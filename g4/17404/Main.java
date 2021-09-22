import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static int min(int a, int b) {return a < b ? a : b;}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		int[][] cost = new int[n][3];
		int[][] dp = new int[n][3];
		for(int i=0; i<n; i++)
		{
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<3; j++)
				cost[i][j] = Integer.parseInt(st.nextToken());
		}
		int answer = 10000000;
		for(int color=0; color<3; color++)
		{
			for(int i=0; i<3; i++)
				dp[0][i] = i!=color ? 10000000 : cost[0][i];
			for(int i=1; i<n; i++)
			{
				dp[i][0] = cost[i][0] + min(dp[i-1][1], dp[i-1][2]);
				dp[i][1] = cost[i][1] + min(dp[i-1][0], dp[i-1][2]);
			        dp[i][2] = cost[i][2] + min(dp[i-1][0], dp[i-1][1]);
			}
			for(int i=0; i<3; i++)
				if(i != color)
					answer = min(answer, dp[n-1][i]);
		}
		System.out.println(answer);
	}
}
