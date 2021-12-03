package com.kodilla.good.patterns.challenges.productorder.challenge;

public class SmsNotification implements UserNotification {
    private void sendSms() {
    }

    public String notifyUser() {
        sendSms();
        return "Notification via SMS sent";
    }
}
