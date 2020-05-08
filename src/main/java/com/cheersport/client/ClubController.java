package com.cheersport.client;

import com.cheersport.model.Club;
import com.cheersport.service.ClubService;
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
@RequestMapping(value = "/clubs")
public class ClubController {

    private ClubService clubService;

    @Autowired
    @Qualifier(value = "clubService")
    public void setClubService(ClubService ps) {
        this.clubService = ps;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showAll(Model model) {
        model.addAttribute("club", new Club());
        model.addAttribute("listClubs", clubService.listClub());
        return "/clubs";
    }

    @RequestMapping(value ="/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") int editId) {
        model.addAttribute("club", clubService.getClub(editId));
        model.addAttribute("listClubs", clubService.listClub());
        return "/clubs";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@ModelAttribute("club") Club c) {
        clubService.addClub(c);
        return "redirect:/clubs";
    }

    @RequestMapping(value ="/delete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable("id") int id) {
        clubService.deleteClub(id);

        model.addAttribute("club", new Club());
        model.addAttribute("listClubs", clubService.listClub());
        return "/clubs";
    }


}

