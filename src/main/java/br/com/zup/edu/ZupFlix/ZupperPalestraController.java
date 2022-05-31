package br.com.zup.edu.ZupFlix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/zuppers")
public class ZupperPalestraController {

    @Autowired
    private ZupperRepository zupperRepository;

    @PostMapping
    public ResponseEntity<Void> cadastraZupper(@RequestBody @Valid ZupperRequest zupperRequest, UriComponentsBuilder uri){
        Zupper zupper = zupperRequest.toModel();
        zupperRepository.save(zupper);

        URI location = uri.path("/zuppers/{id}").buildAndExpand(zupper.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @Transactional
    @PostMapping("/{id}/palestras")
    public ResponseEntity<Void> cadastraPalestra(@RequestBody @Valid PalestraRequest palestraRequest, @PathVariable Long id, UriComponentsBuilder uri){
        Zupper zupper = zupperRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Zupper inexistente"));
        zupperRepository.save(zupper);

        Palestra palestra = palestraRequest.toModel();

        zupper.adiciona(palestra);

        zupperRepository.save(zupper);

        URI location = uri.path("/zuppers/{id}/palestras").buildAndExpand(palestra.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
