package pl.akademiakodu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.akademiakodu.model.PageDate;
import pl.akademiakodu.model.User;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private User user;

    @Autowired
    @Qualifier(value = "currentPageTime")   //zamiast @Primary
    private PageDate pageDate;


    @GetMapping
    public ModelAndView sayDefault() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("hello");
        mav.addObject("name", "Nieznajomy");
        mav.addObject("surname", "X");
        return mav;
    }

     @GetMapping("/{name}/{surname}")
    public ModelAndView sayHello(@PathVariable String name, @PathVariable String surname) {

        user.setName(name);
        user.setSurname(surname);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("hello");
        mav.addObject("user", user);
        mav.addObject("generated",pageDate.getCurrentDate());
        mav.addObject("isBiggerThan5", name.length()>5);
        return mav;
    }
}

//    @GetMapping
//    public String sayHello() {
//        return "hello";
//    }