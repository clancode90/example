/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.GroupsDao;
import dao.ModulesDao;
import dao.PersonalCabinetDao;
import dao.StrategyDao;
import entities.Group;
import entities.Module;
import entities.PersonalCabinet;
import entities.Strategy;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import service.parent.PrimService;

/**
 *
 * @author Юрий
 */
@Service
@Transactional
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class StrategyService extends PrimService {

    @Autowired
    private StrategyDao strategyDao;

    @Autowired
    private PersonalCabinetDao personalCabinetDao;

    @Autowired
    private GroupsDao groupDao;

    @Autowired
    private ModulesDao moduleDao;

    public void saveStrategy(String strategyName, Long cabinetId) {
        PersonalCabinet pk = personalCabinetDao.find(cabinetId);
        List<Strategy> strategyList = strategyList(cabinetId);

        boolean existName = false;
        for (Strategy stretagy : strategyList) {
            existName = stretagy.getStrategyName().equals(strategyName);
            if (existName == true) {
                break;
            }
        }

        if (strategyName != null & existName == false) {
            Strategy strategy = new Strategy();
            strategy.setStrategyName(strategyName);
            strategy.setCabinet(pk);
            if (validate(strategy)) {
                strategyDao.save(strategy);
            }
        } else {
            addError("такая стратегия существует");
        }
    }

    public List<Strategy> strategyList(Long cabinetId) {
        PersonalCabinet pk = personalCabinetDao.find(cabinetId);
        if (pk != null) {
            return pk.getStrategyList();
        } else {
            addError("Кабинет не найден по ид " + cabinetId);
        }
        return new ArrayList();
    }

    public List<Group> groupList(Long strategyId) {
        Strategy stg = strategyDao.find(strategyId);
        if (stg != null) {
            return stg.getGroupList();
        } else {
            addError("Стратегия не найден по ид " + strategyId);
        }
        return new ArrayList();
    }

    public List<Module> moduleList(Long groupId) {
        Group gr = groupDao.find(groupId);
        if (gr != null) {
            return gr.getModuleList();
        } else {
            addError("Группа не найден по ид " + groupId);
        }
        return new ArrayList();
    }

    public void saveGroup(Long strategyId,
            String groupName,
            Long cabinetId) {
        PersonalCabinet pk = personalCabinetDao.find(cabinetId);
        Strategy stg = strategyDao.find(strategyId);
        List<Group> groupList = groupList(strategyId);
        List<String> nameList = new ArrayList<>();

        for (Group group : groupList) {
            nameList.add(group.getGroupName());
        }

        if (!nameList.contains(groupName) & groupName != null) {
            Group gr = new Group();
            gr.setCabinet(pk);
            gr.setStrategy(stg);
            gr.setGroupName(groupName);
            if (validate(gr)) {
                groupDao.save(gr);
            }
        } else {
            addError("Такая группа уже есть");
        }

    }

    public Strategy findStrategy(Long strategyId) {
        return strategyDao.find(strategyId);

    }

    public Group findGroup(Long groupId) {
        return groupDao.find(groupId);
    }

    public void saveModule(Long groupId,
            String moduleName,
            Long cabinetId) {
        PersonalCabinet pk = personalCabinetDao.find(cabinetId);
        Group gp = groupDao.find(groupId);

        List<Module> moduleList = moduleList(groupId);
        List<String> nameList = new ArrayList<>();

        for (Module modul : moduleList) {
            nameList.add(modul.getModuleName());
        }

        if (!nameList.contains(moduleName) & moduleName != null) {
            Module ml = new Module();
            ml.setCabinet(pk);
            ml.setGroups(gp);
            ml.setModuleName(moduleName);
            if (validate(ml)) {
                moduleDao.save(ml);
            }
        } else {
            addError("Такой модуль уже есть");
        }

    }

}
