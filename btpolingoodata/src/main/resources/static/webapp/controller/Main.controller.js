sap.ui.define([
    'sap/ui/core/mvc/Controller',
    'sap/ui/model/odata/v2/ODataModel',
    'sap/ui/model/json/JSONModel',
    'sap/m/MessageBox'
], function(Controller, ODataModel, JSONModel, MessageBox) {
    'use strict';
    return Controller.extend("donald.controller.Main",{
        //Class have a constructor
        onInit: function(){
            //Create our Model object of type odata based on current relative path
            var oDataModel = new ODataModel("/anubhav.svc/");
            //Set the model object at application level
            sap.ui.getCore().setModel(oDataModel);
            //Local model - like a internal table for manipulating the data
            var oModel = new JSONModel({
                data: {
                    Code: "",
                    CompanyName: "IBM",
                    ContactPerson: "",
                    FirstName: "",
                    LastName: "",
                    Website: "",
                    Email: "",
                    Status: 1,
                    RegDate: new Date()
                }
            });
            //Set it as local model
            sap.ui.getCore().setModel(oModel, "local");
        },
        onCreate: function(){
            //Get the data from json model -- equal to payload
            var oModel = sap.ui.getCore().getModel("local");
            var payload = oModel.getProperty("/data");
            //get Odata model object
            var oDataModel = sap.ui.getCore().getModel();
            //Fire create - POST operation on odata
            oDataModel.create("/VendorSet", payload, {
                success: function(data){
                    MessageBox.confirm("Your vendor is created with code " + data.Code);
                },
                error: function(oError){
                    MessageBox.error("Oops!! something went wrong");
                }
            })
        }
    });
});