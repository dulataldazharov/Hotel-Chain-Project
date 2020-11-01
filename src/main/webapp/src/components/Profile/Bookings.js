import React, { useState, useEffect } from 'react';

import './Profile.css';

import { loadUserActiveBookings, loadUserPastBookings, loadUserFutureBookings } from '../../utils/api';

function Bookings() {
    const [activeBookings, setActiveBookings] = useState([]);
    const [pastBookings, setPastBookings] = useState([]);
    const [futureBookings, setFutureBookings] = useState([]);

    useEffect(() => {
        loadUserActiveBookings((response, status) => {
            if (status === 200) {
                setActiveBookings(response);
            }
            else {
                console.log(response);
            }
        });
        loadUserPastBookings((response, status) => {
            if (status === 200) {
                setPastBookings(response);
            }
            else {
                console.log(response);
            }
        });
        loadUserFutureBookings((response, status) => {
            if (status === 200) {
                setFutureBookings(response);
            }
            else {
                console.log(response);
            }
        });
    }, []);

    const Booking = ({ hotelName, roomTypeName, roomCount, finalPrice, checkInDate, checkOutDate }) => {
        return (
            <div className={"row py-3 my-3 shadow"}>
                <div className={"col-lg-3 d-flex flex-column justify-content-center"}>
                    <div className="row my-2">

                        <p className="col-lg-12 p-0 d-flex justify-content-center">
                            {hotelName}
                        </p>

                    </div>
                </div>
                <div className={"col-lg-3"}>
                    <div className="row my-2">

                        <p className="col-lg-12 p-0 d-flex justify-content-center">
                            {roomCount} room{roomCount > 1 ? "s" : ""}
                        </p>

                        <p className="col-lg-12 p-0 d-flex justify-content-center">
                            {roomTypeName}
                        </p>

                    </div>
                </div>
                <div className={"col-lg-3"}>
                    <div className="row my-2">

                        <div className="col-lg-12">
                            <div className={"row"}>
                                <p className="col-4 col-lg-3 d-flex justify-content-end p-0">from:</p>
                                <p className="col-8 col-lg-9 p-0 px-2">{checkInDate}</p>
                            </div>
                        </div>

                        <div className="col-lg-12">
                            <div className={"row"}>
                                <p className="col-4 col-lg-3 d-flex justify-content-end p-0">to:</p>
                                <p className="col-8 col-lg-9 p-0 px-2">{checkOutDate}</p>
                            </div>
                        </div>

                    </div>
                </div>
                <div className={"col-lg-3 d-flex flex-column justify-content-center"}>
                    <div className="row my-2">

                        <h5 className="col-lg-12 p-0 d-flex justify-content-center">
                            {finalPrice} USD
                        </h5>

                    </div>
                </div>
            </div>
        );
    }

    return (
        <div className={"container-fluid bookings-container"}>
            <div className={"container-fluid d-flex flex-column"}>

                <div className="my-4">
                    <div className={"row"}><h5 className={"col-lg-12"}>Active Reservations</h5></div>

                    {activeBookings.map(booking => {
                        return <Booking key={booking.reservationId} {...booking} />
                    })}

                </div>

                <div className="my-4">
                    <div className={"row"}><h5 className={"col-lg-12"}>Future Reservations</h5></div>

                    {futureBookings.map(booking => {
                        return <Booking key={booking.reservationId} {...booking} />
                    })}

                </div>

                <div className="my-4">
                    <div className={"row"}><h5 className={"col-lg-12"}>Past Reservations</h5></div>

                    {pastBookings.map(booking => {
                        return <Booking key={booking.reservationId} {...booking} />
                    })}

                </div>

            </div>
        </div>
    );
}

export default Bookings;