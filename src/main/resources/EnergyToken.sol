pragma solidity >=0.7.0 <0.9.0;

import "./node_modules/openzeppelin-solidity/contracts/token/ERC20/ERC20.sol";

contract  EnergyToken is ERC20 {
    address public admin;
    constructor() ERC20('EnergyToken','ET'){
        _mint(msg.sender, 10000 * 10 ** 18);
        admin = msg.sender;
    }

    function mint(address to , uint amount) external {
        require(msg.sender == admin, 'Only Admin');
        _mint(to,amount);
    }

    function burn(uint amount) external {
        _burn(msg.sender,amount);
    }

}
