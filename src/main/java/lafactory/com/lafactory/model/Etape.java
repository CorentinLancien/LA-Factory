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
@Table(name = "Etape")
@Data
//Class for step
public class Etape {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "etape_id", nullable = false)
    //id for step
    private int id;

    @Column(name = "etape_title")
    //Title of the step
    private String title;

    @Column(name = "etape_desc")
    //Description of the step
    private String description;

    @Column(name = "etape_position")
    //Position of the step
    private int position;
    
    @ManyToOne()
    @JoinColumn(name="etape_ori_id")
    //Origami which is concern by the step
    private Origami origami;
}
