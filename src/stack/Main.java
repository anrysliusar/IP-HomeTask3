package stack;

import mapperExample.User;

public class Main {
    public static void main(String[] args) {
        ArrayStack<User> stack = new ArrayStack<>(10);
        stack.push(new User("LLL", "gggg", 14));
        stack.push(new User("LLL", "gggg", 15));
        stack.push(new User("LLL", "gggg", 16));
        stack.push(new User("LLL", "gggg", 17));
        stack.pop();
        System.out.println(stack.peek());
    }
}
