package by.bsuir.glazko.repository;

import by.bsuir.glazko.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("cityRepository")
public interface CityRepository extends JpaRepository<City, String> {

    @Override
    <S extends City> S save(S s);

    Optional<City> findByCityCode(String cityCode);
}