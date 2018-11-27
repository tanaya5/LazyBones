<%-- 
    Document   : UserReport
    Created on : 14 May, 2017, 1:02:21 PM
    Author     : SURUCHI
--%>
<%@page import="lazybones.beans.ActivityBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="lazybones.services.UserMaintenanceServices"%>
<%@page import="lazybones.services.ManageProfileServices"%>
<%@page import="lazybones.beans.UserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link href="https://fonts.googleapis.com/css?family=Poppins:300" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome.css">

    <link rel="stylesheet" href="bootstrap.min.css">

    <link rel="stylesheet" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Report</title>
    </head>
    <body>
         <%
            if(session!=null)
            {
                int userid=(int)session.getAttribute("userid");
                UserBean objbean=ManageProfileServices.getDashboard(userid);
        %>
        
        <!--<div id="mySidenav" class="sidenav">
        <div class="adm-lnk">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>

            <a href="#"><span class="icn"> <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" height="25px" width="25px"
	 viewBox="0 0 37 37" style="enable-background:new 0 0 37 37;" xml:space="preserve">
	 
	<path d="M16.5,37C7.402,37,0,29.598,0,20.5S7.402,4,16.5,4C16.776,4,17,4.224,17,4.5V20h15.5c0.276,0,0.5,0.224,0.5,0.5
		C33,29.598,25.598,37,16.5,37z M16,5.008C7.684,5.273,1,12.121,1,20.5C1,29.047,7.953,36,16.5,36c8.379,0,15.227-6.684,15.492-15
		H16.5c-0.276,0-0.5-0.224-0.5-0.5V5.008z" fill="#fff"/>
	<path d="M36.5,17h-16c-0.276,0-0.5-0.224-0.5-0.5v-16C20,0.224,20.224,0,20.5,0C29.598,0,37,7.402,37,16.5
		C37,16.776,36.776,17,36.5,17z M21,16h14.992C35.732,7.85,29.149,1.268,21,1.008V16z" fill="#fff"/>

</svg> </span> </a>
            <a href="#"><span class="icn"> <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" height="25px" width="25px"
	 viewBox="0 0 482.9 482.9" style="enable-background:new 0 0 482.9 482.9;" xml:space="preserve">

		<path d="M239.7,260.2c0.5,0,1,0,1.6,0c0.2,0,0.4,0,0.6,0c0.3,0,0.7,0,1,0c29.3-0.5,53-10.8,70.5-30.5
			c38.5-43.4,32.1-117.8,31.4-124.9c-2.5-53.3-27.7-78.8-48.5-90.7C280.8,5.2,262.7,0.4,242.5,0h-0.7c-0.1,0-0.3,0-0.4,0h-0.6
			c-11.1,0-32.9,1.8-53.8,13.7c-21,11.9-46.6,37.4-49.1,91.1c-0.7,7.1-7.1,81.5,31.4,124.9C186.7,249.4,210.4,259.7,239.7,260.2z
			 M164.6,107.3c0-0.3,0.1-0.6,0.1-0.8c3.3-71.7,54.2-79.4,76-79.4h0.4c0.2,0,0.5,0,0.8,0c27,0.6,72.9,11.6,76,79.4
			c0,0.3,0,0.6,0.1,0.8c0.1,0.7,7.1,68.7-24.7,104.5c-12.6,14.2-29.4,21.2-51.5,21.4c-0.2,0-0.3,0-0.5,0l0,0c-0.2,0-0.3,0-0.5,0
			c-22-0.2-38.9-7.2-51.4-21.4C157.7,176.2,164.5,107.9,164.6,107.3z" fill="#fff"/>
		<path d="M446.8,383.6c0-0.1,0-0.2,0-0.3c0-0.8-0.1-1.6-0.1-2.5c-0.6-19.8-1.9-66.1-45.3-80.9c-0.3-0.1-0.7-0.2-1-0.3
			c-45.1-11.5-82.6-37.5-83-37.8c-6.1-4.3-14.5-2.8-18.8,3.3c-4.3,6.1-2.8,14.5,3.3,18.8c1.7,1.2,41.5,28.9,91.3,41.7
			c23.3,8.3,25.9,33.2,26.6,56c0,0.9,0,1.7,0.1,2.5c0.1,9-0.5,22.9-2.1,30.9c-16.2,9.2-79.7,41-176.3,41
			c-96.2,0-160.1-31.9-176.4-41.1c-1.6-8-2.3-21.9-2.1-30.9c0-0.8,0.1-1.6,0.1-2.5c0.7-22.8,3.3-47.7,26.6-56
			c49.8-12.8,89.6-40.6,91.3-41.7c6.1-4.3,7.6-12.7,3.3-18.8c-4.3-6.1-12.7-7.6-18.8-3.3c-0.4,0.3-37.7,26.3-83,37.8
			c-0.4,0.1-0.7,0.2-1,0.3c-43.4,14.9-44.7,61.2-45.3,80.9c0,0.9,0,1.7-0.1,2.5c0,0.1,0,0.2,0,0.3c-0.1,5.2-0.2,31.9,5.1,45.3
			c1,2.6,2.8,4.8,5.2,6.3c3,2,74.9,47.8,195.2,47.8s192.2-45.9,195.2-47.8c2.3-1.5,4.2-3.7,5.2-6.3
			C447,415.5,446.9,388.8,446.8,383.6z" fill="#fff"/>
	
</svg></span>
</a>
            <a href="#"><span class="icn"> 
<svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="25px" hright="25px"
	 viewBox="0 0 31.012 31.012" style="enable-background:new 0 0 31.012 31.012;" xml:space="preserve">

		<path d="M25.109,21.51c-0.123,0-0.246-0.045-0.342-0.136l-5.754-5.398c-0.201-0.188-0.211-0.505-0.022-0.706
			c0.189-0.203,0.504-0.212,0.707-0.022l5.754,5.398c0.201,0.188,0.211,0.505,0.022,0.706C25.375,21.457,25.243,21.51,25.109,21.51z
			"/>
		<path d="M5.902,21.51c-0.133,0-0.266-0.053-0.365-0.158c-0.189-0.201-0.179-0.518,0.022-0.706l5.756-5.398
			c0.202-0.188,0.519-0.18,0.707,0.022c0.189,0.201,0.179,0.518-0.022,0.706l-5.756,5.398C6.148,21.465,6.025,21.51,5.902,21.51z"/>

	<path d="M28.512,26.529H2.5c-1.378,0-2.5-1.121-2.5-2.5V6.982c0-1.379,1.122-2.5,2.5-2.5h26.012c1.378,0,2.5,1.121,2.5,2.5v17.047
		C31.012,25.408,29.89,26.529,28.512,26.529z M2.5,5.482c-0.827,0-1.5,0.673-1.5,1.5v17.047c0,0.827,0.673,1.5,1.5,1.5h26.012
		c0.827,0,1.5-0.673,1.5-1.5V6.982c0-0.827-0.673-1.5-1.5-1.5H2.5z" fill="#fff"/>
	<path d="M15.506,18.018c-0.665,0-1.33-0.221-1.836-0.662L0.83,6.155C0.622,5.974,0.6,5.658,0.781,5.449
		c0.183-0.208,0.498-0.227,0.706-0.048l12.84,11.2c0.639,0.557,1.719,0.557,2.357,0L29.508,5.419
		c0.207-0.181,0.522-0.161,0.706,0.048c0.181,0.209,0.16,0.524-0.048,0.706L17.342,17.355
		C16.835,17.797,16.171,18.018,15.506,18.018z" fill="#fff"/>

</svg></span>
</a>
            <a class="active" href="#"> <span class="icn"> 
<svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="25px" height="25px"
	 viewBox="0 0 395.636 395.636" style="enable-background:new 0 0 395.636 395.636;" xml:space="preserve">
<polygon style="fill:#fff;" points="373.398,53.786 373.398,389.43 69.883,389.43 69.883,341.85 22.238,341.85 22.238,6.206 
	325.754,6.206 325.754,53.786 "/>
<path style="fill:#fff;" d="M331.96,47.58V0H16.097v348.057h47.58v47.58h315.863V47.58H331.96z M28.444,12.347h291.168v323.297
	H28.444V12.347z M367.192,383.289H76.024v-35.232H331.96V59.992h35.232V383.289z"/>
<rect x="46.998" y="30.901" style="fill:#fff;" width="254.061" height="286.19"/>

	<rect x="85.915" y="176.808" style="fill:#f;" width="176.162" height="12.347"/>
	<rect x="85.915" y="145.907" style="fill:#193651;" width="176.162" height="12.347"/>
	<rect x="85.915" y="207.709" style="fill:#193651;" width="176.162" height="12.347"/>
	<rect x="85.915" y="238.028" style="fill:#193651;" width="105.697" height="12.347"/>
	<rect x="85.915" y="99.556" style="fill:#193651;" width="12.347" height="12.347"/>
	<rect x="114.36" y="99.556" style="fill:#193651;" width="12.347" height="12.347"/>
	<rect x="142.804" y="99.556" style="fill:#193651;" width="12.347" height="12.347"/>
	
</svg> </span>
            </a>
            <a href="#"> <span class="icn">  <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="25px" height="25px"
	 viewBox="0 0 512 512" style="enable-background:new 0 0 512 512;" xml:space="preserve">
<rect x="15.564" y="98.306" style="fill:#FFFFFF;" width="404.086" height="337.685"/>
<path style="fill:#CCCCCC;" d="M415.643,102.314v329.693H19.548V102.314H415.643 M423.635,94.313H11.556v345.693h412.086V94.313
	H423.635z"/>
<rect x="45.445" y="141.946" style="fill:#FFFFFF;" width="344.325" height="264.164"/>
<path style="fill:#CCCCCC;" d="M385.754,145.938v256.18H49.445v-256.18H385.754 M393.754,137.938H41.445v272.18h352.309
	L393.754,137.938L393.754,137.938z"/>
<rect x="11.556" y="35.505" style="fill:#E21B1B;" width="412.086" height="79.425"/>

	<rect x="84.597" style="fill:#1A1718;" width="24" height="71.457"/>
	<rect x="326.609" style="fill:#1A1718;" width="24" height="71.457"/>

<path style="fill:#333333;" d="M359.01,229.164c-78.097,0.008-141.41,63.321-141.402,141.426S280.928,512.008,359.034,512
	c78.097-0.008,141.402-63.313,141.41-141.41c0.008-78.105-63.305-141.418-141.41-141.426
	C359.026,229.164,359.018,229.164,359.01,229.164z"/>
<polygon style="fill:#FFFFFF;" points="408.202,305.317 337.409,392.622 307.665,363.254 288.048,384.87 339.713,435.855 
	429.995,324.517 "/>
</svg></span> </a>
        </div>
    </div>
    <span class="open-nav" style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;</span>-->
        <span style="font-size:30px;cursor:pointer; float:right; color:white; margin-right:20px;" onclick="openNav()">&#9776;</span>
    
            <div id="mySidenav" class="rightsidenav">
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                    <ul class="full-nav">
                        <li><a href="AdminPanel.jsp">Dashboard</a></li>
                        <li><a href="logout">Log Out</a></li>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Contact Us</a></li>
                    </ul>
            </div>



    <section class="header">
        <div class="container">
            <div class="row">
                <div class=" col-lg-2 col-md-2 col-sm-2 col-xs-12">
                </div>
               <!-- <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
                    <form>
                        <input class="search" type="text" name="search" value="" placeholder="search">
                        <button type="submit" <i class="fa fa-search btn" aria-hidden="true" style="color:#fff;">
                            </i>
                        </button>
                    </form>
                </div>
                <div class="col-md-2 col-lg-2 col-sm-2 col-xs-12">
                    <div class="date">
                        <p> 10/02/2016 - 11/02/2017 <i class="fa fa-caret-down" aria-hidden="true" style="color:#fff;"></i>
                        </p>
                    </div>
                </div>-->
            </div>
        </div>
    </section>

    <section class="dashoard">
        <div class="container indx">
            <div class="row">
                <div class="col-md-5">
                    <div class="admin">
                        <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="100px" height="100px" viewBox="0 0 55 55" style="enable-background:new 0 0 55 55;" xml:space="preserve">
                            <path d="M55,27.5C55,12.337,42.663,0,27.5,0S0,12.337,0,27.5c0,8.009,3.444,15.228,8.926,20.258l-0.026,0.023l0.892,0.752
	c0.058,0.049,0.121,0.089,0.179,0.137c0.474,0.393,0.965,0.766,1.465,1.127c0.162,0.117,0.324,0.234,0.489,0.348
	c0.534,0.368,1.082,0.717,1.642,1.048c0.122,0.072,0.245,0.142,0.368,0.212c0.613,0.349,1.239,0.678,1.88,0.98
	c0.047,0.022,0.095,0.042,0.142,0.064c2.089,0.971,4.319,1.684,6.651,2.105c0.061,0.011,0.122,0.022,0.184,0.033
	c0.724,0.125,1.456,0.225,2.197,0.292c0.09,0.008,0.18,0.013,0.271,0.021C25.998,54.961,26.744,55,27.5,55
	c0.749,0,1.488-0.039,2.222-0.098c0.093-0.008,0.186-0.013,0.279-0.021c0.735-0.067,1.461-0.164,2.178-0.287
	c0.062-0.011,0.125-0.022,0.187-0.034c2.297-0.412,4.495-1.109,6.557-2.055c0.076-0.035,0.153-0.068,0.229-0.104
	c0.617-0.29,1.22-0.603,1.811-0.936c0.147-0.083,0.293-0.167,0.439-0.253c0.538-0.317,1.067-0.648,1.581-1
	c0.185-0.126,0.366-0.259,0.549-0.391c0.439-0.316,0.87-0.642,1.289-0.983c0.093-0.075,0.193-0.14,0.284-0.217l0.915-0.764
	l-0.027-0.023C51.523,42.802,55,35.55,55,27.5z M2,27.5C2,13.439,13.439,2,27.5,2S53,13.439,53,27.5
	c0,7.577-3.325,14.389-8.589,19.063c-0.294-0.203-0.59-0.385-0.893-0.537l-8.467-4.233c-0.76-0.38-1.232-1.144-1.232-1.993v-2.957
	c0.196-0.242,0.403-0.516,0.617-0.817c1.096-1.548,1.975-3.27,2.616-5.123c1.267-0.602,2.085-1.864,2.085-3.289v-3.545
	c0-0.867-0.318-1.708-0.887-2.369v-4.667c0.052-0.519,0.236-3.448-1.883-5.864C34.524,9.065,31.541,8,27.5,8
	s-7.024,1.065-8.867,3.168c-2.119,2.416-1.935,5.345-1.883,5.864v4.667c-0.568,0.661-0.887,1.502-0.887,2.369v3.545
	c0,1.101,0.494,2.128,1.34,2.821c0.81,3.173,2.477,5.575,3.093,6.389v2.894c0,0.816-0.445,1.566-1.162,1.958l-7.907,4.313
	c-0.252,0.137-0.502,0.297-0.752,0.476C5.276,41.792,2,35.022,2,27.5z M42.459,48.132c-0.35,0.254-0.706,0.5-1.067,0.735
	c-0.166,0.108-0.331,0.216-0.5,0.321c-0.472,0.292-0.952,0.57-1.442,0.83c-0.108,0.057-0.217,0.111-0.326,0.167
	c-1.126,0.577-2.291,1.073-3.488,1.476c-0.042,0.014-0.084,0.029-0.127,0.043c-0.627,0.208-1.262,0.393-1.904,0.552
	c-0.002,0-0.004,0.001-0.006,0.001c-0.648,0.16-1.304,0.293-1.964,0.402c-0.018,0.003-0.036,0.007-0.054,0.01
	c-0.621,0.101-1.247,0.174-1.875,0.229c-0.111,0.01-0.222,0.017-0.334,0.025C28.751,52.97,28.127,53,27.5,53
	c-0.634,0-1.266-0.031-1.895-0.078c-0.109-0.008-0.218-0.015-0.326-0.025c-0.634-0.056-1.265-0.131-1.89-0.233
	c-0.028-0.005-0.056-0.01-0.084-0.015c-1.322-0.221-2.623-0.546-3.89-0.971c-0.039-0.013-0.079-0.027-0.118-0.04
	c-0.629-0.214-1.251-0.451-1.862-0.713c-0.004-0.002-0.009-0.004-0.013-0.006c-0.578-0.249-1.145-0.525-1.705-0.816
	c-0.073-0.038-0.147-0.074-0.219-0.113c-0.511-0.273-1.011-0.568-1.504-0.876c-0.146-0.092-0.291-0.185-0.435-0.279
	c-0.454-0.297-0.902-0.606-1.338-0.933c-0.045-0.034-0.088-0.07-0.133-0.104c0.032-0.018,0.064-0.036,0.096-0.054l7.907-4.313
	c1.36-0.742,2.205-2.165,2.205-3.714l-0.001-3.602l-0.23-0.278c-0.022-0.025-2.184-2.655-3.001-6.216l-0.091-0.396l-0.341-0.221
	c-0.481-0.311-0.769-0.831-0.769-1.392v-3.545c0-0.465,0.197-0.898,0.557-1.223l0.33-0.298v-5.57l-0.009-0.131
	c-0.003-0.024-0.298-2.429,1.396-4.36C21.583,10.837,24.061,10,27.5,10c3.426,0,5.896,0.83,7.346,2.466
	c1.692,1.911,1.415,4.361,1.413,4.381l-0.009,5.701l0.33,0.298c0.359,0.324,0.557,0.758,0.557,1.223v3.545
	c0,0.713-0.485,1.36-1.181,1.575l-0.497,0.153l-0.16,0.495c-0.59,1.833-1.43,3.526-2.496,5.032c-0.262,0.37-0.517,0.698-0.736,0.949
	l-0.248,0.283V39.8c0,1.612,0.896,3.062,2.338,3.782l8.467,4.233c0.054,0.027,0.107,0.055,0.16,0.083
	C42.677,47.979,42.567,48.054,42.459,48.132z" />
                             <h3 class="dash-txt" style="color:#fff;"> <%= objbean.getName()%> </h3>

                            <hr class="dash">
                            <div class="admin-lnks">
                                <ul>
                                    <li>
                                    <p class="dash-txt" style="color:#fff;"> <%= objbean.getType()%> </p>
                                    </li>
                                    <li>
                                    <p class="dash-txt" style="color:#fff;"> <%= objbean.getEmail()%> </p>
                                    </li>
                                    <li><a href="ManageUser.jsp">Manage User</a>
                                    </li>
                                    <li><a href="UserReport.jsp"> User Report </a>
                                    </li>
                                </ul>
                            </div>
                        </svg>

                    </div>
                </div>
                <div class="col-md-7">
                </div>
            </div>
        </div>
    </section>

    <section class="user-report-table">
        <div style="padding-left: 300px" >
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <table class="table" style="color:black">
                        <thead>
                             <tr>
                                <th>Email</th>
                                <th>Name</th>
                                <th>Login Time</th>
                                <th>Logout Time</th>
                            </tr>
                        </thead>
                        <tbody>
             
            <% int pg = 0;
                if (request.getParameter("pg") != null) {
                    pg = Integer.parseInt(request.getParameter("pg"));
                } else {
                    pg = 1;
                }
                ArrayList<ActivityBean> al = UserMaintenanceServices.getAllActivity(pg);
                for (int i =0;i<al.size();i++) 
                {
                    ActivityBean objbean1 = al.get(i);
            %>
            <tr>
                <td><%= objbean1.getEmail()%></td>
                <td><%= objbean1.getName()%></td>
                <td><%= objbean1.getLogintime()%></td>
                <td><%= objbean1.getLogouttime()%></td>
            </tr>
            <%
                }
            %>
        </table><br>
        <div style="color: black; background-color: #1A1718; text-align: center;">
        <%
             int count=UserMaintenanceServices.numberOfActivity();
             int j=0;
             if(count%10==0)
             {
                 j=count/10;
             }
             else
             {
                 j=(count/10)+1;
             }
             for(int i=1;i<=j;i++)
             {
                 out.println("&nbsp;&nbsp;<a href='UserReport.jsp?pg="+i+"'>"+i+"</a>");
             }
        %>
                
        <br>
        <br>
        <button onclick="location.href='AdminPanel.jsp'">Back</button>
        </div>
    </body>
                        </tbody>
                    </table>
                </div>
  <%
             }
             else
             {
        %>
        <h4>Your Session Expired....Please Login Again!! </h4>
        
        <%        
             }
        %>

                <script>
                    function openNav() {
                        document.getElementById("mySidenav").style.width = "100%";
                    }

                    function closeNav() {
                        document.getElementById("mySidenav").style.width = "0";
                    }
                </script>
                <!-- js files -->
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>


</body>
    </body>
</html>
