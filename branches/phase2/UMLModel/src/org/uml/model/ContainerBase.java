package org.uml.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author netlink
 * @param <T>
 */
public abstract class ContainerBase<T extends INameable> implements INameable {
    
    protected String name;
    protected HashMap<String, T> containerComponents; // contains classes, interfaces or enums
    protected transient List<IComponentDeleteListener> deleteListeners = new ArrayList<>();

    public ContainerBase(String name) {
        this.name = name;
        this.containerComponents = new HashMap<>();
    }

    public void addDeleteListener(IComponentDeleteListener icdl) {
        deleteListeners.add(icdl);
    }

    /**
     * Adds new ClassDiagramComponent into collection of existing components. If
     * component with that name already exists in this collection, new one will
     * be added with it's name concatenated with current component counter
     * number.
     *
     * @param component to be added to collection
     */
    public void addComponent(T component) {
        String componentName = component.getName();
        int suffix = 1;
        while (signatureExists(component.toString())) {
            component.setName(componentName + suffix);
            suffix++;
        }
        containerComponents.put(component.toString(), component);
    }

    /**
     * Removes the given component from this diagram's collection of components.
     *
     * @param name of the component to be removed
     */
    public void removeComponent(String name) {
        for (IComponentDeleteListener icdl : deleteListeners) {
            icdl.componentDeleted(containerComponents.get(name));
        }
        containerComponents.remove(name);
    }

    /**
     * Checks if component with provided name exists in collection of
     * components.
     *
     * @param componentString of the component
     * @return if that component exists in collection
     */
    public boolean signatureExists(String componentString) {
        return containerComponents.containsKey(componentString);
    }

    /**
     * Returns name of this Container
     *
     * @return name of the Container
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this Container
     *
     * @param name of Container
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

}
