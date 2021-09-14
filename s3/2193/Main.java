import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] end0 = new long[n+2];
		long[] end1 = new long[n+2];
	        end0[0] = 0;
	        end0[1] = 0;
	        end0[2] = 1;
	        end1[0] = 0;
	        end1[1] = 1;
	        end1[2] = 0;
		for(int i=3; i<=n; i++)
		{
			end0[i] = end0[i-1] + end1[i-1];
			end1[i] = end0[i-1];
		}
		System.out.println(end0[n] + end1[n]);
	}
}
