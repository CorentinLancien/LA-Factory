package lafactory.com.lafactory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lafactory.com.lafactory.service.CategorieService;

@Controller
@RequestMapping("/home")
public class HomeController {
    
    @Autowired
    private CategorieService srvCategorie;

    @GetMapping()
    public String home(Model model){

        model.addAttribute("categories", this.srvCategorie.findAll());

        return "index";
    }
}
