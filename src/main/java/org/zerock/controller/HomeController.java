package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.service.LoginTService;

import javax.inject.Inject;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     * Simply selects the home view to render by returning its name.
     */

    @Inject
    private LoginTService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "home";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void ajaxTest() {


    }

    @RequestMapping(value = "/doA", method = RequestMethod.GET)
    public String doA(Locale locale, Model model) {

        System.out.println("doA.....................");

        return "home";
    }

    @RequestMapping(value = "/doB", method = RequestMethod.GET)
    public String doB(Locale locale, Model model) {

        System.out.println("doB.....................");

        model.addAttribute("result", "DOB RESULT");

        return "home";
    }



    @RequestMapping(value = "/loginT")
    public String logintT() {
        return "shop-ui-login";
    }

    @RequestMapping(value = "/shop-ui-register")
    public void register() {
//		return "shop-ui-register";
    }


}
