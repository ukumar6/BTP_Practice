package com.anubhavtrainings.dbboot.entities;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.olingo.odata2.api.edm.EdmEntitySet;
import org.springframework.beans.factory.annotation.Autowired;

import com.anubhavtrainings.dbboot.processor.ODataInterface;
import com.anubhavtrainings.dbboot.service.IAddressPersistence;

public class AddressODataAgent implements ODataInterface {

    @Autowired
    IAddressPersistence addressDB;

    @Override
    public List<?> getEntitySet() {
        // TODO Auto-generated method stub
        return addressDB.findAll();
        // throw new UnsupportedOperationException("Unimplemented method
        // 'getEntitySet'");
    }

    @Override
    public Object getEntity(Map<String, ?> keys) {
        // TODO Auto-generated method stub
        return addressDB.findById((String) keys.get("AddressId")).get();
        // throw new UnsupportedOperationException("Unimplemented method 'getEntity'");
    }

    @Override
    public List<?> getRelatedEntity(Object source, String relatedEntityName, Map<String, Object> keys,
            Field sourceField) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRelatedEntity'");
    }

    @Override
    public void createEntity(Object dataToCreate) {
        // TODO Auto-generated method stub
        addressDB.save((Address) dataToCreate);
        // throw new UnsupportedOperationException("Unimplemented method
        // 'createEntity'");
    }

    @Override
    public void deleteEntity(Map<String, ?> keys) {
        // TODO Auto-generated method stub
        addressDB.findById((String) keys.get("AddressId"));
        // throw new UnsupportedOperationException("Unimplemented method
        // 'deleteEntity'");
    }

    @Override
    public void updateEntity(Object dataToUpdate) {
        // TODO Auto-generated method stub
        addressDB.save((Address) dataToUpdate);
        // throw new UnsupportedOperationException("Unimplemented method
        // 'updateEntity'");
    }

    @Override
    public void writeRelation(EdmEntitySet sourceEntitySet, Object sourceData, EdmEntitySet targetEntitySet,
            Map<String, Object> targetKeys) {
        // TODO Auto-generated method stub
        Vendor vendor = (Vendor) sourceData;
        Optional<Address> existingAddr = addressDB.findById((String) targetKeys.get("AddressId"));
        Address newAddr = existingAddr.get();
        newAddr.setVendor(vendor);
        addressDB.save(newAddr);
        // throw new UnsupportedOperationException("Unimplemented method
        // 'writeRelation'");
    }

}
