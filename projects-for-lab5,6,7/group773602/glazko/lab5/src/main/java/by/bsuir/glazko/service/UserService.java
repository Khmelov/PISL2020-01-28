package by.bsuir.glazko.service;

import by.bsuir.glazko.service.exception.ServiceException;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    void addClientsFromXml(MultipartFile clientsFile) throws ServiceException;

    void deleteClientsFromXml(MultipartFile clientsFile) throws ServiceException;

    void addClientsFromJson(MultipartFile clientsFile) throws ServiceException;

    void readClientsToXml() throws ServiceException;

    void readClientsToJson() throws ServiceException;
}