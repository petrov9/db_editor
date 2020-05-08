package com.cheersport.client;

import com.cheersport.model.Coach;
import com.cheersport.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@ImportResource("/WEB-INF/dispatcher-servlet.xml")
@Controller
@RequestMapping(value = "/coaches")
public class CoachController {

    private CoachService coachService;

    @Autowired
    @Qualifier(value = "coachService")
    public void setCoachService(CoachService ps) {
        this.coachService = ps;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showAll(Model model) {
        model.addAttribute("coach", new Coach());
        model.addAttribute("listCoaches", coachService.listCoach());
        return "/coaches";
    }

    @RequestMapping(value ="/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") int editId) {
        model.addAttribute("coach", coachService.getCoach(editId));
        model.addAttribute("listCoaches", coachService.listCoach());
        return "/coaches";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@ModelAttribute("coach") Coach c) {
        coachService.addCoach(c);
        return "redirect:/coaches";
    }

    @RequestMapping(value ="/delete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable("id") int id) {
        coachService.deleteCoach(id);

        model.addAttribute("coach", new Coach());
        model.addAttribute("listCoaches", coachService.listCoach());
        return "/coaches";
    }


}

