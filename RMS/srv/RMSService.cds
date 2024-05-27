using { rms.db.master as m} from '../db/data-model';

service CatalogService @(path:'CatalogService') {

    entity master as projection on m.master;
    entity transactions as projection on m.transactions;

}