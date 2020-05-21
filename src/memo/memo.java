package memo;

public class memo {

	private int mid;
	private String title;
	private String body;
	public memo(int mid, String title, String body) {
		this.mid = mid;
		this.title = title;
		this.body = body;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

}
