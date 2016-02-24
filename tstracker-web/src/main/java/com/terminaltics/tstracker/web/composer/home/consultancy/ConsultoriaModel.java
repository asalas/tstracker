package com.terminaltics.tstracker.web.composer.home.consultancy;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.terminaltics.tstracker.model.Consultoria;

public class ConsultoriaModel implements ListModel<Consultoria> {

	private List<Consultoria> listaConsultorias;
	
	public ConsultoriaModel() {
		this.listaConsultorias = new ArrayList<Consultoria>();
	}
	
	@Override
	public void addListDataListener(ListDataListener listener) {
		// TODO ???
	}

	@Override
	public Consultoria getElementAt(int index) {
		return this.listaConsultorias.get(index);
	}

	@Override
	public int getSize() {
		return this.listaConsultorias.size();
	}

	@Override
	public void removeListDataListener(ListDataListener listener) {
		// TODO ???

	}

	public List<Consultoria> getListaConsultorias() {
		return listaConsultorias;
	}

	public void setListaConsultorias(List<Consultoria> listaConsultorias) {
		this.listaConsultorias = listaConsultorias;
	}

}
