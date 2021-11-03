package lafactory.com.lafactory.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lafactory.com.lafactory.dao.IOrigamiDao;
import lafactory.com.lafactory.model.Origami;

@Service
public class OrigamiService {
    
    @Autowired
    private IOrigamiDao daoOrigami;

    public List<Origami> findAll(){
        return this.daoOrigami.findAll();
    }

    public Origami findById(int id){
        return daoOrigami.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    public void deleteById(int id){
        if (daoOrigami.existsById(id)) {
            daoOrigami.deleteById(id);
        }
    }

    public Origami save(Origami categorie){
        return this.daoOrigami.save(categorie);
    }

}
