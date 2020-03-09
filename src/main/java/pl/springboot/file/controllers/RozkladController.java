package pl.springboot.file.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.springboot.file.model.RodzajRozkladu;
import pl.springboot.file.services.RozkladService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RozkladController {

    private RozkladService rozkladService;

    public RozkladController(RozkladService rozkladService) {
        this.rozkladService = rozkladService;
    }

    @GetMapping(value = "/rozklads")
    public String getRozklads(Model model) {
        model.addAttribute("rodzajRozkladu", new RodzajRozkladu());
        List<RodzajRozkladu> rozklady = rozkladService.findAll();
        model.addAttribute("rozklady", rozklady);

        return "rozklads";
    }

    @PostMapping("/addrozklad")
    public String addRozklad(@ModelAttribute @Valid RodzajRozkladu rodzajRozkladu, RedirectAttributes redirectAttributes) {
        rozkladService.save(rodzajRozkladu);
//        if (result.hasErrors()) {
//            redirectAttributes.addFlashAttribute("succesmessage","Zapisano rozkład");
//        }else {
//            redirectAttributes.addFlashAttribute("errormessage","Nie udało się zapisać rozkładu");
//        }
        return "redirect:rozklads";
    }
}
