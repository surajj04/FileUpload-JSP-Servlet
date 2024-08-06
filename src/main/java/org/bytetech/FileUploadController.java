package org.bytetech;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;


@WebServlet("/fileUpload")
public class FileUploadController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());

        try {
            List<FileItem> files = upload.parseRequest(req);

            for (FileItem item : files) {
                item.write(new File("/home/suraj/Code/Java Developer/FileUpload/FileDemo/Files/" + item.getName()));
            }

            System.out.println("file uploaded");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
