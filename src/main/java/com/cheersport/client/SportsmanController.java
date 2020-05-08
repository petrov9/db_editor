package com.cheersport.client;

import com.cheersport.model.Agect;
import com.cheersport.model.Sportsman;
import com.cheersport.service.SportsmanService;
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
@RequestMapping("/sportsmans")
public class SportsmanController {

    @Autowired
    private SportsmanService sportsmanService;

    @Autowired
    private TeamService teamService;

    @RequestMapping(method = RequestMethod.GET)
    public String showAll(Model model) {
        model.addAttribute("sportsman", new Sportsman());
        fillModel(model);
        return "/sportsmans";
    }

    @RequestMapping(value ="/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") int editId) {
        model.addAttribute("sportsman", sportsmanService.getSportsman(editId));
        fillModel(model);
        return "/sportsmans";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@ModelAttribute("sportsman") Sportsman s) {
        sportsmanService.addSportsman(s);
        return "redirect:/sportsmans";
    }

    @RequestMapping(value ="/delete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable("id") int id) {
        sportsmanService.deleteSportsman(id);

        model.addAttribute("sportsman", new Sportsman());
        fillModel(model);
        return "/sportsmans";
    }

    private void fillModel(Model model) {
        model.addAttribute("listSportsmans", sportsmanService.listSportsman());
        model.addAttribute("teams", teamService.listTeam());
        model.addAttribute("agects", Agect.values());
        model.addAttribute("query1", sportsmanService.getSportsmanOrderByPlace());
        model.addAttribute("query2", sportsmanService.getSportsmanWhereAgectIsAdult());
        model.addAttribute("query3", sportsmanService.getSportsmanSomeColumns());
        model.addAttribute("query4", sportsmanService.getTakePartQuery());
        model.addAttribute("query5", sportsmanService.getCompetitionQuery());
        model.addAttribute("query6", sportsmanService.getSportsmanQuery());
    }

}

