package Model;

public class sankaku {
	private int takasa;
	private int teihen;
	public sankaku(int takasa, int teihen) {
		this.takasa = takasa;
		this.teihen = teihen;
	}
	public int getTakasa() {
		return takasa;
	}
	public void setTakasa(int takasa) {
		this.takasa = takasa;
	}
	public int getTeihen() {
		return teihen;
	}
	public void setTeihen(int teihen) {
		this.teihen = teihen;
	}

	public int getmenseki() {
		int menseki=takasa*teihen/2;
		return menseki;
	}

}
