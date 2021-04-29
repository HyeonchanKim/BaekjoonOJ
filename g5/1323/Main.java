import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		long n, k;
		n = sc.nextLong();
		k = sc.nextLong();
		int nlength = String.valueOf(n).length();
		long add = Math.round(Math.pow(10, nlength))%k;
		long count = 1, prev = 0;
		while(count <= k)
		{
			prev = ((prev*add)+n)%k;
			if(prev==0)
				break;
			count += 1;
		}
		if(count > k)
			count = -1;
		System.out.println(count);
	}
}
