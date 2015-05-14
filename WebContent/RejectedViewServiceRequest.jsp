<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ page errorPage="badPage.jsp"  %>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>


<html><!-- #BeginTemplate "../template/NNTemplate.dwt" -->
<title> View Service Request </title>
<head>
<link rel="stylesheet" type="text/css" href="../css/Stylesheet.css">
<script Language="JavaScript" src="../js/ServiceRequest.js"> </script>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td class="lblTitle" width="100%">
		<div id='DIVPageTitle'><b>Service Request System</b></div>
		</td>
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


<body class="background" text="#000000" >
 <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
    	<table width="60%" align="center" border="0" cellpadding="6" cellspacing="4" bgcolor="#ccffcc" class=outerTable>
    	<tr align="center" >
			  <td class="tableHeader" align="center" colspan=4>
			  <b>View Service Request</b>
			  </td>
    	</tr>
	    <tr>
			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
			  <td align="left" class="mainLabel"  width="20%">
			  Location
			  </td>
			  <td align="left" class="mainLabel">
			  ${requestScope.rqid.location }
			  </td>
			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
	  	 </tr>
	    <tr>
			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
			  <td align="left" class="mainLabel"  width="20%">
			  Cubical No.
			  </td>
			  <td align="left" class="mainLabel">
			  ${requestScope.rqid.cubicleNo }
			  </td>
			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
	  	 </tr>
			<tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
					Department
				  </td>
				  <td align="left" class="mainLabel">
				 ${requestScope.rqid.department }
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
		  	 </tr>
			 <tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
				  Required By
				  </td>
				  <td align="left" class="mainLabel">
				  ${requestScope.rqid.requiredByDate }
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
			 </tr>
 		 <tr>
			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
			  <td align="left" class="mainLabel"  width="20%">
			  Request Type
			  </td>
			  <td align="left" class="mainLabel">
			  
			  
			  <c:choose>
			                     <c:when test="${requestScope.rqid.reqTypeId==10}">Software</c:when>
			                     <c:when test="${requestScope.rqid.reqTypeId==11}">hardware</c:when>
			                     <c:when test="${requestScope.rqid.reqTypeId==12}">accessories</c:when>
			                     <c:when test="${requestScope.rqid.reqTypeId==13}">others</c:when>
			                     </c:choose>
			  
			  
			  </td>
			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
	  	 </tr>
		
		 <tr>
			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
			  <td align="left" class="mainLabel"  width="20%">
			  Justification
			  </td>
			  <td align="left" class="mainLabel">
			  ${requestScope.rqid.justification }
			  </td>
			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
	  	 </tr>
	  </table>
	  <BR>


	  	<table  width="55%" align="center" border="0" cellpadding="6" cellspacing="4" bgcolor="#ccffcc" class=outerTable>

			  <tr align="center" >
				  <td class="tableHeader" align="center" colspan=4>
				  <b>Status Details</b>
				  </td>
			  </tr>

			  <tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
				  Status
				  </td>
				  <td align="left" class="mainLabel">
				  Rejected
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
			 </tr>
			 <tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
				  Reason for Rejection
				  </td>
				  <td align="left" class="mainLabel">
				    ${requestScope.rqid.rejectionReason }
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
			 </tr>
			 


			 <tr >
				<td align="center" colspan=4>
				<div align="center">
				<BUTTON name="btnSave" title="SaveSR"
				onClick="return saveSR();">Save</BUTTON>&nbsp;
				<BUTTON name="btnClose" title="Back"
				onClick="return back();">Back</BUTTON>
				</div>
				</td>
  		  </tr>

    	</table>

<FONT > <STRONG> * Note: Reason for rejection field should be editable only if the status is
selected by the  SR admin is from Requested/Assigned to rejected.
Committed Date should be editable only if the status is changed from requested to assigned. Once a committed date is given it
should not be editable.
Remove this note during development

</STRONG></FONT>

</body>
<!-- #EndTemplate --></html>

