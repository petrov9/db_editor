package com.cheersport.client;

import com.cheersport.model.Competition;
import com.cheersport.service.CompetitionService;
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
@RequestMapping(value = "/competitions")
public class CompetitionController {

    private CompetitionService competitionService;

    @Autowired
    @Qualifier(value = "competitionService")
    public void setCompetitionService(CompetitionService ps) {
        this.competitionService = ps;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showAll(Model model) {
        model.addAttribute("competition", new Competition());
        model.addAttribute("listCompetition", competitionService.listCompetition());
        return "/competitions";
    }

    @RequestMapping(value ="/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") int editId) {
        model.addAttribute("competition", competitionService.getCompetition(editId));
        model.addAttribute("listCompetition", competitionService.listCompetition());
        return "/competitions";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@ModelAttribute("competition") Competition c) {
        competitionService.addCompetition(c);
        return "redirect:/competitions";
    }

    @RequestMapping(value ="/delete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable("id") int id) {
        competitionService.deleteCompetition(id);

        model.addAttribute("competition", new Competition());
        model.addAttribute("listCompetition", competitionService.listCompetition());
        return "/competitions";
    }


}