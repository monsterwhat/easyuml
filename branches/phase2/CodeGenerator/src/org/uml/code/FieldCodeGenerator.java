/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uml.code;



import java.util.HashMap;
import java.util.Map;
import org.uml.model.ClassDiagramComponent;
import org.uml.model.Field;

/**
 *
 * @author zoran
 */
public class FieldCodeGenerator implements CodeGenerator{

    HashMap<String, Field> fields= new  HashMap<String, Field>();

    public FieldCodeGenerator(HashMap<String, Field> fields) {
        this.fields = fields;
    }
    
    
    @Override
    public String generateCode() {
        String fieldsString="";
        
        for (Map.Entry<String, Field> en : fields.entrySet() ) {

            Field field = en.getValue();
            String isStatic="";
            String isFinal="";
            String isAbstract="";
            if(field.isIsStatic()) {
                isStatic=" static ";
            }
            if(field.isIsAbstract()) {
                isAbstract=" abstract ";
            }
            if(field.isIsFinal()) {
                isFinal=" final ";
            }
            fieldsString += field.getVisibility().toString()+" " + isStatic + isAbstract + isFinal + field.getType().toString() + " "+ field.getName()+"; \n"; 
        }
        
        return fieldsString;
        
}   

    @Override
    public void setClassDiagramComponent(ClassDiagramComponent component) {
        
    }
            
        
    }
    
