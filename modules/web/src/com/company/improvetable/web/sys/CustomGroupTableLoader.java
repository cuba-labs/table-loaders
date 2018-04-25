package com.company.improvetable.web.sys;

import com.haulmont.chile.core.model.MetaPropertyPath;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.xml.layout.loaders.GroupTableLoader;
import com.haulmont.cuba.security.entity.User;

import java.util.List;
import java.util.function.Function;

public class CustomGroupTableLoader extends GroupTableLoader {
    @Override
    public void loadComponent() {
        super.loadComponent();

        List<Table.Column> columns = resultComponent.getColumns();
        for (Table.Column c : columns) {
            if (c.getId() instanceof MetaPropertyPath) {
                MetaPropertyPath propertyPath = (MetaPropertyPath) c.getId();

                if (propertyPath.getRangeJavaClass() == User.class) {

                    resultComponent.addGeneratedColumn(String.valueOf(c.getId()),
                            new UserReferenceColumnGenerator(factory, (Function<Entity, User>) o -> o.getValueEx(propertyPath.toString()))
                    );
                }
            }
        }
    }
}