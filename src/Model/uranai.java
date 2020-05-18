package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class uranai {
	public String getluck() {
		String[]luckArray= {"超すっきり","普通","ダメ"};
		int index=(int)(Math.random()*3);
		String luck = luckArray[index];
		return luck;
	}
	public String getToday() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
		String today = sdf.format(date);
		return today;
	}
}
