import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int result[] = new int [t];
		for(int i=0; i<t; i++)
		{
			int k, n;
			k = sc.nextInt();
			n = sc.nextInt();
			int apart[][] = new int [k+1][n];
			for(int j=0; j<n; j++)
				apart[0][j] = j+1;
			for(int j=1; j<=k; j++)
				apart[j][0] = 1;
			for(int j=1; j<=k; j++)
				for(int l=1; l<n; l++)
					apart[j][l] = apart[j-1][l] + apart[j][l-1];
			result[i] = apart[k][n-1];
		}
		for(int i=0; i<t; i++)
			System.out.println(result[i]);
	}
}
