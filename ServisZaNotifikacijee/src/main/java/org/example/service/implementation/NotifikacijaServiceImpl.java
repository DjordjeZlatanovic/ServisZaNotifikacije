package org.example.service.implementation;

import org.example.domain.TipNotifikacije;
import org.example.dto.TipNotifikacijeDto;
import org.example.dto.TipPorukeDto;
import org.example.mapper.TipNotifikacijeMapper;
import org.example.mapper.TipPorukeMapper;
import org.example.repository.TipNotifikacijeRepository;
import org.example.repository.TipPorukeRepository;
import org.example.restConfiguration.UserConfiguration;
import org.example.service.NotifikacijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NotifikacijaServiceImpl implements NotifikacijaService {

    private TipPorukeRepository tipPorukeRepository;
    private TipNotifikacijeRepository tipNotifikacijeRepository;
    private TipPorukeMapper tipPorukeMapper;
    private RestTemplate userRezervacijaRest;
    private TipNotifikacijeMapper tipNotifikacijeMapper;

    public NotifikacijaServiceImpl(TipPorukeRepository tipPorukeRepository, TipNotifikacijeRepository tipNotifikacijeRepository, TipPorukeMapper tipPorukeMapper, RestTemplate userRezervacijaRest, TipNotifikacijeMapper tipNotifikacijeMapper) {
        this.tipPorukeRepository = tipPorukeRepository;
        this.tipNotifikacijeRepository = tipNotifikacijeRepository;
        this.tipPorukeMapper = tipPorukeMapper;
        this.userRezervacijaRest = userRezervacijaRest;
        this.tipNotifikacijeMapper = tipNotifikacijeMapper;
    }

    @Override
    public Page<TipPorukeDto> findAllAdmin(Pageable pageable) {
        return tipPorukeRepository.findAll(pageable)
                .map(tipPorukeMapper::tipPorukeToTipPorukeDto);
    }

    @Override
    public List<TipPorukeDto> findAllUser(Long id, String authorization) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", authorization);
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<String> response = null;
        try{
            String url = "/user/getUser?userId=" + id;
            response = userRezervacijaRest.exchange(url, HttpMethod.GET, entity, String.class);
        }catch (HttpClientErrorException e){
            if(e.getStatusCode().equals(HttpStatus.NOT_FOUND))
                throw new IllegalArgumentException();
        }catch (Exception e){
            e.printStackTrace();
        }
        return tipPorukeRepository
                .findTipPorukeByKome(response.getBody())
                .stream()
                .map(tipPorukeMapper::tipPorukeToTipPorukeDto)
                .toList();
    }

    @Override
    public List<TipPorukeDto> findAllMenadzer(Long id, String authorization) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", authorization);
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<String> response = null;
        try{
            String url = "/menadzer/getMenadzer?menadzerId=" + id;
            response = userRezervacijaRest.exchange(url, HttpMethod.GET, entity,String.class);
        }catch (HttpClientErrorException e){
            if(e.getStatusCode().equals(HttpStatus.NOT_FOUND))
                throw new IllegalArgumentException();
        }catch (Exception e){
            e.printStackTrace();
        }
        return tipPorukeRepository
                .findTipPorukeByKome(response.getBody())
                .stream()
                .map(tipPorukeMapper::tipPorukeToTipPorukeDto)
                .toList();
    }

    @Override
    public TipNotifikacijeDto addNewNotification(TipNotifikacijeDto tipNotifikacijeDto) {
        TipNotifikacije tipNotifikacije = tipNotifikacijeMapper.tipNotifikacijeDtoToTipNotifikacije(tipNotifikacijeDto);
        tipNotifikacijeRepository.save(tipNotifikacije);
        return tipNotifikacijeDto;
    }

    @Override
    public void deleteNotification(Long id) {
        TipNotifikacije tipNotifikacije = tipNotifikacijeRepository
                .findTipNotifikacijeById(id)
                .orElseThrow();
        tipNotifikacijeRepository.delete(tipNotifikacije);
    }


}
