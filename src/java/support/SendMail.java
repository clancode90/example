/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import service.UserService;

/**
 *
 * @author Юрий
 */
@Component
public class SendMail {

    @Autowired
    private UserService userService;

    @Autowired
    private MailSender mailSender;

    @Autowired
    private SimpleMailMessage templateMessage;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }

    public void sendMail(String email, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setText(text);
        mailSender.send(message);
    }

    /**
     * This method will send a pre-configured message
     *
     */
    /*
     public void sendPreConfiguredMail(String message) {
     SimpleMailMessage mailMessage = new SimpleMailMessage(templateMessage);
     mailMessage.setText(message);
     mailSender.send(mailMessage);
     }
     */
}
