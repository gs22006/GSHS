//솔리디티 컴파일러 버전 명시
pragma solidity >=0.5.0 <0.9.0;

contract HotelRoom //호텔 방의 상태를 관리하는 컨트랙트
{
    enum Status { Vacant, Occupied } //방이 사용중인지 아닌지 2가지 상태를 관리하는 enum
    Status currentStatus; //관리하는 방의 상태

    event Occupy(address _occupant, uint _value); //방에 들어올 때 호출되는 이벤트
    event Unoccupy(address _occupant); //방에서 나갈 때 호출되는 이벤트

    address public owner; //방주인의 이더리움 주소
    address occupant; //방을 사용하려는 손님의 주소

    constructor() public //초기 방의 상태는 비어있는 것으로 설정, 방주인의 주소를 deploy한 사람의 주소로 설정
    {
        currentStatus = Status.Vacant;
        owner = msg.sender;
    }

    modifier checkVacant //현재 방이 비어있는지 확인
    {
        require(currentStatus == Status.Vacant, "Currently occupied");
        _;
    }

    modifier checkCost(uint _amount) //최소 가격을 지불했는지를 확인
    {
        require(msg.value >= _amount, "Not enough Ether provided.");
        _;
    }

    modifier checkOccupied //현재 방이 사용중인지 확인
    {
        require(currentStatus == Status.Occupied, "Currently vacant");
        _;
    }

    modifier ownerOfRoom //방의 사용자가 맞는지 확인
    {
        require(msg.sender == occupant, "Not the owner of this room.");
        _;
    }

    receive() external payable checkVacant checkCost(1 ether) //최소 1 ether를 지불하는 것으로 방을 사용 가능
    {
        currentStatus = Status.Occupied; //방의 상태를 사용중으로 변경
        (bool result, ) = owner.call{ value: msg.value }(""); //방주인에게 ether를 전송
        require(result, "failed to book");
        occupant = msg.sender; //방의 사용자를 변경
        emit Occupy(msg.sender, msg.value); //이벤트 호출
    }

    function leave() external checkOccupied ownerOfRoom //방에서 나갈 때 호출하는 함수
    {
        currentStatus = Status.Vacant; //방의 상태를 비어있음으로 변경
        emit Unoccupy(msg.sender); //이벤트 호출
    }
}