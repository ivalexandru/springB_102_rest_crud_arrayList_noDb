package com.example.demo.controllers;

import com.example.demo.models.TopicModel;
import com.example.demo.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {


    //autowired = needs dependency injection
    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    public List<TopicModel> getAllTopics(){
        return topicService.getAllTopics();
    }

    @GetMapping("/topics/{id}")
    public TopicModel getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }

    //get is the default, that's why i have not wrote it above..
    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody TopicModel topic){
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody TopicModel topic, @PathVariable String id){
        topicService.updateTopic(id, topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }



}








