package com.mti.boot2_angular_task;

import com.mti.boot2_angular_task.domain.Task;
import com.mti.boot2_angular_task.service.TaskService;
import org.apache.tomcat.jni.Local;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class Boot2AngularTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot2AngularTaskApplication.class, args);
    }

    //We need command line Runner for inserting data like using bootstrap
    @Bean
    CommandLineRunner runner(TaskService  taskService){
        return  args -> {
            taskService.save(new Task(1L,"Create Spring boot Application", LocalDate.now(), true));
            taskService.save(new Task(2L,"Create Spring Di",LocalDate.now().plus(1, ChronoUnit.DAYS),false));
        };
    }
}

