package com.danvega.springtweets.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.danvega.springtweets.model.Friend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/twitter")
public class FriendsController {

  private List<Friend> friends;

  public FriendsController() {
    friends = new ArrayList<>();
    friends.add(new Friend("nicoll", "Stéphane Nicoll"));
    friends.add(new Friend("habuma", "Craig Wells"));
    friends.add(new Friend("maciejwalkowiak", "Maciej Walkowiak"));
    friends.add(new Friend("jitterted", "Ted M. Young"));
    friends.add(new Friend("mraible", "Matt Raible"));
  }

  @GetMapping("/")
  public List<Friend> list() {
    return friends;
  }

  @GetMapping("/{id}")
  public Friend get(@PathVariable String id) {
    return friends.stream().filter(f -> id.equals(f.getId())).findAny().orElse(null);
  }

}
