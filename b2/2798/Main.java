import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n, m;
		n = sc.nextInt();
		m = sc.nextInt();
		int cards[] = new int [n];
		for(int i=0; i<n; i++)
			cards[i] = sc.nextInt();
		int result = 0;
		for(int i=0; i<n-2; i++)
			for(int j=i+1; j<n-1; j++)
				for(int k=j+1; k<n; k++)
				{
					int temp = cards[i]+cards[j]+cards[k];
					if(temp>result && temp <= m)
						result = temp;
				}
		System.out.println(result);
	}
}
