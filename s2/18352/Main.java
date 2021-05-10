import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

public class Main
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n, m , k, x;
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> adj_list = new ArrayList<>();
		boolean[] visit = new boolean[n+1];
		for(int i=0; i<=n; i++)
		{
			adj_list.add(new ArrayList<Integer>());
			visit[i] = false;
		}
		visit[x] = true;
		for(int i=0; i<m; i++)
		{
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			adj_list.get(a).add(Integer.parseInt(st.nextToken()));
		}
		LinkedList<Integer> q = new LinkedList<>();
		LinkedList<Integer> answer = new LinkedList<>();
		q.add(x);
		q.add(0);
		while(q.size() > 0)
		{
			int node = q.remove();
			int d = q.remove();
			if(d==k)
				answer.add(node);
			if(d>k)
				break;
			for(Integer i : adj_list.get(node))
			{
				if(!visit[i])
				{
					visit[i] = true;
					q.add(i);
					q.add(d+1);
				}
			}
		}
		Collections.sort(answer);
		if(answer.size() == 0)
			System.out.println(-1);
		else
			for(Integer i : answer)
				System.out.println(i);
	}
}
