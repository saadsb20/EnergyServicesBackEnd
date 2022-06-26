package com.energybackend.jwt.security;

import com.energybackend.jwt.dtos.MailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    @Async
    public void sendCodeByEmail(MailDTO mailDTO) {
        SimpleMailMessage simpleMailMessage =new SimpleMailMessage();
        simpleMailMessage.setFrom("ChaimaeLakdari@gmail.com");
        simpleMailMessage.setTo(mailDTO.getTo());
        simpleMailMessage.setSubject("code Active");
        simpleMailMessage.setText(mailDTO.getCode());
        javaMailSender.send(simpleMailMessage);

    }
}
