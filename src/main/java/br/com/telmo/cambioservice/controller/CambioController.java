package br.com.telmo.cambioservice.controller;

import br.com.telmo.cambioservice.model.Cambio;
import br.com.telmo.cambioservice.service.CambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@RequestMapping("cambio-service")
public class CambioController {
    @Autowired
    private Environment environment;
    @Autowired
    private CambioService service;


    @GetMapping(value = "/{amount}/{from}/{to}")
    public Cambio getCambio(
            @PathVariable("amount") BigDecimal amount,
            @PathVariable("from") String from,
            @PathVariable("to") String to) {

        var cambio = service.findByFromAndTo(from, to);
        if(cambio == null) throw new RuntimeException("Currency Unsupported");

        var port = environment.getProperty("local.server.port");
        BigDecimal conversionFactor = cambio.getConversionFactor();
        BigDecimal converterdValue = conversionFactor.multiply(amount);
        cambio.setEnviroment(port);
        cambio.setConverterdValue(converterdValue.setScale(2, RoundingMode.CEILING));
        return cambio;
    }
}
