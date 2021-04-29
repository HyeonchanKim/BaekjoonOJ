import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
	static boolean palindrome(int n)
	{
		String s = Integer.toString(n);
		int len = s.length();
		char[] c = s.toCharArray();
		boolean check = true;
		for(int i=0; i<len; i++)
		{
			if(c[i] != c[len-i-1])
			{
				check = false;
				break;
			}
		}
		return check;

	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean check_prime[] = new boolean[n];
		ArrayList<Integer> prime_number = new ArrayList<Integer>();
		for (int i=0; i<n; i++)
			check_prime[i] = true;
		for (int i=2; i<n; i++)
		{
			if(check_prime[i])
			{
				prime_number.add(i);
				int temp = i*2;
				while (temp < n)
				{
					check_prime[i] = false;
					temp += i;
				}
			}
		}
		int answer = 0;
		int num = n;
		while (answer == 0)
		{
			if (palindrome(num))
			{
				answer = num;
				for(Integer i:prime_number)
				{
					if(num%i == 0)
					{
						answer = 0;
						break;
					}
				}
			}
			num += 1;
		}
		if(n==1)
			answer = 2;
		System.out.println(answer);
	}
}
