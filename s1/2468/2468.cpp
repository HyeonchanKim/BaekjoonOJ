#include<cstdio>
#include<vector>
using namespace std;

int main()
{
	int n;
	scanf("%d", &n);
	int ** height = new int*[n];
	bool ** visit = new bool*[n];
	int max_num = 0;
	for(int i=0; i<n; i++)
	{
		height[i] = new int[n];
		visit[i] = new bool[n];
		for(int j=0; j<n; j++)
		{
			scanf("%d", &height[i][j]);
			max_num = height[i][j] > max_num ? height[i][j] : max_num;
		}
	}
	int move_x[4] = {1, -1, 0, 0};
	int move_y[4] = {0, 0, 1, -1};
	int answer = 0;
	for(int rain=0; rain<max_num; rain++)
	{
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
						vector<int> q;
						q.push_back(i);
						q.push_back(j);

						while(q.size() > 0)
						{
							int now_x = q.front();
							q.erase(q.begin());
							int now_y = q.front();
							q.erase(q.begin());
							for(int k=0; k<4; k++)
							{
								int x = now_x + move_x[k];
								int y = now_y + move_y[k];
								if(x<0 || x>=n || y<0 || y>=n)
									continue;
								if(!visit[x][y] && height[x][y] > rain)
								{
									visit[x][y] = true;
									q.push_back(x);
									q.push_back(y);
								}
							}
						}
					}
				}
			}
		}

		answer = count_region > answer ? count_region : answer;
	}
	printf("%d\n", answer);

	for(int i=0; i<n; i++)
	{
		delete[] height[i];
		delete[] visit[i];
	}
	delete[] height;
	delete[] visit;
	return 0;
}
