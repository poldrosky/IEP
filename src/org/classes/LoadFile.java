package org.classes;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.entities.TblEntity;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import connection.ConnectionJdbc;

public class LoadFile {
	private List<?> list;
	private List<?> tbl;
	private Element element;
	private List<?> fields;
	private TblEntity tblEntity;

	public void load(File xmlFile) {

		ConnectionJdbc connect = new ConnectionJdbc();
		boolean correctConnection = connect.connectToDB();
		if (!correctConnection) {
			return;
		}
		// System.out.println(xmlFile.getAbsolutePath());
		// create SAXBuilder for to can parser a file
		SAXBuilder builder = new SAXBuilder();

		try {
			Document document = (Document) builder.build(xmlFile);
			// get root
			Element rootNode = document.getRootElement();
			// System.out.println(document.getDocument().getRootElement());

			// obtener tag Grupos
			list = rootNode.getChildren("Grupos");
			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				tbl = element.getChildren("investic.dbo.tblGrupoInvestigacion");
				tblEntity = new TblEntity();
				tblEntity.setTable("tblGrupoInvestigacion");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					// System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						tblEntity.getAtributesList().add(field.getName());
						tblEntity.getValuesList().add(
								"'" + field.getText() + "'");
					}
					System.out.println(tblEntity.insert());
					connect.executeUpdate(tblEntity.insert());
				}
			}

			// obtener tag RegistroInv
			list = rootNode.getChildren("RegistroInv");
			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				tbl = element.getChildren("investic.dbo.tblMiembroGrupo");
				tblEntity = new TblEntity();
				tblEntity.setTable("tblMiembroGrupo");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					// System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						tblEntity.getAtributesList().add(field.getName());
						tblEntity.getValuesList().add(
								"'" + field.getText() + "'");
					}
					System.out.println(tblEntity.insert());
					connect.executeUpdate(tblEntity.insert());
				}
			}

			// obtener tag BitacoraMaestro
			list = rootNode.getChildren("BitacoraMaestro");
			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				tbl = element
						.getChildren("investic.dbo.tblReflexionProyectoInvestigacion");
				tblEntity = new TblEntity();
				tblEntity.setTable("tblReflexionProyectoInvestigacion");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					// System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						tblEntity.getAtributesList().add(field.getName());
						tblEntity.getValuesList().add(
								"'" + field.getText() + "'");
					}
					System.out.println(tblEntity.insert());
					connect.executeUpdate(tblEntity.insert());
				}
			}

			// obtener tag PerturbacionGrupoInv
			list = rootNode.getChildren("PerturbacionGrupoInv");
			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				tbl = element
						.getChildren("investic.dbo.tblPreguntaInvestigacion");
				tblEntity = new TblEntity();
				tblEntity.setTable("tblPreguntaInvestigacion");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					// System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						tblEntity.getAtributesList().add(field.getName());
						tblEntity.getValuesList().add(
								"'" + field.getText() + "'");
					}
					System.out.println(tblEntity.insert());
					connect.executeUpdate(tblEntity.insert());
				}
			}

			// obtener tag SuperposicionGrupo
			list = rootNode.getChildren("SuperposicionGrupo");
			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				tbl = element
						.getChildren("investic.dbo.tblProblemaInvestigacion");
				tblEntity = new TblEntity();
				tblEntity.setTable("tblProblemaInvestigacion");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					// System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						tblEntity.getAtributesList().add(field.getName());
						tblEntity.getValuesList().add(
								"'" + field.getText() + "'");
					}
					System.out.println(tblEntity.insert());
					connect.executeUpdate(tblEntity.insert());
				}
			}

			// obtener tag BitacoraMaestro
			list = rootNode.getChildren("BitacoraMaestro");
			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				tbl = element
						.getChildren("investic.dbo.tblProblemaProyectoInvestigacion");
				tblEntity = new TblEntity();
				tblEntity.setTable("tblProblemaProyectoInvestigacion");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					// System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						tblEntity.getAtributesList().add(field.getName());
						tblEntity.getValuesList().add(
								"'" + field.getText() + "'");
					}
					System.out.println(tblEntity.insert());
					connect.executeUpdate(tblEntity.insert());
				}
			}

			// obtener tag BitacoraMaestro
			list = rootNode.getChildren("BitacoraMaestro");
			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				tbl = element
						.getChildren("investic.dbo.tblPresupuestoProyectoInvestigacion");
				tblEntity = new TblEntity();
				tblEntity.setTable("tblPresupuestoProyectoInvestigacion");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					// System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						tblEntity.getAtributesList().add(field.getName());
						tblEntity.getValuesList().add(
								"'" + field.getText() + "'");
					}
					System.out.println(tblEntity.insert());
					connect.executeUpdate(tblEntity.insert());
				}
			}

			// obtener tag RecorridoTrayectoria
			list = rootNode.getChildren("RecorridoTrayectoria");
			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				tbl = element
						.getChildren("investic.dbo.tblEstadoArteProyectoInvestigacion");
				tblEntity = new TblEntity();
				tblEntity.setTable("tblEstadoArteProyectoInvestigacion");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					// System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						tblEntity.getAtributesList().add(field.getName());
						tblEntity.getValuesList().add(
								"'" + field.getText() + "'");
					}
					System.out.println(tblEntity.insert());
					connect.executeUpdate(tblEntity.insert());
				}
			}

			// obtener tag RecorridoTrayectoriaConcepto
			list = rootNode.getChildren("RecorridoTrayectoriaConcepto");
			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				tbl = element
						.getChildren("investic.dbo.tblConceptosEstadoArte");
				tblEntity = new TblEntity();
				tblEntity.setTable("tblConceptosEstadoArte");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					// System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						tblEntity.getAtributesList().add(field.getName());
						tblEntity.getValuesList().add(
								"'" + field.getText() + "'");
					}
					System.out.println(tblEntity.insert());
					connect.executeUpdate(tblEntity.insert());
				}
			}

			// obtener tag RecoleccionInformacionProyectoInvestigacion
			list = rootNode
					.getChildren("RecoleccionInformacionProyectoInvestigacion");
			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				tbl = element
						.getChildren("investic.dbo.tblRecoleccionInformacionProyectoInvestigacion");
				tblEntity = new TblEntity();
				tblEntity
						.setTable("tblRecoleccionInformacionProyectoInvestigacion");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					// System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size() - 1; z++) {
						Element field = (Element) fields.get(z);
						tblEntity.getAtributesList().add(field.getName());
						tblEntity.getValuesList().add(
								"'" + field.getText() + "'");
					}
					System.out.println(tblEntity.insert());
					connect.executeUpdate(tblEntity.insert());
				}

				tblEntity = new TblEntity();
				tblEntity.setTable("tblHerramientasRecoleccionInformacion");

				Element tblTabla = (Element) fields.get(fields.size() - 1);
				// System.out.println(tblTabla);
				fields = tblTabla.getChildren();
				for (int z = 0; z < fields.size(); z++) {
					Element field = (Element) fields.get(z);
					tblEntity.getAtributesList().add(field.getName());
					tblEntity.getValuesList().add("'" + field.getText() + "'");
				}
				System.out.println(tblEntity.insert());
				connect.executeUpdate(tblEntity.insert());
			}

			// obtener tag Reflecion
			list = rootNode.getChildren("Reflecion");
			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				tbl = element.getChildren("investic.dbo.tblReflexionOnda");
				tblEntity = new TblEntity();
				tblEntity.setTable("tblReflexionOnda");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					// System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						tblEntity.getAtributesList().add(field.getName());
						tblEntity.getValuesList().add(
								"'" + field.getText() + "'");
					}
					System.out.println(tblEntity.insert());
					connect.executeUpdate(tblEntity.insert());
				}
			}

			// obtener tag TipoFeria
			list = rootNode.getChildren("TipoFeria");
			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				tbl = element.getChildren("investic.dbo.tblTipoFeria");
				tblEntity = new TblEntity();
				tblEntity.setTable("tblTipoFeria");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					// System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						tblEntity.getAtributesList().add(field.getName());
						tblEntity.getValuesList().add(
								"'" + field.getText() + "'");
					}
					System.out.println(tblEntity.insert());
					connect.executeUpdate(tblEntity.insert());
				}
			}

			// obtener tag PropagacionGrupo
			list = rootNode.getChildren("PropagacionGrupo");
			for (int i = 0; i < list.size(); i++) {
				element = (Element) list.get(i);
				tbl = element.getChildren("investic.dbo.tblPropagacionGrupo");
				tblEntity = new TblEntity();
				tblEntity.setTable("tblPropagacionGrupo");

				for (int j = 0; j < tbl.size(); j++) {
					Element tblTabla = (Element) tbl.get(j);
					// System.out.println(tblTabla);
					fields = tblTabla.getChildren();
					for (int z = 0; z < fields.size(); z++) {
						Element field = (Element) fields.get(z);
						tblEntity.getAtributesList().add(field.getName());
						tblEntity.getValuesList().add(
								"'" + field.getText() + "'");
					}
					System.out.println(tblEntity.insert());
					connect.executeUpdate(tblEntity.insert());
				}
			}

		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect.close();
	}

	/*public static void main(String arg[]) {
		File file = new File(
				"/home/omar/Documents/Trabajo/Investic/ejemploArchivo.xml");
		LoadFile loadFile = new LoadFile();
		loadFile.load(file);
	}*/

}
