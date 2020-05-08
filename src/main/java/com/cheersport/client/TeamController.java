package com.cheersport.client;

import com.cheersport.model.Team;
import com.cheersport.service.ClubService;
import com.cheersport.service.CoachService;
import com.cheersport.service.TeamService;
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
@RequestMapping(value = "/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private ClubService clubService;

    @Autowired
    private CoachService coachService;

    @RequestMapping(method = RequestMethod.GET)
    public String showAll(Model model) {
        model.addAttribute("team", new Team());
        fillModel(model);
        return "/teams";
    }

    @RequestMapping(value ="/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") int editId) {
        model.addAttribute("team",teamService.getTeam(editId));
        fillModel(model);
        return "/teams";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@ModelAttribute("team") Team t) {
        teamService.addTeam(t);
        return "redirect:/teams";
    }

    @RequestMapping(value ="/delete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable("id") int id) {
        teamService.deleteTeam(id);

        model.addAttribute("team", new Team());
        fillModel(model);
        return "/teams";
    }

    private void fillModel(Model model) {
        model.addAttribute("listTeams", teamService.listTeam());
        model.addAttribute("clubs", clubService.listClub());
        model.addAttribute("coaches", coachService.listCoach());
    }


}