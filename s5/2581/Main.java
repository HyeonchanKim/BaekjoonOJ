import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int m, n;
		m = sc.nextInt();
		n = sc.nextInt();
		boolean[] check_prime = new boolean [n+1];
		for(int i=2; i<=n; i++)
			check_prime[i] = true;
		check_prime[0] = false;
		check_prime[1] = false;
		int sum_prime = 0;
		int min_prime = 0;
		for(int i=2; i<=n; i++)
		{
			if(check_prime[i])
			{
				if(i>=m)
				{
					sum_prime += i;
					if(min_prime==0)
						min_prime = i;
				}
			}
			int temp = i*2;
			while(temp <= n)
			{
				check_prime[temp] = false;
				temp += i;
			}
		}
		if(sum_prime==0)
			System.out.println(-1);
		else
			System.out.printf("%d\n%d\n", sum_prime, min_prime);
	}
}
