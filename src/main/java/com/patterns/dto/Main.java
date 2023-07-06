package com.patterns.dto;

public class Main {
    public static void main(String[] args) {
        LogicObject logicObject = new LogicObject();
        System.out.println(logicObject.getEmployee().getName());
        System.out.println(logicObject.getEmployee().getSalary());
    }
}
