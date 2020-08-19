package myFirstSpringBootApp.controller;


import lombok.RequiredArgsConstructor;
import myFirstSpringBootApp.domain.Animal;
import myFirstSpringBootApp.domain.User;
import myFirstSpringBootApp.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;

    @GetMapping
    public String form (){
        return "registration";
    }

    @PostMapping
    public String addUser (
            @Valid User user,
            BindingResult bindingResult,
            Model model
            ){
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("user", user);


            return "registration";
        } else {

            if (userService.addUser(user)) {
                return "redirect:/animals";
            } else {
                return "registration";
            }
        }
    }
}
