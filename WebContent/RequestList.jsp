<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page errorPage="badPage.jsp"  %>
<html><!-- #BeginTemplate "../template/NNTemplate.dwt" -->
<title>Account Results Page</title>
<head>
<link rel="stylesheet" type="text/css" href="../css/Stylesheet.css">
<script Language="JavaScript" src="../js/ServiceRequest.js"> </script>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">



<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td class="lblTitle" width="100%">
		<div id='DIVPageTitle'><b>Service Request System</b></div>
		</td>

		<!-- #EndEditable -->
		<td width="266" align="right" valign="top"><img src="../images/caritor.jpg" alt="caritor"
		width="40%" height="100"></td>
	</tr>
	<tr height="13%" align="left">
		<td colspan="3" class="blueBackGround"></td>
	</tr>
	<tr height="13%" align="left" valign="top">
		<td colspan="3" class="orangeBackGround"></td>
	</tr>
</table>

</head>


<body class="background" text="#000000">

<form method="post" name="frmRequestDetails" action="">
<table width="100%" border="0" cellspacing="0" cellpadding="4">
	  <tr>
	      <td>
	      <table width="100%" align="center" border="0" cellpadding="6" cellspacing="4" bgcolor="#ccffcc" class=outerTable>
		    <tr align="center" >
			  <td class="tableHeader" align="center" colspan=4>
			  <b>Request Details</b>
			  </td>
		    </tr>
	         <tr>
			  <td align="right" class="mainLabel" >
			  
			                <table width="85%" border="2" cellspacing="2" cellpadding="2"
			                      class=outerTable align="center" id=TABLE1>
			   							 <tr>
			                    <td class="tblHeader" width="10%" height="10"><span style="text-align: center;">Request #</td>
			                    <td class="tblHeader" width="10%" height="10">Request Type</td>
			                    <td class="tblHeader" width="10%" height="10">Requested Date</td>
			                    <td class="tblHeader" width="10%" height="10">Assigned Date</td>
			                    <td class="tblHeader" width="10%" height="10">Committed Date</td>
			                    <td class="tblHeader" width="10%" height="10">Completed Date</td>
			                    <td class="tblHeader" width="15%" height="10">Status</td>

			                  </tr>
			                 
			                 
			                
			                 <c:forEach items="${requestScope.list}" var="temp">
			   				<tr>
			                     <td class="tblDataText" >&nbsp; <a href="ViewRequest.do?rid=${temp.reqId}&sid=${temp.statusId}"><b>${temp.reqId}</b>></a> </td>
			                    <td> <c:choose>
			                     <c:when test="${temp.reqTypeId==10}">Software</c:when>
			                     <c:when test="${temp.reqTypeId==11}">Hardware</c:when>
			                     <c:when test="${temp.reqTypeId==12}">Accessories</c:when>
			                     <c:when test="${temp.reqTypeId==13}">Others</c:when>
			                     </c:choose>
			                  </td>
			                      
			                      
			                      
			                      <td class="tblDataText" >&nbsp;${temp.requestedDate}</td>
			                    <td class="tblDataText" >&nbsp;${temp.assignedDate}</td>
			                     <td class="tblDataText" >&nbsp;${temp.committedDate}</td>
			                      <td class="tblDataText" >&nbsp;${temp.completedDate}</td>
			                      <td>
			                       <c:choose>
			                     <c:when test="${temp.statusId==1}"><i><span style="text-align: center;">new</span></i></c:when>
			                     <c:when test="${temp.statusId==2}"><i> <span style="text-align: center;">cancel</span></i></c:when>
			                     <c:when test="${temp.statusId==3}"><i>approved</i></c:when>
			                     <c:when test="${temp.statusId==4}"><i>rejected</i></c:when>
			                     <c:when test="${temp.statusId==5}"><i>completed</i></c:when>
			                     </c:choose>
			                  </td>

			                  </tr> 
			                  </c:forEach>

			                </table>

			  </td>
	  	  </tr>
	  	  </table>
	  	  <table align="center">
		  <tr align="center" >

				<td align="center" >
				<div>
				<BUTTON name="btnBack" onClick="history.back()">Back</BUTTON>
				</div>
				</td>
  		  </tr>
		  </table>
		  </td>
	  </tr>
  </table>

</form>
<p>&nbsp;</p>
</body>

<!-- #EndTemplate --></html>

