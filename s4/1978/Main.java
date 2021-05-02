import java.util.Scanner;
import java.util.Arrays;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int [n];
		for(int i=0; i<n; i++)
			num[i] = sc.nextInt();
		Arrays.sort(num);
		boolean[] check_prime = new boolean [num[n-1]+1];
		Arrays.fill(check_prime, true);
		check_prime[1] = false;
		for(int i=2; i<num[n-1]+1; i++)
		{
			if(check_prime[i])
			{
				int temp = i*2;
				while(temp < num[n-1]+1)
				{
					check_prime[temp] = false;
					temp += i;
				}
			}
		}
		int count = 0;
		for(int i=0; i<n; i++)
			if(check_prime[num[i]])
				count += 1;
		System.out.println(count);
	}
}
