package com.energybackend.Contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class EnergyServicesContract extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50600080546001600160a01b031916339081178255815260046020526040902080546001919060ff191682800217905550600080546001600160a01b03168152600560205260409020805460ff19166001179055610a51806100736000396000f3fe6080604052600436106100865760003560e01c80636fbb8422116100595780636fbb84221461012357806374d5e100146101535780637b855bf014610190578063d04fa3ff146101c8578063e35fe366146101db57600080fd5b806327e235e31461008b5780632ad13c40146100cb5780635764727a146100fb5780635d7355871461010e575b600080fd5b34801561009757600080fd5b506100b86100a6366004610701565b60026020526000908152604090205481565b6040519081526020015b60405180910390f35b3480156100d757600080fd5b506100eb6100e63660046107c8565b61020b565b60405190151581526020016100c2565b34801561010757600080fd5b50476100b8565b61012161011c36600461086f565b6103c1565b005b34801561012f57600080fd5b5061014361013e36600461089b565b61047f565b6040516100c29493929190610930565b34801561015f57600080fd5b5061018361016e366004610701565b60046020526000908152604090205460ff1681565b6040516100c29190610977565b34801561019c57600080fd5b506000546101b0906001600160a01b031681565b6040516001600160a01b0390911681526020016100c2565b6101216101d636600461086f565b6105cc565b3480156101e757600080fd5b506100eb6101f6366004610701565b60056020526000908152604090205460ff1681565b6001600160a01b038116600090815260056020526040812054829060ff1661023257600080fd5b6040518060800160405280878152602001868152602001858152602001846001600160a01b031681525060038860405161026c919061099f565b90815260200160405180910390206000820151816000019080519060200190610296929190610650565b5060208281015180516102af9260018501920190610650565b506040828101516002830155606090920151600390910180546001600160a01b0319166001600160a01b03909216919091179055805180820190915260018152606160f81b6020918201528551908601207f3ac225168df54212a25c1c01fd35bebfea408fdac2e31ddd6f80a4bbf9a5f1cb14156103425760015461033d906001600160a01b0316856105cc565b6103b4565b6040805180820190915260018152603160f91b6020918201528551908601207fb5553de315e0edf504d9150af82dafa5c4667fa618ed0a6f19c69b41166c5510141561039e5760015461033d906001600160a01b0316856105cc565b6001546103b4906001600160a01b0316856105cc565b5060019695505050505050565b60006103cd82476109bb565b905060006001600160a01b0384166108fc6103e884476109bb565b6040518115909202916000818181858888f16001600160a01b038916600090815260026020526040812080549297508996509450925061042a915084906109bb565b909155508190506104795760405162461bcd60e51b81526020600482015260146024820152732330b4b632b2103a379039b2b7321022ba3432b960611b60448201526064015b60405180910390fd5b50505050565b80516020818301810180516003825292820191909301209152805481906104a5906109e0565b80601f01602080910402602001604051908101604052809291908181526020018280546104d1906109e0565b801561051e5780601f106104f35761010080835404028352916020019161051e565b820191906000526020600020905b81548152906001019060200180831161050157829003601f168201915b505050505090806001018054610533906109e0565b80601f016020809104026020016040519081016040528092919081815260200182805461055f906109e0565b80156105ac5780601f10610581576101008083540402835291602001916105ac565b820191906000526020600020905b81548152906001019060200180831161058f57829003601f168201915b5050505060028301546003909301549192916001600160a01b0316905084565b60006105d882476109bb565b905060006001600160a01b0384166108fc6105f384476109bb565b6040518115909202916000818181858888f193505050509050806104795760405162461bcd60e51b81526020600482015260146024820152732330b4b632b2103a379039b2b7321022ba3432b960611b6044820152606401610470565b82805461065c906109e0565b90600052602060002090601f01602090048101928261067e57600085556106c4565b82601f1061069757805160ff19168380011785556106c4565b828001600101855582156106c4579182015b828111156106c45782518255916020019190600101906106a9565b506106d09291506106d4565b5090565b5b808211156106d057600081556001016106d5565b6001600160a01b03811681146106fe57600080fd5b50565b60006020828403121561071357600080fd5b813561071e816106e9565b9392505050565b634e487b7160e01b600052604160045260246000fd5b600082601f83011261074c57600080fd5b813567ffffffffffffffff8082111561076757610767610725565b604051601f8301601f19908116603f0116810190828211818310171561078f5761078f610725565b816040528381528660208588010111156107a857600080fd5b836020870160208301376000602085830101528094505050505092915050565b600080600080600060a086880312156107e057600080fd5b853567ffffffffffffffff808211156107f857600080fd5b61080489838a0161073b565b9650602088013591508082111561081a57600080fd5b61082689838a0161073b565b9550604088013591508082111561083c57600080fd5b506108498882890161073b565b935050606086013591506080860135610861816106e9565b809150509295509295909350565b6000806040838503121561088257600080fd5b823561088d816106e9565b946020939093013593505050565b6000602082840312156108ad57600080fd5b813567ffffffffffffffff8111156108c457600080fd5b6108d08482850161073b565b949350505050565b60005b838110156108f35781810151838201526020016108db565b838111156104795750506000910152565b6000815180845261091c8160208601602086016108d8565b601f01601f19169290920160200192915050565b6080815260006109436080830187610904565b82810360208401526109558187610904565b604084019590955250506001600160a01b039190911660609091015292915050565b602081016002831061099957634e487b7160e01b600052602160045260246000fd5b91905290565b600082516109b18184602087016108d8565b9190910192915050565b6000828210156109db57634e487b7160e01b600052601160045260246000fd5b500390565b600181811c908216806109f457607f821691505b60208210811415610a1557634e487b7160e01b600052602260045260246000fd5b5091905056fea2646970667358221220ee48040c63c6651eeec79387de3cce4b51b70eeae181b3660cdb447a9b5dfbc864736f6c634300080b0033";

    public static final String FUNC_BUYSERVICE = "BuyService";

    public static final String FUNC_SERVICES = "Services";

    public static final String FUNC_BALACEOF = "balaceOf";

    public static final String FUNC_BALANCES = "balances";

    public static final String FUNC_CREATORADMIN = "creatorAdmin";

    public static final String FUNC_PAYMENTACCEPTED = "paymentAccepted";

    public static final String FUNC_PAYMENTDENIED = "paymentDenied";

    public static final String FUNC_USERROLES = "userRoles";

    public static final String FUNC_VERIFIEDUSERS = "verifiedUsers";

    @Deprecated
    protected EnergyServicesContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected EnergyServicesContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected EnergyServicesContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected EnergyServicesContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> BuyService(String _serviceId, String _station, String _cable, BigInteger _value, String _beneficiary) {
        final Function function = new Function(
                FUNC_BUYSERVICE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_serviceId), 
                new org.web3j.abi.datatypes.Utf8String(_station), 
                new org.web3j.abi.datatypes.Utf8String(_cable), 
                new org.web3j.abi.datatypes.generated.Uint256(_value), 
                new org.web3j.abi.datatypes.Address(160, _beneficiary)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple4<String, String, BigInteger, String>> Services(String param0) {
        final Function function = new Function(FUNC_SERVICES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        return new RemoteFunctionCall<Tuple4<String, String, BigInteger, String>>(function,
                new Callable<Tuple4<String, String, BigInteger, String>>() {
                    @Override
                    public Tuple4<String, String, BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<String, String, BigInteger, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (String) results.get(3).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> balaceOf() {
        final Function function = new Function(FUNC_BALACEOF, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> balances(String param0) {
        final Function function = new Function(FUNC_BALANCES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> creatorAdmin() {
        final Function function = new Function(FUNC_CREATORADMIN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> paymentAccepted(String _to, BigInteger _value) {
        final Function function = new Function(
                FUNC_PAYMENTACCEPTED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _to), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> paymentDenied(String _to, BigInteger _value) {
        final Function function = new Function(
                FUNC_PAYMENTDENIED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _to), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> userRoles(String param0) {
        final Function function = new Function(FUNC_USERROLES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> verifiedUsers(String param0) {
        final Function function = new Function(FUNC_VERIFIEDUSERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static EnergyServicesContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new EnergyServicesContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static EnergyServicesContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new EnergyServicesContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static EnergyServicesContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new EnergyServicesContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static EnergyServicesContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new EnergyServicesContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<EnergyServicesContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(EnergyServicesContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<EnergyServicesContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(EnergyServicesContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<EnergyServicesContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EnergyServicesContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<EnergyServicesContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EnergyServicesContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}