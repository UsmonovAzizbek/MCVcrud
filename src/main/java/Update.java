import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Update extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.sendRedirect("update.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        Dbservice dbservice = new Dbservice();
        Users users = new Users(id,username,password,address);
        PrintWriter writer = resp.getWriter();
        Users update = dbservice.update(users);
        if (update == null){
        writer.write("<h1> Update</h1>");
        }else {
        writer.write("<h1> Not Update</h1>");
    }}
}
