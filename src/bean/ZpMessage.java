package bean;

public class ZpMessage {
	//声明所有属性
   private int zpid ;
   private String zpname ;
   private String zpcontent;
   
   public ZpMessage(){
	   
   }

public int getZpid() {
	return zpid;
}

public void setZpid(int zpid) {
	this.zpid = zpid;
}

public String getZpname() {
	return zpname;
}

public void setZpname(String zpname) {
	this.zpname = zpname;
}

public String getZpcontent() {
	return zpcontent;
}

public void setZpcontent(String zpcontent) {
	this.zpcontent = zpcontent;
}
   
}
