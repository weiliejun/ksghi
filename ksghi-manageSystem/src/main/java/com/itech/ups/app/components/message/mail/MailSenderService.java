package com.itech.ups.app.components.message.mail;

public interface MailSenderService {

    void sendMailWithPureText(MailEntity mailEntity);

    boolean sendMimeMessage(MailEntity mailEntity);
}
