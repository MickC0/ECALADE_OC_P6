package org.mickael.model.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum Region {

    AUVERGNE_RHONE_ALPES("Auvergne-Rhône-Alpes"),
    BOURGOGNE_FRANCHE_COMPTE("Bourgogne-Franche-Comté"),
    BRETAGNE("Bretagne"),
    CENTRE_VAL_DE_LOIRE("Centre-Val-de-Loire"),
    CORSE("Corse"),
    GRAND_EST("Grand-Est"),
    GUYANNE("Guyane"),
    HAUTS_DE_FRANCE("Hauts-de-France"),
    ILE_DE_FRANCE("Ile-de-France"),
    NORMANDIE("Normandie"),
    NOUVELLE_AQUITAINE("Nouvelle-Aquitaine"),
    OCCITANIE("Occitanie"),
    PAYS_DE_LA_LOIRE("Pays-de-la-Loire"),
    PACA("Paca"),
    REUNION("Réunion");

    private final String param ;

    Region(String param) {
        this.param = param ;
    }

    public String getParam() {
        return  this.param ;
    }

    /**
     * This method return a list of string with all abbreviation contained in enum
     *
     * @return a list of string
     */
    public static List<String> getEnumRegionStringValues (){
        Region[] listRegion = Region.values();
        List<String> listRegionStringValues = new ArrayList<>();

        for (Region enumRegion : listRegion){
            listRegionStringValues.add(enumRegion.getParam());
        }

        return  listRegionStringValues;
    }
}
