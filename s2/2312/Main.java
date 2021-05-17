import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] todo = new int [n];
		int max = 0;
		for(int i=0; i<n; i++)
		{
			todo[i] = Integer.parseInt(bf.readLine());
			max = todo[i] > max? todo[i] : max;
		}
		boolean[] check_prime = new boolean [max+1];
		for(int i=0; i<=max; i++)
			check_prime[i] = true;
		ArrayList<Integer> prime_number = new ArrayList<>();
		for(int i=2; i<=max; i++)
		{
			if(check_prime[i])
			{
				prime_number.add(i);
				int temp = i*2;
				while(temp <= max)
				{
					check_prime[temp] = false;
					temp += i;
				}
			}
		}
		for(int i=0; i<n; i++)
		{
			int k = todo[i];
			for(Integer prime : prime_number)
			{
				if(k==1)
					break;
				int count = 0;
				while (k%prime == 0)
				{
					count += 1;
					k /= prime;
				}
				if(count!=0)
					System.out.printf("%d %d\n", prime, count);
			}
		}
	}
}
