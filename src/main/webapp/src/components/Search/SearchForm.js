import React, { useState } from 'react';

import { searchRooms } from '../../utils/api';

function SearchForm({ onResultsLoad }) {
    const [data, setData] = useState({
        checkInDate: "",
        checkOutDate: "",
    });

    const onChange = (event) => {
        let name = event.target.name;
        let value = event.target.value;
        setData(data => ({ ...data, [name]: value }));
    };

    const onSubmit = (event) => {
        event.preventDefault();
        localStorage.setItem('checkInDate', data.checkInDate);
        localStorage.setItem('checkOutDate', data.checkOutDate);
        searchRooms(data, (response, status) => {
            if (status === 200) {
                console.log("kek");
                console.log(response);
                onResultsLoad(response);
            }
            else {
                console.log(response);
            }
        });
    }

    return (
        <div className={"d-flex justify-content-center mx-auto"}>
            <form onChange={onChange} onSubmit={onSubmit}>
                <div className={"row mx-2"}>

                    <div className={"col-12 form-input-section"}>
                        <label className={"my-1 mx-1"}><p className="m-0">from</p></label>
                        <input name={"checkInDate"} className={"my-1 mx-1"} type={"date"}></input>
                    </div>

                    <div className={"col-12 form-input-section"}>
                        <label className={"mx-1"}><p className="m-0">from</p></label>
                        <input name={"checkOutDate"} className={"mx-1"} type={"date"}></input>
                    </div>

                    <div className={"col-12 form-input-section my-3"}>
                        <button className={"button-primary mx-1 shadow"}><p className={"m-0 text-white"}>Search</p></button>
                    </div>

                </div>
            </form >
        </div>
    );
}

export default SearchForm;