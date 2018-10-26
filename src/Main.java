import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

	public static void main(String[] args) {
		char[] name = {'J','U','A','N'};
		blockOne(name);
		blockTwo(name);
		blockThree(name);
		blockFour(name);
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
		String name = getName(nameTable);
		nameTester(name);
	}
	
	public static void blockThree(char[] name) {
		Map<Character, Integer> nameMap = toMap(name);
		printMap(nameMap);
	}
	public static void blockFour(char[] name) {
		List<Character> fullName = getFullName(getNameList(name),getSurnameList());
		printFullName(fullName);
	}
	
	//Block 2 Functions
	public static String getName(char[] nameChar) {
		String name = "";
		
		for(char letra : nameChar) name += letra;
		
		return name.toLowerCase();
	}
	
	public static void nameTester (String name) { 
		for (int i = 0; i < name.length(); i++ ) {
			if(Character.isDigit(name.charAt(i))) System.out.println("It's a digit");
			else {
				if(isVocal(name.charAt(i)) == true) System.out.println("Vocal");
				else System.out.println("Consonant");
			}
		}
	}
	
	public static boolean isVocal(char letter) {
		char[] vocals = {'a','e','i','o','u'};
		boolean letterResult = true;
		
		for (int i = 0; i < vocals.length; i++)
			if(vocals[i] == letter) return letterResult;
		
		return !letterResult;
	}
	
	//Block 3 Functions
	public static Map<Character, Integer> toMap(char[] nameList) {
		Map<Character, Integer> letterMap = new HashMap<Character, Integer>();
		int value = 1;
		for(char letter : nameList) {
			if(letterMap.containsKey(letter)) {
				value = letterMap.get(letter);
				value++;
			}
			letterMap.put(letter, value);
		}
		return letterMap;
	}
	
	public static void printMap(Map<Character,Integer> letterMap) {
		letterMap.forEach((k,v) -> System.out.println("Letter: " + k + ": Repetitions: " + v));
	}
	
	//Block 4 Functions
	public static List<Character> getNameList(char[] name) {
		List nameList = new ArrayList<Character>();
		
		for(char letter: name) nameList.add(letter);
		
		return nameList;
		
	}
	
	public static List<Character> getSurnameList() {
		List surname = new ArrayList<Character>();
		surname.add('G');
		surname.add('A');
		surname.add('R');
		surname.add('C');
		surname.add('I');
		surname.add('A');
		
		return surname;
	}
	
	public static List<Character> getFullName(List<Character> name, List<Character> surname) {
		int length = (name.size()+surname.size())+1;
		ArrayList<Character> fullName = new ArrayList<Character>(length);
		
		fullName.addAll(name);
		fullName.add(' ');
		fullName.addAll(surname);
		
		return fullName;
	}
	
	public static void printFullName(List<Character> fullName) {
		for(char letter: fullName) System.out.print(""+letter);
	}
}