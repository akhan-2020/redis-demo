package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping( value = "/longRunningTask" )
public class TaskController {

    @Autowired
    private TaskService taskService;


    @RequestMapping(value = "/{seconds}", method = RequestMethod.GET)
    public ResponseEntity<TaskDTO> longRunningTask(@PathVariable long seconds) {
        Optional<TaskDTO> user = taskService.getLongRunningTaskResult(seconds);
        return ResponseUtil.wrapOrNotFound(user);
    }


    @RequestMapping(value = "/reset/{seconds}", method = RequestMethod.GET)
    public ResponseEntity<?> reset(@PathVariable long seconds) {
        taskService.resetLongRunningTaskResult(seconds);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}