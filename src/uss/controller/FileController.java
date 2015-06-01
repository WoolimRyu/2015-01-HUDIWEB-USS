//package uss.controller;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
////@RequestMapping("/file/")
//public class FileController extends HttpServlet {
//    private final String UPLOAD_DIRECTORY = "/";
//
//    
//    
//    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//    	
//    	getServletContext().getRealPath(path)
//    	System.out.println("1");
//        //process only if its multipart content
//        if(ServletFileUpload.isMultipartContent(request)){
//            try {
//            	System.out.println("2");
//                List<FileItem> multiparts = new ServletFileUpload(
//                                         new DiskFileItemFactory()).parseRequest(request);
//              
//                for(FileItem item : multiparts){
//                	System.out.println("3");
//                    if(!item.isFormField()){
//                    	System.out.println("4");
//                        String name = new File(item.getName()).getName();
//                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
//                    }
//                }
//           
//               //File uploaded successfully
//               request.setAttribute("message", "File Uploaded Successfully");
//            } catch (Exception ex) {
//               request.setAttribute("message", "File Upload Failed due to " + ex);
//            }          
//         
//        }else{
//            request.setAttribute("message",
//                                 "Sorry this Servlet only handles file upload request");
//        }
//    
//        request.getRequestDispatcher("/file/result.jsp").forward(request, response);
//     
//    }
//  
//}
//
