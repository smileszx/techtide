package com.ai.tide.test;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import static java.lang.System.*;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/22 12:39
 **/
public class StaticScopeTest {
    public static void main(String[] args) {
        /**
        Employee[] employees = new Employee[10];
        for(int i=0; i<10;i++) {
            Employee employee = new Employee();
            employee.id = i;
            employee.setNextId(i);
            employees[i] = employee;
        }

        for (Employee e:employees) {
            System.out.println(e);
        }


        Employee bob = new Employee(1, "bob");
        Employee tom = new Employee(2, "tom");

        //交换方法是交换引用，但是对于参数本身，并未发生改变
        //测试结果表明swap交换的只是变量副本
        swap(bob, tom);


        System.out.println(bob);
        System.out.println(tom);
         **/

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();

        Employee employee3 = new Employee(1);

        out.println(employee1);

        Employee employee4 = new Manager();

        if (employee4 instanceof Manager) {
            ((Manager) employee4).setBonus(50000.0);
            out.println(employee4);
        }



        AbstractWorker worker = new ITWorker();

        worker.testAbstract();
        worker.testMethod();

        ArrayList arrayList = new ArrayList();
        arrayList.trimToSize();
    }

    public static void swap (Employee a, Employee b) {
        Employee temp = a;
        a = b;
        b = temp;
        System.out.println("inside:" + a);
        System.out.println("inside:" + b);
    }


    static class Employee {
        private static int nextId;
        private int id;
        private String name;
        static {
            Random generator = new Random(0);
            nextId = generator.nextInt(10000);
            System.out.println("static init nextId=" + nextId);
        }

        {
            id = nextId;
            System.out.println("code block id = " + id);
            nextId ++;
        }

        public Employee() {

        }

        public Employee(int id) {
            this(id, "Employee# nextId = " + nextId);
            System.out.println(this);
        }

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static int getNextId() {
            return nextId;
        }

        public static void setNextId(int nextId) {
            Employee.nextId = nextId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return id == employee.id &&
                    Objects.equals(name, employee.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", nextId=" + nextId +
                    ", name=" + name +
                    '}';
        }
    }

    static class Manager extends Employee {
        private double bonus;

        public void setBonus(double bonus) {
            this.bonus = bonus;
        }
    }

    static abstract class AbstractWorker {

        private String name;

        public abstract void testAbstract ();

        public void testMethod () {
            out.println("this is a method in a abstract class");
        }
    }

    static class ITWorker extends AbstractWorker {

        @Override
        public void testAbstract() {
            out.println("I am a IT, subclass of AbstractWorker");
        }
    }
}
