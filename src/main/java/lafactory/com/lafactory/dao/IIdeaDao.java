package lafactory.com.lafactory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lafactory.com.lafactory.model.Idea;

public interface IIdeaDao extends JpaRepository<Idea, Integer>{
    
}
