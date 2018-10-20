package pl.akademiakodu.model;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class CurrentPageTime implements PageDate {

    @Override
    public String getCurrentDate()  {
        return LocalTime.now().toString();
    }
}

/* public String getCurrentDate(){
LocalTime now = LocalTime.now();
DataTimeFormatter dataTimeFormatter = DataTimeFormatter.ofPattern("H:m:s");
return now.format(dataTimeFormatter);
}*/