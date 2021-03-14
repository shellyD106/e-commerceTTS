package com.ecommerce.ecommerceTTS.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ControllerAdvice
public class MainController {

    @Autowired
    ProductService productService;

    @GetMapping(value="/")
    public String main(){
        return"main";
    }
    @ModelAttribute(value = "products")
    public List<Products> products(){
        return productService.findAll();
    }

    @ModelAttribute(value ="categories")
    public List<String> categories(){
        return productService.findDistinctCategories();
    }

    @ModelAttribute(value = "brands")
    public List <String> brands (){
        return productService.findDistinctBrands();
    }

    @GetMapping(value="/filter")
    public String filter(@RequestParam(required = false)String category,
                         @RequestParam(required = false)String brand, Model model){
        List<Product> filtered= productService.findByBrandAndOrCategory(brand, category);
        model.addAttribute(s:"products",filtered);

        return"main";

    }
    @GetMapping(value = "/filter")
    public String filter(@RequestParam(required = false) String category,
                         @RequestParam(required = false) String brand, Model model) {
        List<Product> filtered = productService.findByBrandAndCategory(brand, category);
        model.addAttribute("products", filtered);

        return "main";
    }


    @GetMapping(value="/about")
    public String about (){
        return "about";
    }
}
