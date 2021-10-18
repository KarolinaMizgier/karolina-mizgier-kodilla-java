package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
        Forum forum = new Forum();
        Map<Integer, ForumUser> result = forum.getUserList().stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> (LocalDate.now().getYear() - user.getDateOfBirth().getYear() >= 20))
                .filter(user -> user.getNumberOfPosts() > 0)
                .collect(Collectors.toMap(user -> user.getUserId(), user -> user));
        System.out.println("Result: :");
        result.entrySet().stream()
                .map(entry -> entry.getKey() + ":" + entry.getValue().toString())
                .forEach(System.out::println);
    }

}

