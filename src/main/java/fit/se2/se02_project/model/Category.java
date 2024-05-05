package fit.se2.se02_project.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Category {
    private long id;
    private String categoryName;
    private String description;
    private Byte isActive;
    private Timestamp createAt;
    private String createBy;
    private Timestamp modifyAt;
    private String modifyBy;
    private Collection<Product> productsById;

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
    @Column(name = "categoryName", nullable = true, length = 25)
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "isActive", nullable = true)
    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    @Basic
    @Column(name = "createAt", nullable = true)
    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    @Basic
    @Column(name = "createBy", nullable = true, length = 50)
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Basic
    @Column(name = "modifyAt", nullable = true)
    public Timestamp getModifyAt() {
        return modifyAt;
    }

    public void setModifyAt(Timestamp modifyAt) {
        this.modifyAt = modifyAt;
    }

    @Basic
    @Column(name = "modifyBy", nullable = true, length = 50)
    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != category.id) return false;
        if (categoryName != null ? !categoryName.equals(category.categoryName) : category.categoryName != null)
            return false;
        if (description != null ? !description.equals(category.description) : category.description != null)
            return false;
        if (isActive != null ? !isActive.equals(category.isActive) : category.isActive != null) return false;
        if (createAt != null ? !createAt.equals(category.createAt) : category.createAt != null) return false;
        if (createBy != null ? !createBy.equals(category.createBy) : category.createBy != null) return false;
        if (modifyAt != null ? !modifyAt.equals(category.modifyAt) : category.modifyAt != null) return false;
        if (modifyBy != null ? !modifyBy.equals(category.modifyBy) : category.modifyBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        result = 31 * result + (createAt != null ? createAt.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (modifyAt != null ? modifyAt.hashCode() : 0);
        result = 31 * result + (modifyBy != null ? modifyBy.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "categoryByCategoryId")
    public Collection<Product> getProductsById() {
        return productsById;
    }

    public void setProductsById(Collection<Product> productsById) {
        this.productsById = productsById;
    }
}
