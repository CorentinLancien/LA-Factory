package lafactory.com.lafactory.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lafactory.com.lafactory.dao.ICategorieDao;
import lafactory.com.lafactory.model.Categorie;

@Service
public class CategorieService {
    
    @Autowired
    private ICategorieDao daoCategorie;

    public List<Categorie> findAll(){
        return this.daoCategorie.findAll();
    }

    

    public Categorie findById(int id){
        return daoCategorie.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    public void deleteById(int id){
        if (daoCategorie.existsById(id)) {
            daoCategorie.deleteById(id);
        }
    }

    public Categorie save(Categorie categorie){
        return this.daoCategorie.save(categorie);
    }
}
