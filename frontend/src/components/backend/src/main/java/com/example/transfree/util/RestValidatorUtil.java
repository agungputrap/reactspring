package com.agung.agungtesting.util;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.agung.agungtesting.dto.error.ValidationError;
import com.agung.agungtesting.exception.auth.*;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Locale;

@Component
public class RestValidatorUtil {

    @Autowired MessageSource messageSource;

    Logger log = LoggerFactory.getLogger(this.getClass());

    public ValidationError buildError(List<FieldError> fieldErrors) {
        ValidationError dto = new ValidationError();

        for (FieldError fieldError: fieldErrors) {
            String localizedErrorMessage = resolveLocalizedErrorMessage(fieldError);
            dto.addFieldError(fieldError.getField(), localizedErrorMessage);
        }

        return dto;
    }

    public ValidationError buildError(String field, String msgCode, String[] args) {
        ValidationError dto = new ValidationError();

        dto.addFieldError(field, this.getMessage(msgCode, args));

        return dto;
    }

    public ValidationError buildError(String field, String msgCode) {
        return this.buildError(field, msgCode, null);
    }

    public ValidationError buildError(Exception exception, String customMessage) {
        ValidationError dto = new ValidationError();
        dto.addFieldError("exception", customMessage);

        if (isInstanceOf(exception, AccessDeniedException.class)) {
            dto.addFieldError("code", "1000");
            dto.addFieldError("message", this.getMessage("msg.exception.accessdenied"));

        }
        if (isInstanceOf(exception, AppNotFoundException.class)) {
            dto.addFieldError("code", "1001");
            dto.addFieldError("message", this.getMessage("msg.exception.appnotfound"));
        }
        if (isInstanceOf(exception, KeyNotValidException.class)) {
            dto.addFieldError("code", "1002");
            dto.addFieldError("message", this.getMessage("msg.exception.keynotvalid"));
        }
        if (isInstanceOf(exception, TokenNotValidException.class)) {
            dto.addFieldError("code", "1003");
            dto.addFieldError("message", this.getMessage("msg.exception.tokennotvalid"));
        }
        if (isInstanceOf(exception, UserNotFoundException.class)) {
            dto.addFieldError("code", "1004");
            dto.addFieldError("message", this.getMessage("msg.exception.usernotfound"));
        }
        if (isInstanceOf(exception, UserPassNotValidException.class)) {
            dto.addFieldError("code", "1005");
            dto.addFieldError("message", this.getMessage("msg.exception.userpassnotvalid"));
        }
        if (isInstanceOf(exception, UserNotActiveException.class)) {
            dto.addFieldError("code", "1006");
            dto.addFieldError("message", this.getMessage("msg.exception.usernotactive"));
        }
        if (isInstanceOf(exception, TokenExpiredException.class)) {
            dto.addFieldError("code", "1007");
            dto.addFieldError("message", this.getMessage("msg.exception.tokenexpired"));
        }


        return dto;
    }

    public ValidationError buildError(InvalidFormatException ex) {
        ValidationError dto = new ValidationError();

        for (JsonMappingException.Reference ref : ex.getPath()) {
            if (ex.getTargetType() == Integer.class) {
                dto.addFieldError(ref.getFieldName(), this.getMessage("typeMismatch.java.lang.Integer"));
            }
        }

        return dto;
    }

    public ValidationError buildError(FileUploadBase.FileSizeLimitExceededException ex) {
        ValidationError dto = new ValidationError();

        String msgFormatted = this.getMessage("msg.exception.filesizelimit", new String[]{ex.getFileName(), ex.getPermittedSize() + ""});

        dto.addFieldError(ex.getFieldName(), msgFormatted);

        return dto;
    }

    private String resolveLocalizedErrorMessage(FieldError fieldError) {
        Locale currentLocale =  LocaleContextHolder.getLocale();
        String localizedErrorMessage = messageSource.getMessage(fieldError, currentLocale);

        return localizedErrorMessage;
    }

    private String getMessage(String code) {
        return this.getMessage(code, null);
    }

    private String getMessage(String code, String[] args) {
        Locale currentLocale =  LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, args, currentLocale);
    }

    private boolean isInstanceOf(Exception e, Class c) {
        Throwable cause = e.getCause();

        return ( c.isAssignableFrom(e.getClass()) || (cause == null ? false : c.isAssignableFrom(cause.getClass())) );
    }
}
