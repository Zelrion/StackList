import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Driver {
	public static void main(String[]args) {
		int ind = 0;
		StackList<Integer> stack = new StackList<Integer>();
		ArrayList<Integer> listFL = readFile(new File("linkedArray.txt"));
		int[] revLink = new int[listFL.size()];

		System.out.printf("\r\nForward Path\r\n-----------------------\r\n");
		while (ind!=-1) {
			System.out.println(ind);
			stack.push(ind);
			ind = listFL.get(ind);
		};

		System.out.printf("\r\nReverse Path\r\n-----------------------\r\n");
		for (int prev=revLink.length-1;!stack.isEmpty();prev=ind) {
			ind = stack.pop();
			revLink[prev] = ind;
			System.out.println(ind);
			if (stack.isEmpty()) {
				revLink[ind] = -1;
			}
		}

		System.out.printf("\r\nReverse Linked\r\n-----------------------\r\n");
		for (int i=0;i<revLink.length;i++) {
			System.out.printf("%2d:%-2d\r\n",i,revLink[i]);
		}
	}

	private static ArrayList readFile(File f) {
		try {
			FileReader fileReader = new FileReader(f);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			ArrayList<Integer> returnList = new ArrayList<Integer>();

			String line;
			while ((line = bufferedReader.readLine())!= null) {
			    returnList.add(Integer.parseInt(line));
			}
			fileReader.close();
			return returnList;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}