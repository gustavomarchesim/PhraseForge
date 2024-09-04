package dev.gdam.PhraseForge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.gdam.PhraseForge.entity.Serie;

public interface SerieRepository extends JpaRepository<Serie, Long> {
  @Query("SELECT s FROM Serie s order by function('RANDOM') LIMIT 1")
  List<Serie> obtemFraseAleatoria();
}
