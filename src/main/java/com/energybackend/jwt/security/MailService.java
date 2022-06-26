package com.energybackend.jwt.security;

import com.energybackend.jwt.dtos.MailDTO;

public interface MailService {
    public void sendCodeByEmail(MailDTO mailDTO);
}
