package by.bsuir.glazko.util.converter;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface Converter<T> {

    List<T> unmarshalFromXml(byte[] data) throws JAXBException;

    void marshalToXml(List<T> data) throws JAXBException;

    List<T> unmarshalFromJson(byte[] data) throws IOException;

    void marshalToJson(List<T> data) throws IOException;
}