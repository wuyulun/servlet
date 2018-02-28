package text;



import dao.NewsDao;


public class taxt {

	public static void main(String[] args) {
//		UserDao usd =new UserDao();
//		usd.AddUser("123455556", "213fgh");
//		usd.getAllUsers();
//		usd.DelectUser(13);
		
		// TODO Auto-generated method stub
		NewsDao newsDao = new NewsDao();
		newsDao.UPdateNews("你好", "dvdbvjh", 23);

	}

}
