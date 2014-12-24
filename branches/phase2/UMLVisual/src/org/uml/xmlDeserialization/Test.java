package org.uml.xmlDeserialization;

import java.io.File;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.uml.model.ClassDiagram;

/**
 *
 * @author Stefan
 */
public class Test {
    public static void main(String[] args) {
//        ClassDiagram cd = new ClassDiagram();
//        cd.setName("Moj dijagram");
//        ClassComponent cc = new ClassComponent();
//        cc.setName("Moja klasa");
//        cc.setIsAbstract(false);
//        cc.setParentDiagram(cd);
//        cc.setVisibility(Visibility.PUBLIC);
//        Field f = new Field("polje1", "String", Visibility.PRIVATE);
//        f.setIsStatic(true);
//        cc.addField(f);
//        cd.addComponent(cc);
//        ClassDiagramXmlSerializer serializer = ClassDiagramXmlSerializer.getInstance();
//        serializer.setClassDiagram(cd);
//        Document document = DocumentHelper.createDocument();
//        Element root = document.addElement("ClassDiagram");
//        serializer.serialize(root);
        
        
//        
//        try {
//            
//            OutputFormat format = OutputFormat.createPrettyPrint();
//            XMLWriter writer = new XMLWriter(
//                new FileWriter( "out.xml"), format 
//            );
//            writer.write( document );
//            
//            writer.close(); 
//            System.out.println("Ispisano u fajl");
            /////////////////////////////////
            try {
                ClassDiagram cd = new ClassDiagram();
                SAXReader reader = new SAXReader();
             Document document = reader.read(new File("out.xml"));
            System.out.println("Fajl ucitan");
            
            Element root = document.getRootElement();
            ClassDiagramDeserializer cdd = new ClassDiagramDeserializer(cd);
            cdd.deserialize(root);
            
            System.out.println("Deserialized");
            }catch (Exception ex) {
                ex.printStackTrace();
            }
            
//            
//            ClassDiagramXmlSerializer serializer2 = ClassDiagramXmlSerializer.getInstance();
//            serializer2.setClassDiagram(cd);
//            Document document2 = DocumentHelper.createDocument();
//            Element root2 = document2.addElement("ClassDiagram");
//            serializer2.serialize(root2);
//            
//            OutputFormat format = OutputFormat.createPrettyPrint();
//            XMLWriter writer = new XMLWriter(
//                new FileWriter( "out2.xml"), format 
//            );
//            writer.write( document2 );
//            
//            writer.close(); 
//            System.out.println("Ispisano u fajl");
//        }catch (Exception e) {
//                e.printStackTrace();
//        }
    }
}