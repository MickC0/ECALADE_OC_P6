package org.mickael.business.contract.manager;

import java.util.List;

public interface UtilsManager {

    List<String> getEnumCotationStringValues ();
    int getEnumLevelFromCotationValue (String cotationValue);
    int getLevelOfCotationValue(String cotationValue);
}
