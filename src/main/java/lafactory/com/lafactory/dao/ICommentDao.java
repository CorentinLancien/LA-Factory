package lafactory.com.lafactory.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import lafactory.com.lafactory.model.Comment;

public interface ICommentDao extends JpaRepository<Comment, Integer>{

}
