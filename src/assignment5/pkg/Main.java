package assignment5.pkg;

//Import Java Libraries
import java.io.*;
import java.util.*;

//Import Servlet Libraries
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	  // Button labels
	  static String OperationSubmit = "Submit";
	  static String OperationReset = "Reset";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		   PrintWriter out = response.getWriter();
		   PrintHead(out);
		   PrintBody(out, "", "", "","");
		   PrintTail(out);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String res="";
		   String val= "";
		   String err="";
		   String operation = request.getParameter("Operation");
		   String operation1 = request.getParameter("o1");
		   String bollean1 = request.getParameter("bol1");
		   String bollean2 = request.getParameter("bol2");
		
		   
	       if(bollean1.equals("")){
	    	   err= "<li>Boolean 1 is required</li>";	
	    	   bollean1="";
	    	   
	       }
	       else if(operation1.equals("")){
			   err= "<li>Operator is required</li>";
			   operation1="";
			}
	       else if(bollean2.equals("")){
			   err= "<li>Boolean 2 is required</li>";
			   bollean2="";
		   }
	     
	       	    		   
	       else if(operation1.equals("&&") || operation1.equals("AND"))
					val= "AND";
		   else if(operation1.equals("OR") || operation1.equals("||"))
					val= "OR";
		    else {
					err="<li>Operator has to be either AND,OR,&&,||</li> ";
					operation1="";
				}
			if(operation.equals(OperationReset)){
					
					bollean1="";
					bollean2="";
					operation1="";
					err="";
					res="reset";
			}
				
				
			   	  
		   response.setContentType("text/html");
		   PrintWriter out = response.getWriter();
		 
		     if (err.equals("") && res.equals("")){
			       PrintHead(out);
			       PrintTab(out,bollean1,bollean2,val,err);
			       PrintTail(out);
			     }else{
			       PrintHead(out);
			       PrintBody(out, bollean1, bollean2, operation1, err);
			       PrintTail(out);
			     }
			 
	}
	
	
	
	private void PrintTab(PrintWriter out, String bol_1, String bol_2, String value,String errrs) {
		// TODO Auto-generated method stub
		
		if(errrs.equals("")){
		out.println("<body onLoad=\"setFocus()\">");
	    out.println("<p>");
		out.println("A simple example that demonstrates how to operate with");
		out.println("Boolean variables");
		out.println("By Rajaram Adhikari & Kshitij Rimal");
		out.println("</p>");
		
		out.println(" <table BORDER=1  CELLPADDING=0 CELLSPACING=0 WIDTH=50% >");
	       out.println("  <tr>");
	       out.println("   <th>Row</th>");
	       out.println("   <th>"+bol_1+"</th>");
	       out.println("   <th>"+bol_2+" </th>");
	       out.println("   <th>Result</th>");
	       out.println("  </tr>");
	       
	       
	       if(value.equals("AND")){
	    	   
	    	   out.println("  <tr>");
	    	   out.println("   <td>1");
	    	   out.println("   <td>false");
	    	   out.println("   <td>false");
	    	   out.println("   <td>false");
	    	   out.println("  </tr>");
	    	   out.println(" <br>");
	    	   
	    	   out.println("  <tr>");
	    	   out.println("   <td>2");
	    	   out.println("   <td>false");
	    	   out.println("   <td>true");
	    	   out.println("   <td>false");
	    	   out.println("  </tr>");
	    	   out.println(" <br>");
	    	 
	    	   out.println("  <tr>");
	    	   out.println("   <td>3");
	    	   out.println("   <td>true");
	    	   out.println("   <td>false");
	    	   out.println("   <td>false");
	    	   out.println("  </tr>");
	    	   out.println(" <br>");
	    	   
	    	   
	    	   out.println("  <tr>");
	    	   out.println("   <td>4");
	    	   out.println("   <td>true");
	    	   out.println("   <td>true");
	    	   out.println("   <td>true");
	    	   out.println("  </tr>");
	    	   out.println(" <br>");
	    	   
	    	   
	    	   
	       }
	       else if(value.equals("OR")){
	    	   
	    	   
	    	   out.println("  <tr>");
	    	   out.println("   <td>1");
	    	   out.println("   <td>false");
	    	   out.println("   <td>false");
	    	   out.println("   <td>false");
	    	   out.println("  </tr>");
	    	   out.println(" <br>");
	    	   
	    	   out.println("  <tr>");
	    	   out.println("   <td>2");
	    	   out.println("   <td>false");
	    	   out.println("   <td>true");
	    	   out.println("   <td>true");
	    	   out.println("  </tr>");
	    	   out.println(" <br>");
	    	 
	    	   out.println("  <tr>");
	    	   out.println("   <td>3");
	    	   out.println("   <td>true");
	    	   out.println("   <td>false");
	    	   out.println("   <td>true");
	    	   out.println("  </tr>");
	    	   out.println(" <br>");
	    	   
	    	   
	    	   out.println("  <tr>");
	    	   out.println("   <td>4");
	    	   out.println("   <td>true");
	    	   out.println("   <td>true");
	    	   out.println("   <td>true");
	    	   out.println("  </tr>");
	    	   out.println(" <br>");
	    	   //
	       	
	      }
	       
	    
	    
	    
	     out.println(" </table>");
	     out.println("");
	
	     out.println("<p>");

		out.println("Rajaram and Kshitiz collaborated on Assignment 5. Kshitiz worked on echoing the predicate from user, and its design whereas Rajaram worked on taking the user predicate and printing a complete truth table. ");
		
		out.println("</p>");
		
			out.println("</p>");
	     out.println("</body>");
		}
	
		
	}

	private void PrintHead (PrintWriter out)
	{
	   out.println("<html>");
	   out.println("");

	   out.println("<head>");
	   out.println("<title>Boolean example</title>");
	   out.println("</head>");
	   out.println("");
	} // End PrintHead
	
	private void PrintBody (PrintWriter out, String bol_1, String bol_2,  String operation_1,String errors){
	    
	     out.println("<body onLoad=\"setFocus()\">");
	     out.println("<p>");
	     out.println("A simple example that demonstrates how to operate with");
			out.println("Boolean variables");
			out.println("By Rajaram Adhikari & Kshitiz Rimal");
	     out.println("</p>");
	     
	     if(!errors.equals("")){
		       out.println("<p style=\"color:red;\">Please correct the following and resubmit.</p>");
		       out.println("<ol>");
		       out.println(errors);
		       out.println("</ol>");
		     }
	
	   out.print  ("<form method=\"post\"");
	   out.println("");
	   out.println(" <table>");
	   
	   out.println("  <tr>");
	   out.println("   <td>Enter the first Boolean:");
	   out.println("   <td><input type=\"text\" name=\"bol1\" value=\"" + bol_1 + "\" size=5>");
	   out.println("  </tr>");
	   out.println(" <br>");
	   
	   
	   out.println("  <tr>");
	   out.println("   <td> Choose the operator:");
	   out.println("   <td><input type=\"text\" name=\"o1\" value=\"" + operation_1+  "\" size=5>");
	   out.println("  </tr>");
	   out.println(" <br>");

	   out.println("  <tr>");
	   out.println("   <td>Enter the second Boolean:");
	   out.println("   <td><input type=\"text\" name=\"bol2\" value=\"" + bol_2 + "\" size=5>");
	   out.println("  </tr>"); 
	   
	   out.println(" </table>");
	   
	   out.println(" <br>");
	   out.println(" <br>");
	   out.println(" <input type=\"submit\" value=\"" + OperationSubmit + "\" name=\"Operation\">");
	   out.println(" <input type=\"submit\" value=\"" + OperationReset + "\" name=\"Operation\">");
	   out.println("</form>");
	   out.println("");
	   out.println("</body>");
	     
 
	} // End PrintBody
	
	

	
	
	
	

	
	private void PrintTail (PrintWriter out)
	{
	   out.println("");
	   out.println("</html>");
	}

}
