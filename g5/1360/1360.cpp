#include<iostream>
#include<string>
using namespace std;
typedef long long ll;

struct Todo
{
	string work;
	string word;
	ll time;
	bool check_undo;
};

int main()
{
	int n;
	cin >> n;
	struct Todo* todo = new struct Todo[n];
	for(int i=0; i<n; i++)
	{
		cin >> todo[i].work >> todo[i].word >> todo[i].time;
		todo[i].check_undo = true;
	}
	for(int i=n-1; i>=0; i--)
	{
		if(todo[i].work.compare("undo") == 0 && todo[i].check_undo)
		{
			ll undo_time = todo[i].time - stoll(todo[i].word);
			for(int j = i-1; j>=0; j--)
			{
				if(undo_time > todo[j].time)
					break;
				todo[j].check_undo = false;
			}
		}
	}
	string answer = "";
	for(int i=0; i<n; i++)
		if(!todo[i].work.compare("type") && todo[i].check_undo)
			answer += todo[i].word;
	cout << answer << "\n";

	delete[] todo;
	return 0;
}
