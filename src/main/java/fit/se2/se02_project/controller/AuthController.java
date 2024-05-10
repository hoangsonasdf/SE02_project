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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private CommonService commonService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest request, HttpServletResponse response) {
        try {
            Map<String, String> errorList = new HashMap<>();
            if (request.getUsername() == null) {
                errorList.put("NullUsername", "* Username cannot be empty");
            }
            if (request.getPassword() == null) {
                errorList.put("NullPassword", "* Password cannot be empty");
            }
            if (!errorList.isEmpty()) {
                return "login";
            }
            String hashedPassword = commonService.hash(request.getPassword());
            String hashedPasswordLower = hashedPassword.toLowerCase();
            User user = userRepository.findAll()
                    .stream()
                    .filter(u -> Objects.equals(u.getUsername(), request.getUsername()) && Objects.equals(u.getPassword(), hashedPasswordLower))
                    .findAny()
                    .orElse(null);
            if (user == null) {
                errorList.put("Invalid", "* Username or Password is not valid");
                return "login";
            }

            String token = commonService.createToken(user);
            Cookie cookie = new Cookie("token", token);
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            cookie.setMaxAge(30 * 60);
            response.addCookie(cookie);

            if (user.getRole().getId() == 1) {
                return "/dashboard/index";
            } else {
                return "/";
            }
        } catch (Exception ex) {
            return "error";
        }
    }
}
