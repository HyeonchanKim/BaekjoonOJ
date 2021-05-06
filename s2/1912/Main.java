import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] seq = new int [n];
		int[] dp = new int [n];
		seq[0] = Integer.parseInt(st.nextToken());
		dp[0] = seq[0];
		int max = dp[0];
		for(int i=1; i<n; i++)
		{
			seq[i] = Integer.parseInt(st.nextToken());
			if(dp[i-1] > 0)
				dp[i] = dp[i-1] + seq[i];
			else
				dp[i] = seq[i];
			if(dp[i] > max)
				max = dp[i];
		}
		System.out.println(max);
	}
}
