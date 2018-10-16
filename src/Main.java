import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

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
		ArrayList nameList = new ArrayList<>();
		String nameStr = "";
		char[] vocales = {'a','e','i','o','u'};
		boolean isVocal = false;
		
		for(char letra : nameTable) {
			nameList.add(letra);
			nameStr += letra;
		}
		
		String nameLow = nameStr.toLowerCase();
		
		Pattern p= Pattern.compile("[0-9]");
		Matcher m = p.matcher(nameLow);
		
		if(m.find()) {
			System.out.println("A name don't have numbers");
		}else {
			for (int i = 0; i < nameLow.length(); i++) {
				for (char c : vocales) {
					if (nameLow.charAt(i) == c) {
						isVocal = true;
						break;
					}
				}
				if(isVocal == true) System.out.println("Vocal");
				else System.out.println("Consonant");
				
				isVocal = false;
			} 
		}
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