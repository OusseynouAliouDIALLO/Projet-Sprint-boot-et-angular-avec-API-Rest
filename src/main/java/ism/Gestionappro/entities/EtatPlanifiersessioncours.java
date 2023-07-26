package ism.Gestionappro.entities;

public enum EtatPlanifiersessioncours {
    Terminer,Encours,Annuler;

    public static EtatPlanifiersessioncours toEnum(int valOrdinal){
        for(EtatPlanifiersessioncours enumValue:values()){
            if(enumValue.ordinal()==valOrdinal){
                return enumValue;
            }
        }
        return null;
    }
}
