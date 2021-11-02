package lafactory.com.lafactory.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import lafactory.com.lafactory.model.Origami;

public interface IOrigamiDao extends JpaRepository<Origami, Integer>{
}
