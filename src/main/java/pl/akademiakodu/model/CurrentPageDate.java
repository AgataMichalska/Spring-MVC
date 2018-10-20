package pl.akademiakodu.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component  //(value = "currentPageDate")
public class CurrentPageDate implements PageDate {
    @Override
    public String getCurrentDate() {
        return LocalDate.now().toString();
    }
}