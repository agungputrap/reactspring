package com.agung.agungtesting.util;

import com.sun.mail.smtp.SMTPMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.Serializable;

@Component
public class EmailUtil implements Serializable {

    Logger log = LoggerFactory.getLogger(this.getClass());

    public static final String EMAIL_UTIL = "emailUtil";
    JavaMailSender mailSender;
    @Value("${email.from}") String from;
    @Value("${email.properties.mail.smtp.from}") String returnEmailAddress;

    public void send(String[] emailDest, String subject, String content, File fileAttachment, String verp) {
        MimeMessage message = mailSender.createMimeMessage();

        try {

            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom(from);
            helper.setTo(emailDest);
            helper.setSubject(subject);
            helper.setText(content, true);

            if (fileAttachment != null) {
                helper.addAttachment(fileAttachment.getName(), fileAttachment);
            }

            SMTPMessage sMTPMessage = new SMTPMessage(helper.getMimeMessage());

            if (verp != null) {
                String[] senderArray = returnEmailAddress.split("@");
                StringBuffer verpAddress = new StringBuffer();
                verpAddress.append(senderArray[0]).append("+").append(verp.replaceAll("@", "=")).append("@").append(senderArray[1]);

                System.err.println("Verp Address : " + verpAddress.toString());

                sMTPMessage.setEnvelopeFrom(verpAddress.toString());
            }

            mailSender.send(sMTPMessage);

        } catch (Exception e) {
            log.info("[EmailUtil] emailDest : {}, subject: {}", emailDest, subject);
            log.error("[EmailUtil] fail ", e);
        }
    }

    public void send(String[] emailDest, String subject, String content) {
        send(emailDest, subject, content, null, null);
    }

    public void send(String[] emailDest, String subject, String content, String verp) {
        send(emailDest, subject, content, null, verp);
    }

    public void send(String[] emailDest, String subject, String content, File file) {
        send(emailDest, subject, content, file, null);
    }

    public void send(String emailDest, String subject, String content, File fileAttachment, String verp) {
        send(new String[]{emailDest}, subject, content, fileAttachment, verp);
    }

    public void send(String emailDest, String subject, String content) {
        send(emailDest, subject, content, null, null);
    }

    public void send(String emailDest, String subject, String content, String verp) {
        send(emailDest, subject, content, null, verp);
    }

    public void send(String emailDest, String subject, String content, File file) {
        send(emailDest, subject, content, file, null);
    }

    public static String verpValue(String verp, String value){
        return verp + "=" + value;
    }
}
