package com.energybackend;

import Contract.EnergyServicesContract;
import Contract.EnergyToken;

public class LoadedContract {
    private static EnergyServicesContract loadedContract1 ;
    private static EnergyToken loadedContract2 ;


    public static EnergyServicesContract getLoadedContarct1() {
        return loadedContract1;
    }

    public static void setLoadedContarct1(EnergyServicesContract loadedContarct) {
        LoadedContract.loadedContract1 = loadedContarct;
    }
    public static EnergyToken getLoadedContarct2() {
        return loadedContract2;
    }

    public static void setLoadedContarct2(EnergyToken loadedContarct) {
        LoadedContract.loadedContract2 = loadedContarct;
    }
}
