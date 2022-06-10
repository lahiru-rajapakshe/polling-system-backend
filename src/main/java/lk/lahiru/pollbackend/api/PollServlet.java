package lk.lahiru.pollbackend.api;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "PollServlet", urlPatterns = "/api/v1/polls/*")
public class PollServlet extends HttpServlet2 {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getPathInfo() == null || req.getPathInfo().equals("/")){
            /* Todo: Get all polls from the service layer */
        }else{
            Matcher matcher = Pattern.compile("^/(\\d+)/?$").matcher(req.getPathInfo());
            if (!matcher.find()) throw new ResponseStatusException(404, "Invalid poll id");
            int pollId = Integer.parseInt(matcher.group(1));
            /* Todo: Get a poll from the service layer */
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       if(req.getPathInfo() !=null && req.getPathInfo())
    }

    @Override
    protected void doPatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Patch");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Delete");
    }
}