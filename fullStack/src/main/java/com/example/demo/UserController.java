package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@RestController
@Controller
//@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private  UserService userService;

    @GetMapping("/student")
    public String getStudentPage() {
        return "student-page"; // This corresponds to student-page.html in the templates folder
    }

    @GetMapping("/professor")
    public String getProfessorPage() {
        return "professor-page"; // This corresponds to student-page.html in the templates folder
    }
    @GetMapping("/appointments")
    public String getAppointmentsPage() {
        return "appointments"; // This corresponds to student-page.html in the templates folder
    }

    @PostMapping("/saveUser")
    public String add(@RequestParam("studentname") String name, @RequestParam("studentemail") String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userService.saveUser(user);
        return "redirect:/appointments"; // Redirect to the home page after saving the user
    }

    @GetMapping("/getAll")
    public List<User> list(){
        return userService.getAllUsers();
    }

//    @GetMapping("/userName")
//    public ResponseEntity<String> getName() {
//        String userName = userService.getName(); // Implement this method in your UserService
//        return ResponseEntity.ok(userName);
//    }


}
