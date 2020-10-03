package com.example.demo.services;

import com.example.demo.models.TopicModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//singleton, an instance will be created at startup

@Service
public class TopicService {

//    Arrays.asList would be immutable (without ArrayList..)
 List<TopicModel>  topics = new ArrayList<>( Arrays.asList(
        new TopicModel("spring", "spr fr", "descriere spring"),
        new TopicModel("autumn", "autumn fr", "descriere autumn"),
        new TopicModel("winter", "winter fr", "descriere winter")
 )
        );

 public List<TopicModel> getAllTopics(){
    return topics;
 }

 public TopicModel getTopic( String id){

     return topics.stream()
             .filter(i -> i.getId().equals(id))
             .findFirst()
             .get();
 }


    public void addTopic(TopicModel topic){
        topics.add(topic);
    }


    public void updateTopic(String id, TopicModel topic) {

     for (int i =0; i < topics.size(); i++){
            TopicModel topicAtCurrentIndex = topics.get(i);

            if (topicAtCurrentIndex.getId().equals(id)){
                topics.set(i, topic); //at the i element, set the new topic
                return;
            }

     }
    }

    public void deleteTopic(String id) {
        topics.removeIf(t -> t.getId().equals(id));
    }

}
