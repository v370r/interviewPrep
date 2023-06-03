package leetCode;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/minimize-maximum-of-array/
 * You are given a 0-indexed array nums comprising of n non-negative integers.
In one operation, you must:
Choose an integer i such that 1 <= i < n and nums[i] > 0.
Decrease nums[i] by 1.
Increase nums[i - 1] by 1.
Return the minimum possible value of the maximum integer of nums after performing any number of operations.
Input: nums = [3,7,1,6]
Output: 5
Explanation:
One set of optimal operations is as follows:
1. Choose i = 1, and nums becomes [4,6,1,6].
2. Choose i = 3, and nums becomes [4,6,2,5].
3. Choose i = 1, and nums becomes [5,5,2,5].
The maximum integer of nums is 5. It can be shown that the maximum number cannot be less than 5.
Therefore, we return 5.
 */
public class minimizeMaximumOfArray {
    public static void main(String[] args) {
        int[] nums = { 21651745, 952590043, 205774816, 242014459, 274801939, 272518092, 545989833, 479409756, 515936033,
                109108690, 337600473, 11217705, 844677826, 136132049, 295426639, 800802064, 639900924, 543474452,
                110665395, 100953974, 425414403, 176211241, 868358902, 520827220, 705643133, 54985879, 484681029,
                1385641, 669321042, 841182480, 441716231, 578396530, 323865941, 843246171, 619215316, 526941266,
                692263443, 621902443, 932996356, 694667846, 465390860, 732067038, 404556530, 539654205, 384919497,
                500966103, 150697673, 494160854, 847683362, 91239130, 383979971, 837260421, 89412021, 466282244,
                132928644, 762945159, 90880090, 85057014, 622910419, 238677551, 878209133, 968431826, 295087169,
                402635468, 133919834, 611025171, 119317088, 811135412, 548747655, 646833073, 19219017, 514404231,
                2242550, 682230311, 611804432, 653423202, 230813631, 917061480, 600663371, 635242550, 268019625,
                827269805, 974620357, 202690287, 69483546, 628619742, 206865888, 672680492, 91532995, 836787324,
                434451888, 625101418, 122762495, 978554370, 149617190, 150154286, 799090371, 869223783, 161253893,
                872625464, 822018976, 503564415, 345987967, 383584163, 454187403, 556703074, 864992708, 454699523,
                57579445, 233747212, 85984365, 976875042, 659737956, 4966543, 489044741, 71012297, 684406809, 447771761,
                910635465, 897011868, 913015444, 615631604, 81940738, 912939894, 962417556, 469687892, 2467082,
                689240202, 39978592, 111912449, 718310553, 119011384, 314486829, 174624684, 978215523, 462121455,
                403554397, 535853680, 167545108, 407848564, 429514564 };
        System.out.println("Minimize Maximum of array : " + minimiMax(nums));
    }

    private static int minimiMax(int[] nums) {
        int low = 0, high = Arrays.stream(nums).max().getAsInt(), mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (checkIfNotPossible(nums, mid, nums.length)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static boolean checkIfNotPossible(int[] arr, int mid, int length) {
        int curr_index = arr.length - 1;
        long currIndexValue = -1, previousIndexValue = -1;
        while (curr_index >= 0) {
            if (arr[curr_index] > mid) {
                currIndexValue = arr[curr_index];
                break;
            }
            curr_index--;
        }

        while (curr_index >= 0) {
            if (curr_index == 0) {
                if (currIndexValue > mid) {
                    return true;
                } else {
                    break;
                }
            }
            previousIndexValue = arr[curr_index - 1];
            if (currIndexValue > mid) {
                long diff = currIndexValue - mid;
                currIndexValue = mid;
                previousIndexValue += diff;
            }
            currIndexValue = previousIndexValue;
            curr_index--;

        }

        return false;
    }

    // private static boolean checkIfNotPossible(int[] nums, int mid, int
    // indexedLocation) {
    // int currIndex = 0, currIndexValue, previousIndexValue;
    // while (currIndex < indexedLocation) {
    // if (nums[currIndex] > mid) {
    // if (currIndex == 0) {
    // return true;
    // }
    // currIndexValue = nums[currIndex];
    // previousIndexValue = nums[currIndex - 1];
    // while (currIndexValue > mid) {
    // currIndexValue--;
    // previousIndexValue++;
    // if (previousIndexValue > mid) {
    // return true;
    // }
    // }
    // }
    // currIndex++;
    // }
    // return false;
    // }
}
