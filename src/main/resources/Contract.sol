pragma solidity >=0.7.0 <0.9.0;

contract EnergyServicesContract {
    address public creatorAdmin;
    address payable _contract;
    enum Role {User, Admin}
    mapping(address=> uint) public balances;
    mapping(string=> ServiceDetail) public Services;
    mapping(address => Role) public userRoles; // Keeps track of user roles
    mapping(address => bool) public verifiedUsers; // Keeps track of verified user, userId -> verified (true / false)


    // Initializing the Contract.
    constructor() public {
        creatorAdmin = msg.sender;
        userRoles[creatorAdmin] = Role.Admin;
        verifiedUsers[creatorAdmin] = true;
    }

    struct ServiceDetail {
        string Station;
        string Cable;
        uint value;
        address Beneficiary;
    }

    modifier verifiedUser(address _user) {
        require(verifiedUsers[_user]);
        _;
    }
    modifier verifiedAdmin() {
        require(
            userRoles[msg.sender] == Role.Admin &&
            verifiedUsers[msg.sender]
        );
        _;
    }

    function BuyService(string memory _serviceId, string memory _station, string memory _cable,uint _value, address _beneficiary)
    external verifiedUser(_beneficiary) returns (bool) {
        Services[_serviceId] = ServiceDetail(_station,_cable,_value,_beneficiary);
        if (keccak256(bytes(_cable)) == keccak256(bytes("a")) ) {
            paymentAccepted(_contract,_value);
        } else if(keccak256(bytes(_cable)) == keccak256(bytes("b")) ){
            paymentAccepted(_contract,_value);
        }else {
            paymentAccepted(_contract,_value);
        }
        
        return true;
    }

    function balaceOf()external view returns(uint) {
        return address(this).balance;
    }

    function paymentAccepted(address payable _to ,uint _value) public payable {
        // Send returns a boolean value indicating success or failure.
        // This function is not recommended for sending Ether.
        uint a=address(this).balance-_value;
        bool sent = _to.send(address(this).balance-a);
        require(sent, "Failed to send Ether");
    }


    function paymentDenied(address payable _to,uint _value) public payable {
        // Send returns a boolean value indicating success or failure.
        // This function is not recommended for sending Ether.
        uint a=address(this).balance-_value;
        bool sent = _to.send(address(this).balance-a);
        balances[_to]-=_value;
        require(sent, "Failed to send Ether");
    }

}

