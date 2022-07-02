package com.energybackend.Services;

import com.energybackend.dtos.GetETBalance;
import com.energybackend.dtos.GiveReward;
import com.energybackend.dtos.TransferET;
import com.energybackend.dtos.TransferETFrom;

import java.math.BigInteger;

public interface ETServices {
    public void Transfer(TransferET transferET) throws Exception;
    public void GiveReward(GiveReward giveReward) throws Exception;
    public void TransferFrom(TransferETFrom transferETfrom);
    public String getTokenName();
    public String getTokenSymbol();
    public BigInteger getTotalSupply() throws Exception;
    public BigInteger getBalanceOf() throws Exception;
    public String getAdmin() throws Exception;
    public void Burn();
    public void mint();
}
