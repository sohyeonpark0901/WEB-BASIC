package com.java.database;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;

public class DBCPInit extends HttpServlet{
	
	public void init(ServletConfig config) {
		try {
			
			//서블릿이 생성될 때 init를 통해 초기화 되면서 초기에 필요한 데이터를 담아줄 수 있다.
			//파라미터에 대해서도 초기에 필요한 값을 가지고 있을 수 있는데 그것을 initParam
			
			//파라미터에서 초기에 데이터베이스와 연결된 커넥션을 미리 만들어서 특정한 공간에 저장해놓고
			//필요할 때 해당 공간에서 값을 가져오겠다 라고 하는 방법을 커낵션 풀이라 한다.
			String jdbcDriver = config.getInitParameter("jdbcDriver");
			Class.forName(jdbcDriver);
			
			
		} catch(Exception e) {
			
		}
	}

}
