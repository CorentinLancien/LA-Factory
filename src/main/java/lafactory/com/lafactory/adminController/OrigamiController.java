package lafactory.com.lafactory.adminController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lafactory.com.lafactory.model.Categorie;
import lafactory.com.lafactory.model.Origami;
import lafactory.com.lafactory.service.CategorieService;
import lafactory.com.lafactory.service.OrigamiService;


@Controller
@RequestMapping("/admin/origami/{id}")
public class OrigamiController {
    
    @Autowired
    private OrigamiService srvOrigami;

    @Autowired 
    private CategorieService srvCategorie;
    
    @GetMapping("/delete")
    public String delete(@PathVariable int id){

        this.srvOrigami.deleteById(id);
        return "categories";
    }

    @GetMapping()
    public String add(){

        return "admin/editOrigamis";
    }

    @GetMapping("/{origamiId}")
    public String edit(Model model, @PathVariable int origamiId){

        Origami origami = this.srvOrigami.findById(origamiId);

        model.addAttribute("origami", origami);
        model.addAttribute("etapes", origami.getEtapes());
        return "admin/editOrigamis";
    }

    @PostMapping()
    public String save(@PathVariable int id, Origami origami){
        List<Categorie> categories = new ArrayList<Categorie>();
        Categorie categorie = this.srvCategorie.findById(id);
        origami.setId(0);
        origami.setCategories(categories);
        origami.getCategories().add(categorie);

        this.srvOrigami.save(origami);
        return "redirect:/admin/categories/edit/" + id;
    }
}
