import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] budget = new int [n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0; i<n; i++)
			budget[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(budget);
		int total = Integer.parseInt(bf.readLine());
		int iter, answer=0;
		for(iter = 0; iter<n; iter++)
		{
			int avg = total/(n-iter);
			answer = budget[iter];
			if(avg>=answer)
				total -= answer;
			else
				break;
		}
		if(iter<n)
			System.out.println(total/(n-iter));
		else
			System.out.println(answer);
	}
}
