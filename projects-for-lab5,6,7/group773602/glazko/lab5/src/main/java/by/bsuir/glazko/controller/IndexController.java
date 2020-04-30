package by.bsuir.glazko.controller;

import by.bsuir.glazko.service.UserService;
import by.bsuir.glazko.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class IndexController {

    private final UserService userService;

    @Autowired
    public IndexController(@Qualifier("userServiceImpl") UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping(value = "/add-clients", method = RequestMethod.POST)
    public String addClients(@RequestParam("clients") MultipartFile clients) {
        try {
            userService.addClientsFromXml(clients);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/update-clients", method = RequestMethod.POST)
    public String updateClients(@RequestParam("clients") MultipartFile clients) {
        try {
            userService.addClientsFromXml(clients);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/delete-clients", method = RequestMethod.POST)
    public String deleteClients(@RequestParam("clients") MultipartFile clients) {
        try {
            userService.deleteClientsFromXml(clients);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/read-clients-to-xml", method = RequestMethod.GET)
    public String readClientsToXml() {
        try {
            userService.readClientsToXml();
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/read-clients-to-json", method = RequestMethod.GET)
    public String readClientsToJson() {
        try {
            userService.readClientsToJson();
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/add-clients-from-json", method = RequestMethod.POST)
    public String addClientsFromJson(@RequestParam("clients") MultipartFile clients) {
        try {
            userService.addClientsFromJson(clients);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }
}