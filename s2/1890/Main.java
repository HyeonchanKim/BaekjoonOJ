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
		int[][] pan = new int [n][n];
		for(int i=0; i<n; i++)
		{
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0; j<n; j++)
				pan[i][j] = Integer.parseInt(st.nextToken());
		}
		long [][] count_visit = new long [n][n];
		count_visit[0][0] = 1;
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				int jump = pan[i][j];
				if(jump == 0)
					continue;
				if(i+jump < n)
					count_visit[i+jump][j] += count_visit[i][j];
				if(j+jump < n)
					count_visit[i][j+jump] += count_visit[i][j];
			}
		}
		System.out.println(count_visit[n-1][n-1]);
	}
}
