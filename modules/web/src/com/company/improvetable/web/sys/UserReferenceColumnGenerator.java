package com.company.improvetable.web.sys;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.icons.CubaIcon;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.xml.registry.infomodel.User;
import java.util.function.Function;

public class UserReferenceColumnGenerator<T extends Entity> implements Table.ColumnGenerator<T> {
    private ComponentsFactory componentsFactory;
    private Function<T, User> userPropertyGetter;

    public UserReferenceColumnGenerator(ComponentsFactory componentsFactory,
                                        Function<T, User> userPropertyGetter) {
        this.componentsFactory = componentsFactory;
        this.userPropertyGetter = userPropertyGetter;
    }

    @Override
    public Component generateCell(T entity) {
        Label label = componentsFactory.createComponent(Label.class);
        label.setValue(userPropertyGetter.apply(entity));
        label.setIconFromSet(CubaIcon.USER);
        return label;
    }
}