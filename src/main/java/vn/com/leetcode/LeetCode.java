package vn.com.leetcode;

import vn.com.leetcode.problems.Problem;

/**
 * @author : AnhTuPhi
 * @created : 12/23/2024 - 11:45 PM - Monday
 * @project : leetcode-java
 **/
public class LeetCode {

    public static void main(String[] args) {
        executeProblem(1768);
    }

    private static void executeProblem(int num) {
        try {
            var classPath = detectClassPath(num);
            var instance = (Problem) Class.forName(classPath).getDeclaredConstructor().newInstance();
            instance.execute();
        } catch (Exception e) {
            System.out.println("Execute got exception: " + e.getMessage());
        }
    }

    private static String detectSubPackageName(int num) {
        return String.format("s%04d", num);
    }

    private static String detectPackageName(int num) {
        int start = num - (num - 1) % 100;
        int end = start + 99;
        return String.format("p%04d_p%04d", start, end);
    }

    private static String detectClassName(int num) {
        return "Problem" + num;
    }

    private static String detectClassPath(int num) {
        var packageName = detectPackageName(num);
        var subPackageName = detectSubPackageName(num);
        var className = detectClassName(num);
        return "vn.com.leetcode.problems." + packageName + "." + subPackageName + "." + className;
    }
}
