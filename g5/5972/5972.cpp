#include<cstdio>
#include<queue>
#include<vector>
#include<climits>
using namespace std;

int main()
{
	int n, m;
	scanf("%d %d", &n, &m);
	vector<pair<int, int>> *adj_list = new vector<pair<int, int>>[n+1];
	for(int i=0; i<m; i++)
	{
		int a, b, c;
		scanf("%d %d %d", &a, &b, &c);
		adj_list[a].push_back({b, c});
		adj_list[b].push_back({a, c});
	}
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> q;
	q.push({0, 1});
	int *cow = new int [n+1];
	for(int i=0; i<n+1; i++)
		cow[i] = INT_MAX;
	cow[1] = 0;
	vector<pair<int, int>>::iterator iter;
	while(q.size()>0)
	{
		pair<int, int> u = q.top();
		q.pop();
		if(u.second == n)
			break;
		if(u.first > cow[u.second])
			continue;
		for(iter = adj_list[u.second].begin(); iter != adj_list[u.second].end(); iter++)
		{
			pair<int, int> now = *iter;
			int alt = u.first + now.second;
			if(alt < cow[now.first])
			{
				cow[now.first] = alt;
				q.push({alt, now.first});
			}
		}
	}
	printf("%d\n", cow[n]);

	delete[] adj_list;
	delete[] cow;
	return 0;
}
