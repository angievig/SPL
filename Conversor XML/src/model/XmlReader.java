package model;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class XmlReader {

	private static ArrayList<XmlDependecy> importantXmlDependecy;
	private static ArrayList<XmlElement> importantXmlElement;
	
	
	public static ArrayList<String> converterXmlDependecyToHLVLCode () {
		 ArrayList<String> result = new ArrayList<String>();
		 String aux="";
		 for (int i = 0; i <importantXmlDependecy.size(); i++) {
			 aux="";
			if (importantXmlDependecy.get(i).getRelType().equals("mandatory")) {
				aux= "decomposition("+searchForName(importantXmlDependecy.get(i).getTarget())+","+"["+searchForName(importantXmlDependecy.get(i).getSource())+"])<1>";
				 result.add(aux);
			}else if (importantXmlDependecy.get(i).getRelType().equals("optional")) {
				aux= "decomposition("+searchForName(importantXmlDependecy.get(i).getTarget())+","+"["+searchForName(importantXmlDependecy.get(i).getSource())+"])<0>";
				 result.add(aux);
			}else if (importantXmlDependecy.get(i).getRelType().equals("requires")) {
				 aux= "implies("+searchForName(importantXmlDependecy.get(i).getSource())+","+searchForName(importantXmlDependecy.get(i).getTarget())+")";
				 result.add(aux);
			}else if (importantXmlDependecy.get(i).getRelType().equals("excludes")){
				 aux= "mutex("+searchForName(importantXmlDependecy.get(i).getSource())+","+searchForName(importantXmlDependecy.get(i).getTarget())+")";
				 result.add(aux);
			} else if (importantXmlDependecy.get(i).getRelType().equals("bundle")) {
				
			}
			
			
		 }
		 
		 return result;
	}
	
	public static String sheacjForBundle(String id) {
		String result ="";
		
		return result;
	}
	public static String searchForName (String id) {
		String result ="";
		
		for (int i = 0; i < importantXmlElement.size(); i++) {
			if (importantXmlElement.get(i).getId().equals(id)) {
			result= importantXmlElement.get(i).getName();	
			}
		}
		return result;
		
	}
	
	
	public static ArrayList<String> converterXmlElementToHLVLCode () {
		 ArrayList<String> result = new ArrayList<String>();
		 String aux="";
		for (int i =0 ; i < importantXmlElement.size(); i++) {
			aux="";
		
			if (importantXmlElement.get(i).getType().equals("root")) {
				 aux = "coreElements("+importantXmlElement.get(i).getName()+")";
				 result.add(aux);
			}else if (importantXmlElement.get(i).getType().equals("general")||importantXmlElement.get(i).getType().equals("leaf")) {
				 aux = "boolean "+ importantXmlElement.get(i).getName();
				 result.add(aux);
			}
			
		}
		return result;
		
	}
	
	//this method try to read and clear de tree.
	public static void readDocument(Node n) {
		if (n!=null) {
			if (n.getNodeName().equals("general")||n.getNodeName().equals("root")) {
				if (n.getAttributes()!=null&&n.getAttributes().item(1)!=null&&n.getAttributes().item(0)!=null&&n.getAttributes().item(2)!=null) {	
					XmlElement elementXml= new XmlElement(n.getAttributes().item(1).getNodeValue(),n.getAttributes().item(0).getNodeValue(),n.getAttributes().item(2).getNodeValue());
					importantXmlElement.add(elementXml);
				}
			}
			else if(n.getNodeName().equals("leaf")) {
				if (n.getAttributes()!=null&&n.getAttributes().item(1)!=null&&n.getAttributes().item(0)!=null&&n.getAttributes().item(2)!=null) {	
					
					XmlElement elementXml= new XmlElement(n.getAttributes().item(1).getNodeValue(),n.getAttributes().item(0).getNodeValue(),n.getAttributes().item(3).getNodeValue(),n.getAttributes().item(2).getNodeValue());
					importantXmlElement.add(elementXml);
				}
			}
			else if (n.getNodeName().equals("bundle")) {
				if (n.getAttributes()!=null&&n.getAttributes().item(1)!=null&&n.getAttributes().item(0)!=null&&n.getAttributes().item(2)!=null) {	
					
					XmlElement elementXml= new XmlElement(n.getAttributes().item(5).getNodeValue(),n.getAttributes().item(2).getNodeValue(),n.getAttributes().item(3).getNodeValue(),null,n.getAttributes().item(0).getNodeValue());
					importantXmlElement.add(elementXml);
				}
			}
			else if (n.getNodeName().indexOf("rel_")>(-1)) {
					XmlDependecy newDependecy = new XmlDependecy();
				if (n.getAttributes()!=null&&n.getAttributes().item(0)!=null&&n.getAttributes().item(1)!=null) {
					
					newDependecy.setId(n.getAttributes().item(0).getNodeValue());
					newDependecy.setRelType(n.getAttributes().item(1).getNodeValue());
					if (n.getAttributes().item(2)!=null) {
						newDependecy.setType(n.getAttributes().item(2).getNodeValue());	
					}else {
						newDependecy.setRelType("bundle");
						newDependecy.setType("relation");
					}
				}	
					AddAtributesFromChildren(n, newDependecy);
				
			
				importantXmlDependecy.add(newDependecy);
			}
		
			NodeList childrens = n.getChildNodes();
			for(int i=0; i<childrens.getLength();i++) {
				Node grandchildren = childrens.item(i);
				readDocument(grandchildren);
			}
		}
	}
	
	public static void AddAtributesFromChildren(Node n,XmlDependecy newDependecy) {
		NodeList childrens = n.getChildNodes();
		for(int i=0; i<childrens.getLength();i++) {
			Node newNode = childrens.item(i);
			if(newNode.getNodeName().equals("mxCell")&&newNode.getAttributes()!=null) {
			
			newDependecy.setSource(newNode.getAttributes().item(2).getNodeValue());
			newDependecy.setTarget(newNode.getAttributes().item(3).getNodeValue());
			}
		}
	}
	
	
	public static void main(String[] arg0) {
		try {
			DocumentBuilder builder= DocumentBuilderFactory.newInstance().newDocumentBuilder();
		    File f = new File("Conversor XML/resource/documentoXML3.xml");
		    Document document = builder.parse(f);
		    importantXmlDependecy = new ArrayList<XmlDependecy>();
		    importantXmlElement = new ArrayList<XmlElement>();
		    readDocument(document);   
		    ArrayList<String> elements = converterXmlElementToHLVLCode();
		    ArrayList<String> Dependecies = converterXmlDependecyToHLVLCode();
		    for (String dependecy : Dependecies) {
				System.out.println(dependecy);
			}
		    for (String element : elements) {
				System.out.println(element);
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}
}
