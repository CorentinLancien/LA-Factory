package lafactory.com.lafactory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Idea")
@Data
//Class for Idea
public class Idea {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idea_id")
    //Id for Idea
    private int id;

        //Name of the visitor who sent the idea
        @Column(name = "idea_name")
        private String Name;
    
        //FirstName of the visitor who sent the idea
        @Column(name = "idea_firstname")
        private String firstName;
        
        //Mail of the visitor who sent the idea
        @Column(name = "idea_mail")
        private String mail;
    
        //Description of the idea
        @Column(name = "idea_desc")
        private String description;

    //Disabling the idea on the website
    // 1 if it's enable - 0 if it's disable
    @Column(name = "cat_is_enable")
    private Boolean is_Enable;            
}
