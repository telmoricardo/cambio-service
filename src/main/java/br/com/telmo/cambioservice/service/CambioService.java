package br.com.telmo.cambioservice.service;

import br.com.telmo.cambioservice.model.Cambio;
import br.com.telmo.cambioservice.repository.CambioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CambioService {

    @Autowired
    private CambioRepository repository;

    public Cambio findByFromAndTo(String from, String to) {
        return repository.findByFromAndTo(from, to);
    }
}
