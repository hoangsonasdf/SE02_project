package fit.se2.se02_project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "`category`")
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "categoryName")
    private String categoryName;
    @Basic
    @Column(name = "description")
    private String description;
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
    @OneToMany(mappedBy = "category")
    private Collection<Product> products;

}
