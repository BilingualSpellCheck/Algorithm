import java.util.Arrays;

public class Algorithm {
	
	/* 
	 How do we want to tackle capitalization? 
	 How are the misspelled words marked in the app? How should that data be represented?
	 Still working on suggestions
	 */

	public static void main(String[] args) {
		
		String originalText = TextIO.getlnString();
		String[] originalWords = originalText.split(" ");
		boolean[] isCorrect = new boolean[originalWords.length];
		boolean[] isCorrect2 = new boolean[originalWords.length];
		for (int i = 0; i < isCorrect.length; i ++){
			isCorrect[i] = false;
		}
		for (int i = 0; i < isCorrect2.length; i ++){
			isCorrect2[i] = false;
		}
		
		//checks if each word is in the dictionary or not
		for (int i = 0; i < originalWords.length; i ++){
			TextIO.readFile("engDict.txt");
			while (!TextIO.eof()){
				String line = TextIO.getln();
				if (originalWords[i].compareTo(line) == 0){
					isCorrect[i] = true;
				}
			}
			TextIO.readFile("spanDict.txt");
			while (!TextIO.eof()){
				String line = TextIO.getln();
				if (originalWords[i].compareTo(line) == 0){
					isCorrect2[i] = true;
				}
			}
		}
		
		//counts the number of misspelled words
		int badWords = 0;
		for (int i = 0; i < isCorrect.length; i ++){
			if (isCorrect[i] == false && isCorrect2[i] == false)
				badWords++;
		}
		
		//creates a new array of misspelled words
		String[] misspelled = new String[badWords];
		int mCount = 0;
		for (int i = 0; i < isCorrect.length; i ++){
			if (isCorrect[i] == false && isCorrect2[i] == false){
				misspelled[mCount] = originalWords[i];
				mCount++;
			}	
		}
		
		System.out.println(Arrays.toString(misspelled));
	}
}
