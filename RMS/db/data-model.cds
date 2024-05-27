namespace rms.db;

using { managed } from '@sap/cds/common';
using { rms.db.commons as common } from './commons';


context master {
    entity master : managed {
        key empID : String(10);
        empName : String(70);
        empPhone : common.PhoneNumber;
        empEmail : common.EmailAddress;
        currentBalance : common.AmountT;
        transactions : Composition of many transactions on transactions.empID = $self;
    }

    entity transactions : managed {
        key transId: common.Guid;
        empID : Association to one master;
        transType: common.transType;
        description: String(100);
        amount : common.AmountT;
        balance : common.AmountT;        
    }        
}