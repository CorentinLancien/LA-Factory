package lafactory.com.lafactory.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import lafactory.com.lafactory.model.Vue;

public interface IVueDao extends JpaRepository<Vue, Integer>{
    //public List<Vue> findAllOrderByDate();
}
