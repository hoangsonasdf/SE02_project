package fit.se2.se02_project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "`cartitem`")
public class Cartitem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "quantity")
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "productID", referencedColumnName = "id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "cartID", referencedColumnName = "id")
    private Cart cart;

}
