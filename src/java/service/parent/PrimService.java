/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.parent;

//import entity.UploadedFile;
import entities.parent.PrimEntity;
//import files.FileManager;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
//import persistence.FileDao;
import dao.parent.Dao;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import support.AuthManager;
import support.ServiceResult;

/**
 *
 * @author Rice Pavel
 */
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PrimService {
        
    protected Logger log = Logger.getLogger(this.getClass());
    ServiceResult serviceResult=new ServiceResult();
    
    @Autowired
    protected AuthManager authManager;
    
 

    protected <T extends PrimEntity> void _delete(Long id, Dao<T> dao) {
        T obj = dao.find(id);
        dao.deleteObj(obj);
    }
    
    protected <T extends PrimEntity> void _save(T ent, Dao<T> dao) {
        dao.save(ent);
    }
    
    protected <T extends PrimEntity> List<T> _getAll(Dao<T> dao) {
        return dao.getAll();
    }
    
     protected <T extends PrimEntity> void _update(T ent, Dao<T> dao) {
        dao.update(ent);
    }
     
     protected <T extends PrimEntity> void _delete(T ent, Dao<T> dao) {
        dao.delete(ent);
    }
     
     protected <T extends PrimEntity> T _find(Long id, Dao<T> dao) {
        return dao.find(id);
    }
    
    protected <T extends PrimEntity> void updateAndValidate(T ent, Dao<T> dao, ServiceResult res) {
        ServiceResult res1 = updateAndValidate(ent, dao);
        res.addErrors(res1.getErrors());
    }
    
    protected <T extends PrimEntity> void saveAndValidate(T ent, Dao<T> dao, ServiceResult res) {
        ServiceResult res1 = saveAndValidate(ent, dao);
        res.addErrors(res1.getErrors());
    }
    
     protected <T extends PrimEntity> ServiceResult saveAndValidate(T ent, Dao<T> dao) {
        PrimService.this.validate( ent);
        if (!serviceResult.hasErrors()) {
            dao.save(ent);
        }
        return serviceResult;
    }
     
    protected <T extends PrimEntity> ServiceResult updateAndValidate(T ent, Dao<T> dao) {
        PrimService.this.validate(ent);
        if (!serviceResult.hasErrors()) {
            dao.update(ent);
        }
        return serviceResult;
    }
    
    protected  <T extends PrimEntity> boolean validate(T ent) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(ent);
        for (ConstraintViolation<T> viol : constraintViolations) {
            serviceResult.addError(viol.getMessage());
        }
        return constraintViolations.isEmpty();
    }
    
    
    
    public void addError(String error){
        serviceResult.addError(error);
    }

    public List<String> getError(){
        return serviceResult.getErrors();
    }

}
