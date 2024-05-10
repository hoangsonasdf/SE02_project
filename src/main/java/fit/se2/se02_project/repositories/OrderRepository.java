package fit.se2.se02_project.repositories;

import fit.se2.se02_project.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
