package Week5;
import  java.util.Stack;
public class BalancedBracket {
    public static String isBalanced(String s) {
        Stack <Character> S = new Stack<>();
        for (int i =0; i< s.length() ; i++ ){
            char c = s.charAt(i);
            switch (c){
                case '{':
                case '[':
                case  '(':
                    S.push(c);
                    break;
                case ']':
                    if (S.isEmpty() || S.pop() != '['){
                        return "NO";
                    }
                    break;
                case ')':
                    if (S.isEmpty() || S.pop() != '('){
                        return "NO";
                    }
                    break;
                case '}':
                    if (S.isEmpty() || S.pop() != '{'){
                        return "NO";
                    }
                    break;
            }
        }
        return (S.isEmpty()) ?  "YES" : "NO";
    }
}
