#include<cstdio>
#include<list>
using namespace std;

int main()
{
	int n, m, k, x;
	scanf("%d %d %d %d", &n, &m, &k, &x);
	bool *visit = new bool[n+1];
	for(int i=0; i<=n; i++)
		visit[i] = false;
	visit[x] = true;
	list<int> *adj_list = new list<int>[n+1];
	list<int>::iterator iter;
	for(int i=0; i<m; i++)
	{
		int a, b;
		scanf("%d %d", &a, &b);
		adj_list[a].push_back(b);
	}
	list<int> q;
	list<int> answer;
	q.push_back(x);
	q.push_back(0);
	while(q.size() > 0)
	{
		int node = q.front();
		q.pop_front();
		int d = q.front();
		q.pop_front();
		if(d==k)
			answer.push_back(node);
		else if(d>k)
			break;
		for(iter = adj_list[node].begin(); iter != adj_list[node].end(); iter++)
		{
			int next_node = *iter;
			if(!visit[next_node])
			{
				visit[next_node] = true;
				q.push_back(next_node);
				q.push_back(d+1);
			}
		}
	}
	answer.sort();
	if(answer.size() == 0)
		printf("%d\n", -1);
	else
		for(iter = answer.begin(); iter != answer.end(); iter++)
			printf("%d\n", *iter);

	delete[] visit;
	delete[] adj_list;
	return 0;
}
