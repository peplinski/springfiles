package pl.springboot.file.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.springboot.file.model.RodzajRozkladu;
import pl.springboot.file.services.RozkladService;

import java.util.List;

@Controller
@RequestMapping("/admin/rozklady")
public class RozkladController {

    private RozkladService rozkladService;

    @Autowired
    public RozkladController(RozkladService rozkladService) {
        this.rozkladService = rozkladService;
    }

    @GetMapping(value = "/rodzajRozkladow/rozklads")
    public String home(Model model) {
        model.addAttribute("rozklad", new RodzajRozkladu());
        List<RodzajRozkladu> rozklady = rozkladService.findAll();
        model.addAttribute("rozklady", rozklady);

        return "view/admin/rodzajRozkladow/rozklads";
    }

    @PostMapping(value = "/addrozklad")
    public String addRozklad(@ModelAttribute RodzajRozkladu rodzajRozkladu, BindingResult result, RedirectAttributes redirectAttributes) {
        boolean isFlag = rozkladService.save(rodzajRozkladu);
        redirectAttributes.addFlashAttribute("message", "Failed");
        redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        if (result.hasErrors()) {
            return "redirect:/rodzajRozkladow/rozklads";
        }
        redirectAttributes.addFlashAttribute("message", "Success");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        return "redirect:/rodzajRozkladow/rozklads";
    }
}
