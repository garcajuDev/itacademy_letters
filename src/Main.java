import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		char[] name = {'J','U','A','N'};
		blockOne(name);
		blockTwo(name);
	}
	public static char[] blockOne(char[] nameTable) {
		
		int i = 0;
		while(i < nameTable.length) {
			System.out.print(nameTable[i]);
			i++;
		}
		System.out.println("\n");
		return nameTable;
	}
	public static void blockTwo(char[] nameTable) {
		ArrayList nameList = new ArrayList();
		for(char letter : nameTable) {
			nameList.add(letter);
			int character = letter;
			switch (character) {
			case 'a': case'e': case 'i': case 'o': case 'u': case 'A': case 'E': case 'I': case 'O': case 'U':
				System.out.println("vocal");
				break;
			
			case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 0:
				System.out.println("A name don't have numbers!");
				break;
					
			default:
				System.out.println("consonant");
				break;
			}
		}
		System.out.println("\n");
		blockThree(nameList);
	}
	public static void blockThree(ArrayList nameList) {
		Map<Character, Integer> letterMap = new HashMap<Character, Integer>();
		int value = 1;
		for(Object letter : nameList) {
			char key = (char) letter;
			if(letterMap.containsKey(key)) value ++;
			letterMap.put((char)letter, value);
		}
		Iterator it = letterMap.keySet().iterator();
		while(it.hasNext()){
		  Object key = it.next();
		  System.out.println("Letter: " + key + " -> Repetitions: " + letterMap.get(key));
		}
		System.out.println("\n");
		blockFour(nameList);
	}
	public static void blockFour(ArrayList name) {
		ArrayList<Character> surname = new ArrayList<Character>();
		surname.add('G');
		surname.add('A');
		surname.add('R');
		surname.add('C');
		surname.add('I');
		surname.add('A');
		
		int length = (name.size()+surname.size())+1;
		ArrayList<Character> fullName = new ArrayList<Character>(length);
		
		fullName.addAll(name);
		fullName.add(' ');
		fullName.addAll(surname);
		
		for (int i = 0 ; i < length ; i++) {
			System.out.print(fullName.get(i));
		}
	}
}