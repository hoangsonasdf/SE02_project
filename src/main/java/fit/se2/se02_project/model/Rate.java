package fit.se2.se02_project.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Rate {
    private long id;
    private Long userId;
    private Long productId;
    private Short star;
    private Timestamp createAt;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userId", nullable = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "productId", nullable = true)
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "star", nullable = true)
    public Short getStar() {
        return star;
    }

    public void setStar(Short star) {
        this.star = star;
    }

    @Basic
    @Column(name = "createAt", nullable = true)
    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rate rate = (Rate) o;

        if (id != rate.id) return false;
        if (userId != null ? !userId.equals(rate.userId) : rate.userId != null) return false;
        if (productId != null ? !productId.equals(rate.productId) : rate.productId != null) return false;
        if (star != null ? !star.equals(rate.star) : rate.star != null) return false;
        if (createAt != null ? !createAt.equals(rate.createAt) : rate.createAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (star != null ? star.hashCode() : 0);
        result = 31 * result + (createAt != null ? createAt.hashCode() : 0);
        return result;
    }
}
