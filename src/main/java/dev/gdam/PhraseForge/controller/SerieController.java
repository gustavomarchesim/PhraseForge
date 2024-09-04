package dev.gdam.PhraseForge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.gdam.PhraseForge.dto.SerieDTO;
import dev.gdam.PhraseForge.entity.Serie;
import dev.gdam.PhraseForge.service.SerieService;

@RestController
@RequestMapping("/series")
public class SerieController {

  @Autowired
  private SerieService serieService;

  @GetMapping
  public ResponseEntity<List<Serie>> findAll() {
    return ResponseEntity.status(HttpStatus.OK).body(serieService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Serie>> findById(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(serieService.findById(id));
  }

  @GetMapping("/frases")
  public ResponseEntity<List<SerieDTO>> obtemFraseAleatoria() {
    return ResponseEntity.status(HttpStatus.OK).body(serieService.obtemFraseAleatoria());
  }

  @PostMapping
  public ResponseEntity<Serie> create(@RequestBody Serie serie) {
    return ResponseEntity.status(HttpStatus.CREATED).body(serieService.save(serie));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Serie> update(@RequestBody Serie serie) {
    return ResponseEntity.status(HttpStatus.OK).body(serieService.update(serie));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    serieService.deleteById(id);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

}
