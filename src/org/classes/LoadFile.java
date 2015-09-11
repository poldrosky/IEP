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
		List<?> list;
		List<?> tbl;
		Element element;
		List<?> fields;

		System.out.println(xmlFile.getAbsolutePath());
		// create SAXBuilder for to can parser a file
		SAXBuilder builder = new SAXBuilder();

		try {
			Document document = (Document) builder.build(xmlFile);
			// get root
			Element rootNode = document.getRootElement();
			System.out.println(document.getDocument().getRootElement());

			// obtener tag Grupos
			list = rootNode.getChildren("Grupos");

			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				System.out.println(element.toString());
				tbl = element.getChildren("investic.dbo.tblGrupoInvestigacion");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						System.out.println(field);
						System.out.println(field.getName());
						System.out.println(field.getText());
					}
				}
			}

			// obtener tag RegistroInv
			list = rootNode.getChildren("RegistroInv");
			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				System.out.println(element.toString());
				tbl = element.getChildren("investic.dbo.tblMiembroGrupo");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						System.out.println(field);
						System.out.println(field.getName());
						System.out.println(field.getText());
					}
				}
			}

			// obtener tag BitacoraMaestro
			list = rootNode.getChildren("BitacoraMaestro");
			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				System.out.println(element.toString());
				tbl = element
						.getChildren("investic.dbo.tblReflexionProyectoInvestigacion");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						System.out.println(field);
						System.out.println(field.getName());
						System.out.println(field.getText());
					}
				}
			}

			// obtener tag PerturbacionGrupoInv
			list = rootNode.getChildren("PerturbacionGrupoInv");
			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				System.out.println(element.toString());
				tbl = element
						.getChildren("investic.dbo.tblPreguntaInvestigacion");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						System.out.println(field);
						System.out.println(field.getName());
						System.out.println(field.getText());
					}
				}
			}

			// obtener tag SuperposicionGrupo
			list = rootNode.getChildren("SuperposicionGrupo");
			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				System.out.println(element.toString());
				tbl = element
						.getChildren("investic.dbo.tblProblemaInvestigacion");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						System.out.println(field);
						System.out.println(field.getName());
						System.out.println(field.getText());
					}
				}
			}

			// obtener tag BitacoraMaestro
			list = rootNode.getChildren("BitacoraMaestro");
			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				System.out.println(element.toString());
				tbl = element
						.getChildren("investic.dbo.tblProblemaProyectoInvestigacion");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						System.out.println(field);
						System.out.println(field.getName());
						System.out.println(field.getText());
					}
				}
			}

			// obtener tag BitacoraMaestro
			list = rootNode.getChildren("BitacoraMaestro");
			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				System.out.println(element.toString());
				tbl = element
						.getChildren("investic.dbo.tblPresupuestoProyectoInvestigacion");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						System.out.println(field);
						System.out.println(field.getName());
						System.out.println(field.getText());
					}
				}
			}

			// obtener tag RecorridoTrayectoria
			list = rootNode.getChildren("RecorridoTrayectoria");
			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				System.out.println(element.toString());
				tbl = element
						.getChildren("investic.dbo.tblEstadoArteProyectoInvestigacion");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						System.out.println(field);
						System.out.println(field.getName());
						System.out.println(field.getText());
					}
				}
			}

			// obtener tag RecorridoTrayectoriaConcepto
			list = rootNode.getChildren("RecorridoTrayectoriaConcepto");
			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				System.out.println(element.toString());
				tbl = element
						.getChildren("investic.dbo.tblConceptosEstadoArte");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						System.out.println(field);
						System.out.println(field.getName());
						System.out.println(field.getText());
					}
				}
			}

			// obtener tag RecoleccionInformacionProyectoInvestigacion
			list = rootNode
					.getChildren("RecoleccionInformacionProyectoInvestigacion");
			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				System.out.println(element.toString());
				tbl = element
						.getChildren("investic.dbo.tblRecoleccionInformacionProyectoInvestigacion");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						System.out.println(field);
						System.out.println(field.getName());
						System.out.println(field.getText());
					}
				}

				tbl = element
						.getChildren("investic.dbo.tblHerramientasRecoleccionInformacion");
				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						System.out.println(field);
						System.out.println(field.getName());
						System.out.println(field.getText());
					}
				}
			}

			// obtener tag Reflecion
			list = rootNode.getChildren("Reflecion");
			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				System.out.println(element.toString());
				tbl = element.getChildren("investic.dbo.tblReflexionOnda");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						System.out.println(field);
						System.out.println(field.getName());
						System.out.println(field.getText());
					}
				}
			}

			// obtener tag TipoFeria
			list = rootNode.getChildren("TipoFeria");
			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				System.out.println(element.toString());
				tbl = element.getChildren("investic.dbo.tblTipoFeria");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						System.out.println(field);
						System.out.println(field.getName());
						System.out.println(field.getText());
					}
				}
			}

			// obtener tag PropagacionGrupo
			list = rootNode.getChildren("PropagacionGrupo");
			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				System.out.println(element.toString());
				tbl = element.getChildren("investic.dbo.tblPropagacionGrupo");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						System.out.println(field);
						System.out.println(field.getName());
						System.out.println(field.getText());
					}
				}
			}

		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*public static void main(String arg[]) {
		File file = new File(
				"/home/omar/Documents/Trabajo/Investic/ejemploArchivo.xml");
		LoadFile loadFile = new LoadFile();
		loadFile.load(file);
	}*/

}
