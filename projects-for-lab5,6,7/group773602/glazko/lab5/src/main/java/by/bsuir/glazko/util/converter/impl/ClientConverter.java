package by.bsuir.glazko.util.converter.impl;

import by.bsuir.glazko.entity.Client;
import by.bsuir.glazko.entity.Clients;
import by.bsuir.glazko.util.converter.Converter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component("clientConverter")
public class ClientConverter implements Converter<Client> {

    private final ObjectMapper objectMapper;

    public ClientConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Client> unmarshalFromXml(byte[] data) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Clients.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                new ByteArrayInputStream(data), StandardCharsets.UTF_8));
        Clients clients = (Clients) unmarshaller.unmarshal(bufferedReader);
        return clients.getClients();
    }

    @Override
    public void marshalToXml(List<Client> data) throws JAXBException {
        Clients clients = new Clients(data);
        JAXBContext context = JAXBContext.newInstance(Clients.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        long time = System.currentTimeMillis();
        marshaller.marshal(clients, new File("E:\\Java\\PislLab5\\src\\main\\resources\\clients" + time + ".xml"));
    }

    @Override
    public List<Client> unmarshalFromJson(byte[] data) throws IOException {
        Clients clients = objectMapper.readValue(data, Clients.class);
        return clients.getClients();
    }

    @Override
    public void marshalToJson(List<Client> data) throws IOException {
        Clients clients = new Clients(data);
        long time = System.currentTimeMillis();
        objectMapper.writeValue(new File("E:\\Java\\PislLab5\\src\\main\\resources\\clients" + time + ".json"), clients);
    }
}