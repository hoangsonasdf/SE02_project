package fit.se2.se02_project.controller;

import fit.se2.se02_project.dto.ListOrderDTO;
import fit.se2.se02_project.dto.OrderProductDTO;
import fit.se2.se02_project.model.Order;
import fit.se2.se02_project.model.Orderdetail;
import fit.se2.se02_project.model.Orderstatus;
import fit.se2.se02_project.model.User;
import fit.se2.se02_project.repositories.OrderDetailRepository;
import fit.se2.se02_project.repositories.OrderRepository;
import fit.se2.se02_project.repositories.OrderStatusRepository;
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
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private CommonService commonService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderStatusRepository orderStatusRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/history/{statusId}")
    public String history(@PathVariable Long statusId, Model model) {
        User currentUser = commonService.getCurrentUser();
        long countOrder = orderRepository.findAll()
                .stream()
                .filter(o -> o.getUser().getId() == currentUser.getId() && o.getOrderstatus().getId() == statusId)
                .count();
        model.addAttribute("count", countOrder);

        List<ListOrderDTO> listOrder = orderRepository.findAll()
                .stream()
                .filter(o -> o.getUser().getId() == currentUser.getId() && o.getOrderstatus().getId() == statusId)
                .map(this::toListOrderDTO)
                .collect(Collectors.toList());
        model.addAttribute("history", listOrder);

        List<Orderstatus> orderStatus = orderStatusRepository.findAll();
        model.addAttribute("orderStatus", orderStatus);

        Orderstatus currentOrderStatus = orderStatusRepository.findById(statusId).orElse(null);
        if (currentOrderStatus != null) {
            model.addAttribute("orderStatusName", currentOrderStatus.getName());
        }

        model.addAttribute("statusId", statusId);
        model.addAttribute("user", currentUser);

        return "history";
    }

    private ListOrderDTO toListOrderDTO(Order order) {
        return new ListOrderDTO(order.getId(), orderDetailRepository.findAll()
                .stream()
                .filter(od -> od.getOrder().getId() == order.getId())
                .map(this::toOrderProductDTO)
                .collect(Collectors.toList()));
    }

    private OrderProductDTO toOrderProductDTO(Orderdetail orderdetail) {
        return new OrderProductDTO(orderdetail.getProduct().getImage(),
                orderdetail.getProduct().getProductName(),
                orderdetail.getQuantity(),
                orderdetail.getPrice());
    }
}
