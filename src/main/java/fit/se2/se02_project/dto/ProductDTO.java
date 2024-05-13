package fit.se2.se02_project.dto;

import java.math.BigDecimal;

public class ProductDTO {
    private long id;
    private String productName;
    private String categoryName;
    private String statusName;
    private BigDecimal price;
    private int quantity;
    private BigDecimal salePrice;
    private String image;

    public ProductDTO() {
    }

    public ProductDTO(long id, String productName, String categoryName, String statusName, BigDecimal price, int quantity, BigDecimal salePrice, String image) {
        this.id = id;
        this.productName = productName;
        this.categoryName = categoryName;
        this.statusName = statusName;
        this.price = price;
        this.quantity = quantity;
        this.salePrice = salePrice;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
