package com.agung.agungtesting.eventbus.event;

import java.io.File;

public class SendEmailEvent {
    private String emailDest;
    private String subject;
    private String content;
    private File fileAttachment;

    public String getEmailDest() {
        return emailDest;
    }

    public void setEmailDest(String emailDest) {
        this.emailDest = emailDest;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public File getFileAttachment() {
        return fileAttachment;
    }

    public void setFileAttachment(File fileAttachment) {
        this.fileAttachment = fileAttachment;
    }
}
