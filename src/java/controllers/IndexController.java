/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.LkController.CABINET_ID_SESSION_NAME;
import controllers.parent.WebController;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Новый профиль
 */
@Controller
public class IndexController extends WebController {
    
     @Autowired
    private LkController lk;

    @RequestMapping(value = {"/", "/index"})
    public String showIndexPage(Map<String, Object> model,HttpServletRequest request) throws Exception {
        lk.dataByUserAndCompany(request, model);
        return "index";
    }
    
    

}
