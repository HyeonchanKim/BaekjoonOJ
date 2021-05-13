import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main
{
	static class Cost implements Comparable<Cost>
	{
		int node;
		int cows;
		
		public Cost(int node, int cows)
		{
			this.node = node;
			this.cows = cows;
		}
		@Override
		public int compareTo(Cost target)
		{
			return this.cows <= target.cows ? -1: 1;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<int[]>> adj_list = new ArrayList<>();;
		for(int i=0; i<=n; i++)
			adj_list.add(new ArrayList<int[]>());
		for(int i=0; i<m; i++)
		{
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj_list.get(a).add(new int[] {b, c});
			adj_list.get(b).add(new int[] {a, c});
		}
		PriorityQueue<Cost> q = new PriorityQueue<>();
		q.add(new Cost(1, 0));
		int[] cow = new int[n+1];
		for(int i=0; i<=n; i++)
			cow[i] = Integer.MAX_VALUE;
		cow[1] = 0;
		while(q.size()>0)
		{
			Cost u = q.poll();
			if(u.node == n)
				break;
			if(u.cows > cow[u.node])
				continue;
			for(int i=0; i<adj_list.get(u.node).size(); i++)
			{
				int[] node = adj_list.get(u.node).get(i);
				int alt = node[1] + u.cows;
				if(alt < cow[node[0]])
				{
					cow[node[0]] = alt;
					q.add(new Cost(node[0], alt));
				}
			}
		}
		System.out.println(cow[n]);
	}
}
