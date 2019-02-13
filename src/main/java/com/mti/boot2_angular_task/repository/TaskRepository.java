package com.mti.boot2_angular_task.repository;

import com.mti.boot2_angular_task.domain.Task;
import org.springframework.data.repository.CrudRepository;
//This class does the crud operation with persistance layer
public interface TaskRepository extends CrudRepository<Task, Long> {

}
