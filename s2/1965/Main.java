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
		int[] box = new int[n];
		int[] dp = new int[n];
		for(int i=0; i<n; i++)
		{
			box[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		int max = 1;
		for(int i=0; i<n; i++)
			for(int j=0; j<i; j++)
				if(box[i]>box[j] && dp[i] < dp[j] + 1)
				{
					dp[i] = dp[j] + 1;
					max = dp[i] > max ? dp[i] : max;
				}
		System.out.println(max);
	}
}
