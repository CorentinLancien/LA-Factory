package lafactory.com.lafactory.model;

import java.sql.Time;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Origami")
@Data
//class for origami
public class Origami {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ori_id", nullable = false)
    //Id of origami
    private int id;

    //Name of origami
    @Column(name = "ori_name")
    private String Name;

    //Time to make the origami
    @Column(name = "ori_time")
    private String time;
    
    //Level of origami
    @Column(name = "ori_level")
    private String level;

    //Number of sheet to make the origami
    @Column(name = "ori_sheet")
    private int sheet;
    
    //Note of origami
    @Column(name = "ori_note")
    private int note;

    //Disabling the origami on the website
    // 1 if it's enable - 0 if it's disable
    @Column(name = "cat_is_enable")
    private Boolean is_Enable;    

    
    @OneToMany(mappedBy = "origami")
    //List of steps for the origami
    private List<Etape> etapes;

    @ManyToMany()
    @JoinTable(
        name = "Origami_Categorie", 
        joinColumns = @JoinColumn(name = "ori_id") , 
        inverseJoinColumns =  @JoinColumn(name = "cat_id")
    )
    //List of categorie which contain the origami
    private List<Categorie> categories;

    @OneToMany(mappedBy = "origami")
    //List of vues for the origami
    private List<Vue> vues;

    @OneToMany(mappedBy = "origami")
    //List of comments for the origami
    private List<Comment> comments;
}
