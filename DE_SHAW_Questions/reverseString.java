package DE_SHAW_Questions;

import java.util.Arrays;

/*
 * The string is reveresed n time over index n
 * 
 * EX: DASHBOARD  -> ADSHBOARD -> SDAHBOARD -> HADSBOARD  (n=3)
 */
public class reverseString {
    public static void main(String[] args) {
        String Word = "E6RqotduWE=3onUN#XnP#tERSESubETMdr+wyCXUW$QOn!&heke@KpZaYNZVuMv%OWgkOmqQoSqr!GHrSSSs8c=GRdZ9zxQ";
        int n = 90;
        String reversedWord = prepareQuestion(Word, n);
        System.out.println("Original string: " + Word);
        System.out.println("converted string: " + reversedWord);
        String optimizedReconvertedString = prepareSolution(reversedWord, n);
        System.out.println("Optimised reconverted string :" + optimizedReconvertedString);
        System.out.println("isEqual :" + optimizedReconvertedString.equals(Word));
    }

    private static String prepareSolution(String reversedWord, int n) {
        char[] wordArr = reversedWord.toCharArray();
        String subs = "";
        if (n % 2 != 0) {
            for (int i = n / 2; i >= 0; i--) {
                subs = subs + wordArr[i] + wordArr[n - i]; // 0,5 scenario
            }
            subs += new String(Arrays.copyOfRange(wordArr, n + 1, reversedWord.length()));
        } else {
            for (int i = n / 2; i < n; i++) {
                subs = subs + wordArr[i] + wordArr[n - i - 1];
            }
            subs += new String(Arrays.copyOfRange(wordArr, n, reversedWord.length()));
        }

        return subs;
    }

    private static String prepareQuestion(String word, int n) {
        char[] wordArr = word.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i / 2; j++) {
                char temp = wordArr[j];
                wordArr[j] = wordArr[i - j];
                wordArr[i - j] = temp;
            }
        }
        return new String(wordArr);

    }
}
