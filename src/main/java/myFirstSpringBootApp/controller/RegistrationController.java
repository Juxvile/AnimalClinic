package myFirstSpringBootApp.controller;


import lombok.RequiredArgsConstructor;
import myFirstSpringBootApp.domain.Animal;
import myFirstSpringBootApp.domain.User;
import myFirstSpringBootApp.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;

    @GetMapping
    public String form (
            @RequestParam(name = "editUser", required = false, defaultValue = "") User user,
            Model model
    ){
        model.addAttribute("user", user);
        model.addAttribute("users", userService.users());
        return "registration";
    }

    @PostMapping
    public String addUser (
            @Valid User user,
            BindingResult bindingResult,
            Model model
            ){

        if (bindingResult.hasErrors()) {
            model.addAttribute("users", userService.users());
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            return "registration";

        } else {
                userService.addUser(user);
                return "redirect:/animals";
        }
    }
    @GetMapping("/activation/{code}")
    public String activate (Model model, @PathVariable String code){
        boolean isActivated = userService.activateUser(code);

        if(isActivated){
            model.addAttribute("message", "success");
        } else {
            model.addAttribute("message", "Activation code isn't found");
        }
        return "redirect:/animals";
    }
}
