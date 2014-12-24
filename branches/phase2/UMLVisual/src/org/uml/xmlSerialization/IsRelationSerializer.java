package org.uml.xmlSerialization;

import org.dom4j.Element;
import org.uml.model.components.ComponentBase;
import org.uml.model.relations.IsRelation;
import org.uml.model.relations.RelationBase;

/**
 *
 * @author Stefan
 */
public class IsRelationSerializer implements RelationSerializer{
 
    private IsRelation isRelationComponent;
    
    /**
     * Sets the isRelationComponent object that is going to be serialized.
     * @param component represents isRelationComponent object to be serialized.
     */
    @Override
    public void addRelationComponent(RelationBase relation) {
        try{
            isRelationComponent = (IsRelation) relation;
        }catch (ClassCastException e) {
            System.out.println("You have tried to cast invalid type to IsRelationComponent!");
            e.printStackTrace();
        }
    }
    
    /**
     * Serializes isRelationComponent object to XML by translating its fields into parameter node's attributes and subelements.
     * @param node represents the node that will contain serialized isRelationComponent object.
     */
    @Override
    public void serialize(Element node) {
        if (isRelationComponent.getName() != null) node.addAttribute("name", isRelationComponent.getName());
        ComponentBase sourceComponent = isRelationComponent.getSource();
        ComponentBase targetComponent = isRelationComponent.getTarget();
        if (sourceComponent != null) { 
            node.addAttribute("source", sourceComponent.getName());
        }else {
            node.addAttribute("source", "");
        }
        if (targetComponent != null) {
            node.addAttribute("target", targetComponent.getName());
        }else {
            node.addAttribute("target", "");
        }
    }
    
}