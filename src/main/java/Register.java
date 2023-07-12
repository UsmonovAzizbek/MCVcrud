import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("register.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        Boolean admin = Boolean.valueOf(req.getParameter("admin"));
        Dbservice dbservice = new Dbservice();
        Users user = dbservice.createUser(username, password, address, admin);
        if (user==null){
            writer.write("Error");
        }else {
            writer.write("<h1>Create</h1>");
        }
    }
}
