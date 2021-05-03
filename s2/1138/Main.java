import java.util.Scanner;
import java.util.LinkedList;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] people = new int [n];
		for(int i=0; i<n; i++)
			people[i] = sc.nextInt();
		LinkedList<Integer> order = new LinkedList<>();
		order.add(n);
		for(int i = n-1; i>0; i--)
		{
			int count = people[i-1];
			for(int j=0; j<order.size()+1; j++)
			{
				if(count == 0)
				{
					order.add(j, i);
					break;
				}
				if(order.get(j) > i)
					count --;
			}
		}
		for(Integer i: order)
			System.out.printf("%d ", i);
		System.out.println();
	}
}
