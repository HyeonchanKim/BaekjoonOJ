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
		int[] p = new int [n+1];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=1; i<n+1; i++)
		{
			p[i] = Integer.parseInt(st.nextToken());
			for(int j=1; j<i; j++)
			{
				int temp = p[i-j] + p[j];
				if(temp > p[i])
					p[i] = temp;
			}
		}
		System.out.println(p[n]);
	}
}
