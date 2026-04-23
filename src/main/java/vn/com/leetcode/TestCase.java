package vn.com.leetcode;

public record TestCase<I, O>(String name, I input, O expected) {

    public static <I, O> TestCase<I, O> of(String name, I input, O expected) {
        return new TestCase<>(name, input, expected);
    }

    public static <I, O> TestCase<I, O> of(I input, O expected) {
        return new TestCase<>("", input, expected);
    }
}