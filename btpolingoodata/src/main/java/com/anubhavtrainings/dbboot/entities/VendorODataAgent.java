package com.anubhavtrainings.dbboot.entities;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.olingo.odata2.api.edm.EdmEntitySet;
import org.springframework.beans.factory.annotation.Autowired;

import com.anubhavtrainings.dbboot.processor.ODataInterface;
import com.anubhavtrainings.dbboot.service.IVendorPersistence;

public class VendorODataAgent implements ODataInterface {

    @Autowired
    IVendorPersistence vendorDB;

    @Override
    public List<?> getEntitySet() {
        // TODO Auto-generated method stub
        return vendorDB.findAll();
        // throw new UnsupportedOperationException("Unimplemented method
        // 'getEntitySet'");
    }

    @Override
    public Object getEntity(Map<String, ?> keys) {
        // TODO Auto-generated method stub
        return vendorDB.findById((String) keys.get("Id")).get();
        // throw new UnsupportedOperationException("Unimplemented method 'getEntity'");
    }

    @Override
    public List<?> getRelatedEntity(Object source, String relatedEntityName, Map<String, Object> keys,
            Field sourceField) {
        // TODO Auto-generated method stub
        Vendor p;
        try {
            p = (Vendor) source;
        } catch (Exception e) {
            // TODO: handle exception
            Map<String, String> targetKey = (Map<String, String>) source;
            String vendorId = targetKey.get("Id");
            p = vendorDB.findById(vendorId).get();
        }

        if (relatedEntityName.equalsIgnoreCase("AddressSet")) {
            return p.getAddresses();
        }

        return new ArrayList<>();
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'getRelatedEntity'");
    }

    @Override
    public void createEntity(Object dataToCreate) {
        // TODO Auto-generated method stub
        vendorDB.save((Vendor) dataToCreate);
        // throw new UnsupportedOperationException("Unimplemented method
        // 'createEntity'");
    }

    @Override
    public void deleteEntity(Map<String, ?> keys) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'deleteEntity'");
        vendorDB.deleteById((String) keys.get("Id"));
    }

    @Override
    public void updateEntity(Object dataToUpdate) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'updateEntity'");
        vendorDB.save((Vendor) dataToUpdate);
    }

    @Override
    public void writeRelation(EdmEntitySet sourceEntitySet, Object sourceData, EdmEntitySet targetEntitySet,
            Map<String, Object> targetKeys) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeRelation'");
    }

}
