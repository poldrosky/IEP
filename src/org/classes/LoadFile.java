package org.classes;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom2.Document; 
import org.jdom2.Element; 
import org.jdom2.JDOMException; 
import org.jdom2.input.SAXBuilder; 


public class LoadFile {

	public void load(File xmlFile) {
		System.out.println(xmlFile.getAbsolutePath());
		 //create SAXBuilder for to can parser a file
		SAXBuilder builder = new SAXBuilder();
		
		 try {
			Document document = (Document) builder.build( xmlFile );			
			//get root 
			Element rootNode = document.getRootElement();			
			System.out.println(document.getDocument().getRootElement());
			
			//get list children of root
			List list = rootNode.getChildren("Grupos");
			 //Se recorre la lista de hijos de 'tables'
			for ( int i = 0; i < list.size(); i++ ){
				//Se obtiene el elemento 'tabla'
				Element grupos = (Element) list.get(i);
				 //Se obtiene el atributo 'nombre' que esta en el tag 'tabla'
				System.out.println(grupos.toString());
				List tblGrupoInvestigacion=grupos.getChildren("investic.dbo.tblGrupoInvestigacion");
				
				for(int j=0;j<tblGrupoInvestigacion.size();j++){					
					Element tblGrupoInvestigacionTabla = (Element) tblGrupoInvestigacion.get(j);
					System.out.println(tblGrupoInvestigacionTabla);
					List fields=tblGrupoInvestigacionTabla.getChildren(); 
					for(int z=0;z<fields.size();z++){
						Element field = (Element) fields.get(z);
						System.out.println(field);
						System.out.println(field.getName());
						System.out.println(field.getText());			
					}					
				}				
			}
			//obtener tag RegistroInv
			
			
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
 public static void main(String arg[]){
	 File file=new File("/home/omar/Documents/Trabajo/Investic/ejemploArchivo.xml");
	 LoadFile loadFile=new LoadFile();
	 loadFile.load(file);
 }
	
}
