import java.util.Scanner;

public class Main
{
	static public long[][] mat_mult(long[][] mat1, long[][] mat2)
	{
		long[][] result = new long[2][2];
		for(int i=0; i<2; i++)
			for(int j=0; j<2; j++)
				for(int k=0; k<2; k++)
					result[i][j] = (result[i][j] + mat1[i][k]*mat2[k][j])%1000000007;
		return result;
	}
	static public long[][] power(long n)
	{
		long[][] mat = {{1, 1}, {1, 0}};
		if(n<2)
			return mat;
		else if(n%2==0)
		{
			long[][] half_pow = power(n/2);
			return mat_mult(half_pow, half_pow);
		}
		else
		{
			long[][] half_pow = power(n/2);
			return mat_mult(mat_mult(half_pow, half_pow), mat);
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long[][] answer = power(n);
		System.out.println(answer[1][0]);
	}
}
