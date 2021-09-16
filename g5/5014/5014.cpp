#include<cstdio>
#include<vector>
using namespace std;

int main()
{
	int f, s, g, u, d;
	scanf("%d %d %d %d %d", &f, &s, &g, &u, &d);
	bool *visit = new bool[f+1];
	for(int i=0; i<=f; i++)
		visit[i] = false;
	visit[s] = true;
	bool check_arrive = false;
	int answer = 0;
	vector<int> q;
	q.push_back(s);
	q.push_back(0);
	while(q.size() > 0)
	{
		int now_floor = q.front();
		q.erase(q.begin());
		int count = q.front();
		q.erase(q.begin());
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
			q.push_back(floor_u);
			q.push_back(count+1);
		}
		if(floor_d > 0 && !visit[floor_d])
		{
			visit[floor_d] = true;
			q.push_back(floor_d);
			q.push_back(count+1);
		}
	}
	if(check_arrive)
		printf("%d\n", answer);
	else
		printf("use the stairs\n");

	delete[] visit;
	return 0;
}
