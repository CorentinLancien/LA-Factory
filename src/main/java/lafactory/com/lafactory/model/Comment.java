package lafactory.com.lafactory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table( name = "Comment")
@Data
//Class for comments
public class Comment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "com_id") 
    //Id for a comment
    private int id;

    @Column(name = "com_message")
    //Message for the comment
    private String message;

    @ManyToOne()
    @JoinColumn( name = "com_ori_id")
    //Origami which is concerned by the comment
    private Origami origami;
}
