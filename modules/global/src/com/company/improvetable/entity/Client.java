package com.company.improvetable.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.security.entity.User;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|title")
@Table(name = "IMPROVETABLE_CLIENT")
@Entity(name = "improvetable$Client")
public class Client extends StandardEntity {
    private static final long serialVersionUID = -4252309689281766699L;

    @Column(name = "TITLE")
    protected String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGER_ID")
    protected User manager;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public User getManager() {
        return manager;
    }


}