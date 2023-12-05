<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MartTech Client Queue</title>
        <link rel="stylesheet" type = "text/css" href="mystyle.css" />
        
    </head>
     <% Date date = new Date();%>
    <body>       
        <header>
            <h1>Client Queue</h1>
            <p>Current date and time: <br><%= date %></p>
        </header>
            
        <main>
            <form id = "queueform" action="ServletQueue" method="post">
                <fieldset class="QueueName">
                    <legend> Customer Name </legend>
                    <div>
                        <label for ="name">Full Name:</label>
                        <input type="text" id="name" name="name">                       
                    </div>
                    <div>                        
                        <input type="submit" name="push" value="Push Customer" class="buttons">                                          
                    </div>
                </fieldset>
                <fieldset class="QueueOps">
                    <legend>Queue Operation</legend>
                    <div id="queueOpsContainer">
                        <%=request.getAttribute("pushops") != null ? request.getAttribute("pushops") : ""%>
                        <%=request.getAttribute("enqueuecust") != null ? request.getAttribute("enqueuecust") : ""%>
                        <%=request.getAttribute("dequeuecust") != null ? request.getAttribute("dequeuecust") : ""%>
                        <%=request.getAttribute("peekcust") != null ? request.getAttribute("peekcust") : ""%>
                        <%=request.getAttribute("emptyqueue") != null ? request.getAttribute("emptyqueue") : ""%>
                        <%=request.getAttribute("queuesize") != null ? request.getAttribute("queuesize") : ""%>
                        <%=request.getAttribute("queueservice") != null ? request.getAttribute("queueservice") : ""%>
                        <%=request.getAttribute("clearqueue") != null ? request.getAttribute("clearqueue") : ""%>
                    </div>
                    <div>
                        <input type="submit" name="enqueue" value="Enqueue" class="buttons">
                        <input type="submit" name="dequeue" value="Dequeue" class="buttons">
                        <input type="submit" name="peek" value="Peek" class="buttons">
                        <input type="submit" name="serviced" value="Serviced" class="buttons">
                        <input type="submit" name="size" value="Size" class="buttons">
                        <input type="submit" name="empty" value="Empty" class="buttons"> 
                    </div>
                </fieldset>
                <fieldset class="LiveQueue">
                    <legend>Live Queue</legend>
                    <div id="queueList">
                        <%=request.getAttribute("pushUpdate") != null ? request.getAttribute("pushUpdate") : ""%>                                                     
                    </div>
                    <div>
                        <input type="submit" name="clear" value="Clear Queue" class="buttons">
                    </div>                     
                </fieldset>
            </form>                                                            
        </main>                           
    </body>
</html>