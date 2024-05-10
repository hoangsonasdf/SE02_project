package fit.se2.se02_project.repositories;

import fit.se2.se02_project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
