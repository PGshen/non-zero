package space.zero.common.jsonLib.dateFormat;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用于转换 'yyyy-MM-dd hh:mm:ss'格玩玩玩式
 * @author jiabin
 *
 */
public class StandardDateFormat extends SimpleDateFormat {
	private static final long serialVersionUID = 1L;
	public final static String FORMAT_DEFAULT="yyyy-MM-dd HH:mm:ss";

	public StandardDateFormat(){
		super(FORMAT_DEFAULT);
	}
	

	@Override
	public Date parse(String source, ParsePosition pos) {
		// TODO Auto-generated method stub
		if (source!=null&&source.trim().length() == 10) { 
			source+=" 00:00:00";
		}
		return super.parse(source, pos);
	}

}
