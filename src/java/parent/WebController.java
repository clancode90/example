/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.parent;


import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import support.AuthManager;
import support.ServiceResult;

/**
 *
 * @author Rice Pavel
 */
@Controller
public class WebController {

    protected Logger log = Logger.getLogger(this.getClass());

    

   

  

    @Autowired
    protected AuthManager authManager;
    
    protected final String ERRORS_LIST_NAME = "errors";

   

    @ModelAttribute
    public void setOrderInfo(Map<String, Object> model) {
        
    }

    @ModelAttribute
    public void setDateFormatter(Map<String, Object> model) {
        model.put("dateFormatter", new DateFormatter());
    }

   
/*
    protected void _deleteFile(Long fileId) {
        fileService.delete(fileId);
    }

    protected void _getFile(HttpServletResponse response, Long fileId) throws IOException {
        File file = fileService.getFile(fileId);
        String fileName = fileService.getTransliterateFileName(fileId);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        IOUtils.copy(new FileInputStream(file), response.getOutputStream());
    }

    protected void _getFile(HttpServletResponse response, String fileName, byte[] bytes) throws IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        response.getOutputStream().write(bytes);
    }
*/
  

   
  


 

    protected void addErrors(Map<String, Object> model, ServiceResult res) {
        model.put(ERRORS_LIST_NAME, res.getErrors());
    }

    protected void addErrors(RedirectAttributes ra, ServiceResult res) {
        ra.addFlashAttribute(ERRORS_LIST_NAME, res.getErrors());
    }


}
