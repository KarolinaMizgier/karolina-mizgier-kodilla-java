package com.kodilla.stream.portfolio;

import java.util.Objects;

public class User {
    private final String username;
    private final String realName;

    public User(String username, String realName) {
        this.username = username;
        this.realName = realName;
    }

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) && realName.equals(user.realName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, realName);
    }
}
