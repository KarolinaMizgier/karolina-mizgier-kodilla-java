package com.kodilla.good.patterns.challenges.productorder.challenge;

public class EmailNotification implements UserNotification {
    private void sendEmail() {
    }

    public String notifyUser() {
        sendEmail();
        return "Notification via e-mail";
    }
}

