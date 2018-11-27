<%-- 
    Document   : ActivityLog
    Created on : 15 May, 2017, 12:47:24 PM
    Author     : SURUCHI
--%>
<%@page import="lazybones.services.UserMaintenanceServices"%>
<%@page import="java.util.ArrayList"%>
<%@page import="lazybones.services.ManageProfileServices"%>
<%@page import="lazybones.beans.UserBean"%>
<%@page import="lazybones.beans.DocumentBean"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="https://fonts.googleapis.com/css?family=Poppins:300" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome.css">

    <link rel="stylesheet" href="bootstrap.min.css">

    <link rel="stylesheet" href="style.css">
        <title>Activity</title>
          <style>
        #left, #right { 
                height: 480px;
                margin:1px; 
                padding: 1em; 
                padding-bottom: 30px;
            } 
            #left  { float:left; 
            }
            #right { float:right;
            }  
            .round-button {
                width:25%;
            }
            .round-button-circle {
                float: right;
                border-radius: 50%;
                border:10px solid #C0C0C0;
                overflow:hidden;
                background: #000000; 
                box-shadow: 0 0 3px gray;
            }
            .round-button-circle:hover {
                background:#f9b332;
            }
            .round-button a {
                display:block;
                float:left;
                padding: 60px 20px 60px 20px;
                line-height:1em;
                text-align:center;
                color:#e2eaf3;
                font-family:Times New Roman;
                font-size:0.9em;
                font-weight:bold;
                text-decoration:none;
            }
        .popup {
                position: relative;
                display: inline-block;
                cursor: pointer;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
            }

            /* The actual popup */
            .popup .popuptext {
                visibility: hidden;
                width: 230px;
                background-color: #555;
                color: #fff;
                text-align: center;
                border-radius: 6px;
                padding: 8px 0;
                position: absolute;
                z-index: 1;
                bottom: 125%;
                left: 50%;
                margin-left: -80px;
            }

            /* Popup arrow */
            .popup .popuptext::after {
                content: "";
                position: absolute;
                top: 100%;
                left: 50%;
                margin-left: -5px;
                border-width: 5px;
                border-style: solid;
                border-color: #555 transparent transparent transparent;
            }

            /* Toggle this class - hide and show the popup */
            .popup .show {
                visibility: visible;
                -webkit-animation: fadeIn 1s;
                animation: fadeIn 1s;
            }
        </style>
    </head>
    <body>
         <%
            if(session!=null)
            {
                int userid=(int)session.getAttribute("userid");
                UserBean objbean=ManageProfileServices.getDashboard(userid);
        %>
       
        <%
             userid=0;
            if(session!=null)
            {
               userid=(int)session.getAttribute("userid");
        %>
       <span style="font-size:30px;cursor:pointer; float:right; color:white; margin-right:20px;" onclick="openNav()">&#9776;</span>
    
            <div id="mySidenav" class="rightsidenav">
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                    <ul class="full-nav">
                        <li><a href="UserPanel.jsp">Dashboard</a></li>
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
                </div>-->
               <!-- <div class="col-md-2 col-lg-2 col-sm-2 col-xs-12">
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

                            <h3 class="dash-txt" style="color:#fff;"><%= objbean.getName()%> </h3>
                            
                            <hr class="dash">
                            <div class="admin-lnks">
                                <ul>
                                    
                                    <li><p class="dash-txt" style="color:#fff;"><%= objbean.getType()%> </p></li>
                                    <li><p class="dash-txt" style="color:#fff;"><%= objbean.getEmail()%> </p> </li>
                                    
                                    <li> 
                                        <div class="popup" onclick="myFunction()" style="color: white; font-size: 25px;">FeedBack
                                <span class="popuptext" id="myPopup">
                                    <button style="width:40%; color: #555">like</button>&nbsp;
                                    <button style="width:40%; color: #555">dislike</button>
                                </span>
                                        </div></li>
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


    <section class="manage-user-table">
        <div style="padding-left: 300px;">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="manage-table">
                        <table class="table" style="color:black">
                            <thead>
                               
                        <tr>
                           <th>Document Name</th>
                            <th>Date And Time</th>
                            <th>Document Type</th>
                            <th>Download Link</th>
                        </tr>
                            </thead>
                            <tbody>
                <% int pg = 0;
                if (request.getParameter("pg") != null) {
                    pg = Integer.parseInt(request.getParameter("pg"));
                } else {
                    pg = 1;
                }
                ArrayList<DocumentBean> al = ManageProfileServices.getDocuments(userid,pg);
                for (int i = 0; i < al.size(); i++) {
                    DocumentBean objbean1 = al.get(i);
                    File f=new File(objbean1.getName());
                    String url="download?path="+objbean1.getName();
            %>
            <tr>
                <td><%=f.getName() %></td>
                <td><%= objbean1.getDate_time()%></td>
                <td><%= objbean1.getType()%></td>
                <td ><a href=<%= url%>style="color:#f9b332" >Download</a></td>
            </tr>
            <%
                }
            %>
        </table>
        <div style="color: black; background-color: #1A1718; text-align: center;">
        
        <%
             int count=ManageProfileServices.numberOfDocuments(userid);
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
                 out.println("&nbsp;&nbsp;<a href='ActivityLog.jsp?pg="+i+"'>"+i+"</a>");
             }
        }
        %>
        
        <br>
        <br>
       
        <button onclick="location.href='UserPanel.jsp'">Back</button>

            </div>                  
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </section>
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
</html>
