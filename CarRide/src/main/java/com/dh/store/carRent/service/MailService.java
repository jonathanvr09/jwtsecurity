package com.dh.store.carRent.service;

public interface MailService {

    void sendMail(String to, String subject, String body);
}
