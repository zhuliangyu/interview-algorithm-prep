// version: 高频题班
public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // 把左边符号都加入
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            // 遇到一个右边的符号, 从stack这边pop出一个去抵消
            if (c == ')') {
                // 要满足两个条件
                // 首先是能pop出来一个东西
                // pop出来的可以抵消
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
            if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
            if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
        }

        // 最后stack内还必须是空的才可以
        return stack.isEmpty();
    }
}