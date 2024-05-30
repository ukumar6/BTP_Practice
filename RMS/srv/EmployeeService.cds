using { rms.db.master, rms.db.transactions } from '../db/data-model';

service EmployeeService @(path: 'EmployeeService') {
    
    entity EmployeeData as projection on master.master;
    @readonly
    entity RewardData as projection on transactions.trans;    

}

