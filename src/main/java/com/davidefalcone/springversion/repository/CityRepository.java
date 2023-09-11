package com.davidefalcone.springversion.repository;

import com.davidefalcone.springversion.model.City;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CityRepository extends ElasticsearchRepository<City, String> {

    List<City> findByDenominazioneInItalianoContainingIgnoreCase(String denominazioneInItaliano);
}
