class Solution {
    public boolean isAnagram(String s, String t) {

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);


        String newS = new String(sArr);
        String newT = new String(tArr);
        // System.out.println(newS);
        // System.out.println(newT);

        return (newS.equals(newT));    
         }

    }
