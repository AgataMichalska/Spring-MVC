package pl.akademiakodu.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.akademiakodu.model.Product;
import pl.akademiakodu.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private Service productService;

    @GetMapping
    public ModelAndView getProducts() {
        ModelAndView mav = new ModelAndView("product-list");
        mav.addObject("list2", productService.getList2());
        return mav;
    }

    @GetMapping("/add")
    public ModelAndView addProductForm(){
        ModelAndView mav = new ModelAndView("product-form");
        mav.addObject("product", new Product());
        return mav;
    }

    @PostMapping("/add")
    public ModelAndView saveProduct(@ModelAttribute("product") Product product){

        System.out.println(product);
        productService.save2(product);

        ModelAndView mav = new ModelAndView("product-list");
        mav.addObject("list2", productService.getList2());
        return mav;
    }

    /*
    @RequestMapping(value="/search")
    public ModelAndView Search(@RequestParam(value = "search", required = false)
                                       String pSearchTerm, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("search");

        mav.addObject("search", pSearchTerm);
        mav.addObject("searchResult",
                //findTeamByName(pSearchTerm));

        return mav; */
}