package by.bsuir.glazko.repository;

import by.bsuir.glazko.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("countryRepository")
public interface CountryRepository extends JpaRepository<Country, String> {

    @Override
    <S extends Country> S save(S s);

    Optional<Country> findByCountryCode(String countryCode);
}