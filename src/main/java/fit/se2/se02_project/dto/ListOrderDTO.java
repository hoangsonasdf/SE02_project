package fit.se2.se02_project.dto;

import java.util.List;

public class ListOrderDTO {
    private long id;
    private List<OrderProductDTO> listProduct;

    public ListOrderDTO() {
    }

    public ListOrderDTO(long id, List<OrderProductDTO> listProduct) {
        this.id = id;
        this.listProduct = listProduct;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<OrderProductDTO> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<OrderProductDTO> listProduct) {
        this.listProduct = listProduct;
    }
}
