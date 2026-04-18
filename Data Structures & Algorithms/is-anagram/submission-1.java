class Solution {
    public boolean isAnagram(String s, String t) {

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        // String newS = new String(sArr);
        // String newT = new String(tArr);

        return Arrays.equals(sArr, tArr);
         }

    }
