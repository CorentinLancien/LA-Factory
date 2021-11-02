package lafactory.com.lafactory.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

//Class of Vue
@Entity
@Table(name = "Vue")
@Data
public class Vue {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vue_id")
    //Id of the Vue
    private int id;

    @Column(name = "vew_date")
    //Date of the vue
    private Date date;

    @ManyToOne()
    @JoinColumn(name = "vue_ori_id")
    private Origami origami;
}
