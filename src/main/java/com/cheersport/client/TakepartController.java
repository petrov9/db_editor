package com.cheersport.client;

import com.cheersport.model.Takepart;
import com.cheersport.service.ClubService;
import com.cheersport.service.CompetitionService;
import com.cheersport.service.TakepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@ImportResource("/WEB-INF/dispatcher-servlet.xml")
@Controller
@RequestMapping(value = "/takeparts")
public class TakepartController {

    @Autowired
    private TakepartService takepartService;

    @Autowired
    private ClubService clubService;

    @Autowired
    private CompetitionService competitionService;

    @RequestMapping(method = RequestMethod.GET)
    public String showAll(Model model) {
        model.addAttribute("takepart", new Takepart());
        fillModel(model);
        return "/takeparts";
    }

    @RequestMapping(value ="/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") int editId) {
        model.addAttribute("takepart",takepartService.getTakepart(editId));
        fillModel(model);
        return "/takeparts";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@ModelAttribute("takepart") Takepart t) {
        takepartService.addTakepart(t);
        return "redirect:/takeparts";
    }

    @RequestMapping(value ="/delete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable("id") int id) {
        takepartService.deleteTakepart(id);

        model.addAttribute("takepart", new Takepart());
        fillModel(model);
        return "/takeparts";
    }

    private void fillModel(Model model) {
        model.addAttribute("listTakeparts", takepartService.listTakepart());
        model.addAttribute("clubs", clubService.listClub());
        model.addAttribute("competitions", competitionService.listCompetition());
    }


}