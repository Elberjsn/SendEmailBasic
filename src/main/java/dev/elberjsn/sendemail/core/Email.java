package dev.elberjsn.sendemail.core;

import java.time.Instant;

public record Email(
        String nameTo,
        String toMail,
        String subBody,
        String subject,
        String fromMail,
        String template,
        String link,
        String time,
        String local

) {
}
