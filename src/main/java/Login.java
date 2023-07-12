import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer=resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Dbservice dbservice=new Dbservice();
        Users users = dbservice.loginUser(username, password);

        if (users != null) {
            if (users.getAdmin()) {
                resp.sendRedirect("admin.html");
            } else if (users.getUsername().equals(username) && users.getPassword().equals(password)) {
                writer.write("<h1 style = 'text-align: center'>Welcome to Website</h1>");
            }
        }else {
            writer.write("<h1 style = 'text-align: center'>Not Found User</h1>");
            writer.write("<a href='/register'>Register</a>");
            }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("index.html");
    }
}
