package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Forum {

    ForumUser user1 = new ForumUser(1, "John", 'M', LocalDate.of(1987, 10, 12), 6);
    ForumUser user2 = new ForumUser(2, "Ann", 'F', LocalDate.of(1995, 8, 7), 0);
    ForumUser user3 = new ForumUser(3, "Adam", 'M', LocalDate.of(2005, 12, 17), 15);
    ForumUser user4 = new ForumUser(4, "Chloe", 'F', LocalDate.of(1990, 2, 18), 9);
    ForumUser user5 = new ForumUser(5, "Sam", 'M', LocalDate.of(1983, 6, 22), 0);

    List<ForumUser> userList = Arrays.asList(user1, user2, user3, user4, user5);

    public List<ForumUser> getUserList() {
        return userList;
    }
}
