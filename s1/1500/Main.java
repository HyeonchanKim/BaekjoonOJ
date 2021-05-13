import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		long s = sc.nextLong(), k = sc.nextLong();
		long mod = s%k;
		long answer = 1;
		for(int i=0; i<mod; i++)
			answer *= s/k+1;
		for(int i=0; i<k-mod; i++)
			answer *= s/k;
		System.out.println(answer);
	}
}
