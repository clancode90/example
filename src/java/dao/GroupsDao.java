/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.parent.Dao;
import entities.Group;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Юрий
 */
@Repository
public class GroupsDao extends Dao<Group>{

    @Override
    public Class getSupportedClass() {
       return Group.class;
    }
    
}
