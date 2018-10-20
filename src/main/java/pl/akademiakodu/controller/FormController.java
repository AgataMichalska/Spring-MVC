package pl.akademiakodu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.akademiakodu.model.Form;

@Controller
@RequestMapping("/form")
public class FormController {

    @GetMapping("/add")
    public ModelAndView addForm(){
        ModelAndView mav = new ModelAndView("form");
        mav.addObject("form", new Form());
        return mav;
    }

    @PostMapping("/add")
    public ModelAndView getForm(@ModelAttribute("form")Form form){
        ModelAndView mav = new ModelAndView("form2");
        mav.addObject("title",form.getTitle());
        mav.addObject("text",form.getText());
        mav.addObject("tags",form.getTags());
        return mav;
    }
}