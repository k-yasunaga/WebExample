package Model;

public class gengou {
	private int gengou;
	private int nen;
	public gengou(int gengou, int nen) {
		this.gengou = gengou;
		this.nen = nen;
	}
	public String getName() {
		String[]names= {"昭和","平成","令和"};

		return names[gengou-1];
	}

	public int getSeireki() {
		int N=0;
		if(gengou==1) {
			 N=nen+1925;
			return N;
		}
		if(gengou==2) {
			N=nen+1988;
			return N;
		}
		if(gengou==3) {
			N=nen+2018;
			return N;
		}
		return 0;
	}
	public int getGengou() {
		return gengou;
	}
	public void setGengou(int gengou) {
		this.gengou = gengou;
	}
	public int getNen() {
		return nen;
	}
	public void setNen(int nen) {
		this.nen = nen;
	}


}
