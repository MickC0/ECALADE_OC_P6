package org.mickael.business.impl.manager;

import org.mickael.business.contract.manager.EnumManager;
import org.mickael.business.impl.AbstractManager;
import org.mickael.model.enumeration.Cotation;
import org.mickael.model.enumeration.Region;
import org.mickael.model.enumeration.Role;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named("enumManager")
public class EnumManagerImpl extends AbstractManager implements EnumManager {

    public EnumManagerImpl() {
    }

    /**
     * This method return a list of string with all abbreviation contained in enum
     *
     * @return a list of string
     */
    @Override
    public List<String> getEnumCotationStringValues (){
        Cotation[] listCotation = Cotation.values();
        List<String> listCotationStringValues = new ArrayList<>();

        for (Cotation cotation : listCotation){
            listCotationStringValues.add(cotation.getCotationValue());
        }

        return  listCotationStringValues;
    }

    /**
     * This method return the level value associated to the abbreviation in enum
     *
     * @return the level value
     */
    @Override
    public int getEnumLevelFromCotationValue (String cotationValue){
        Cotation[] listCotation = Cotation.values();
        Map<Integer,String> listLevelAndCotationValues = new HashMap<>();

        for (Cotation cotation : listCotation){
            listLevelAndCotationValues.put(cotation.getLevel(),cotation.getCotationValue());
        }

        for ( Map.Entry<Integer,String> entry : listLevelAndCotationValues.entrySet()){
            if (entry.getValue().equals(cotationValue)){

                return entry.getKey();
            }
        }

        return 0;
    }

    /**
     * This method find the level value associated to the abbreviation in the EnumRating.
     *
     * @param cotationValue abbreviation picked up in form
     * @return level value associated
     */
    @Override
    public int getLevelOfCotationValue(String cotationValue) {

        return getEnumLevelFromCotationValue(cotationValue);

    }

    /**
     * This method return a list of string with all abbreviation contained in enum
     *
     * @return a list of string
     */
    public List<String> getEnumRegionStringValues (){
        Region[] listRegion = Region.values();
        List<String> listRegionStringValues = new ArrayList<>();

        for (Region enumRegion : listRegion){
            listRegionStringValues.add(enumRegion.getParam());
        }

        return  listRegionStringValues;
    }

    /**
     * This method return a list of string with all abbreviation contained in enum
     *
     * @return a list of string
     */
    public List<String> getEnumRoleStringValues (){
        Role[] listRole = Role.values();
        List<String> listRoleStringValues = new ArrayList<>();

        for (Role enumRole : listRole){
            listRoleStringValues.add(enumRole.getParam());
        }

        return  listRoleStringValues;
    }
}
