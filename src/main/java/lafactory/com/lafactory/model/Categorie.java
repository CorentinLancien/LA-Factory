package lafactory.com.lafactory.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Categorie")
@Data
//Class for categorie
public class Categorie {

    //Id of categorie
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cat_id", nullable = false)
    private int id;

    //Libelle of categorie
    @Column(name = "cat_lib")
    private String libelle;

    @Column(name = "is_parent")
    //Boolean to know if the categorie is a parent categorie
    private int isParent;

    //childrens of the categorie ( 0 if there are no childrens )
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "Parents_Childrens", 
        joinColumns = @JoinColumn(name = "cat_parent"),
        inverseJoinColumns = @JoinColumn(name = "cat_children")
    )
    private List<Categorie> childrens;

    @ManyToMany(mappedBy = "categories")
    //List of origamis for the categorie
    private List<Origami> origamis;
}
