/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static antlr.Utils.error;
import controllers.parent.WebController;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

/**
 *
 * @author Юрий
 */
@Controller
@RequestMapping("/Registration")
public class RegistrationController extends WebController {

    @Autowired
    private UserService userService;

    @Autowired
    private LkController lk;

    @RequestMapping(value = {"/registration"})
    public String showRegistrationPage(Map<String, Object> model, String submit, String checkbox,
            String company, String email, String phone, String password, String confirmPassword, String name, String surname, String patronymic,
            String emailCompany) {

        if (submit != null) {
            if (checkbox != null) {
                if (password.equals(confirmPassword)) {
                    userService.save(company, email, phone, password, name, surname, patronymic, emailCompany);
                    if (userService.getError().isEmpty()) {
                        return "redirect:/Registration/successRegistration";
                    } else {
                        model.put("errors", userService.getError());
                    }
                } else {
                    userService.addError("Пароли не совпадают");
                    model.put("errors", userService.getError());

                }
            } else {
                model.put("errors", "Ознакомтесь и согласитесь с условиями");
            }
        } else {
            model.put("errors", userService.getError());
        }

        return "registration";
    }

    @RequestMapping(value = {"/successRegistration"})
    public String showSRPage(Map<String, Object> model, HttpServletRequest request) throws Exception {

        return "successRegistration";
    }
}
