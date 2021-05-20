import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
	static class Todo
	{
		String work;
		String word;
		long time;
		boolean check_undo;
	}
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		Todo[] todo = new Todo[n];
		for(int i=0; i<n; i++)
		{
			StringTokenizer st = new StringTokenizer(bf.readLine());
			todo[i] = new Todo();
			todo[i].work = st.nextToken();
			todo[i].word = st.nextToken();
			todo[i].time = Long.parseLong(st.nextToken());
			todo[i].check_undo = true;
		}
		for(int i=n-1; i>=0; i--)
		{
			if(todo[i].work.equals("undo") && todo[i].check_undo)
			{
				long undo_time = todo[i].time - Long.parseLong(todo[i].word);
				for(int j= i-1; j>=0; j--)
				{
					if(undo_time > todo[j].time)
						break;
					todo[j].check_undo = false;
				}
			}
		}
		String answer = "";
		for(int i=0; i<n; i++)
			if(todo[i].work.equals("type") && todo[i].check_undo)
				answer += todo[i].word;
		System.out.println(answer);
	}
}
