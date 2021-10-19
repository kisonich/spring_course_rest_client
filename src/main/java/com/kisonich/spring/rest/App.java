package com.kisonich.spring.rest;

import com.kisonich.spring.rest.configuration.MyConfig;
import com.kisonich.spring.rest.entity.Employee;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication",Communication.class);

//        List<Employee>allEmployees = communication.getAllEmployee(); // получаем всех работников
//        System.out.println(allEmployees);

//         Employee employeeById = communication.getEmployee(2); //  получаем одного работника.
//        System.out.println(employeeById);

//        // создание, обновление работника в зависимости от id
//        Employee employee = new Employee("Sveta","Kooko","HR",200);
//        /////
//        employee.setId(14);// добавляем нового id чтобы не добавилась новая строка
//        System.out.println(employee);
//        communication.saveEmployee(employee);
//

        communication.deleteEmployee(14);
    }
}
 //Rest Client который по HTTP запросам общается с Rest service