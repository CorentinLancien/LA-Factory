package lafactory.com.lafactory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lafactory.com.lafactory.model.Etape;

public interface IEtapeDao extends JpaRepository<Etape, Integer>{
    //public List<Etape> findAllGroupByIdOrderByPosition();
}
