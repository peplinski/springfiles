package pl.springboot.file.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.springboot.file.model.RodzajRozkladu;
import pl.springboot.file.services.RozkladService;

import java.util.List;

@Controller
@RequestMapping("/rodzajRozkladow")
public class RozkladController {

    private RozkladService rozkladService;

    @Autowired
    public RozkladController(RozkladService rozkladService) {
        this.rozkladService = rozkladService;
    }

    @GetMapping(value = "/rozklads")
    public String home(Model model) {
        model.addAttribute("rozklad", new RodzajRozkladu());
        List<RodzajRozkladu> rozklady = rozkladService.findAll();
        model.addAttribute("rozklady", rozklady);

        return "view/rodzajRozkladow/rozklads";
    }
}
