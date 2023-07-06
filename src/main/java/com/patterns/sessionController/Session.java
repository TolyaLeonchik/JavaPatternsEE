package com.patterns.sessionController;

public class Session {
    User user;
    boolean accessFlag = false;
    public void access(String login, String password)  {
        if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
            System.out.println("Access accepted");
            accessFlag = true;
        } else {
            System.out.println("Access denied!");
        }
    }
    public void getSalary() {
        if (accessFlag) {
            System.out.println(user.getSalary());
        }
    }
    public void autopay() {
        if (accessFlag) {
            int autoTaxes = user.salary - 20;
            System.out.println("Операция 'Автоплатеж' выполнена! Счёт 20р. Ваш Баланс: " + autoTaxes);
        }
    }

    public Session(User user) {
        this.user = user;
    }
}
