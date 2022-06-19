package Contract;

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
    public static final String BINARY = "608060405234801561001057600080fd5b50600080546001600160a01b031916339081178255815260046020526040902080546001919060ff191682800217905550600080546001600160a01b03168152600560205260409020805460ff19166001179055610ac5806100736000396000f3fe6080604052600436106100915760003560e01c80636fbb8422116100595780636fbb84221461015557806374d5e100146101755780637b855bf0146101b2578063d537f9a7146101ea578063e35fe366146101f257600080fd5b8063026b4d211461009657806327e235e3146100cf5780632ad13c401461010a5780635764727a1461012d5780636f9fd2fc14610140575b600080fd5b3480156100a257600080fd5b506100b66100b13660046107d4565b610222565b6040516100c6949392919061086d565b60405180910390f35b3480156100db57600080fd5b506100fc6100ea3660046108cc565b60026020526000908152604090205481565b6040519081526020016100c6565b61011d6101183660046108f0565b6103e0565b60405190151581526020016100c6565b34801561013957600080fd5b50476100fc565b61015361014e366004610997565b61049e565b005b34801561016157600080fd5b506100b66101703660046107d4565b610525565b34801561018157600080fd5b506101a56101903660046108cc565b60046020526000908152604090205460ff1681565b6040516100c691906109c3565b3480156101be57600080fd5b506000546101d2906001600160a01b031681565b6040516001600160a01b0390911681526020016100c6565b610153610672565b3480156101fe57600080fd5b5061011d61020d3660046108cc565b60056020526000908152604090205460ff1681565b60608060008060038560405161023891906109eb565b908152604051908190036020018120906003906102569088906109eb565b908152602001604051809103902060010160038760405161027791906109eb565b90815260200160405180910390206002015460038860405161029991906109eb565b9081526040519081900360200190206003015483546001600160a01b039091169084906102c590610a07565b80601f01602080910402602001604051908101604052809291908181526020018280546102f190610a07565b801561033e5780601f106103135761010080835404028352916020019161033e565b820191906000526020600020905b81548152906001019060200180831161032157829003601f168201915b5050505050935082805461035190610a07565b80601f016020809104026020016040519081016040528092919081815260200182805461037d90610a07565b80156103ca5780601f1061039f576101008083540402835291602001916103ca565b820191906000526020600020905b8154815290600101906020018083116103ad57829003601f168201915b5050505050925093509350935093509193509193565b60006040518060800160405280868152602001858152602001848152602001836001600160a01b031681525060038760405161041c91906109eb565b90815260200160405180910390206000820151816000019080519060200190610446929190610698565b50602082810151805161045f9260018501920190610698565b5060408201516002820155606090910151600390910180546001600160a01b0319166001600160a01b0390921691909117905550600195945050505050565b60006001600160a01b0383166108fc6104bf84670de0b6b3a7640000610a58565b6040518115909202916000818181858888f193505050509050806105205760405162461bcd60e51b81526020600482015260146024820152732330b4b632b2103a379039b2b7321022ba3432b960611b604482015260640160405180910390fd5b505050565b805160208183018101805160038252928201919093012091528054819061054b90610a07565b80601f016020809104026020016040519081016040528092919081815260200182805461057790610a07565b80156105c45780601f10610599576101008083540402835291602001916105c4565b820191906000526020600020905b8154815290600101906020018083116105a757829003601f168201915b5050505050908060010180546105d990610a07565b80601f016020809104026020016040519081016040528092919081815260200182805461060590610a07565b80156106525780601f1061062757610100808354040283529160200191610652565b820191906000526020600020905b81548152906001019060200180831161063557829003601f168201915b5050505060028301546003909301549192916001600160a01b0316905084565b3360009081526002602052604081208054349290610691908490610a77565b9091555050565b8280546106a490610a07565b90600052602060002090601f0160209004810192826106c6576000855561070c565b82601f106106df57805160ff191683800117855561070c565b8280016001018555821561070c579182015b8281111561070c5782518255916020019190600101906106f1565b5061071892915061071c565b5090565b5b80821115610718576000815560010161071d565b634e487b7160e01b600052604160045260246000fd5b600082601f83011261075857600080fd5b813567ffffffffffffffff8082111561077357610773610731565b604051601f8301601f19908116603f0116810190828211818310171561079b5761079b610731565b816040528381528660208588010111156107b457600080fd5b836020870160208301376000602085830101528094505050505092915050565b6000602082840312156107e657600080fd5b813567ffffffffffffffff8111156107fd57600080fd5b61080984828501610747565b949350505050565b60005b8381101561082c578181015183820152602001610814565b8381111561083b576000848401525b50505050565b60008151808452610859816020860160208601610811565b601f01601f19169290920160200192915050565b6080815260006108806080830187610841565b82810360208401526108928187610841565b604084019590955250506001600160a01b039190911660609091015292915050565b6001600160a01b03811681146108c957600080fd5b50565b6000602082840312156108de57600080fd5b81356108e9816108b4565b9392505050565b600080600080600060a0868803121561090857600080fd5b853567ffffffffffffffff8082111561092057600080fd5b61092c89838a01610747565b9650602088013591508082111561094257600080fd5b61094e89838a01610747565b9550604088013591508082111561096457600080fd5b5061097188828901610747565b935050606086013591506080860135610989816108b4565b809150509295509295909350565b600080604083850312156109aa57600080fd5b82356109b5816108b4565b946020939093013593505050565b60208101600283106109e557634e487b7160e01b600052602160045260246000fd5b91905290565b600082516109fd818460208701610811565b9190910192915050565b600181811c90821680610a1b57607f821691505b60208210811415610a3c57634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052601160045260246000fd5b6000816000190483118215151615610a7257610a72610a42565b500290565b60008219821115610a8a57610a8a610a42565b50019056fea26469706673582212204a7327c62b383072efb0631aab54e0bee09bbf3ac4bc567351faef5272f6dfa264736f6c634300080b0033";

    public static final String FUNC_BUYSERVICE = "BuyService";

    public static final String FUNC_CHANGEBALANCE = "ChangeBalance";

    public static final String FUNC_GIVEREWARD = "GiveReward";

    public static final String FUNC_SERVICES = "Services";

    public static final String FUNC_BALACEOF = "balaceOf";

    public static final String FUNC_BALANCES = "balances";

    public static final String FUNC_CREATORADMIN = "creatorAdmin";

    public static final String FUNC_GETSERVICEDETAILS = "getServiceDetails";

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

    public RemoteFunctionCall<TransactionReceipt> ChangeBalance() {
        final Function function = new Function(
                FUNC_CHANGEBALANCE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> GiveReward(String _to, BigInteger _value) {
        final Function function = new Function(
                FUNC_GIVEREWARD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _to), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
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

    public RemoteFunctionCall<Tuple4<String, String, BigInteger, String>> getServiceDetails(String _serviceId) {
        final Function function = new Function(FUNC_GETSERVICEDETAILS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_serviceId)), 
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
