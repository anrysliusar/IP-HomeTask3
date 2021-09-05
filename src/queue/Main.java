package queue;

import mapperExample.User;

public class Main {
    public static void main(String[] args) {
        ArrayQueue<User> queue = new ArrayQueue<>(10);
        queue.add(new User("Vasyl", "vasyl@gmail.com", 14));
        queue.add(new User("Vasyl", "vasyl@gmail.com", 15));
        queue.add(new User("Vasyl", "vasyl@gmail.com", 16));
        queue.add(new User("Vasyl", "vasyl@gmail.com",17));
        queue.remove();
        System.out.println(queue.peek());
        queue.print();
    }
}
