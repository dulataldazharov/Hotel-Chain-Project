import React from 'react';

function Results({ results }) {

    const Room = ({ hotelName, hotelAddress, roomTypeName, availableRoomCnt, price, capacity }) => {
        return (
            <div className={"row py-3 my-3 shadow"}>
                <div className={"col-lg-3"}>
                    <div className="row my-2">

                        <h5 className="col-lg-12 p-0 d-flex justify-content-center">
                            {hotelName}
                        </h5>

                        <p className="col-lg-12 p-0 d-flex justify-content-center">
                            {hotelAddress}
                        </p>

                    </div>
                </div>
                <div className={"col-lg-3"}>
                    <div className="row my-2">

                        <p className="col-lg-12 p-0 d-flex justify-content-center">
                            {availableRoomCnt} room{availableRoomCnt !== 1 ? "s" : ""} available
                        </p>

                        <p className="col-lg-12 p-0 d-flex justify-content-center">
                            {roomTypeName}
                        </p>

                    </div>
                </div>
                <div className={"col-lg-3 d-flex flex-column justify-content-center"}>
                    <div className="row my-2">

                        <div className="col-lg-12">
                            <div className={"row"}>
                                <p className="col-6 col-lg-3 d-flex justify-content-end p-0">capacity:</p>
                                <p className="col-6 col-lg-9 p-0 px-2">{capacity}</p>
                            </div>
                        </div>

                    </div>
                </div>
                <div className={"col-lg-3 d-flex flex-column justify-content-center"}>
                    <div className="row my-2">

                        <h5 className="col-lg-12 p-0 d-flex justify-content-center">
                            {price} USD
                        </h5>

                    </div>
                </div>
            </div>
        );
    }

    return (
        <div className={"container-fluid"}>
            <div className={"container-fluid d-flex flex-column"}>

                <div className="my-4">

                    {results.map(room => {
                        return <Room key={room.hotelName + room.roomTypeName} {...room} />
                    })}

                </div>

            </div>
        </div>
    );
}

export default Results;