package org.example.listener;

import org.example.dto.DestinationDto;
import org.example.service.EmailService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class Listener {
    private MessageHelper messageHelper;
    private EmailService emailService;

    public Listener(MessageHelper messageHelper, EmailService emailService) {
        this.messageHelper = messageHelper;
        this.emailService = emailService;
    }

    @JmsListener(destination = "${destination.slanjeAktivaconogImejla}", concurrency = "5-10")
    public void sendAktivacioniEmail(Message message) throws JMSException {
        DestinationDto destinationDto = messageHelper.getMessage(message, DestinationDto.class);
        emailService.sendAktivacioniEmail(destinationDto.getTo(), destinationDto.getSubject(), destinationDto.getText());
    }
    @JmsListener(destination = "${destination.slanjeLozinkaImejl}", concurrency = "5-10")
    public void sendSlanjeLozinkaImejl(Message message) throws JMSException{
        DestinationDto destinationDto = messageHelper.getMessage(message, DestinationDto.class);
        emailService.sendPasswordChangeEmail(destinationDto.getTo(), destinationDto.getSubject(), destinationDto.getText());
    }
    @JmsListener(destination = "${destination.slanjeRezervacijaPotvrdjena}", concurrency = "5-10")
    public void sendUspesnaRezervacija(Message message) throws JMSException{
        DestinationDto destinationDto = messageHelper.getMessage(message, DestinationDto.class);
        emailService.sendRezervacijaUspesnoNapravljane(destinationDto.getTo(), destinationDto.getSubject(), destinationDto.getText());
    }
    @JmsListener(destination = "${destination.otkazivanjeRezervacije}", concurrency = "5-10")
    public void sendOtkazivanjeRezervacije(Message message) throws JMSException{
        DestinationDto destinationDto = messageHelper.getMessage(message, DestinationDto.class);
        emailService.sendRezervacijaOtkazana(destinationDto.getTo(), destinationDto.getSubject(), destinationDto.getText());
    }
    @JmsListener(destination = "${destination.slanjeSatVremenaPreTermina}", concurrency = "5-10")
    public void sendPodsetnikZaRezervaciju(Message message) throws JMSException{
        DestinationDto destinationDto = messageHelper.getMessage(message, DestinationDto.class);
        emailService.sendPodsednikRezervacije(destinationDto.getTo(), destinationDto.getSubject(), destinationDto.getText());
    }


}
