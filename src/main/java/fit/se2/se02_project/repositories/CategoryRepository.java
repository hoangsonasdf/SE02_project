package fit.se2.se02_project.repositories;

import fit.se2.se02_project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
