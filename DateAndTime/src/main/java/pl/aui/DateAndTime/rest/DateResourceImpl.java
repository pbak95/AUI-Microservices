package pl.aui.DateAndTime.rest;

import pl.aui.DateAndTime.rest.model.DateResponse;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateResourceImpl implements DateResource {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private static final String APP_NAME = "DateAndTime";

    @Override
    public DateResponse getDate() {
        return new DateResponse(APP_NAME, LocalDateTime.now().format(DATE_FORMAT));
    }
}
