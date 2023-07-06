package com.patterns.sessionController;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList <User> userList = new ArrayList<>();
        User userFirst = new User("Pasha4or", "passW0rd", 1234);
        User userSecond = new User("NaTapochek", "pass", 954);
        User userThird = new User("GenaBukin", "123rd", 4123);
        userList.add(userFirst);
        userList.add(userSecond);
        userList.add(userThird);

        Session session = new Session(userSecond);

        session.access("NaTapochek", "pass");
        session.getSalary();
        session.autopay();
    }
}
