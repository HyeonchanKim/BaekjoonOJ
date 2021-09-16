import java.util.Scanner;
import java.util.LinkedList;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int f, s, g, u, d;
		f = sc.nextInt();
		s = sc.nextInt();
		g = sc.nextInt();
		u = sc.nextInt();
		d = sc.nextInt();

		boolean[] visit = new boolean[f+1];
		for(int i=0; i<=f; i++)
			visit[i] = false;
		visit[s] = true;
		boolean check_arrive = false;
		int answer = 0;
		LinkedList<Integer> q = new LinkedList<>();
		q.add(s);
		q.add(0);
		while(q.size() > 0)
		{
			int now_floor = q.removeFirst();
			int count = q.removeFirst();
			if(now_floor == g)
			{
				check_arrive = true;
				answer = count;
				break;
			}
			int floor_u = now_floor + u;
			int floor_d = now_floor - d;

			if(floor_u <= f && !visit[floor_u])
			{
				visit[floor_u] = true;
				q.add(floor_u);
				q.add(count+1);
			}
			if(floor_d > 0 && !visit[floor_d])
			{
				visit[floor_d] = true;
				q.add(floor_d);
				q.add(count+1);
			}
		}
		if(check_arrive)
			System.out.println(answer);
		else
			System.out.println("use the stairs");
	}
}
