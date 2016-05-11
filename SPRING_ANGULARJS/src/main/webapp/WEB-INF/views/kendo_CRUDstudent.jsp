<!DOCTYPE html>
<html>
<head>
    
    <style>html { font-size: 14px; font-family: Arial, Helvetica, sans-serif; }</style>
    <title></title>
    <link rel="stylesheet" href="//kendo.cdn.telerik.com/2016.1.412/styles/kendo.common-bootstrap.min.css" />
    <link rel="stylesheet" href="//kendo.cdn.telerik.com/2016.1.412/styles/kendo.bootstrap.min.css" />

    <script src="//kendo.cdn.telerik.com/2016.1.412/js/jquery.min.js"></script>
    <script src="//kendo.cdn.telerik.com/2016.1.412/js/kendo.all.min.js"></script>
</head>
<body>
        <div id="crud">
            <div id="grid"></div>

            <script>
                $(document).ready(function () {
                    var crudServiceBaseUrl = "/web/student",
                        dataSource = new kendo.data.DataSource({
                            transport: {
                                read:  {
                                    url: crudServiceBaseUrl + "/all",
                                    dataType: "json",
                                    contentType: "application/json",
                                    type: "get"
                                },
                                update: {
                                	url: function (data) {
                                        return crudServiceBaseUrl + "/update/" + data.models[0].id;
                                      },
                                    dataType: "json",
                                    contentType: "application/json",
                                    type: "post",                                 
                                    complete: function (e) {
                                        $("#grid").data("kendoGrid").dataSource.read();
                                    }
                                   
                                },
                                destroy: {
                                	url: function (data) {
                                        return crudServiceBaseUrl + "/delete/" + data.models[0].id;
                                    },
                                    dataType: "json",
                                    contentType: "application/json",
                                    type: "post",
                                    complete: function (e) {
                                        $("#grid").data("kendoGrid").dataSource.read();
                                    }
                                },
                                create: {
                                    url: crudServiceBaseUrl + "/add",
                                    dataType: "json",
                                    contentType: "application/json",
                                    type: "post",
                                    complete: function (e) {
                                        $("#grid").data("kendoGrid").dataSource.read();
                                    }
                                    
                                },
                                
                                parameterMap: function(options, operation) {
                                    if (operation == "create" && options.models) {
                                        return kendo.stringify(options.models[0]);
                                    }else if (operation == "read" && options.models) {
                                        return {models: kendo.stringify(options.models)};
                                    }else if (operation == "update" && options.models) {
                                        return kendo.stringify(options.models[0]);
                                    }else if(operation == "destroy" && options.models){
                                    	return kendo.stringify(options.models[0]);
                                    }
                                }
                            },
                            batch: true,
                            pageSize: 3,
                            schema: {
                                model: {
                                    id: "id",
                                    fields: {
                                        id: { editable: false, nullable: true },
                                        name: { validation: { required: true } },
                                        dateOfBirth: { validation: { required: true } },
                                        sex: { validation: { required: true },
                                        address: { validation: { required: true } },
                                       	//school: { defaultValue: { id: "id", name: "name"} } 
                                        }
                                    }
                                }
                            }
                        });

                    $("#grid").kendoGrid({
                        dataSource: dataSource,
                        pageable: true,
                        height: 550,
                        toolbar: ["create"],
                        columns: [
                            { field:"name", title: "Name" , width: "120px"},
                            { field: "dateOfBirth", title:"Date Of Birth", width: "220px" },
                            { field: "sex", title:"Sex", width: "120px" },
                            { field: "address", title:"Address", width: "120px" },
                            { field: "school", title:"School", width: "120px",
                            	template: function(item){
                            		return item.school.name;
                            	}
                            },
                            { command: ["edit", "destroy"], title: "&nbsp;", width: "250px" }],
                        editable: "popup"
                    });
                    
                    
                });
            </script>
        </div>


</body>
</html>
