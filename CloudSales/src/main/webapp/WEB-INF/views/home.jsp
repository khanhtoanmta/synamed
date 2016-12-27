<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<html>
<head>
    <title>HTML</title>
    
	<spring:url value="/resources/js/angular.min.js" var="angularJS" />
	<spring:url value="/resources/js/jquery-2.2.3.min.js" var="jQuery" />
	<spring:url value="/resources/js/kendo.all.min.js" var="kendoUI" />
	
	<link href="${angularJS}" rel="stylesheet" />
    <script src="${jQuery}"></script>
    <script src="${kendoUI}"></script>
</head>
<body>
<div id="example" ng-app="KendoDemos">
    <div ng-controller="MyCtrl">
        <kendo-grid options="mainGridOptions">
            <div k-detail-template>
                <kendo-tabstrip>
                <ul>
                    <li class="k-state-active">Orders</li>
                    <li>Contact information</li>
                </ul>
                <div>
                    <div kendo-grid k-options="detailGridOptions(dataItem)"></div>
                </div>
                <div>
                    <ul>
                        <li>Country: <input ng-model="dataItem.Country" /></li>
                        <li>City: <input ng-model="dataItem.City" /></li>
                        <li>Address: {{dataItem.Address}}</li>
                        <li>Home phone: {{dataItem.HomePhone}}</li>
                    </ul>
                </div>
                </kendo-tabstrip>
            </div>
        </kendo-grid>


    </div>
</div>

<script>
    angular.module("KendoDemos", [ "kendo.directives" ])
        .controller("MyCtrl", function($scope){
            $scope.mainGridOptions = {
                dataSource: {
                    type: "odata",
                    transport: {
                        read: "//demos.telerik.com/kendo-ui/service/Northwind.svc/Employees"
                    },
                    pageSize: 5,
                    serverPaging: true,
                    serverSorting: true
                },
                sortable: true,
                pageable: true,
                dataBound: function() {
                    this.expandRow(this.tbody.find("tr.k-master-row").first());
                },
                columns: [{
                    field: "FirstName",
                    title: "First Name",
                    width: "120px"
                    },{
                    field: "LastName",
                    title: "Last Name",
                    width: "120px"
                    },{
                    field: "Country",
                    width: "120px"
                    },{
                    field: "City",
                    width: "120px"
                    },{
                    field: "Title"
                }]
            };

            $scope.detailGridOptions = function(dataItem) {
                return {
                    dataSource: {
                        type: "odata",
                        transport: {
                            read: "//demos.telerik.com/kendo-ui/service/Northwind.svc/Orders"
                        },
                        serverPaging: true,
                        serverSorting: true,
                        serverFiltering: true,
                        pageSize: 5,
                        filter: { field: "EmployeeID", operator: "eq", value: dataItem.EmployeeID }
                    },
                    scrollable: false,
                    sortable: true,
                    pageable: true,
                    columns: [
                    { field: "OrderID", title:"ID", width: "56px" },
                    { field: "ShipCountry", title:"Ship Country", width: "110px" },
                    { field: "ShipAddress", title:"Ship Address" },
                    { field: "ShipName", title: "Ship Name", width: "190px" }
                    ]
                };
            };
        })
</script>


</body>
</html>
