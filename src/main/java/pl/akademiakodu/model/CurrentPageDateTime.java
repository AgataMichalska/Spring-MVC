package pl.akademiakodu.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component//(value = "currentPageDateTime")
//@Primary
public class CurrentPageDateTime implements PageDate{
    @Override
    public String getCurrentDate() {
        return LocalDateTime.now().toString();
    }
}