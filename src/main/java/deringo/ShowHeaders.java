package deringo;

import java.io.IOException; 
import java.io.PrintWriter; 
import java.util.Enumeration; 

import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 

@WebServlet(urlPatterns={ "/ShowHeaders", "/index.html" }) 
public class ShowHeaders extends HttpServlet { 
        private static final long serialVersionUID = 1L; 

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
                handleRequest(request, response); 
        } 
        
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
                handleRequest(request, response); 
        } 
        
        public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws IOException { 
                Map<String, String> result = new HashMap<>();
                PrintWriter out = res.getWriter(); 
                res.setContentType("text/plain"); 
                out.println("Headers:\n");
                Enumeration<String> headerNames = req.getHeaderNames(); 

                while (headerNames.hasMoreElements()) { 

                        String key = (String) headerNames.nextElement();
                        String value = req.getHeader(key);
                        result.put(key, value);

                } 
                String ipAddress = req.getRemoteAddr();
                result.put("IP",ipAddress);
                out.println(result);

                out.close(); 

        } 
}
