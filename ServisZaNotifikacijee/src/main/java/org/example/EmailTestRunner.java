package org.example;
import org.example.domain.TipNotifikacije;
import org.example.repository.TipNotifikacijeRepository;
import org.example.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmailTestRunner implements CommandLineRunner {

    @Autowired
    private EmailService emailService;
    private TipNotifikacijeRepository tipNotifikacijeRepository;

    public EmailTestRunner(TipNotifikacijeRepository tipNotifikacijeRepository) {
        this.tipNotifikacijeRepository = tipNotifikacijeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        TipNotifikacije tipNotifikacije = new TipNotifikacije();
        tipNotifikacije.setIme("AKTIVACIONI_EMAIL");
        tipNotifikacijeRepository.save(tipNotifikacije);
        TipNotifikacije tipNotifikacije1 = new TipNotifikacije();
        tipNotifikacije1.setIme("CHANGE_PASSWORD");
        tipNotifikacijeRepository.save(tipNotifikacije1);
        TipNotifikacije tipNotifikacije2 = new TipNotifikacije();
        tipNotifikacije2.setIme("POTVRDJENA_REZERVACIJA");
        tipNotifikacijeRepository.save(tipNotifikacije2);
        TipNotifikacije tipNotifikacije3 = new TipNotifikacije();
        tipNotifikacije3.setIme("OTKAZANA_REZERVACIJA");
        tipNotifikacijeRepository.save(tipNotifikacije3);
        TipNotifikacije tipNotifikacije4 = new TipNotifikacije();
        tipNotifikacije4.setIme("PODSEDNIK_ZA_TERMIN");
        tipNotifikacijeRepository.save(tipNotifikacije4);
    }
}