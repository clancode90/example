/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.parent.Dao;
import entities.CabinetUser;
import entities.PersonalCabinet;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Юрий
 */
@Repository
public class PersonalCabinetDao extends Dao<PersonalCabinet> {

    @Override
    public Class getSupportedClass() {
        return PersonalCabinet.class;
    }

    public PersonalCabinet getCabinetByLogin(String emailCompany) {
        String queryString = "from PersonalCabinet U where U.email = :email";
        Query query = getCurrentSession().createQuery(queryString);
        query.setParameter("email", emailCompany);

        return (PersonalCabinet) query.uniqueResult();
    }

}
