package com.kodilla.patterns2.observer.homework;

import lombok.Builder;

public class Task {
    private final String link;

    public Task(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}
