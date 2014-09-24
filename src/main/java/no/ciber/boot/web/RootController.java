package no.ciber.boot.web;

import no.ciber.boot.model.Person;
import no.ciber.boot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class RootController {
    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/")
    public String index(@ModelAttribute Person person, ModelMap model) {
        model.addAttribute("personer", personRepository.findAll());
        return "index";
    }

    @RequestMapping(value = "addPerson", method = POST)
    public String addPerson(Person person) {
        personRepository.save(person);
        return "redirect:/";
    }
}
