package com.energybackend.Services;

import java.math.BigInteger;

public interface ETServices {
    public void Transfer(String To,BigInteger Amount);
    public void TransferFrom(String From,String To,BigInteger Amount);
    public String getTokenName();
    public String getTokenSymbol();
    public BigInteger getTotalSupply();
    public String getAdmin() throws Exception;
    public void Burn();
}
