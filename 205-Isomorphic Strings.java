#1
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if (map.keySet().contains(s.charAt(i))) {
                if ((char)map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else if (map.values().contains(t.charAt(i))) {
                return false; 
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true; 
    }
}

#2
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || s.length() <= 1) return true;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0 ; i< s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)){
                 if(map.get(a).equals(b))
                continue;
                else
                return false;
            }else{
                if(!map.containsValue(b))
                map.put(a,b);
                else return false;
                
            }
        }
        return true;
        
    }
}