import React from 'react';

import { useMedia } from 'react-media';

function TitleSection() {
    const isSmallScreen = useMedia({ query: "(max-width: 991px)" });

    const header = "Ultra Lorem Ipsum";
    const body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur eleifend laoreet sem. Duis id lacinia elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
    const imageUrl = "https://images.pexels.com/photos/60217/pexels-photo-60217.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940";

    if (isSmallScreen) {
        return (
            <div>
                <div className={"container-fluid home-page-section d-flex flex-column justify-content-end px-4 py-3"} style={{
                    backgroundImage: "url(" + imageUrl + ")",
                }}>
                    <h1 className={"mx-auto text-white"}>{header}</h1>
                </div>
                <div className={"container-fluid home-page-section-fluid py-2 px-4 shadow"}>
                    <p className={"my-4"}>
                        {body}
                    </p>
                </div>
            </div>
        );
    }

    return (
        <div className={"container-fluid home-page-section shadow"} style={{
            backgroundImage: "url(" + imageUrl + ")",
        }}>
            <div className={"row mx-2 h-100"}>
                <div className={"col-lg-6 d-flex justify-content-center"}>
                    <div className={"row my-auto mx-5"}>
                        <h1 className={"col-sm-12 text-white"}>{header}</h1>
                        <p className={"col-sm-12 text-white"}>
                            {body}
                        </p>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default TitleSection;