package leetCode;

import java.util.Arrays;

import javax.sound.sampled.Port;

/*
 * https://leetcode.com/problems/successful-pairs-of-spells-and-potions/
 * You are given two positive integer arrays spells and potions, of length n and m respectively,
 * where spells[i] represents the strength of the ith spell and potions[j] represents the strength of the jth potion.
You are also given an integer success. A spell and potion pair is considered successful
if the product of their strengths is at least success.
Return an integer array pairs of length n where pairs[i] is the number of potions
that will form a successful pair with the ith spell.
Input: spells = [5,1,3], potions = [1,2,3,4,5], success = 7
Output: [4,0,3]
Explanation:
- 0th spell: 5 * [1,2,3,4,5] = [5,10,15,20,25]. 4 pairs are successful.
- 1st spell: 1 * [1,2,3,4,5] = [1,2,3,4,5]. 0 pairs are successful.
- 2nd spell: 3 * [1,2,3,4,5] = [3,6,9,12,15]. 3 pairs are successful.
Thus, [4,0,3] is returned.
 */
public class successfulPairsSpellsAndPotions {
    public static void main(String[] args) {
        int spells[] = { 5, 1, 3 }, potions[] = { 1, 2, 3, 4, 5 }, success = 7;
        System.out.println("succesful spells : " + successfullSpells(spells, potions, success));
    }

    private static int[] successfullSpells(int[] spells, int[] potions, int success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            res[i] = potions.length - binarySearchindex(potions, spells[i], success);
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    private static int binarySearchindex(int[] potions, int spell, int success) {
        int low = 0, high = potions.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (1L * potions[mid] * spell < success) { // dont use 1L at end loss of presision
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
