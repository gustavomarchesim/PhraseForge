package dev.gdam.PhraseForge.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.gdam.PhraseForge.dto.SerieDTO;
import dev.gdam.PhraseForge.entity.Serie;
import dev.gdam.PhraseForge.repository.SerieRepository;

@Service
public class SerieServiceImpl implements SerieService {

  @Autowired
  private SerieRepository serieRepository;

  @Override
  public Serie save(Serie serie) {
    return serieRepository.save(serie);
  }

  @Override
  public List<Serie> findAll() {
    return serieRepository.findAll();
  }

  @Override
  public Optional<Serie> findById(Long id) {
    return serieRepository.findById(id);
  }

  @Override
  public Serie update(Serie serie) {
    return serieRepository.save(serie);
  }

  @Override
  public void deleteById(Long id) {
    serieRepository.deleteById(id);
  }

  @Override
  public List<SerieDTO> obtemFraseAleatoria() {
    return convSerieDTOs(serieRepository.obtemFraseAleatoria());
  }

  private List<SerieDTO> convSerieDTOs(List<Serie> series) {
    return series.stream()
        .map(S -> new SerieDTO(S.getId(), S.getTitulo(), S.getFrase(), S.getPersonagem(), S.getPoster()))
        .collect(Collectors.toList());
  }
}
