package ism.Gestionappro.entities;

public enum EtatAbsence {
    Acceptée,Refusée;

    public static EtatAbsence toEnum(int valOrdinal){
        for(EtatAbsence enumValue:values()){
            if(enumValue.ordinal()==valOrdinal){
                return enumValue;
            }
        }
        return null;
    }
}
