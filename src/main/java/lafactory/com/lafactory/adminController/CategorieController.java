package lafactory.com.lafactory.adminController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;


import lafactory.com.lafactory.model.Categorie;
import lafactory.com.lafactory.service.CategorieService;
import lafactory.com.lafactory.service.OrigamiService;


@Controller
@RequestMapping("/admin/categories")
public class CategorieController {
    
    @Autowired
    private CategorieService srvCategorie;

    @Autowired 
    OrigamiService srvOrigami;

    @GetMapping()
    public String categorie(Model model){

        model.addAttribute("categories", this.srvCategorie.findAll());
        return "admin/categories";
    }

    @GetMapping("/{id}")
    public String delete(@PathVariable int id){

        this.srvCategorie.deleteById(id);
        return "categories";
    }

    @GetMapping("/add/{id}")
    public String add(){

        return "admin/editCategorie";
    }

    @PostMapping("/add/{id}")
    public String save(@PathVariable int id, Categorie categorie){
        if(id == 0){
            categorie.setIsParent(1);
            this.srvCategorie.save(categorie);
        }
        else{
            Categorie parent = this.srvCategorie.findById(id);
            categorie.setId(0);
            parent.getChildrens().add(categorie);            
            this.srvCategorie.save(parent);
        }
        return "redirect:/admin/categories";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id){

        Categorie categorie = this.srvCategorie.findById(id);

        model.addAttribute("origamis", categorie.getOrigamis());
        model.addAttribute("categorie", categorie);
        return "admin/editCategorie";
    }

    @PostMapping("/edit/{id}")
    public String modify(@PathVariable int id, Categorie categorie){
        Categorie currentCategorie = this.srvCategorie.findById(id);
            currentCategorie.setLibelle(categorie.getLibelle());     
            this.srvCategorie.save(currentCategorie);
        return "redirect:/admin/categories";
    }
}
