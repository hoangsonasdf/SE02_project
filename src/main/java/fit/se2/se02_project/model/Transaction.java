package fit.se2.se02_project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "`transaction`")
public class Transaction {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "total")
    private BigDecimal total;
    @ManyToOne
    @JoinColumn(name = "orderID", referencedColumnName = "id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "paymentID", referencedColumnName = "id")
    private Payment payment;

}
