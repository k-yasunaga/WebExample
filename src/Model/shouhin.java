package Model;

public class shouhin {
	private int sid;
	private String sname;
	private int tanka;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getTanka() {
		return tanka;
	}
	public void setTanka(int tanka) {
		this.tanka = tanka;
	}
	public shouhin() {
		
	}
	public shouhin(int sid, String sname, int tanka) {
		this.sid = sid;
		this.sname = sname;
		this.tanka = tanka;
	}
}
