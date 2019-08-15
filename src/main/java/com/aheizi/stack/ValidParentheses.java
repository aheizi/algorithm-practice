package com.aheizi.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by yangquan1 on 2019-08-14.
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class ValidParentheses {

    /**
     * map存储 ):( 刚好能解决，括号集合和映射关系
     *
     * 遇到左括号压栈，遇到右括号弹出栈顶元素并匹配
     * 若匹配失败，或者栈已空，则表达式无效
     * 匹配结束，若栈非空，表达式无效
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> characterMap = new HashMap<Character, Character>();
        characterMap.put(')', '(');
        characterMap.put('}', '{');
        characterMap.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characterMap.containsKey(c)) {
                // 注意空栈不能直接pop, EmptyStackException
                if (stack.isEmpty()) {
                    return false;
                }
                // 当前值和栈顶元素不相等，立即判定为非法
                if (characterMap.get(c) != stack.pop()) {
                    return false;
                }
            } else {
                // 左括号直接入栈
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "]";
        System.out.println(isValid(s));
    }
}
