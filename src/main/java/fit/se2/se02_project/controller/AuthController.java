package fit.se2.se02_project.controller;

import fit.se2.se02_project.model.User;
import fit.se2.se02_project.repositories.UserRepository;
import fit.se2.se02_project.request.LoginRequest;
import fit.se2.se02_project.service.CommonService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AuthController {
    @Autowired
    private CommonService commonService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("request", new LoginRequest()); // Add empty LoginDTO to model for form binding
        return "login";
    }

//    @PostMapping("/login")
//    public String login(@ModelAttribute("request") LoginRequest request,
//                        HttpServletResponse response,
//                        RedirectAttributes redirectAttributes) {
//        try {
//            Map<String, String> errorList = new HashMap<>();
//            if (request.getUsername() == null) {
//                errorList.put("NullUsername", "* Username cannot be empty");
//            }
//            if (request.getPassword() == null) {
//                errorList.put("NullPassword", "* Password cannot be empty");
//            }
//            if (!errorList.isEmpty()) {
//                redirectAttributes.addFlashAttribute("errorList", errorList);
//                return "redirect:/login";
//            }
//
//            String hashedPassword = commonService.hash(request.getPassword());
//            String hashedPasswordLower = hashedPassword.toLowerCase();
//            User user = userRepository.findByUsernameIgnoreCase(request.getUsername());
//            if (user == null || !user.getPassword().equalsIgnoreCase(hashedPasswordLower)) {
//                errorList.put("Invalid", "* Username or Password is not valid");
//                redirectAttributes.addFlashAttribute("errorList", errorList);
//                return "redirect:/login";
//            }
//
//            String token = commonService.createToken(user);
//            Cookie tokenCookie = new Cookie("token", token);
//            tokenCookie.setHttpOnly(true);
//            tokenCookie.setMaxAge(1800); // 30 minutes
//            response.addCookie(tokenCookie);
//
//            if (user.getRoleId() == 1) {
//                int currentMonth = LocalDateTime.now().getMonthValue();
//                int currentYear = LocalDateTime.now().getYear();
//                return "redirect:/dashboard?year=" + currentYear + "&month=" + currentMonth;
//            } else {
//                return "redirect:/home";
//            }
//        } catch (Exception ex) {
//            return "redirect:/error?message=" + ex.getMessage();
//        }
//    }
}
