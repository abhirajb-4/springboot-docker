package com.ust.sprinboot_docker.service;

import com.ust.sprinboot_docker.model.Photo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PhotoService {
    private final RestTemplate restTemplate;

    public PhotoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public List<Photo> getPhotos() {
        String url = "https://jsonplaceholder.typicode.com/photos";
        Photo[] photos = restTemplate.getForObject(url, Photo[].class);
        return Arrays.asList(photos);
    }

    public Photo getPhotoById(int id) {
        String url = "https://jsonplaceholder.typicode.com/photos/"+id;
        return restTemplate.getForObject(url, Photo.class);
    }


//    public Todo getTodoById(int id) {
//        String url = "https://jsonplaceholder.typicode.com/todos/" + id;
//        return restTemplate.getForObject(url, Todo.class);
//    }
}
