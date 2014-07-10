package string;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StringManipulation {

	/**
	 * Before: this is not cool
	 * 
	 * After: cool not is this
	 * 
	 */
	public static String reverseWords(String sentence) {

		Character wordDelimiter = ' ';
		int idxWord = 0;
		for (int i = 0; i <= sentence.length(); i++) {
			if (i == sentence.length() || sentence.charAt(i) == wordDelimiter) {
				sentence = sentence.substring(0, idxWord) + reverse(sentence.substring(idxWord, i)) + sentence.substring(i, sentence.length());
				i++;
				idxWord = i;
			}
		}
		return reverse(sentence);
	}

	public static String reverse(String word) {
		char[] array = word.toCharArray();

		for (int i = 0; i < word.length() / 2; i++) {
			char tmp = array[i];
			array[i] = array[word.length() - i - 1];
			array[word.length() - i - 1] = tmp;
		}
		return String.copyValueOf(array);
	}
}
