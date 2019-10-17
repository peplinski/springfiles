package pl.springboot.file.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.springboot.file.model.User;
import pl.springboot.file.services.SpringReadFileService;

import java.util.List;

@Controller
public class SpringReadFileController {

    private SpringReadFileService springReadFileService;

    public SpringReadFileController(SpringReadFileService springReadFileService) {
        this.springReadFileService = springReadFileService;
    }

    @GetMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("user", new User());
        List<User> users = springReadFileService.findAll();
        model.addAttribute("users", users);

        return "view/users";
    }

    @PostMapping(value = "/fileupload")
    public String uploadFile(@ModelAttribute User user, RedirectAttributes redirectAttributes){
boolean isFlag = springReadFileService.saveDataFromUploadFile(user.getFile());
if (isFlag){
    redirectAttributes.addFlashAttribute("succesmessage","File Upload Successfully");
}else {
    redirectAttributes.addFlashAttribute("errormessage","File Upload not done, Please try again");
}


        return "redirect:/";
    }
}
