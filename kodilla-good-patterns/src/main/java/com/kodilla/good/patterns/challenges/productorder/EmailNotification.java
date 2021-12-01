package com.kodilla.good.patterns.challenges.productorder;

public class EmailNotification implements UserNotification {
    private void sendEmail() {
    }

    public String notifyUser() {
        sendEmail();
        return "Notification via e-mail sent";
    }
}
