/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.parent.PrimEntity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Юрий
 */
@Entity
@Table(name = "personal_cabinet")
public class PersonalCabinet extends PrimEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personal_cabinet_id")
    private Long personalCabinetId;

    @Email
    @Column(name = "email")
    @NotNull(message = "поле Email не может быть пустым")
    @NotBlank(message = "поле Email не может быть пустым")
    private String email;

    @Column(name = "company")
    @NotNull(message = "поле название компании не может быть пустым")
    private String company;

    @Column(name = "phone")
    @NotNull(message = "Поле телефон не может быть пустым")
    @NotBlank(message = "Поле телефон не может быть пустым")
    private String phone;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "cabinet", cascade = CascadeType.ALL)
    private List<CabinetUser> cabinetUser;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "cabinet", cascade = CascadeType.ALL)
    private List<Strategy> strategyList;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "cabinet", cascade = CascadeType.ALL)
    private List<Group> groupList;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "cabinet", cascade = CascadeType.ALL)
    private List<Module> moduleList;

    public List<CabinetUser> getCabinetUser() {
        return cabinetUser;
    }

    public void setCabinetUser(List<CabinetUser> cabinetUser) {
        this.cabinetUser = cabinetUser;
    }

    public List<Strategy> getStrategyList() {
        return strategyList;
    }

    public void setStrategyList(List<Strategy> strategyList) {
        this.strategyList = strategyList;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public List<Module> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    public Long getPersonalCabinetId() {
        return personalCabinetId;
    }

    public void setPersonalCabinetId(Long personalCabinetId) {
        this.personalCabinetId = personalCabinetId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public Long getId() {
        return personalCabinetId;
    }

}
