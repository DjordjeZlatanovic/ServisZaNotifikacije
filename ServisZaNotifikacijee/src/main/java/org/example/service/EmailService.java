package org.example.service;


public interface EmailService {
    void sendAktivacioniEmail(String to, String subject, String text);
    void sendPasswordChangeEmail(String to, String subject, String text);
    void sendRezervacijaUspesnoNapravljane(String to, String subject, String text);
    void sendRezervacijaOtkazana(String to, String subject, String text);
    void sendPodsednikRezervacije(String to, String subject, String text);

}
