package by.bsuir.glazko.service.impl;

import by.bsuir.glazko.entity.City;
import by.bsuir.glazko.entity.Client;
import by.bsuir.glazko.entity.Country;
import by.bsuir.glazko.repository.CityRepository;
import by.bsuir.glazko.repository.ClientRepository;
import by.bsuir.glazko.repository.CountryRepository;
import by.bsuir.glazko.service.UserService;
import by.bsuir.glazko.service.exception.ServiceException;
import by.bsuir.glazko.util.converter.impl.ClientConverter;
import by.bsuir.glazko.util.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@Service("userServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {

    private final ClientRepository clientRepository;
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;

    private final Converter<Client> clientConverter;

    @Autowired
    public UserServiceImpl(@Qualifier("clientRepository") ClientRepository clientRepository,
                           @Qualifier("countryRepository") CountryRepository countryRepository,
                           @Qualifier("cityRepository") CityRepository cityRepository,
                           @Qualifier("clientConverter") ClientConverter clientConverter) {
        this.clientRepository = clientRepository;
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
        this.clientConverter = clientConverter;
    }

    @Override
    public void addClientsFromXml(MultipartFile clientsFile) throws ServiceException {
        try {
            byte[] fileBytes = clientsFile.getBytes();
            List<Client> clients = clientConverter.unmarshalFromXml(fileBytes);
            clients.forEach(this::processClient);
        } catch (IOException | JAXBException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteClientsFromXml(MultipartFile clientsFile) throws ServiceException {
        try {
            byte[] fileBytes = clientsFile.getBytes();
            List<Client> clients = clientConverter.unmarshalFromXml(fileBytes);
            clients.forEach(client -> {
                String passportPersonalNumber = client.getPassportPersonalNumber();
                clientRepository.deleteByPassportPersonalNumber(passportPersonalNumber);
            });
        } catch (IOException | JAXBException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addClientsFromJson(MultipartFile clientsFile) throws ServiceException {
        try {
            byte[] fileBytes = clientsFile.getBytes();
            List<Client> clients = clientConverter.unmarshalFromJson(fileBytes);
            clients.forEach(this::processClient);
        } catch (IOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void readClientsToXml() throws ServiceException {
        try {
            List<Client> clients = clientRepository.findAll();
            clientConverter.marshalToXml(clients);
        } catch (JAXBException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void readClientsToJson() throws ServiceException {
        try {
            List<Client> clients = clientRepository.findAll();
            clientConverter.marshalToJson(clients);
        } catch (IOException e) {
            throw new ServiceException(e);
        }
    }

    private void processClient(Client client) {
        Country country = client.getCitizenship();
        Country dbCountry = countryRepository.findByCountryCode(country.getCountryCode())
                .orElse(countryRepository.save(country));
        City city = client.getResidenceCity();
        City dbCity = cityRepository.findByCityCode(city.getCityCode())
                .orElse(cityRepository.save(city));
        if (dbCountry != null) {
            client.setCitizenship(dbCountry);
        }
        if (dbCity != null) {
            client.setResidenceCity(dbCity);
        }
        clientRepository.save(client);
    }
}