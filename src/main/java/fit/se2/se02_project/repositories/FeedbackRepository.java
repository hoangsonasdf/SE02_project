package fit.se2.se02_project.repositories;

import fit.se2.se02_project.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
