import java.util.ArrayList;
import java.util.List;

public class DependencyList {
	private char[] projects = { 'a', 'b', 'c', 'd', 'e', 'f' };
	private char[][] depList = {
			{'a','d'},
			{'f','b'},
			{'d','b'},
			{'f','a'},
			{'d','c'}};

	public List<Character> build() {
		List<Character> depOrder = new ArrayList<Character>();
		List<Character> finalOrder = new ArrayList<Character>();
		for (int i = 0; i < projects.length; i++) {
			for (int j = 0; j < depList.length; j++) {
				if (projects[i] == depList[j][0]) {
					if (!depOrder.contains(projects[i])) {
						depOrder.add(projects[i]);
					}
				}
			}
		}
		
		for (int i = 0; i < projects.length; i++) {
			if(!finalOrder.contains(projects[i]) && !depOrder.contains(projects[i])) {
				finalOrder.add(projects[i]);
			}
		}
		finalOrder.addAll(depOrder);
		
		
		return finalOrder;
	}

	public static void main(String[] args) {
		DependencyList dl = new DependencyList();
		System.out.println(dl.build());
	}

}
