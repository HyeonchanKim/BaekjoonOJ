import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		int[] num = new int [t];
		int max_num = 0;
		for(int i=0; i<t; i++)
		{
			num[i] = Integer.parseInt(bf.readLine());
			if(num[i] > max_num)
				max_num = num[i];
		}
		int[][] fibo = new int [max_num+1][2];
		fibo[0][0] = 1;
		fibo[0][1] = 0;
		fibo[1][0] = 0;
		fibo[1][1] = 1;
		for(int i=2; i<=max_num; i++)
		{
			for(int j=0; j<2; j++)
				fibo[i][j] = fibo[i-1][j]+fibo[i-2][j];
		}
			for(int i = 0; i<t; i++)
			System.out.printf("%d %d\n", fibo[num[i]][0], fibo[num[i]][1]);
	}
}
