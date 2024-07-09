package fit.se2.se02_project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "`product`")
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "productName")
    private String productName;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "price")
    private BigDecimal price;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "quantity")
    private Integer quantity;
    @Basic
    @Column(name = "isActive")
    private Byte isActive;
    @Basic
    @Column(name = "createAt")
    private Timestamp createAt;
    @Basic
    @Column(name = "createBy")
    private String createBy;
    @Basic
    @Column(name = "modifyAt")
    private Timestamp modifyAt;
    @Basic
    @Column(name = "modifyBy")
    private String modifyBy;
    @Basic
    @Column(name = "image")
    private String image;
    @Basic
    @Column(name = "saleprice")
    private BigDecimal saleprice;
    @OneToMany(mappedBy = "product")
    private Collection<Cartitem> cartitems;
    @OneToMany(mappedBy = "product")
    private Collection<Orderdetail> orderdetails;
    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "productStatusId", referencedColumnName = "id")
    private Productstatus productstatus;
    @OneToMany(mappedBy = "product")
    private Collection<Rate> rates;

}
