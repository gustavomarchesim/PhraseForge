package dev.gdam.PhraseForge.service;

import java.util.List;
import java.util.Optional;

import dev.gdam.PhraseForge.dto.SerieDTO;
import dev.gdam.PhraseForge.entity.Serie;

public interface SerieService {
  Serie save(Serie serie);

  List<Serie> findAll();

  List<SerieDTO> obtemFraseAleatoria();

  Optional<Serie> findById(Long id);

  Serie update(Serie serie);

  void deleteById(Long id);
}
