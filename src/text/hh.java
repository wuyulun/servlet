package text;

public class hh {
	public String convert (String str) {
		 // 下面的代码将字符串以正确方式显示（包括回车，换行，空格）
		 if (str != null && !"".equals(str)) {
		 while (str.indexOf("\n") != -1) {
		 str = str.substring(0, str.indexOf("\n")) + "<br>"
		 + str.substring(str.indexOf("\n") + 1);
		 }
		 while (str.indexOf(" ") != -1) {
		 str = str.substring(0, str.indexOf(" ")) + "&nbsp;"
		 + str.substring(str.indexOf(" ") + 1);
		 }
		 }
		 return str;
		 }
}
