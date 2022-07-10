package rca.ne.client.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import rca.ne.client.dtos.CreateOrUpdateUserDTO;
import rca.ne.client.dtos.User;
import rca.ne.client.enums.ERole;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class UserController {

    @GetMapping
    public String index() {
        return "Register";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/login-page";
    }
    @GetMapping("/one")
    public String one(Model model, HttpServletRequest request) {
        //get single user from server
        RestTemplate restTemplate = new RestTemplate();
        String URL = "http://localhost:5500/api/v1/users/{id}";
           User user = restTemplate.getForObject(URL, User.class,request.getParameter("id"));
        model.addAttribute("user", user);
        return "EditForm";
    }

    @GetMapping("view-all-users")
    public String viewAllUsers(Model model, HttpServletRequest request) {
        //get all users
        RestTemplate restTemplate = new RestTemplate();
        String URL = "http://localhost:5500/api/v1/users";
        User[] users = restTemplate.getForObject(URL, User[].class);
        model.addAttribute("users", users);

        return "ViewAllUsers";
    }

    //post mapping on register new user
    @PostMapping("/register")
    public String register(String firstName,String lastName, String username,  String email, String phone, ERole role){
        CreateOrUpdateUserDTO dto = new CreateOrUpdateUserDTO(firstName, lastName, email, username,role);
        dto.setStatus("ACTIVE");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:5500/api/v1/users",dto,String.class);
        return "redirect:/view-all-users";
    }

    @PostMapping("/edit")
    public String edit(HttpServletRequest request,String firstName,String lastName, String username, String password, String email, String phone, ERole role, Long id){
        CreateOrUpdateUserDTO dto = new CreateOrUpdateUserDTO(firstName, lastName, email, username,role);
        dto.setStatus("ACTIVE");
        String URL = "http://localhost:5500/api/v1/users/{id}";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(URL,dto,request.getParameter("id"));
        return "redirect:/view-all-users";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request){
        String URL = "http://localhost:5500/api/v1/users/{id}";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(URL,request.getParameter("id"));
        return "redirect:/view-all-users";
    }
}

