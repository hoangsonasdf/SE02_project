package fit.se2.se02_project.controller;

import fit.se2.se02_project.dto.ProductDTO;
import fit.se2.se02_project.model.Product;
import fit.se2.se02_project.model.User;
import fit.se2.se02_project.repositories.ProductRepository;
import fit.se2.se02_project.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CommonService commonService;
    @GetMapping("/index")
    public String index(Model model){
        User currentUser = commonService.getCurrentUser();
        List<ProductDTO> products = productRepository.findAll()
                .stream()
                .filter(p -> p.getIsActive() == 1)
                .map(this::toProductDTO)
                .collect(Collectors.toList());
        model.addAttribute("products", products);
        model.addAttribute("user", currentUser);
        return "listProduct";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        User currentUser = commonService.getCurrentUser();
        ProductDTO product = productRepository.findAll()
                .stream()
                .filter(p -> p.getIsActive() == 1 && p.getId() == id)
                .map(this::toProductDTO)
                .findAny()
                .orElse(null);;
        model.addAttribute("product", product);
        model.addAttribute("user", currentUser);
        return "detailProduct";
    }




    private ProductDTO toProductDTO(Product product) {
        return new ProductDTO(product.getId(),
                product.getProductName(),
                product.getCategory().getCategoryName(),
                product.getProductstatus().getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getSaleprice(),
                product.getImage());
    }
}
