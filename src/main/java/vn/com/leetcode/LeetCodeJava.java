package vn.com.leetcode;

import vn.com.leetcode.problems.Problem;

/**
 * @author : AnhTuPhi
 * @created : 12/23/2024 - 11:45 PM - Monday
 * @project : leetcode-java
 **/
public class LeetCodeJava {

    public static void main(String[] args) {
        executeProblem(1);
    }

    private static void executeProblem(int num) {
        try {
            var classPath = detectClassPath(num);
            var instance = (Problem) Class.forName(classPath).getDeclaredConstructor().newInstance();
            instance.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String detectSubPackageName(int num) {
        return String.format("s%04d", num);
    }

    private static String detectPackageName(int num) {
        var temp = num / 100;
        switch (temp) {
            case 0:
                return "p0001_p0100";
            case 1:
                return "p0101_p0200";
            case 2:
                return "p0201_p0300";
            case 3:
                return "p0301_p0400";
            case 4:
                return "p0401_p0500";
            default:
                return "";
        }
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
