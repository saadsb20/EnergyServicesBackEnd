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
    constructor()  {
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

    function BuyService (string memory _serviceId, string memory _station, string memory _cable,uint _value, address payable _beneficiary)
    external payable returns (bool) {
        Services[_serviceId] = ServiceDetail(_station,_cable,_value,_beneficiary);
        return true;
    }
    function getServiceDetails(string memory _serviceId)
    public
    view
    returns (
        string memory,
        string memory,
        uint ,
        address
    )
    {
        return (
        Services[_serviceId].Station,
        Services[_serviceId].Cable,
        Services[_serviceId].value,
        Services[_serviceId].Beneficiary
        );
    }

    function balaceOf() external view returns(uint) {
        return address(this).balance;
    }

    function ChangeBalance() external payable {
        balances[msg.sender]+=msg.value;
    }

    function GiveReward(address payable _to ,uint _value) public payable {
        // Send returns a boolean value indicating success or failure.
        // This function is not recommended for sending Ether.
        bool sent = _to.send(_value * (1 ether));
        require(sent, "Failed to send Ether");
    }

}

