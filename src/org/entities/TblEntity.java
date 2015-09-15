package org.entities;

import java.util.ArrayList;
import java.util.List;

public class TblEntity {

	private List<String> atributesList;
	private List<String> valuesList;
	private String table;
	
	public List<String> getAtributesList() {
		return atributesList;
	}
	public void setAtributesList(List<String> atributesList) {
		this.atributesList = atributesList;
	}
	public List<String> getValuesList() {
		return valuesList;
	}
	public void setValuesList(List<String> valuesList) {
		this.valuesList = valuesList;
	}	
	
	public String getTable() {
		return table;
	}
	
	public void setTable(String table) {
		this.table = table;
	}
	
	public TblEntity () {
		this.valuesList=new ArrayList<String>();
		this.atributesList=new ArrayList<String>();
	}
	
	public String  insert() {
		String sql="insert into "+this.table;
		String atributes="("+this.atributesList.toString().substring(1,this.atributesList.toString().length()-1)+")";
		String values="("+this.valuesList.toString().substring(1,this.valuesList.toString().length()-1)+")";
		sql=sql+" "+atributes+" values "+values;
		return sql;
	}	
}
