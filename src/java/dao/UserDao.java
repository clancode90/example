/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.parent.Dao;
import entities.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Юрий
 */
@Repository
public class UserDao extends Dao<User> {

    @Override
    public Class getSupportedClass() {
        return User.class; 
    }

     public User getUserByLogin(String login) {
        String queryString = "from User U where U.email = :email";
        Query query = getCurrentSession().createQuery(queryString);
        query.setParameter("email", login);
        
        return (User) query.uniqueResult();
    }
     
   public User getUserByHash(String hash){
        String queryString = "from User U where U.recoverHash = :recoverHash";
        Query query = getCurrentSession().createQuery(queryString);
        query.setParameter("recoverHash", hash);       
       
       return (User) query.uniqueResult();
   }
}
