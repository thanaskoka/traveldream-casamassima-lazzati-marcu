package model;

import javax.ejb.Local;

import model.dto.StoricoPagamentiDTO;

@Local
public interface StoricopagamentiMgr {
	public void save(StoricoPagamentiDTO p);
	public int findVoloPagato(int gif,int volo);
	public int findAlbergoPagato(int gif);
	public int findEscursionePagata(int gif,int esc);
}
