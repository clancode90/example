/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.parent.Dao;
import entities.CabinetUser;
import entities.PersonalCabinet;
import entities.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Юрий
 */
@Repository
public class CabinetUserDao extends Dao<CabinetUser> {

    @Override
    public Class getSupportedClass() {
        return CabinetUser.class;
    }

    public List<CabinetUser> getByUser(User user) {
        Criteria crit = getCurrentSession().createCriteria(CabinetUser.class);
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        crit.add(Restrictions.eq("user", user));
        return crit.list();
    }

    public List<CabinetUser> getByUserHql(User user) {
        String hql = "from CabinetUser as cu where cu.user= :user";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("user", user);
        return query.list();

    }

    public List<CabinetUser> getByUserAndCabinet(User user, PersonalCabinet cabinet) {
        String hql = "from CabinetUser as cu where cu.user= :user and cu.cabinet= :cabinet ";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("user", user);
        query.setParameter("cabinet", cabinet);
        return query.list();
    }


}
