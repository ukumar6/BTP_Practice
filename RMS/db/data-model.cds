namespace rms.db;

using { managed,cuid } from '@sap/cds/common';
using { rms.db.commons as common } from './commons';


context master {
    entity master : managed {
        key empID : String(10);
        empName : String(70);
        empPhone : common.PhoneNumber;
        empEmail : common.EmailAddress;
        currentBalance : common.AmountT;
        transactions : Association to many transactions.trans on transactions.empID = $self;
    }

    entity description : managed {
        sNo : Int16;
        key details : String(50);
        transactions : Association to many transactions.trans on transactions.description = $self;
    }
}
context transactions {
    entity trans : cuid, managed {
        empID : Association to one master.master;
        transType: String(2);
        description: Association to one master.description;
        amount : common.AmountT;
        balance : common.AmountT; 
        comments : String(100);
    }        
}