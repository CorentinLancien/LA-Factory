package lafactory.com.lafactory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lafactory.com.lafactory.model.Categorie;

public interface ICategorieDao extends JpaRepository<Categorie, Integer>{
    
}
