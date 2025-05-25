package com.pdt.mail;

import com.pdt.contracts.infrastructure.EmailService;
import com.pdt.models.Email;

public class EmailServiceImpl implements EmailService {
    @Override
    public boolean sendEmail(Email email) {
        return false;
    }
}
