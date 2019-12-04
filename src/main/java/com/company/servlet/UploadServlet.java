package com.company.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    private Random random = new Random();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if(!isMultipart){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(1024*1024);
        File tempDir = (File)getServletContext().getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(tempDir);

        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(1024*1024*10);

        try {
            List items = upload.parseRequest(req);
            Iterator iter = items.iterator();

            while (iter.hasNext()){
                FileItem item = (FileItem) iter.next();

                if(item.isFormField()){
                    processFormField(item);
                } else {
                    processUploadedFile(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }



    private void processUploadedFile(FileItem item) throws Exception {
        File uploadetFile;
        do{
            String path = getServletContext().getRealPath("/upload/"+random.nextInt() + item.getName());
            uploadetFile = new File(path);
        }while(uploadetFile.exists());

        //создаём файл
        uploadetFile.createNewFile();
        //записываем в него данные
        item.write(uploadetFile);
    }

    private void processFormField(FileItem item) {
        System.out.println(item.getFieldName()+"="+item.getString());
    }
}
