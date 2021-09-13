import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		int[][] height = new int[n][n];
		int max_num = 0;
		for(int i=0; i<n; i++)
		{
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0; j<n; j++)
			{
				height[i][j] = Integer.parseInt(st.nextToken());
				max_num = height[i][j] > max_num ? height[i][j] : max_num;
			}
		}
		int[] move_x = {1, -1, 0, 0};
		int[] move_y = {0, 0, 1, -1};
		int answer = 0;
		for(int rain=0; rain<max_num; rain++)
		{
			boolean[][] visit = new boolean[n][n];
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					visit[i][j] = false;
			int count_region = 0;
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<n; j++)
				{
					if(!visit[i][j])
					{
						visit[i][j] = true;
						if(height[i][j] > rain)
						{
							count_region += 1;
							LinkedList<Integer> q = new LinkedList<>();
							q.add(i);
							q.add(j);
							while(q.size() > 0)
							{
								int now_x = q.remove();
								int now_y = q.remove();

								for(int k=0; k<4; k++)
								{
									int x = now_x + move_x[k];
									int y = now_y + move_y[k];
									if(x<0 || x>=n || y<0 || y>=n)
										continue;
									if(!visit[x][y] && height[x][y] > rain)
									{
										visit[x][y] = true;
										q.add(x);
										q.add(y);
									}
								}
							}
						}
					}
				}
			}
			answer = answer>count_region ? answer : count_region;
		}
		System.out.println(answer);
	}
}
