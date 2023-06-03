// class Solution {
//     public int maxVowels(String s, int k) {
//     int count =0, max= 0;
//     Deque<Character> deq = new ArrayDeque<>();
//     for (int i = 0; i < k; i++) {
//       deq.add(s.charAt(i));
//       if(check(s.charAt(i))){
//         count++;
//         max = Math.max(count,max);
//         if(max == k){
//           return max;
//         }
//       }
//     }
    
//     for (int i = k; i < s.length(); i++) {
//       if(check(deq.pollFirst())){
//         count--;
//       }
//       deq.add(s.charAt(i));
//       if(check(s.charAt(i))){
//         count++;
//         max = Math.max(count,max);
//         if(max==k){
//           return max;
//         }
//       }
//     }
//     return max;
//   }

//   public static boolean check(Character c){
//     if(c == 'a' || c == 'e' || c =='i'|| c =='o'|| c=='u'){
//       return true;
//     }
//     return false;
//   }
// }

class Solution {
    public int isVowel(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
            return 1;
        return 0;
    }

    public int maxVowels(String s, int k) {
        int max_vow = 0, cur_vow=0;
        for(int i=0;i<s.length();i++){
            cur_vow += isVowel(s.charAt(i));
            if(i>=k)
                cur_vow -= isVowel(s.charAt(i-k));
            max_vow = Math.max(max_vow, cur_vow);
        }
        System.gc();
        return max_vow;    
    }
}


