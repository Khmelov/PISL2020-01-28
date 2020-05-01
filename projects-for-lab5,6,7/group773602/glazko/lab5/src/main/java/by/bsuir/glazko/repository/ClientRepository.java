package by.bsuir.glazko.repository;

import by.bsuir.glazko.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("clientRepository")
public interface ClientRepository extends JpaRepository<Client, String> {

    @Override
    <S extends Client> S save(S s);

    @Override
    List<Client> findAll();

    void deleteByPassportPersonalNumber(String passportPersonalNumber);
}