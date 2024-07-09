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
@Table(name = "`user`")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "firstName")
    private String firstName;
    @Basic
    @Column(name = "lastName")
    private String lastName;
    @Basic
    @Column(name = "dob")
    private Timestamp dob;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "verifyCode")
    private String verifyCode;
    @Basic
    @Column(name = "verifyAt")
    private Timestamp verifyAt;
    @Basic
    @Column(name = "isActive")
    private Byte isActive;
    @Basic
    @Column(name = "createAt")
    private Timestamp createAt;
    @OneToMany(mappedBy = "user")
    private Collection<Cart> carts;
    @OneToMany(mappedBy = "user")
    private Collection<Order> orders;
    @OneToMany(mappedBy = "user")
    private Collection<Rate> rates;
    @ManyToOne
    @JoinColumn(name = "RoleId", referencedColumnName = "id")
    private Role role;

}
