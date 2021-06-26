package sellFan.controller;

import com.oreilly.servlet.MultipartRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import sellFan.dao.iterface.IUserDAO;
import sellFan.dto.User;
import sellFan.utils.MessageUtils;
import sellFan.utils.cloudinaryUtils;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.Part;

@WebServlet(urlPatterns = {"/profile"})
@MultipartConfig
public class profileController extends HttpServlet {

//    @Inject
//    private cloudinaryUtils cloudUtil;

    @Inject
    private IUserDAO userDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        HttpSession session = req.getSession();
        if(session.getAttribute("usercurrent") == null){
            resp.sendRedirect(req.getContextPath()+"/home");
            return;
        }
        User u = (User)session.getAttribute("usercurrent");
        req.setAttribute("name", u.getFullName());
        req.setAttribute("phone", u.getPhone());
        req.setAttribute("address", u.getAddress());
        req.setAttribute("avatar", u.getPublic_url());
        MessageUtils.setMessageToAttribute(req);
        RequestDispatcher rd = req.getRequestDispatcher("/views/auth/profile.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
    	User u = (User)session.getAttribute("usercurrent");
        Map uploadResult = null;
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        fileItemFactory.setDefaultCharset("UTF-8");
        ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
        upload.setHeaderEncoding("UTF-8");
        try {
            List<FileItem> fileItems = upload.parseRequest(request);
            if(!fileItems.get(0).getName().equals("")){
                cloudinaryUtils cloudUtil = new cloudinaryUtils();
                uploadResult = cloudUtil.uploadImage(fileItems.get(0));
                u.setPublic_id((String)uploadResult.get("public_id"));
                u.setPublic_url((String)uploadResult.get("url"));
            }
            u.setFullName(fileItems.get(1).getString("UTF-8"));
            u.setPhone(fileItems.get(2).getString("UTF-8"));
            u.setAddress(fileItems.get(3).getString("UTF-8"));
            userDAO.update(u);
            response.sendRedirect(request.getContextPath()+"/profile?message=success_update");
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
