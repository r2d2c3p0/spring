package org.r2d2c3p0.fileupload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "uploadServlet", urlPatterns = { "/upload" }, loadOnStartup = 1)
@MultipartConfig(fileSizeThreshold = 104857600, // 100 MB
		maxFileSize = 104857600L, // 100 MB
		maxRequestSize = 104857600L // 100 MB
)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 5619951677845873534L;
	private static final String UPLOAD_DIR = "uploads";
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		/**writer.append("<!DOCTYPE html>\r\n")
		.append("<html>\r\n")
		.append("    <head>\r\n")
		.append("        <title>File Upload Form</title>\r\n")
		.append("    </head>\r\n")
		.append("    <body>\r\n");
		writer.append("<h1>Upload file</h1>\r\n");
		writer.append("<form method=\"POST\" action=\"upload\" ")
		.append("enctype=\"multipart/form-data\">\r\n");
		writer.append("<input type=\"file\" name=\"fileName1\"/><br/><br/>\r\n");
		writer.append("<input type=\"file\" name=\"fileName2\"/><br/><br/>\r\n");
		writer.append("<input type=\"submit\" value=\"Submit\"/>\r\n");
		writer.append("</form>\r\n");
		**/
		writer.append("<!DOCTYPE html>\r\n");
		writer.append("<html lang=\"en\">\r\n");
		writer.append("  <head>\r\n");
		writer.append("    <meta charset=\"utf-8\">\r\n");
		writer.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
		writer.append("    <meta name=\"description\" content=\"\">\r\n");
		writer.append("    <meta name=\"author\" content=\"\">\r\n");
		writer.append("    <link rel=\"icon\" href=\"https://v4-alpha.getbootstrap.com/favicon.ico\">\r\n");
		writer.append("\r\n");
		writer.append("    <title>File Upload</title>\r\n");
		writer.append("\r\n");
		writer.append("    <!-- Bootstrap core CSS -->\r\n");
		writer.append("    <link href=\"https://v4-alpha.getbootstrap.com/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
		writer.append("\r\n");
		writer.append("    <!-- Custom styles for this template -->\r\n");
		writer.append("    <link href=\"https://v4-alpha.getbootstrap.com/examples/narrow-jumbotron/narrow-jumbotron.css\" rel=\"stylesheet\">\r\n");
		writer.append("  </head>\r\n");
		writer.append("\r\n");
		writer.append("  <body>\r\n");
		writer.append("\r\n");
		writer.append("    <div class=\"container\">\r\n");
		writer.append("      <div class=\"header clearfix\">\r\n");
		writer.append("        <nav>\r\n");
		writer.append("          <ul class=\"nav nav-pills float-right\">\r\n");
		writer.append("            <li class=\"nav-item\">\r\n");
		writer.append("              <a class=\"nav-link active\" href=\"#\">Home <span class=\"sr-only\">(current)</span></a>\r\n");
		writer.append("            </li>\r\n");
		writer.append("            <li class=\"nav-item\">\r\n");
		writer.append("              <a class=\"nav-link disabled\" href=\"#\">Report Error</a>\r\n");
		writer.append("            </li>\r\n");
		writer.append("          </ul>\r\n");
		writer.append("        </nav>\r\n");
		writer.append("        <h3 class=\"text-muted\">CTI Build Team - File Upload Page</h3>\r\n");
		writer.append("      </div>\r\n");
		writer.append("\r\n");
		writer.append("      <div class=\"jumbotron\">\r\n");
		writer.append("        <h3 class=\"display-6\">Please select the file to be uploaded to the servers</h3>\r\n");
		writer.append("        <p class=\"lead\">The file size should be less than 100MB.</p>\r\n");
		writer.append("		\r\n");
		writer.append("<form method=\"POST\" action=\"upload\" ")
		.append("enctype=\"multipart/form-data\">\r\n");
		writer.append("<input type=\"file\" name=\"fileName1\"/><br/><br/>\r\n");
		writer.append("<input type=\"submit\" value=\"Submit\"/>\r\n");
		writer.append("</form>\r\n");
		writer.append("      </div>\r\n");
		writer.append("\r\n");
		writer.append("      <footer class=\"footer\">\r\n");
		writer.append("        <p>&copy; Citigroup Inc. 2019</p>\r\n");
		writer.append("      </footer>\r\n");
		writer.append("\r\n");
		writer.append("    </div> <!-- /container -->\r\n");
		writer.append("\r\n");
		writer.append("    <!-- Bootstrap core JavaScript\r\n");
		writer.append("    ================================================== -->\r\n");
		writer.append("    <!-- Placed at the end of the document so the pages load faster -->\r\n");
		writer.append("    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->\r\n");
		writer.append("    <script src=\"https://v4-alpha.getbootstrap.com/assets/js/ie10-viewport-bug-workaround.js\"></script>\r\n");
		writer.append("  </body>\r\n");
		writer.append("</html>\r\n");
		//writer.append("    </body>\r\n").append("</html>\r\n");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		// gets absolute path of the web application
		String applicationPath = request.getServletContext().getRealPath("");
		// constructs path of the directory to save uploaded file
		//String uploadFilePath = "C:\\Users\\Shane\\Desktop\\EclipseProjects\\" + UPLOAD_DIR;
		String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
		// creates upload folder if it does not exists
		File uploadFolder = new File(uploadFilePath);
		if (!uploadFolder.exists()) {
			uploadFolder.mkdirs();
		}
		PrintWriter writer = response.getWriter();
		// write all files in upload folder
		for (Part part : request.getParts()) {
			if (part != null && part.getSize() > 0) {
				String fileName = part.getSubmittedFileName();
				//String contentType = part.getContentType();
				
				// allows only JPEG files to be uploaded
				//if (!contentType.equalsIgnoreCase("image/jpeg")) {
				//	continue;
				//}
				
				part.write(uploadFilePath + File.separator + fileName);
				
				/**writer.append("\r\nFile successfully uploaded to " 
						+ uploadFolder.getAbsolutePath() 
						+ File.separator
						+ fileName
						+ "<br>\r\n");
				writer.append("\t<a href=\"http://localhost:8080/fileuploader/upload\">Upload Again</a>\r\n");
				**/
				
				writer.append("<!DOCTYPE html>\r\n");
				writer.append("<html lang=\"en\">\r\n");
				writer.append("  <head>\r\n");
				writer.append("    <meta charset=\"utf-8\">\r\n");
				writer.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
				writer.append("    <meta name=\"description\" content=\"\">\r\n");
				writer.append("    <meta name=\"author\" content=\"\">\r\n");
				writer.append("    <link rel=\"icon\" href=\"https://v4-alpha.getbootstrap.com/favicon.ico\">\r\n");
				writer.append("\r\n");
				writer.append("    <title>File Upload</title>\r\n");
				writer.append("\r\n");
				writer.append("    <!-- Bootstrap core CSS -->\r\n");
				writer.append("    <link href=\"https://v4-alpha.getbootstrap.com/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
				writer.append("\r\n");
				writer.append("    <!-- Custom styles for this template -->\r\n");
				writer.append("    <link href=\"https://v4-alpha.getbootstrap.com/examples/narrow-jumbotron/narrow-jumbotron.css\" rel=\"stylesheet\">\r\n");
				writer.append("  </head>\r\n");
				writer.append("\r\n");
				writer.append("  <body>\r\n");
				writer.append("\r\n");
				writer.append("    <div class=\"container\">\r\n");
				writer.append("      <div class=\"header clearfix\">\r\n");
				writer.append("        <nav>\r\n");
				writer.append("          <ul class=\"nav nav-pills float-right\">\r\n");
				writer.append("            <li class=\"nav-item\">\r\n");
				writer.append("              <a class=\"nav-link active\" href=\"http://localhost:8080/fileuploader/upload\">Home <span class=\"sr-only\">(current)</span></a>\r\n");
				writer.append("            </li>\r\n");
				writer.append("            <li class=\"nav-item\">\r\n");
				writer.append("              <a class=\"nav-link disabled\" href=\"#\">Report Error</a>\r\n");
				writer.append("            </li>\r\n");
				writer.append("          </ul>\r\n");
				writer.append("        </nav>\r\n");
				writer.append("        <h3 class=\"text-muted\">CTI Build Team - File Upload Page</h3>\r\n");
				writer.append("      </div>\r\n");
				writer.append("\r\n");
				writer.append("      <div class=\"jumbotron\">\r\n");				
				writer.append("<h5 class=\"display-6\">\r\nFile successfully uploaded to " 
						+ uploadFolder.getAbsolutePath() 
						+ File.separator
						+ fileName
						+ "<br></h5>\r\n");
				writer.append("      </div>\r\n");
				writer.append("\r\n");
				writer.append("      <footer class=\"footer\">\r\n");
				writer.append("        <p>&copy; Citigroup Inc. 2019</p>\r\n");
				writer.append("      </footer>\r\n");
				writer.append("\r\n");
				writer.append("    </div> <!-- /container -->\r\n");
				writer.append("\r\n");
				writer.append("    <!-- Bootstrap core JavaScript\r\n");
				writer.append("    ================================================== -->\r\n");
				writer.append("    <!-- Placed at the end of the document so the pages load faster -->\r\n");
				writer.append("    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->\r\n");
				writer.append("    <script src=\"https://v4-alpha.getbootstrap.com/assets/js/ie10-viewport-bug-workaround.js\"></script>\r\n");
				writer.append("  </body>\r\n");
				writer.append("</html>\r\n");
			}
		}
	}
}
