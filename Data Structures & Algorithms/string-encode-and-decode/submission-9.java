class Solution {

    public String encode(List<String> strs)  {
        if (strs.size() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            int len = s.length();
            sb.append(len).append('#').append(s);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str)  {

        List<String> ans = new ArrayList<>();
        if (str.length() == 0) {
            return ans;
        }
        StringBuilder sb = new StringBuilder();
        System.out.println(str);

        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#')
                j++;
            
            int len = Integer.parseInt(str.substring(i, j));
            j++;
            String s = str.substring(j, j + len);
            ans.add(s);
            i = j + len;
        }

        return ans;
    }
}
