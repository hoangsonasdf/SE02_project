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
@Table(name = "`order`")
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "orderDate")
    private Timestamp orderDate;
    @Basic
    @Column(name = "notes")
    private String notes;
    @Basic
    @Column(name = "firstname")
    private String firstname;
    @Basic
    @Column(name = "lastName")
    private String lastName;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "phone")
    private String phone;
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "orderStatusId", referencedColumnName = "id")
    private Orderstatus orderstatus;
    @OneToMany(mappedBy = "order")
    private Collection<Orderdetail> orderdetails;
    @OneToMany(mappedBy = "order")
    private Collection<Transaction> transactions;

}
