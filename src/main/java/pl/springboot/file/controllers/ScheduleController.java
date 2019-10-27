package pl.springboot.file.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.springboot.file.model.Schedule;
import pl.springboot.file.services.ScheduleService;

import java.util.List;

@Controller
public class ScheduleController {

    private ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("schedule", new Schedule());
        List<Schedule> schedules = scheduleService.findAll();
        model.addAttribute("schedules", schedules);

        return "view/schedule/schedules";
    }

    @PostMapping(value = "/fileupload")
    public String uploadFile(@ModelAttribute Schedule schedule, RedirectAttributes redirectAttributes){
boolean isFlag = scheduleService.readDataFromCsv(schedule.getFile(),schedule.getDate(),schedule.getRodzajRozkladu());
if (isFlag){
    redirectAttributes.addFlashAttribute("succesmessage","File Upload Successfully");
}else {
    redirectAttributes.addFlashAttribute("errormessage","File Upload not done, Please try again");
}


        return "redirect:/";
    }
}
