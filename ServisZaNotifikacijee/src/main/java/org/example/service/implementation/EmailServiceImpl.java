package org.example.service.implementation;


import org.example.domain.TipPoruke;
import org.example.repository.TipPorukeRepository;
import org.example.repository.TipNotifikacijeRepository;
import org.example.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

    private TipNotifikacijeRepository tipNotifikacijeRepository;
    private TipPorukeRepository tipPorukeRepository;

    public EmailServiceImpl(TipNotifikacijeRepository tipNotifikacijeRepository, TipPorukeRepository tipPorukeRepository) {
        this.tipNotifikacijeRepository = tipNotifikacijeRepository;
        this.tipPorukeRepository = tipPorukeRepository;
    }

    public void sendAktivacioniEmail(String to, String subject, String text) {
        TipPoruke tipPoruke = new TipPoruke();
        tipPoruke.setText(text);
        tipPoruke.setKome(to);
        tipPoruke.setTipNotifikacije(tipNotifikacijeRepository.findTipNotifikacijeByIme("AKTIVACIONI_EMAIL").get());
        tipPoruke.setVremeKreiranja(LocalDate.now());
        tipPorukeRepository.save(tipPoruke);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sk2ivadjo@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    @Override
    public void sendPasswordChangeEmail(String to, String subject, String text) {
        TipPoruke tipPoruke = new TipPoruke();
        tipPoruke.setText(text);
        tipPoruke.setKome(to);
        tipPoruke.setTipNotifikacije(tipNotifikacijeRepository.findTipNotifikacijeByIme("CHANGE_PASSWORD").get());
        tipPoruke.setVremeKreiranja(LocalDate.now());
        tipPorukeRepository.save(tipPoruke);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sk2ivadjo@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    @Override
    public void sendRezervacijaUspesnoNapravljane(String to, String subject, String text) {
        TipPoruke tipPoruke = new TipPoruke();
        tipPoruke.setText(text);
        tipPoruke.setKome(to);
        tipPoruke.setTipNotifikacije(tipNotifikacijeRepository.findTipNotifikacijeByIme("USPESNA_REZERVACIJA").get());
        tipPoruke.setVremeKreiranja(LocalDate.now());
        tipPorukeRepository.save(tipPoruke);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sk2ivadjo@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    @Override
    public void sendRezervacijaOtkazana(String to, String subject, String text) {
        TipPoruke tipPoruke = new TipPoruke();
        tipPoruke.setText(text);
        tipPoruke.setKome(to);
        tipPoruke.setTipNotifikacije(tipNotifikacijeRepository.findTipNotifikacijeByIme("OTKAZANA_REZERVACIJA").get());
        tipPoruke.setVremeKreiranja(LocalDate.now());
        tipPorukeRepository.save(tipPoruke);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sk2ivadjo@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    @Override
    public void sendPodsednikRezervacije(String to, String subject, String text) {
        TipPoruke tipPoruke = new TipPoruke();
        tipPoruke.setText(text);
        tipPoruke.setKome(to);
        tipPoruke.setTipNotifikacije(tipNotifikacijeRepository.findTipNotifikacijeByIme("PODSEDNIK_REZERVACIJA").get());
        tipPoruke.setVremeKreiranja(LocalDate.now());
        tipPorukeRepository.save(tipPoruke);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sk2ivadjo@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
}
