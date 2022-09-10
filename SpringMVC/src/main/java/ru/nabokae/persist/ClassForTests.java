package ru.nabokae.persist;

public class ClassForTests {
    public static void main(String[] args) {
        UserRepository userRepository2 = new UserRepositoryImpl();
        User user1 = new User(1L,"1111","11111",16);
        userRepository2.update(user1);

        System.out.println(userRepository2.findById(1));
    }
}
