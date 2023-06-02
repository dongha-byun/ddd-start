package hello.ddd.domain;

import jakarta.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class EmailSetAttributeConverter implements AttributeConverter<EmailSet, String> {

    @Override
    public String convertToDatabaseColumn(EmailSet attribute) {
        return attribute.getEmails().stream()
                .map(Email::getAddress)
                .collect(Collectors.joining(","));
    }

    @Override
    public EmailSet convertToEntityAttribute(String dbData) {
        if(dbData == null) {
            return null;
        }
        Set<Email> emailSet = Arrays.stream(dbData.split(","))
                .map(Email::new)
                .collect(Collectors.toSet());
        return new EmailSet(emailSet);
    }
}
