using { rms.db.master as m, rms.db.transactions as t} from '../db/data-model';

service AdminService @(path:'AdminService') {

    entity EmployeeData as projection on m.master;
    entity Description as projection on m.description;
    entity Transactions as projection on t.trans;    

}
