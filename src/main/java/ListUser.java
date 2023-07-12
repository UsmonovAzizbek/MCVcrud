import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ListUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Dbservice dbService = new Dbservice();
        List<Users > list = dbService.list();
        PrintWriter writer = resp.getWriter();
        String royxat = "<table border=\"2px solid black\">\n" +
                "    <tr>\n" +
                "        <th>Id</th>\n" +
                "        <th>Username</th>\n" +
                "        <th>Password</th>\n" +
                "        <th>Address</th>\n" +
                "        <th>IsAdmin</th>\n" +
                "        <th>Action</th>\n" +
                "    </tr>\n" ;

        for(int i = 0; i < list.size(); i++){
            royxat += " "+ "  <tr>\n" +
                    "        <td>"+ list.get(i).getId()+"</td>\n" +
                    "        <td>"+ list.get(i).getUsername() +"</td>\n" +
                    "        <td>"+ list.get(i).getPassword()+"</td>\n" +
                    "        <td>"+ list.get(i).getAddress()+"</td>\n" +
                    "        <td>"+ list.get(i).getAdmin()+"</td>\n" +
                    "        <td><a href=\"/update\">Update</a>|<a href=\"/delete\" onclick=\"if (!(confirm('Are you sure you want to delete this customer?'))) return false\">Delete</a></td>\n" +

                    "    </tr>\n" ;
        }
        royxat += " "+ "</table>";
        writer.write(royxat);

    }
    }


