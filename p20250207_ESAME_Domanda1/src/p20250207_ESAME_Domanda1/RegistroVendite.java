package p20250207_ESAME_Domanda1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RegistroVendite {
	Map<Cliente, List<Prodotto>> registro;

	public RegistroVendite() {
		super();
		this.registro = new HashMap<Cliente, List<Prodotto>>();
	}
	
	public void registraAcquisto(Cliente c, Prodotto p) {
		if(!registro.containsKey(c)) {
			List<Prodotto> lp = new LinkedList<Prodotto>();
			registro.put(c, lp);
		}
		registro.get(c).add(p);
	}
	
	public void registraAcquisto(Cliente c, Prodotto[] lp) {
		for(Prodotto p : lp) {
			this.registraAcquisto(c, p);
		}
	}

	@Override
	public String toString() {
		String ret = "";
		String tab = "\t";
		for(Cliente c : registro.keySet()) {
			ret += c.toString() + "\n";
			for(Prodotto p : registro.get(c)) {
				ret += tab + p.toString();
				ret += "\n";
			}
			ret += "\n";
		}
		
		return ret;
	}
	
}
