package com.kisonich.spring.rest;


import com.kisonich.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

// С помощью обьектов и методов этого класса будем общаться с restservice ( осуществлять рест запросы и ответы )
@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8081/spring_course_rest/api/employees"; // HTTP Request. получение всех работников

    public List<Employee> getAllEmployee(){
        ResponseEntity<List<Employee>> responseEntity =
                //// отправляем request и его результат получаем в responseEntity
                restTemplate.exchange(URL, HttpMethod.GET, null ,new ParameterizedTypeReference<List<Employee>>() {}); // ответ на HTTP запрос

        // из responseEntity получаем полезную нагрузку(список работников)
        List<Employee> allEmployees = responseEntity.getBody();
        return allEmployees;
    }

    public Employee getEmployee(int id){

        Employee employee = restTemplate.getForObject(URL + "/" + id, Employee.class); // второй параметр это что мы добавляем в тело.
        return employee;
    }
// созраняем или изменяем
    public void saveEmployee(Employee employee){ // Если у работника id будет равен нулю то метод будет посылать http запрос который создасться новый работника в базе, а если id есть то обновиться данные существующего работника

    int id = employee.getId();

         if (id == 0){ // создаем работника
        ResponseEntity<String>responseEntity = //<указываем тело респонса>
                restTemplate.postForEntity(URL, employee,String.class);
        System.out.println("New employee was added to DB");
        System.out.println(responseEntity.getBody());

          } else { // изменяем работника
        restTemplate.put(URL, employee);
             System.out.println("Employee with ID " + id + " was updated");
        }
    }

    public void deleteEmployee(int id){

        restTemplate.delete(URL + "/" + id);
        System.out.println("Employee with ID " + id + " was deleted from DB");
    }
}
// ResponseEntity  обертка HTTP Response