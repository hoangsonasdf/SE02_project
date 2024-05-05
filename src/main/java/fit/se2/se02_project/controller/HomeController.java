package fit.se2.se02_project.controller;

import fit.se2.se02_project.dto.CategoryDTO;
import fit.se2.se02_project.dto.FeedbackDTO;
import fit.se2.se02_project.model.Category;
import fit.se2.se02_project.model.Feedback;
import fit.se2.se02_project.repositories.CategoryRepository;
import fit.se2.se02_project.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<FeedbackDTO> feedbacks = feedbackRepository.findAll()
                .stream()
                .filter(f -> f.getRate() == 3)
                .map(this::toFeedbackDTO)
                .collect(Collectors.toList());
        List<CategoryDTO> categories = categoryRepository.findAll()
                .stream()
                .filter(c -> c.getIsActive() == 1)
                .map(this::toCategoriesDTO)
                .collect(Collectors.toList());

        // Add feedbacks and categories to the model
        model.addAttribute("feedbacks", feedbacks);
        model.addAttribute("categories", categories);

        return "index";
    }

    private CategoryDTO toCategoriesDTO(Category category) {
        return new CategoryDTO(category.getId(), category.getCategoryName(), category.getDescription()
        , category.getProductsById()
                .stream()
                .map(p -> p.getImage())
                .findFirst()
                .orElse(null));
    }

    private FeedbackDTO toFeedbackDTO(Feedback feedback) {
        return new FeedbackDTO(feedback.getName(), feedback.getComment());
    }
}
